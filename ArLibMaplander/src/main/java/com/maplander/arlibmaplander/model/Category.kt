package com.maplander.arlibmaplander.model

import com.google.gson.annotations.SerializedName

class Category(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("shortName")
    val shortName: String? = null,
    @SerializedName("pluralName")
    val pluralName: String? = null,
    @SerializedName("icon")
    val icon: Photo? = null,
    @SerializedName("isPrimary")
    val isPrimary: Boolean = false,
    @SerializedName("categories")
    val categories: List<Category> = emptyList()
)