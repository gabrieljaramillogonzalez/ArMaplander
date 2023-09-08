package com.maplander.arlibmaplander.ui.ar_properties_map

import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.ar.core.TrackingState
import com.google.ar.core.exceptions.CameraNotAvailableException
import com.google.ar.core.exceptions.UnavailableException
import com.google.ar.sceneform.rendering.ViewRenderable
import com.maplander.arlibmaplander.R
import com.maplander.arlibmaplander.data.db.model.Geolocation
import com.maplander.arlibmaplander.data.db.model.gr.model.PropertyLite
import com.maplander.arlibmaplander.ui.base.BaseActivity
import com.maplander.arlibmaplander.utils.AugmentedRealityLocationUtils
import com.maplander.arlibmaplander.utils.PermissionUtils
import uk.co.appoly.arcorelocation.LocationMarker
import uk.co.appoly.arcorelocation.LocationScene
import java.lang.ref.WeakReference
import java.util.concurrent.CompletableFuture
import com.google.ar.sceneform.Node
import androidx.activity.viewModels
import androidx.cardview.widget.CardView
import com.maplander.arlibmaplander.databinding.ActivityArPropertiesMapBinding

class ArPropertiesMapActivity :  BaseActivity<ArPropertiesMapVieModel>()  {

    private var arCoreInstallRequested = false

    // Our ARCore-Location scene
    private var locationScene: LocationScene? = null

    private var arHandler = Handler(Looper.getMainLooper())

    private val resumeArElementsTask = Runnable {
        locationScene?.resume()
        binding.ArPropertiesMapArSceneView.resume()
    }

    private var userGeolocation = Geolocation.EMPTY_GEOLOCATION

    private var propertiesLiteSet: MutableSet<PropertyLite> = mutableSetOf()
    private var areAllMarkersLoaded = false

    private val viewModel: ArPropertiesMapVieModel by viewModels ()

    private lateinit var binding: ActivityArPropertiesMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArPropertiesMapBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        hideAppBar()

    }

    private fun configAttach(){
        viewModel.onAttach(intent.extras!!,this.baseContext)
        setUp()
        setupSession()
    }

    override fun setUp() {
        viewModel.isLoading.observe(this, Observer<Boolean>{
            binding.ArPropertiesMapRvProgress.visibility = if (it) View.VISIBLE else View.GONE
        })
        viewModel.areAllMarkersLoaded.observe(this, Observer<Boolean>{
            areAllMarkersLoaded = it
        })
        viewModel.textErrorMessage.observe(this, Observer<String>{
            onError(it)
        })
        viewModel.locationSceneClear.observe(this, Observer<Boolean>{
            if(locationScene!=null)
                locationScene!!.clearMarkers()
        })
        viewModel.propertiesLiteList.observe(this, Observer<MutableSet<PropertyLite>>{
            propertiesLiteSet.addAll(it)
            renderProperties()
        })
    }

    private fun renderProperties() {
        setupAndRenderPropertiesMarkers()
        updatePropertiesMarkers()
    }

    private fun updatePropertiesMarkers() {
        binding.ArPropertiesMapArSceneView.scene.addOnUpdateListener()
        {
            if (!areAllMarkersLoaded) {
                return@addOnUpdateListener
            }

            locationScene?.mLocationMarkers?.forEach { locationMarker ->
                locationMarker.height =
                    AugmentedRealityLocationUtils.generateRandomHeightBasedOnDistance(
                        locationMarker?.anchorNode?.distance ?: 0
                    )
            }


            val frame = binding.ArPropertiesMapArSceneView!!.arFrame ?: return@addOnUpdateListener
            if (frame.camera.trackingState != TrackingState.TRACKING) {
                return@addOnUpdateListener
            }
            locationScene!!.processFrame(frame)
        }
    }

    private fun setupAndRenderPropertiesMarkers(){
        propertiesLiteSet.forEach { property ->
            val completableFutureViewRenderable = ViewRenderable.builder()
                .setView(this, R.layout.property_layout_renderable)
                .build()
            CompletableFuture.anyOf(completableFutureViewRenderable)
                .handle<Any> { _, throwable ->
                    //here we know the renderable was built or not
                    if (throwable != null) {
                        // handle renderable load fail
                        return@handle null
                    }
                    try {
                        val propertyMarker = LocationMarker(
                            property.getAddress()?.getLocation()?.getLongitude()?.toDouble()!!,
                            property.getAddress()?.getLocation()?.getLatitude()?.toDouble()!!,
                            setPropertyNode(property, completableFutureViewRenderable)
                        )
                        arHandler.postDelayed({
                            attachMarkerToScene(
                                propertyMarker,
                                completableFutureViewRenderable.get().view
                            )
                            if (propertiesLiteSet.indexOf(property) == propertiesLiteSet.size - 1) {
                                areAllMarkersLoaded = true
                            }
                        }, 200)

                    } catch (ex: Exception) {
                        //                        showToast(getString(R.string.generic_error_msg))
                    }
                    null
                }
        }
    }

    private fun setPropertyNode(property : PropertyLite, completableFuture: CompletableFuture<ViewRenderable>) : Node{
        val node = Node()
        node.renderable = completableFuture.get()
        val nodeLayout = completableFuture.get().view
        val typeProperty = nodeLayout.findViewById<TextView>(R.id.typeProperty)
        val address = nodeLayout.findViewById<TextView>(R.id.address)
        val propertyPrice = nodeLayout.findViewById<TextView>(R.id.propertyPrice)
        typeProperty.text = property.getType()?.name + " "+property.getOffering()?.getDescription(getMContext()!!)?.toLowerCase()
        address.text = property.getAddress()?.getShortAddress()
        propertyPrice.text = property.getPrice().toString()
        nodeLayout.setOnTouchListener { _, _ ->
            Toast.makeText(this, property.getAddress()?.getShortAddress(), Toast.LENGTH_SHORT).show()
            false
        }

        Glide.with(this)
            .load(property.getImage())
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .centerCrop()
            .into(nodeLayout.findViewById<ImageView>(R.id.imageProperty))

        Glide.with(this)
            .load(property.getStockImage())
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .centerCrop()
            .into(nodeLayout.findViewById<ImageView>(R.id.propertyOffice))
        return node
    }

    private fun attachMarkerToScene( locationMarker: LocationMarker, layoutRendarable: View ) {
        resumeArElementsTask.run {
            locationMarker.scalingMode = LocationMarker.ScalingMode.FIXED_SIZE_ON_SCREEN
            locationMarker.scaleModifier = AugmentedRealityLocationUtils.INITIAL_MARKER_SCALE_MODIFIER

            locationScene?.mLocationMarkers?.add(locationMarker)
            locationMarker.anchorNode?.isEnabled = true

            arHandler.post {
                locationScene?.refreshAnchors()
                layoutRendarable.findViewById<CardView>(R.id.contentProperty).visibility = View.VISIBLE
            }
        }
    }

    private fun detachMarker(locationMarker: LocationMarker) {
        locationMarker.anchorNode?.anchor?.detach()
        locationMarker.anchorNode?.isEnabled = false
        locationMarker.anchorNode = null
    }

    override fun onResume() {
        super.onResume()
        checkAndRequestPermissions()
    }

    override fun onPause() {
        super.onPause()
        binding.ArPropertiesMapArSceneView.session?.let {
            locationScene?.pause()
            binding.ArPropertiesMapArSceneView?.pause()
        }
    }

    private fun checkAndRequestPermissions() {
        if (!PermissionUtils.hasLocationAndCameraPermissions(this)) {
            PermissionUtils.requestCameraAndLocationPermissions(this)
        } else {
            configAttach()
        }
    }
    private fun setupSession() {
        if (binding.ArPropertiesMapArSceneView == null) {
            return
        }

        if (binding.ArPropertiesMapArSceneView.session == null) {
            try {
                val session = AugmentedRealityLocationUtils.setupSession(this, arCoreInstallRequested)
                if (session == null) {
                    arCoreInstallRequested = true
                    return
                } else {
                    binding.ArPropertiesMapArSceneView.setupSession(session)
                }
            } catch (e: UnavailableException) {
                AugmentedRealityLocationUtils.handleSessionException(this, e)
            }
        }

        if (locationScene == null) {
            locationScene = LocationScene(this, binding.ArPropertiesMapArSceneView)
            locationScene!!.setMinimalRefreshing(true)
            locationScene!!.setOffsetOverlapping(true)
//            locationScene!!.setRemoveOverlapping(true)
            locationScene!!.anchorRefreshInterval = 2000
        }

        try {
            resumeArElementsTask.run()
        } catch (e: CameraNotAvailableException) {
            Toast.makeText(this, "Unable to get camera", Toast.LENGTH_LONG).show()
            finish()
            return
        }

        if (userGeolocation == Geolocation.EMPTY_GEOLOCATION) {
            ArPropertiesMapActivity.LocationAsyncTask(WeakReference(this@ArPropertiesMapActivity)).execute(locationScene!!)
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, results: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, results)
        if (!PermissionUtils.hasLocationAndCameraPermissions(this)) {
            Toast.makeText(
                this, R.string.camera_and_location_permission_request, Toast.LENGTH_LONG
            )
                .show()
            if (!PermissionUtils.shouldShowRequestPermissionRationale(this)) {
                // Permission denied with checking "Do not ask again".
                PermissionUtils.launchPermissionSettings(this)
            }
            finish()
        }
    }

    private fun fetchProperties(deviceLatitude: Double, deviceLongitude: Double) {
        viewModel.isLoadingDismiss()
        viewModel.getProperties(deviceLatitude, deviceLongitude)
    }

    class LocationAsyncTask(private val activityWeakReference: WeakReference<ArPropertiesMapActivity>) :
        AsyncTask<LocationScene, Void, List<Double>>() {

        override fun onPreExecute() {
            super.onPreExecute()
            activityWeakReference.get()!!.showDialog()
        }

        override fun doInBackground(vararg p0: LocationScene): List<Double> {
            var deviceLatitude: Double?
            var deviceLongitude: Double?
            do {
                deviceLatitude = p0[0].deviceLocation?.currentBestLocation?.latitude
                deviceLongitude = p0[0].deviceLocation?.currentBestLocation?.longitude
            } while (deviceLatitude == null || deviceLongitude == null)
            return listOf(deviceLatitude, deviceLongitude)
        }

        override fun onPostExecute(geolocation: List<Double>) {
            activityWeakReference.get()!!.fetchProperties(deviceLatitude = geolocation[0], deviceLongitude = geolocation[1])
            super.onPostExecute(geolocation)
        }
    }

    private fun showDialog() {
        viewModel.isLoadingShow()
    }
}