package com.maplander.arlibmaplander.data.db.model.model

import com.maplander.arlibmaplander.data.db.model.gr.model.Address
import com.maplander.arlibmaplander.utils.CommonUtils

class Amenities : Cloneable{
    private var adjacentCommerce = false
    private var adjacentGym = false
    private var adjacentPicnic = false
    private var airConditioner = false
    private var balcony = false
    private var countrySide = false
    private var customerParking = false
    private var differentAbilities = false
    private var diningRoom = false
    private var doubleHeight = false
    private var downtown = false
    private var dressingRooms = false
    private var facingStreet = false
    private var finishings = false
    private var furnished = false
    private var garden = false
    private var goodReachableTraffic = false
    private var gym = false
    private var highResistanceFloors = false
    private var highSpeedInternet = false
    private var inCommercialArea = false
    private var inIndustrialPark = false
    private var inShoppingCenter = false
    private var jacuzzi = false
    private var kitchenServices = false
    private var maidsBathroom = false
    private var maneuverArea = false
    private var meetingRoom = false
    private var mezzanine = false
    private var mixedBuilding = false
    private var naturalLighting = false
    private var nearFitnessCentre = false
    private var nearHighway = false
    private var nearHospital = false
    private var nearPark = false
    private var nearPublicTransportation = false
    private var nearSchools = false
    private var nearShops = false
    private var offices = false
    private var onBusyRoad = false
    private var onQuietRoad = false
    private var openSpace = false
    private var petFriendly = false
    private var platforms = false
    private var playground = false
    private var playroom = false
    private var pool = false
    private var railSpur = false
    private var railyard = false
    private var reception = false
    private var roofGarden = false
    private var securityGuard = false
    private var storage = false
    private var visitorParking = false

    constructor() {}

    constructor(extras: List<String?>) {
        adjacentCommerce = extras.contains("adjacentCommerce")
        adjacentGym = extras.contains("adjacentGym")
        adjacentPicnic = extras.contains("adjacentPicnic")
        airConditioner = extras.contains("airConditioner")
        balcony = extras.contains("balcony")
        countrySide = extras.contains("countrySide")
        customerParking = extras.contains("customerParking")
        differentAbilities = extras.contains("differentAbilities")
        diningRoom = extras.contains("diningRoom")
        doubleHeight = extras.contains("doubleHeight")
        downtown = extras.contains("downtown")
        dressingRooms = extras.contains("dressingRooms")
        facingStreet = extras.contains("facingStreet")
        finishings = extras.contains("finishings")
        furnished = extras.contains("furnished")
        garden = extras.contains("garden")
        goodReachableTraffic = extras.contains("goodReachableTraffic")
        gym = extras.contains("gym")
        highResistanceFloors = extras.contains("highResistanceFloors")
        highSpeedInternet = extras.contains("highSpeedInternet")
        inCommercialArea = extras.contains("inCommercialArea")
        inIndustrialPark = extras.contains("inIndustrialPark")
        inShoppingCenter = extras.contains("inShoppingCenter")
        jacuzzi = extras.contains("jacuzzi")
        kitchenServices = extras.contains("kitchenServices")
        maidsBathroom = extras.contains("maidsBathroom")
        maneuverArea = extras.contains("maneuverArea")
        meetingRoom = extras.contains("meetingRoom")
        mezzanine = extras.contains("mezzanine")
        mixedBuilding = extras.contains("mixedBuilding")
        naturalLighting = extras.contains("naturalLighting")
        nearFitnessCentre = extras.contains("nearFitnessCentre")
        nearHighway = extras.contains("nearHighway")
        nearHospital = extras.contains("nearHospital")
        nearPark = extras.contains("nearPark")
        nearPublicTransportation = extras.contains("nearPublicTransportation")
        nearSchools = extras.contains("nearSchools")
        nearShops = extras.contains("nearShops")
        offices = extras.contains("offices")
        onBusyRoad = extras.contains("onBusyRoad")
        onQuietRoad = extras.contains("onQuietRoad")
        openSpace = extras.contains("openSpace")
        petFriendly = extras.contains("petFriendly")
        platforms = extras.contains("platforms")
        playground = extras.contains("playground")
        playroom = extras.contains("playroom")
        pool = extras.contains("pool")
        railSpur = extras.contains("railSpur")
        railyard = extras.contains("railyard")
        reception = extras.contains("reception")
        roofGarden = extras.contains("roofGarden")
        securityGuard = extras.contains("securityGuard")
        storage = extras.contains("storage")
        visitorParking = extras.contains("visitorParking")
    }

    fun isAdjacentCommerce(): Boolean {
        return adjacentCommerce
    }

    fun setAdjacentCommerce(adjacentCommerce: Boolean) {
        this.adjacentCommerce = adjacentCommerce
    }

    fun isAdjacentGym(): Boolean {
        return adjacentGym
    }

    fun setAdjacentGym(adjacentGym: Boolean) {
        this.adjacentGym = adjacentGym
    }

    fun isAdjacentPicnic(): Boolean {
        return adjacentPicnic
    }

    fun setAdjacentPicnic(adjacentPicnic: Boolean) {
        this.adjacentPicnic = adjacentPicnic
    }

    fun isAirConditioner(): Boolean {
        return airConditioner
    }

    fun setAirConditioner(airConditioner: Boolean) {
        this.airConditioner = airConditioner
    }

    fun isBalcony(): Boolean {
        return balcony
    }

    fun setBalcony(balcony: Boolean) {
        this.balcony = balcony
    }

    fun isCountrySide(): Boolean {
        return countrySide
    }

    fun setCountrySide(countrySide: Boolean) {
        this.countrySide = countrySide
    }

    fun isCustomerParking(): Boolean {
        return customerParking
    }

    fun setCustomerParking(customerParking: Boolean) {
        this.customerParking = customerParking
    }

    fun isDifferentAbilities(): Boolean {
        return differentAbilities
    }

    fun setDifferentAbilities(differentAbilities: Boolean) {
        this.differentAbilities = differentAbilities
    }

    fun isDiningRoom(): Boolean {
        return diningRoom
    }

    fun setDiningRoom(diningRoom: Boolean) {
        this.diningRoom = diningRoom
    }

    fun isDoubleHeight(): Boolean {
        return doubleHeight
    }

    fun setDoubleHeight(doubleHeight: Boolean) {
        this.doubleHeight = doubleHeight
    }

    fun isDowntown(): Boolean {
        return downtown
    }

    fun setDowntown(downtown: Boolean) {
        this.downtown = downtown
    }

    fun isDressingRooms(): Boolean {
        return dressingRooms
    }

    fun setDressingRooms(dressingRooms: Boolean) {
        this.dressingRooms = dressingRooms
    }

    fun isFacingStreet(): Boolean {
        return facingStreet
    }

    fun setFacingStreet(facingStreet: Boolean) {
        this.facingStreet = facingStreet
    }

    fun isFinishings(): Boolean {
        return finishings
    }

    fun setFinishings(finishings: Boolean) {
        this.finishings = finishings
    }

    fun isFurnished(): Boolean {
        return furnished
    }

    fun setFurnished(furnished: Boolean) {
        this.furnished = furnished
    }

    fun isGarden(): Boolean {
        return garden
    }

    fun setGarden(garden: Boolean) {
        this.garden = garden
    }

    fun isGoodReachableTraffic(): Boolean {
        return goodReachableTraffic
    }

    fun setGoodReachableTraffic(goodReachableTraffic: Boolean) {
        this.goodReachableTraffic = goodReachableTraffic
    }

    fun isGym(): Boolean {
        return gym
    }

    fun setGym(gym: Boolean) {
        this.gym = gym
    }

    fun isHighResistanceFloors(): Boolean {
        return highResistanceFloors
    }

    fun setHighResistanceFloors(highResistanceFloors: Boolean) {
        this.highResistanceFloors = highResistanceFloors
    }

    fun isHighSpeedInternet(): Boolean {
        return highSpeedInternet
    }

    fun setHighSpeedInternet(highSpeedInternet: Boolean) {
        this.highSpeedInternet = highSpeedInternet
    }

    fun isInCommercialArea(): Boolean {
        return inCommercialArea
    }

    fun setInCommercialArea(inCommercialArea: Boolean) {
        this.inCommercialArea = inCommercialArea
    }

    fun isInIndustrialPark(): Boolean {
        return inIndustrialPark
    }

    fun setInIndustrialPark(inIndustrialPark: Boolean) {
        this.inIndustrialPark = inIndustrialPark
    }

    fun isInShoppingCenter(): Boolean {
        return inShoppingCenter
    }

    fun setInShoppingCenter(inShoppingCenter: Boolean) {
        this.inShoppingCenter = inShoppingCenter
    }

    fun isJacuzzi(): Boolean {
        return jacuzzi
    }

    fun setJacuzzi(jacuzzi: Boolean) {
        this.jacuzzi = jacuzzi
    }

    fun isKitchenServices(): Boolean {
        return kitchenServices
    }

    fun setKitchenServices(kitchenServices: Boolean) {
        this.kitchenServices = kitchenServices
    }

    fun isMaidsBathroom(): Boolean {
        return maidsBathroom
    }

    fun setMaidsBathroom(maidsBathroom: Boolean) {
        this.maidsBathroom = maidsBathroom
    }

    fun isManeuverArea(): Boolean {
        return maneuverArea
    }

    fun setManeuverArea(maneuverArea: Boolean) {
        this.maneuverArea = maneuverArea
    }

    fun isMeetingRoom(): Boolean {
        return meetingRoom
    }

    fun setMeetingRoom(meetingRoom: Boolean) {
        this.meetingRoom = meetingRoom
    }

    fun isMezzanine(): Boolean {
        return mezzanine
    }

    fun setMezzanine(mezzanine: Boolean) {
        this.mezzanine = mezzanine
    }

    fun isMixedBuilding(): Boolean {
        return mixedBuilding
    }

    fun setMixedBuilding(mixedBuilding: Boolean) {
        this.mixedBuilding = mixedBuilding
    }

    fun isNaturalLighting(): Boolean {
        return naturalLighting
    }

    fun setNaturalLighting(naturalLighting: Boolean) {
        this.naturalLighting = naturalLighting
    }

    fun isNearFitnessCentre(): Boolean {
        return nearFitnessCentre
    }

    fun setNearFitnessCentre(nearFitnessCentre: Boolean) {
        this.nearFitnessCentre = nearFitnessCentre
    }

    fun isNearHighway(): Boolean {
        return nearHighway
    }

    fun setNearHighway(nearHighway: Boolean) {
        this.nearHighway = nearHighway
    }

    fun isNearHospital(): Boolean {
        return nearHospital
    }

    fun setNearHospital(nearHospital: Boolean) {
        this.nearHospital = nearHospital
    }

    fun isNearPark(): Boolean {
        return nearPark
    }

    fun setNearPark(nearPark: Boolean) {
        this.nearPark = nearPark
    }

    fun isNearPublicTransportation(): Boolean {
        return nearPublicTransportation
    }

    fun setNearPublicTransportation(nearPublicTransportation: Boolean) {
        this.nearPublicTransportation = nearPublicTransportation
    }

    fun isNearSchools(): Boolean {
        return nearSchools
    }

    fun setNearSchools(nearSchools: Boolean) {
        this.nearSchools = nearSchools
    }

    fun isNearShops(): Boolean {
        return nearShops
    }

    fun setNearShops(nearShops: Boolean) {
        this.nearShops = nearShops
    }

    fun isOffices(): Boolean {
        return offices
    }

    fun setOffices(offices: Boolean) {
        this.offices = offices
    }

    fun isOnBusyRoad(): Boolean {
        return onBusyRoad
    }

    fun setOnBusyRoad(onBusyRoad: Boolean) {
        this.onBusyRoad = onBusyRoad
    }

    fun isOnQuietRoad(): Boolean {
        return onQuietRoad
    }

    fun setOnQuietRoad(onQuietRoad: Boolean) {
        this.onQuietRoad = onQuietRoad
    }

    fun isOpenSpace(): Boolean {
        return openSpace
    }

    fun setOpenSpace(openSpace: Boolean) {
        this.openSpace = openSpace
    }

    fun isPetFriendly(): Boolean {
        return petFriendly
    }

    fun setPetFriendly(petFriendly: Boolean) {
        this.petFriendly = petFriendly
    }

    fun isPlatforms(): Boolean {
        return platforms
    }

    fun setPlatforms(platforms: Boolean) {
        this.platforms = platforms
    }

    fun isPlayground(): Boolean {
        return playground
    }

    fun setPlayground(playground: Boolean) {
        this.playground = playground
    }

    fun isPlayroom(): Boolean {
        return playroom
    }

    fun setPlayroom(playroom: Boolean) {
        this.playroom = playroom
    }

    fun isPool(): Boolean {
        return pool
    }

    fun setPool(pool: Boolean) {
        this.pool = pool
    }

    fun isRailSpur(): Boolean {
        return railSpur
    }

    fun setRailSpur(railSpur: Boolean) {
        this.railSpur = railSpur
    }

    fun isRailyard(): Boolean {
        return railyard
    }

    fun setRailyard(railyard: Boolean) {
        this.railyard = railyard
    }

    fun isReception(): Boolean {
        return reception
    }

    fun setReception(reception: Boolean) {
        this.reception = reception
    }

    fun isRoofGarden(): Boolean {
        return roofGarden
    }

    fun setRoofGarden(roofGarden: Boolean) {
        this.roofGarden = roofGarden
    }

    fun isSecurityGuard(): Boolean {
        return securityGuard
    }

    fun setSecurityGuard(securityGuard: Boolean) {
        this.securityGuard = securityGuard
    }

    fun isStorage(): Boolean {
        return storage
    }

    fun setStorage(storage: Boolean) {
        this.storage = storage
    }

    fun isVisitorParking(): Boolean {
        return visitorParking
    }

    fun setVisitorParking(visitorParking: Boolean) {
        this.visitorParking = visitorParking
    }

    override fun clone(): Any {
        return try {
            val address: Amenities =
                super.clone() as Amenities
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
        }
    }

    override fun equals(obj: Any?): Boolean {
        if (obj == null) return false
        if (obj !is Amenities) return false
        val obj1 = obj
        return CommonUtils.equals(adjacentCommerce, obj1.isAdjacentCommerce()) &&
                CommonUtils.equals(adjacentGym, obj1.isAdjacentGym()) &&
                CommonUtils.equals(adjacentPicnic, obj1.isAdjacentPicnic()) &&
                CommonUtils.equals(airConditioner, obj1.isAirConditioner()) &&
                CommonUtils.equals(balcony, obj1.isBalcony()) &&
                CommonUtils.equals(countrySide, obj1.isCountrySide()) &&
                CommonUtils.equals(customerParking, obj1.isCustomerParking()) &&
                CommonUtils.equals(differentAbilities, obj1.isDifferentAbilities()) &&
                CommonUtils.equals(diningRoom, obj1.isDiningRoom()) &&
                CommonUtils.equals(doubleHeight, obj1.isDoubleHeight()) &&
                CommonUtils.equals(downtown, obj1.isDowntown()) &&
                CommonUtils.equals(dressingRooms, obj1.isDressingRooms()) &&
                CommonUtils.equals(facingStreet, obj1.isFacingStreet()) &&
                CommonUtils.equals(finishings, obj1.isFinishings()) &&
                CommonUtils.equals(furnished, obj1.isFurnished()) &&
                CommonUtils.equals(garden, obj1.isGarden()) &&
                CommonUtils.equals(goodReachableTraffic, obj1.isGoodReachableTraffic()) &&
                CommonUtils.equals(gym, obj1.isGym()) &&
                CommonUtils.equals(highResistanceFloors, obj1.isHighResistanceFloors()) &&
                CommonUtils.equals(highSpeedInternet, obj1.isHighSpeedInternet()) &&
                CommonUtils.equals(inCommercialArea, obj1.isInCommercialArea()) &&
                CommonUtils.equals(inIndustrialPark, obj1.isInIndustrialPark()) &&
                CommonUtils.equals(inShoppingCenter, obj1.isInShoppingCenter()) &&
                CommonUtils.equals(jacuzzi, obj1.isJacuzzi()) &&
                CommonUtils.equals(kitchenServices, obj1.isKitchenServices()) &&
                CommonUtils.equals(maidsBathroom, obj1.isMaidsBathroom()) &&
                CommonUtils.equals(maneuverArea, obj1.isManeuverArea()) &&
                CommonUtils.equals(meetingRoom, obj1.isMeetingRoom()) &&
                CommonUtils.equals(mezzanine, obj1.isMezzanine()) &&
                CommonUtils.equals(mixedBuilding, obj1.isMixedBuilding()) &&
                CommonUtils.equals(naturalLighting, obj1.isNaturalLighting()) &&
                CommonUtils.equals(nearFitnessCentre, obj1.isNearFitnessCentre()) &&
                CommonUtils.equals(nearHighway, obj1.isNearHighway()) &&
                CommonUtils.equals(nearHospital, obj1.isNearHospital()) &&
                CommonUtils.equals(nearPark, obj1.isNearPark()) &&
                CommonUtils.equals(nearPublicTransportation, obj1.isNearPublicTransportation()) &&
                CommonUtils.equals(nearSchools, obj1.isNearSchools()) &&
                CommonUtils.equals(nearShops, obj1.isNearShops()) &&
                CommonUtils.equals(offices, obj1.isOffices()) &&
                CommonUtils.equals(onBusyRoad, obj1.isOnBusyRoad()) &&
                CommonUtils.equals(onQuietRoad, obj1.isOnQuietRoad()) &&
                CommonUtils.equals(openSpace, obj1.isOpenSpace()) &&
                CommonUtils.equals(petFriendly, obj1.isPetFriendly()) &&
                CommonUtils.equals(platforms, obj1.isPlatforms()) &&
                CommonUtils.equals(playground, obj1.isPlayground()) &&
                CommonUtils.equals(playroom, obj1.isPlayroom()) &&
                CommonUtils.equals(pool, obj1.isPool()) &&
                CommonUtils.equals(railSpur, obj1.isRailSpur()) &&
                CommonUtils.equals(railyard, obj1.isRailyard()) &&
                CommonUtils.equals(reception, obj1.isReception()) &&
                CommonUtils.equals(roofGarden, obj1.isRoofGarden()) &&
                CommonUtils.equals(securityGuard, obj1.isSecurityGuard()) &&
                CommonUtils.equals(storage, obj1.isStorage()) &&
                CommonUtils.equals(visitorParking, obj1.isVisitorParking())
    }
}