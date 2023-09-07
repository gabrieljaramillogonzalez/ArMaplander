package com.maplander.arlibmaplander.data.db.model.gr.model

import com.google.gson.annotations.SerializedName

class Location {
    @SerializedName("lat")
    private var latitude = 0.0

    @SerializedName("lng")
    private var longitude = 0.0

    fun getLatitude(): Double {
        return latitude
    }

    fun setLatitude(latitude: Double) {
        this.latitude = latitude
    }

    fun getLongitude(): Double {
        return longitude
    }

    fun setLongitude(longitude: Double) {
        this.longitude = longitude
    }
}