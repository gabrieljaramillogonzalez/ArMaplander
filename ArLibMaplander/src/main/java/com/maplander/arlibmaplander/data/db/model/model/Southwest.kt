package com.maplander.arlibmaplander.data.db.model.gr.model

import com.google.gson.annotations.SerializedName

class Southwest {
    @SerializedName("lat")
    private var lat = 0f

    @SerializedName("lng")
    private var lng = 0f

    fun getLat(): Float {
        return lat
    }

    fun setLat(lat: Float) {
        this.lat = lat
    }

    fun getLng(): Float {
        return lng
    }

    fun setLng(lng: Float) {
        this.lng = lng
    }
}