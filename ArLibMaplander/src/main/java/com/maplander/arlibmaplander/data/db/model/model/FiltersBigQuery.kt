package com.maplander.arlibmaplander.data.db.model.model

import com.maplander.arlibmaplander.data.db.enum.AreaUnitEnum
import com.maplander.arlibmaplander.data.db.enum.LocationTypeEnum
import com.maplander.arlibmaplander.data.db.model.gr.enum.BrandTypeEnum
import com.maplander.arlibmaplander.data.db.enum.OfferingTypeEnum
import com.maplander.arlibmaplander.data.db.model.gr.enum.PropertyTypeEnum
import com.maplander.arlibmaplander.data.db.model.gr.enum.StatusTypeEnum
import com.maplander.arlibmaplander.data.db.model.gr.model.GeoPt

class FiltersBigQuery() :Cloneable{
    private var amenities: Amenities? = null
    private var areaUnit: AreaUnitEnum? = null
    private var bathrooms = 0f
    private var bedrooms = 0
    private var brand: BrandTypeEnum? = null
    private var colony: String? = null
    private var currency: String? = null
    private var distance = 0
    private var downLimitPrice = 0.0
    private var exclusivity = false
    private var extras: ArrayList<String>? = null
    private var location: GeoPt? = null
    private var locationType: LocationTypeEnum? = null
    private var mainArea = 0f
    private var mls = false
    private var municipality: String? = null
    private var offering: OfferingTypeEnum? = null
    private var officeId: Long? = null
    private var parkingPlaces = 0
    private var roi = 0f
    private var state: String? = null
    private var status: StatusTypeEnum? = null
    private var type: PropertyTypeEnum? = null
    private var upLimitPrice = 0.0
    private var userId: Long? = null
    private var zoom = 0.0
    private var polygon: ArrayList<GeoPt>? = null

    constructor(
        amenities: Amenities?,
        areaUnit: AreaUnitEnum?,
        bathrooms: Float,
        bedrooms: Int,
        brand: BrandTypeEnum?,
        colony: String?,
        currency: String?,
        distance: Int,
        downLimitPrice: Double,
        exclusivity: Boolean,
        extras: ArrayList<String>?,
        location: GeoPt?,
        locationType: LocationTypeEnum?,
        mainArea: Float,
        mls: Boolean,
        municipality: String?,
        offering: OfferingTypeEnum?,
        officeId: Long?,
        parkingPlaces: Int,
        roi: Float,
        state: String?,
        status: StatusTypeEnum?,
        type: PropertyTypeEnum?,
        upLimitPrice: Double,
        userId: Long?
    ) : this() {
        this.amenities = amenities
        this.areaUnit = areaUnit
        this.bathrooms = bathrooms
        this.bedrooms = bedrooms
        this.brand = brand
        this.colony = colony
        this.currency = currency
        this.distance = distance
        this.downLimitPrice = downLimitPrice
        this.exclusivity = exclusivity
        this.extras = extras
        this.location = location
        this.locationType = locationType
        this.mainArea = mainArea
        this.mls = mls
        this.municipality = municipality
        this.offering = offering
        this.officeId = officeId
        this.parkingPlaces = parkingPlaces
        this.roi = roi
        this.state = state
        this.status = status
        this.type = type
        this.upLimitPrice = upLimitPrice
        this.userId = userId
    }

    fun getAmenities(): Amenities? {
        return amenities
    }

    fun setAmenities(amenities: Amenities?) {
        this.amenities = amenities
    }

    fun getAreaUnit(): AreaUnitEnum? {
        return areaUnit
    }

    fun setAreaUnit(areaUnit: AreaUnitEnum?) {
        this.areaUnit = areaUnit
    }

    fun getBathrooms(): Float {
        return bathrooms
    }

    fun setBathrooms(bathrooms: Float) {
        this.bathrooms = bathrooms
    }

    fun getBedrooms(): Int {
        return bedrooms
    }

    fun setBedrooms(bedrooms: Int) {
        this.bedrooms = bedrooms
    }

    fun getBrand(): BrandTypeEnum? {
        return brand
    }

    fun setBrand(brand: BrandTypeEnum?) {
        this.brand = brand
    }

    fun getColony(): String? {
        return colony
    }

    fun setColony(colony: String?) {
        this.colony = colony
    }

    fun getCurrency(): String? {
        return currency
    }

    fun setCurrency(currency: String?) {
        this.currency = currency
    }

    fun getDistance(): Int {
        return distance
    }

    fun setDistance(distance: Int) {
        this.distance = distance
    }

    fun getDownLimitPrice(): Double {
        return downLimitPrice
    }

    fun setDownLimitPrice(downLimitPrice: Double) {
        this.downLimitPrice = downLimitPrice
    }

    fun isExclusivity(): Boolean {
        return exclusivity
    }

    fun setExclusivity(exclusivity: Boolean) {
        this.exclusivity = exclusivity
    }

    fun getExtras(): ArrayList<String>? {
        return extras
    }

    fun setExtras(extras: ArrayList<String>?) {
        this.extras = extras
    }

    fun getLocation(): GeoPt? {
        return location
    }

    fun setLocation(location: GeoPt?) {
        this.location = location
    }

    fun getLocationType(): LocationTypeEnum? {
        return locationType
    }

    fun setLocationType(locationType: LocationTypeEnum?) {
        this.locationType = locationType
    }

    fun getMainArea(): Float {
        return mainArea
    }

    fun setMainArea(mainArea: Float) {
        this.mainArea = mainArea
    }

    fun isMls(): Boolean {
        return mls
    }

    fun setMls(mls: Boolean) {
        this.mls = mls
    }

    fun getMunicipality(): String? {
        return municipality
    }

    fun setMunicipality(municipality: String?) {
        this.municipality = municipality
    }

    fun getOffering(): OfferingTypeEnum? {
        return offering
    }

    fun setOffering(offering: OfferingTypeEnum?) {
        this.offering = offering
    }

    fun getOfficeId(): Long? {
        return officeId
    }

    fun setOfficeId(officeId: Long?) {
        this.officeId = officeId
    }

    fun getParkingPlaces(): Int {
        return parkingPlaces
    }

    fun setParkingPlaces(parkingPlaces: Int) {
        this.parkingPlaces = parkingPlaces
    }

    fun getRoi(): Float {
        return roi
    }

    fun setRoi(roi: Float) {
        this.roi = roi
    }

    fun getState(): String? {
        return state
    }

    fun setState(state: String?) {
        this.state = state
    }

    fun getStatus(): StatusTypeEnum? {
        return status
    }

    fun setStatus(status: StatusTypeEnum?) {
        this.status = status
    }

    fun getType(): PropertyTypeEnum? {
        return type
    }

    fun setType(type: PropertyTypeEnum?) {
        this.type = type
    }

    fun getUpLimitPrice(): Double {
        return upLimitPrice
    }

    fun setUpLimitPrice(upLimitPrice: Double) {
        this.upLimitPrice = upLimitPrice
    }

    fun getUserId(): Long? {
        return userId
    }

    fun setUserId(userId: Long?) {
        this.userId = userId
    }

    fun getGeoLocation(): GeoPt? {
        if (location == null) {
            location = GeoPt(22.14674186706543, -101.86625671386719)
            return GeoPt(22.14674186706543, -101.86625671386719)
        }
        return GeoPt(location!!.getLatitude(), location!!.getLongitude())
    }

    fun getGeoLocation(countryCode: String?): GeoPt? {
        return if (location == null) {
            if (countryCode != null && countryCode == "PA") {
                location = GeoPt(8.0020125, -80.8535436)
                GeoPt(8.0020125, -80.8535436)
            } else {
                location = GeoPt(22.14674186706543, -101.86625671386719)
                GeoPt(22.14674186706543, -101.86625671386719)
            }
        } else GeoPt(location!!.getLatitude(), location!!.getLongitude())
    }

    fun setGeoLocation(position: GeoPt?) {
        if (position == null) return
        if (location == null) location = GeoPt()
        location!!.setLatitude(position.getLatitude() as Float)
        location!!.setLongitude(position.getLongitude() as Float)
    }

    override fun clone(): Any {
        return try {
            val filter = super.clone() as FiltersBigQuery
            if (officeId != null) filter.setOfficeId(officeId!!.toLong())
            if (location != null) filter.setLocation(location!!.clone())
            if (extras != null) filter.setExtras(java.util.ArrayList(extras))
            filter
        } catch (e: Exception) {
            FiltersBigQuery()
        }
    }

    fun getZoom(): Double {
        if (zoom == 0.0) zoom = 4.0
        return zoom
    }

    fun setZoom(zoom: Double) {
        this.zoom = zoom
    }

    fun getPolygon(): List<GeoPt>? {
        if (polygon == null || polygon!!.size == 0) {
            if (polygon == null) polygon = java.util.ArrayList()
            polygon!!.add(GeoPt(45.250137, -117.07473))
            polygon!!.add(GeoPt(45.250137, -86.67889))
            polygon!!.add(GeoPt(-5.3429003, -86.67889))
            polygon!!.add(GeoPt(-5.3429003, -117.07473))
        }
        return polygon
    }

    fun setPolygon(polygon: List<GeoPt>?) {
        if(polygon!=null)
            this.polygon = polygon as ArrayList<GeoPt>
    }

    fun getPolygon(position: Int): GeoPt {
        return polygon!![position]
    }

    fun setPolygon(polygon: GeoPt) {
        this.polygon!!.add(polygon)
    }

    fun addExtra(extra: String?) {
        extras!!.add(extra!!)
    }

    fun removeExtra(extra: String?) {
        extras!!.remove(extra!!)
    }

}