package com.maplander.arlibmaplander.data.db.model.gr.model

class GeoPt : Cloneable{
    private var latitude = 0f
    private var longitude = 0f

    constructor() {
        this.latitude = 0f
        this.longitude = 0f
    }
    constructor(latitude: Float, longitude: Float) {
        this.latitude = latitude
        this.longitude = longitude
    }

    constructor(latitude: Double, longitude: Double) {
        this.latitude = latitude.toFloat()
        this.longitude = longitude.toFloat()
    }

    fun getLatitude(): Float {
        return latitude
    }

    fun setLatitude(latitude: Float) {
        this.latitude = latitude
    }

    fun getLongitude(): Float {
        return longitude
    }

    fun setLongitude(longitude: Float) {
        this.longitude = longitude
    }

    public override fun clone(): GeoPt {
        try {
            return super.clone() as GeoPt
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
        }
        return GeoPt()
    }

    override fun equals(obj: Any?): Boolean {
        if (obj == null) return false
        if (obj !is GeoPt) return false
        val geoPt = obj
        return latitude == geoPt.getLatitude() &&
                longitude == geoPt.getLongitude()
    }
}