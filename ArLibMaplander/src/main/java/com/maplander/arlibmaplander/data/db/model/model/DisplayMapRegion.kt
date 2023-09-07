package com.maplander.arlibmaplander.data.db.model.gr.model

import com.google.gson.annotations.SerializedName

class DisplayMapRegion {
    @SerializedName("southLatitude")
    private var southLatitude = 0f

    @SerializedName("westLongitude")
    private var westLongitude = 0f

    @SerializedName("northLatitude")
    private var northLatitude = 0f

    @SerializedName("eastLongitude")
    private var eastLongitude = 0f

    constructor() {
        southLatitude = 0f
        westLongitude = 0f
        northLatitude = 0f
        eastLongitude = 0f
    }

    constructor(
        southLatitude: Float,
        westLongitude: Float,
        northLatitude: Float,
        eastLongitude: Float
    ) {
        this.southLatitude = southLatitude
        this.westLongitude = westLongitude
        this.northLatitude = northLatitude
        this.eastLongitude = eastLongitude
    }

    fun getSouthLatitude(): Float {
        return southLatitude
    }

    fun setSouthLatitude(southLatitude: Float) {
        this.southLatitude = southLatitude
    }

    fun getWestLongitude(): Float {
        return westLongitude
    }

    fun setWestLongitude(westLongitude: Float) {
        this.westLongitude = westLongitude
    }

    fun getNorthLatitude(): Float {
        return northLatitude
    }

    fun setNorthLatitude(northLatitude: Float) {
        this.northLatitude = northLatitude
    }

    fun getEastLongitude(): Float {
        return eastLongitude
    }

    fun setEastLongitude(eastLongitude: Float) {
        this.eastLongitude = eastLongitude
    }
}