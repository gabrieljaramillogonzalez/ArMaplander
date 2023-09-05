package com.maplander.armaplander.model

import com.google.gson.annotations.SerializedName

class Photo(
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("createdAt")
    var createdAt: Long = 0,
    @SerializedName("prefix")
    var prefix: String? = null,
    @SerializedName("suffix")
    var suffix: String? = null,
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("width")
    var width: Int = 0,
    @SerializedName("height")
    var height: Int = 0,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("sizes")
    var sizes: IntArray? = null
)