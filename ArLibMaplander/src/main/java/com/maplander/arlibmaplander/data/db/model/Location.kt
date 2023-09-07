package com.maplander.arlibmaplander.data.db.model

import com.google.gson.annotations.SerializedName

class Location (
    @SerializedName("lat")
    var lat: Double = 0.0,
    @SerializedName("lng")
    var lng: Double = 0.0,
    @SerializedName("address")
    var address: String? = null,
    @SerializedName("city")
    var city: String? = null,
    @SerializedName("cross_Street")
    var crossStreet: String? = null,
    @SerializedName("distance")
    var distance: Int = -1,
    @SerializedName("postalCode")
    var postalCode: String? = null,
    @SerializedName("state")
    var state: String? = null,
    @SerializedName("country")
    var country: String? = null,
    @SerializedName("locality")
    var locality: String? = null,
    @SerializedName("formatted_address")
    var formattedAddress: List<String> = emptyList())