package com.maplander.arlibmaplander.data.db.model.gr.model

import com.google.gson.annotations.SerializedName

class Bounds {
    @SerializedName("northeast")
    private var northeast: Northeast? = null

    @SerializedName("southwest")
    private var southwest: Southwest? = null

    fun getNortheast(): Northeast? {
        return northeast
    }

    fun setNortheast(northeast: Northeast?) {
        this.northeast = northeast
    }

    fun getSouthwest(): Southwest? {
        return southwest
    }

    fun setSouthwest(southwest: Southwest?) {
        this.southwest = southwest
    }
}