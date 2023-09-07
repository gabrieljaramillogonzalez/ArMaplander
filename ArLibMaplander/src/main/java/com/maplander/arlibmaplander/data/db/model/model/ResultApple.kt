package com.maplander.arlibmaplander.data.db.model.gr.model

import com.google.gson.annotations.SerializedName

class ResultApple {
    @SerializedName("coordinate")
    private var coordinate: Coordinate? = null

    @SerializedName("displayMapRegion")
    private var displayMapRegion: DisplayMapRegion? = null

    @SerializedName("name")
    private var name: String? = null

    @SerializedName("formattedAddressLines")
    private var formattedAddressLines: List<String>? = null

    @SerializedName("structuredAddress")
    private var structuredAddress: StructuredAddress? = null

    @SerializedName("country")
    private var country: String? = null

    @SerializedName("countryCode")
    private var countryCode: String? = null
    constructor() {
        coordinate = Coordinate()
        displayMapRegion = DisplayMapRegion()
        name = ""
        formattedAddressLines = ArrayList()
        structuredAddress = StructuredAddress()
        country = ""
        countryCode = ""
    }

    constructor(
        coordinate: Coordinate?,
        displayMapRegion: DisplayMapRegion?,
        name: String?,
        formattedAddressLines: List<String?>?,
        structuredAddress: StructuredAddress?,
        country: String?,
        countryCode: String?
    ) {
        this.coordinate = coordinate
        this.displayMapRegion = displayMapRegion
        this.name = name
        this.formattedAddressLines = formattedAddressLines as List<String>?
        this.structuredAddress = structuredAddress
        this.country = country
        this.countryCode = countryCode
    }

    fun getCoordinate(): Coordinate? {
        return coordinate
    }

    fun setCoordinate(coordinate: Coordinate?) {
        this.coordinate = coordinate
    }

    fun getDisplayMapRegion(): DisplayMapRegion? {
        return displayMapRegion
    }

    fun setDisplayMapRegion(displayMapRegion: DisplayMapRegion?) {
        this.displayMapRegion = displayMapRegion
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getFormattedAddressLines(): List<String?>? {
        return formattedAddressLines
    }

    fun setFormattedAddressLines(formattedAddressLines: List<String?>?) {
        this.formattedAddressLines = formattedAddressLines as List<String>?
    }

    fun getStructuredAddress(): StructuredAddress? {
        return structuredAddress
    }

    fun setStructuredAddress(structuredAddress: StructuredAddress?) {
        this.structuredAddress = structuredAddress
    }

    fun getCountry(): String? {
        return country
    }

    fun setCountry(country: String?) {
        this.country = country
    }

    fun getCountryCode(): String? {
        return countryCode
    }

    fun setCountryCode(countryCode: String?) {
        this.countryCode = countryCode
    }

}