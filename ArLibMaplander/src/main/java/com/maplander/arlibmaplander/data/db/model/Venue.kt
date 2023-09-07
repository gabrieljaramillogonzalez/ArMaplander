package com.maplander.arlibmaplander.data.db.model

import com.google.gson.annotations.SerializedName

data class Venue(
    @SerializedName("fsq_id")
    var fsq_id: String,
    @SerializedName("categories")
    var categories: Any,
    @SerializedName("chains")
    var chains: Any,
    @SerializedName("distance")
    var distance: Double,
    @SerializedName("geocodes")
    var geocodes: Any,
    @SerializedName("link")
    var link: String,
    @SerializedName("location")
    var location: Location,
    @SerializedName("name")
    var name: String,
    @SerializedName("related_places")
    var related_places: Any,
    @SerializedName("timezone")
    var timezone: String

)