package com.maplander.arlibmaplander.ui.ar_properties_map

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.lib.filebrowserlibrary.data.core.ConstantsLib
import com.maplander.arlibmaplander.R
import com.maplander.arlibmaplander.data.db.enum.OfferingTypeEnum
import com.maplander.arlibmaplander.data.db.model.gr.enum.PropertyTypeEnum
import com.maplander.arlibmaplander.data.db.model.gr.enum.StatusTypeEnum
import com.maplander.arlibmaplander.data.db.model.gr.model.GeoPt
import com.maplander.arlibmaplander.data.db.model.gr.model.PropertyLite
import com.maplander.arlibmaplander.data.db.model.model.FiltersBigQuery
import com.maplander.arlibmaplander.data.db.model.response.EntityCollectionResponse
import com.maplander.arlibmaplander.data.db.model.response.HttpStatusCode
import com.maplander.arlibmaplander.ui.base.BaseViewModel
import com.maplander.arlibmaplander.utils.CommonUtils
import com.maplander.arlibmaplander.utils.Logger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArPropertiesMapVieModel() : BaseViewModel() {

    private var filtersBigQueryOrigin = FiltersBigQuery()
    val isLoading = MutableLiveData<Boolean>()
    var areAllMarkersLoaded = MutableLiveData<Boolean>(false)
    var locationSceneClear = MutableLiveData<Boolean>(false)
    val textErrorMessage = MutableLiveData<String>()
    val propertyLiteList : MutableSet<PropertyLite> = mutableSetOf()
    val propertiesLiteList : MutableLiveData<MutableSet<PropertyLite>> = MutableLiveData()
    private var distan = 1000

    override fun onAttach(bundle: Bundle, context: Context) {
        super.onAttach(bundle, context)
        getBundle()
    }

    private fun getBundle() {
        if (getMBundle().containsKey(ConstantsLib.FILTERS_BIG_QUERY))
            filtersBigQueryOrigin = CommonUtils.toObject<FiltersBigQuery>(getMBundle().getString(ConstantsLib.FILTERS_BIG_QUERY, ""), FiltersBigQuery::class.java)!!
    }

    fun getProperties(deviceLatitude: Double, deviceLongitude: Double){
        val requestPropertiesCallback: Callback<EntityCollectionResponse<PropertyLite?>?> =
            object : Callback<EntityCollectionResponse<PropertyLite?>?> {
                override fun onResponse( call: Call<EntityCollectionResponse<PropertyLite?>?>, response: Response<EntityCollectionResponse<PropertyLite?>?> ) {
                    isLoading.value = false
                    if (response.code() != 200 || response.body() == null) {
                        textErrorMessage.value = getMContext().getString(R.string.communication_error_message)
                        Logger.e( ArPropertiesMapActivity::class.java.simpleName, String.format("Error on requestProperties: %s", response.toString()) )
                        return
                    }
                    when (response.body()?.code) {
                        HttpStatusCode.OK -> {
                            propertyLiteList.clear()
                            if (response.body()!=null && response.body()!!.items!=null && response.body()!!.items?.size!! > 0 ) {
                                for (elemnt in response.body()!!.items?.parallelStream()!!) {
                                    propertyLiteList.add(elemnt!!)
                                }
                            }
                            areAllMarkersLoaded.value = false
                            locationSceneClear.value = true
                            propertiesLiteList.postValue(propertyLiteList)
                        } else -> {
                            textErrorMessage.value = getMContext().getString(R.string.communication_error_message)
                            Logger.e(
                                ArPropertiesMapActivity::class.java.simpleName,
                                String.format("Error on requestProperties: %s", response.toString())
                            )
                        }
                    }
                }

                override fun onFailure(call: Call<EntityCollectionResponse<PropertyLite?>?>,t: Throwable) {
                    isLoading.value = false
                    textErrorMessage.value = getMContext().getString(R.string.communication_error_message)
                    Logger.e(
                        ArPropertiesMapActivity::class.java.getSimpleName(),
                        String.format(
                            "Error on requestProperties: %s",
                            CommonUtils.toJson(t)
                        )
                    )
                }
            }
        val filtersBigQuery = filtersBigQueryOrigin
        filtersBigQuery.setLocation(GeoPt(deviceLatitude, deviceLongitude))
        filtersBigQuery.setOfficeId(null)
        filtersBigQuery.setPolygon(null)
        filtersBigQuery.setType(PropertyTypeEnum.NONE)
        filtersBigQuery.setOffering(OfferingTypeEnum.NONE)
        filtersBigQuery.setStatus(StatusTypeEnum.ANNOUNCED)
        filtersBigQuery.setDistance(distan)
        getDataManager()?.queryPropertyLiteWithFiltersPagedBQ(null, null, filtersBigQuery, requestPropertiesCallback)
    }

    fun isLoadingDismiss() {
        isLoading.value = false
    }

    fun isLoadingShow() {
        isLoading.value = true
    }
}