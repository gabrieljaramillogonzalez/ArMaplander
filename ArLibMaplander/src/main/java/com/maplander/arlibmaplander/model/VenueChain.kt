package com.maplander.arlibmaplander.model

import com.google.gson.annotations.SerializedName

class VenueChain(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String)