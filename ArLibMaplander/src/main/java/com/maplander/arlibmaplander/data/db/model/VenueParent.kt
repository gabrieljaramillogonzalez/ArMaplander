package com.maplander.arlibmaplander.data.db.model

import com.google.gson.annotations.SerializedName

class VenueParent(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("categories")
    val categories: List<com.maplander.arlibmaplander.data.db.model.Category> = emptyList(),
    @SerializedName("lang")
    val lang: String? = null,
    @SerializedName("canonicalUrl")
    val canonicalUrl: String? = null)