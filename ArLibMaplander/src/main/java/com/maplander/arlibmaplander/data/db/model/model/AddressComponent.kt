package com.maplander.arlibmaplander.data.db.model.gr.model

import com.google.gson.annotations.SerializedName

class AddressComponent {
    @SerializedName("long_name")
    private var longName: String? = null

    @SerializedName("short_name")
    private var shortName: String? = null

    @SerializedName("types")
    private var types: List<String>? = null


    fun getLongName(): String? {
        return longName
    }

    fun setLongName(longName: String?) {
        this.longName = longName
    }

    fun getShortName(): String? {
        return shortName
    }

    fun setShortName(shortName: String?) {
        this.shortName = shortName
    }

    fun getTypes(): List<String?>? {
        return types
    }

    fun setTypes(types: List<String?>?) {
        this.types = types as List<String>?
    }
}