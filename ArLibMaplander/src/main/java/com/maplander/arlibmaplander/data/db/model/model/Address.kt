package com.maplander.arlibmaplander.data.db.model.gr.model

import android.text.TextUtils
import com.maplander.arlibmaplander.utils.CommonUtils

class Address : Cloneable{
    private var city: String? = null
    private var colony: String? = null
    private var country: String? = null
    private var countryCode: String? = null
    private var interiorNumber: String? = null
    private var location: GeoPt? = null
    private var lt: String? = null
    private var mz: String? = null
    private var outdoorNumber: String? = null
    private var postalCode: String? = null
    private var publicLocation: GeoPt? = null
    private var state: String? = null
    private var street: String? = null
    private var township: String? = null
    private var visible = false

    constructor(){
        visible = true
    }

    fun createFromJson(result: Result): Address {
        val address: Address = Address()
        address.setPostalCode(result.getZipCode())
        address.setCountry(result.getCountry())
        address.setState(result.getAdministrativeAreaLevel1())
        address.setCity(result.getAdministrativeAreaLevel1())
        address.setTownship(if (result.getAdministrativeAreaLevel2() != null) result.getAdministrativeAreaLevel2() else result.getAdministrativeAreaLevel3())
        address.setColony(result.getSubLocality())
        address.setStreet(result.getRoute())
        address.setOutdoorNumber(result.getStreetNumber())
        if (result.getGeometry() != null && result.getGeometry()!!.getLocation() != null) {
            val geoPt = GeoPt()
            geoPt.setLatitude(result.getGeometry()!!.getLocation()?.getLatitude() as Float)
            geoPt.setLongitude(result.getGeometry()!!.getLocation()?.getLongitude() as Float)
            address.setLocation(geoPt)
            address.setPublicLocation(geoPt.clone())
        }
        return address
    }

    fun createFromJson(result: PlacesAppleBodyResponse): Address {
        val address: Address = Address()
        address.setPostalCode(result.getResults()?.get(0)?.getStructuredAddress()?.getPostCode())
        address.setCountry(result.getResults()?.get(0)?.getCountry())
        address.setState(result.getResults()?.get(0)?.getStructuredAddress()?.getThoroughfare())
        address.setCity(result.getResults()?.get(0)?.getStructuredAddress()?.getSubLocality())
        address.setTownship(result.getResults()?.get(0)?.getStructuredAddress()?.getLocality())
        address.setColony(result.getResults()?.get(0)?.getStructuredAddress()?.getSubLocality())
        address.setStreet(result.getResults()?.get(0)?.getStructuredAddress()?.getThoroughfare())
        address.setOutdoorNumber(
            result.getResults()?.get(0)?.getStructuredAddress()?.getSubThoroughfare()
        )
        address.setCountryCode(result.getResults()?.get(0)?.getCountryCode())
        if (result.getResults()?.get(0)?.getCoordinate() != null) {
            val geoPt = GeoPt()
            geoPt.setLatitude(result.getResults()!!.get(0).getCoordinate()?.getLatitude() as Float)
            geoPt.setLongitude(result.getResults()!!.get(0).getCoordinate()?.getLongitude() as Float)
            address.setLocation(geoPt)
            address.setPublicLocation(geoPt.clone())
        }
        return address
    }

    fun getCity(): String {
        return city!!
    }

    fun setCity(city: String?) {
        this.city = city
    }

    fun getColony(): String {
        return colony!!
    }

    fun setColony(colony: String?) {
        this.colony = colony
    }

    fun getCountry(): String {
        return country!!
    }

    fun setCountry(country: String?) {
        this.country = country
    }

    fun getInteriorNumber(): String {
        return interiorNumber!!
    }

    fun setInteriorNumber(interiorNumber: String?) {
        this.interiorNumber = interiorNumber
    }

    fun getLocation(): GeoPt? {
        return location
    }

    fun setLocation(location: GeoPt?) {
        this.location = location
    }

    fun getLt(): String {
        return lt!!
    }

    fun setLt(lt: String?) {
        this.lt = lt
    }

    fun getMz(): String {
        return mz!!
    }

    fun setMz(mz: String?) {
        this.mz = mz
    }

    fun getOutdoorNumber(): String {
        return outdoorNumber!!
    }

    fun setOutdoorNumber(outdoorNumber: String?) {
        this.outdoorNumber = outdoorNumber
    }

    fun getPostalCode(): String {
        return postalCode!!
    }

    fun setPostalCode(postalCode: String?) {
        this.postalCode = postalCode
    }

    fun getPublicLocation(): GeoPt? {
        return publicLocation
    }

    fun setPublicLocation(publicLocation: GeoPt?) {
        this.publicLocation = publicLocation
    }

    fun getState(): String {
        return state!!
    }

    fun setState(state: String?) {
        this.state = state
    }

    fun getStreet(): String? {
        return street
    }

    fun setStreet(street: String?) {
        this.street = street
    }

    fun getTownship(): String {
        return township!!
    }

    fun setTownship(township: String?) {
        this.township = township
    }

    fun isVisible(): Boolean {
        return visible
    }

    fun setVisible(visible: Boolean) {
        this.visible = visible
    }

    fun getCountryCode(): String? {
        return countryCode
    }

    fun setCountryCode(countryCode: String?) {
        this.countryCode = countryCode
    }

    override fun clone(): Any {
        return try {
            val address: Address =
                super.clone() as Address
            if (location != null) address.setLocation(location!!.clone())
            address
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
        }
    }

    override fun toString(): String {
        return String.format(
            "%s%s%s%s%s%s%s%s%s%s%s", if (!TextUtils.isEmpty(getStreet())) "" + getStreet() else "",
            if (!TextUtils.isEmpty(getOutdoorNumber())) " " + getOutdoorNumber() else "",
            if (!TextUtils.isEmpty(getInteriorNumber())) " Int " + getInteriorNumber() else "",
            if (!TextUtils.isEmpty(getMz())) " Mz " + getMz() else "",
            if (!TextUtils.isEmpty(getLt())) " Lt " + getLt() else "",
            if (!TextUtils.isEmpty(getColony())) ", " + getColony() else "",
            if (!TextUtils.isEmpty(getTownship())) ", " + getTownship() else "",
            if (!TextUtils.isEmpty(getCity())) ", " + getCity() else "",
            if (!TextUtils.isEmpty(getState())) ", " + getState() else "",
            if (!TextUtils.isEmpty(getPostalCode())) ", " + getPostalCode() else "",
            if (!TextUtils.isEmpty(getCountry())) ", " + getCountry() else ""
        )
    }

    fun getShortAddress(): String? {
        return String.format(
            "%s%s%s%s%s%s", if (!TextUtils.isEmpty(getColony())) getColony() else "",
            if (!TextUtils.isEmpty(getTownship())) ", " + getTownship() else "",
            if (!TextUtils.isEmpty(getCity())) ", " + getCity() else "",
            if (!TextUtils.isEmpty(getState())) ", " + getState() else "",
            if (!TextUtils.isEmpty(getPostalCode())) ", " + getPostalCode() else "",
            if (!TextUtils.isEmpty(getCountry())) ", " + getCountry() else ""
        )
    }

    override fun equals(obj: Any?): Boolean {
        if (obj == null) return false
        if (obj !is Address) return false
        val address: Address =
            obj as Address
        return CommonUtils.equals(city, address.getCity()) &&
                CommonUtils.equals(colony, address.getColony()) &&
                CommonUtils.equals(country, address.getCountry()) &&
                CommonUtils.equals(interiorNumber, address.getInteriorNumber()) &&
                CommonUtils.equals(outdoorNumber, address.getOutdoorNumber()) &&
                CommonUtils.equals(postalCode, address.getPostalCode()) &&
                CommonUtils.equals(state, address.getState()) &&
                CommonUtils.equals(street, address.getStreet()) &&
                CommonUtils.equals(township, address.getTownship()) &&
                CommonUtils.equals(visible, address.isVisible())
    }
}