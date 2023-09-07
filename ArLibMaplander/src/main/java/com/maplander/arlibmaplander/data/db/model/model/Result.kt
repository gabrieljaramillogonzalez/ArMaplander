package com.maplander.arlibmaplander.data.db.model.gr.model

import com.google.gson.annotations.SerializedName

class Result {
    @SerializedName("address_components")
    private var addressComponents: List<AddressComponent>? = null

    @SerializedName("formatted_address")
    private var formatterAddress: String? = null

    @SerializedName("geometry")
    private var geometry: Geometry? = null

    @SerializedName("types")
    private var types: List<String>? = null

    @SerializedName("place_id")
    private var placeId: String? = null

    @SerializedName("plus_code")
    private var plusCode: PlusCode? = null


    fun getAddressComponents(): List<AddressComponent?>? {
        return addressComponents
    }

    fun setAddressComponents(addressComponents: List<AddressComponent?>?) {
        this.addressComponents = addressComponents as List<AddressComponent>?
    }

    fun getFormatterAddress(): String? {
        return formatterAddress
    }

    fun setFormatterAddress(formatterAddress: String?) {
        this.formatterAddress = formatterAddress
    }

    fun getGeometry(): Geometry? {
        return geometry
    }

    fun setGeometry(geometry: Geometry?) {
        this.geometry = geometry
    }

    fun getTypes(): List<String?>? {
        return types
    }

    fun setTypes(types: List<String?>?) {
        this.types = types as List<String>?
    }

    fun getZipCode(): String? {
        return getLongNameByType("postal_code")
    }

    fun getCountry(): String? {
        return getLongNameByType("country")
    }

    fun getShortCountry(): String? {
        return getShortNameByType("country")
    }

    fun getAdministrativeAreaLevel5(): String? {
        return getLongNameByType("administrative_area_level_5")
    }

    fun getAdministrativeAreaLevel4(): String? {
        return getLongNameByType("administrative_area_level_4")
    }

    fun getAdministrativeAreaLevel3(): String? {
        return getLongNameByType("administrative_area_level_3")
    }

    fun getAdministrativeAreaLevel2(): String? {
        return getLongNameByType("administrative_area_level_2")
    }

    fun getAdministrativeAreaLevel1(): String? {
        return getLongNameByType("administrative_area_level_1")
    }

    fun getLocality(): String? {
        return getLongNameByType("locality")
    }

    fun getSubLocality(): String? {
        return getLongNameByType("sublocality")
    }

    fun getRoute(): String? {
        return getLongNameByType("route")
    }

    fun getStreetNumber(): String? {
        return getLongNameByType("street_number")
    }

    private fun getLongNameByType(type: String): String? {
        for (item in addressComponents!!) {
            if (item.getTypes()!!.contains(type)) return item.getLongName()
        }
        return null
    }

    private fun getShortNameByType(type: String): String? {
        for (item in addressComponents!!) {
            if (item.getTypes()!!.contains(type)) return item.getShortName()
        }
        return null
    }

    fun getPlaceId(): String? {
        return placeId
    }

    fun setPlaceId(placeId: String?) {
        this.placeId = placeId
    }

    fun getPlusCode(): PlusCode? {
        return plusCode
    }

    fun setPlusCode(plusCode: PlusCode?) {
        this.plusCode = plusCode
    }
}