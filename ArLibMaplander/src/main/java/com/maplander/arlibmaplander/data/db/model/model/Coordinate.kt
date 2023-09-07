package com.maplander.arlibmaplander.data.db.model.gr.model

import com.google.gson.annotations.SerializedName

class Coordinate {
    @SerializedName("latitude")
    private var latitude = 0f

    @SerializedName("longitude")
    private var longitude = 0f

    constructor() {
        latitude = 0f
        longitude = 0f
    }

    constructor(latitude: Float, longitude: Float) {
        this.latitude = latitude
        this.longitude = longitude
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
}