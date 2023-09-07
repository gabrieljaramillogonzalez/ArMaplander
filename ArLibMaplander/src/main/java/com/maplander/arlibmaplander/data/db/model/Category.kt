package com.maplander.arlibmaplander.data.db.model

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
    val icon: com.maplander.arlibmaplander.data.db.model.Photo? = null,
    @SerializedName("isPrimary")
    val isPrimary: Boolean = false,
    @SerializedName("categories")
    val categories: List<com.maplander.arlibmaplander.data.db.model.Category> = emptyList()
)