package com.maplander.arlibmaplander.data.db.model

import com.google.gson.annotations.SerializedName

class VenueChain(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String)