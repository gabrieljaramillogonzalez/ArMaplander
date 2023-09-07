package com.maplander.arlibmaplander.data.db.model.gr.model

import com.google.gson.annotations.SerializedName

class Geometry {
    @SerializedName("location")
    private var location: Location? = null

    @SerializedName("location_type")
    private var locationType: String? = null

    @SerializedName("bounds")
    private var bounds: Bounds? = null

    @SerializedName("viewport")
    private var viewport: Viewport? = null

    fun getLocation(): Location? {
        return location
    }

    fun setLocation(location: Location?) {
        this.location = location
    }

    fun getLocationType(): String? {
        return locationType
    }

    fun setLocationType(locationType: String?) {
        this.locationType = locationType
    }

    fun getBounds(): Bounds? {
        return bounds
    }

    fun setBounds(bounds: Bounds?) {
        this.bounds = bounds
    }

    fun getViewport(): Viewport? {
        return viewport
    }

    fun setViewport(viewport: Viewport?) {
        this.viewport = viewport
    }
}