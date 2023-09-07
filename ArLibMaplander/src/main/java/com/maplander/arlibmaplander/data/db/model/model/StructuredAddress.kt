package com.maplander.arlibmaplander.data.db.model.gr.model

import com.google.gson.annotations.SerializedName

class StructuredAddress {
    @SerializedName("administrativeArea")
    private var administrativeArea: String? = null

    @SerializedName("locality")
    private var locality: String? = null

    @SerializedName("postCode")
    private var postCode: String? = null

    @SerializedName("subLocality")
    private var subLocality: String? = null

    @SerializedName("thoroughfare")
    private var thoroughfare: String? = null

    @SerializedName("subThoroughfare")
    private var subThoroughfare: String? = null

    @SerializedName("fullThoroughfare")
    private var fullThoroughfare: String? = null

    @SerializedName("dependentLocalities")
    private var dependentLocalities: List<String>? = null

    constructor() {
        administrativeArea = ""
        locality = ""
        postCode = ""
        subLocality = ""
        thoroughfare = ""
        subThoroughfare = ""
        fullThoroughfare = ""
        dependentLocalities = ArrayList()
    }

    constructor(
        administrativeArea: String?,
        locality: String?,
        postCode: String?,
        subLocality: String?,
        thoroughfare: String?,
        subThoroughfare: String?,
        fullThoroughfare: String?,
        dependentLocalities: List<String>?
    ) {
        this.administrativeArea = administrativeArea
        this.locality = locality
        this.postCode = postCode
        this.subLocality = subLocality
        this.thoroughfare = thoroughfare
        this.subThoroughfare = subThoroughfare
        this.fullThoroughfare = fullThoroughfare
        this.dependentLocalities = dependentLocalities
    }

    fun getAdministrativeArea(): String? {
        return administrativeArea
    }

    fun setAdministrativeArea(administrativeArea: String?) {
        this.administrativeArea = administrativeArea
    }

    fun getLocality(): String? {
        return locality
    }

    fun setLocality(locality: String?) {
        this.locality = locality
    }

    fun getPostCode(): String? {
        return postCode
    }

    fun setPostCode(postCode: String?) {
        this.postCode = postCode
    }

    fun getSubLocality(): String? {
        return subLocality
    }

    fun setSubLocality(subLocality: String?) {
        this.subLocality = subLocality
    }

    fun getThoroughfare(): String? {
        return thoroughfare
    }

    fun setThoroughfare(thoroughfare: String?) {
        this.thoroughfare = thoroughfare
    }

    fun getSubThoroughfare(): String? {
        return subThoroughfare
    }

    fun setSubThoroughfare(subThoroughfare: String?) {
        this.subThoroughfare = subThoroughfare
    }

    fun getFullThoroughfare(): String? {
        return fullThoroughfare
    }

    fun setFullThoroughfare(fullThoroughfare: String?) {
        this.fullThoroughfare = fullThoroughfare
    }

    fun getDependentLocalities(): List<String>? {
        return dependentLocalities
    }

    fun setDependentLocalities(dependentLocalities: List<String>?) {
        this.dependentLocalities = dependentLocalities
    }
}