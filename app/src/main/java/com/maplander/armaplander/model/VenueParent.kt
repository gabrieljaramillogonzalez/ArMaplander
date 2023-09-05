package com.maplander.armaplander.model

import com.google.gson.annotations.SerializedName

class VenueParent(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("categories")
    val categories: List<Category> = emptyList(),
    @SerializedName("lang")
    val lang: String? = null,
    @SerializedName("canonicalUrl")
    val canonicalUrl: String? = null)