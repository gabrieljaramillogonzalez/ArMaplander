package com.maplander.arlibmaplander.data.db.model.gr.model

import android.content.Context
import com.maplander.arlibmaplander.R
import com.maplander.arlibmaplander.data.db.model.gr.enum.BrandTypeEnum
import com.maplander.arlibmaplander.data.db.enum.OfferingTypeEnum
import com.maplander.arlibmaplander.data.db.model.gr.enum.PropertyTypeEnum
import com.maplander.arlibmaplander.data.db.model.gr.enum.PropertyTypeEnum.*
import com.maplander.arlibmaplander.data.db.model.gr.enum.StatusTypeEnum
import java.text.SimpleDateFormat
import java.util.*

class PropertyLite {
    private var address: Address? = null
    private var brand: BrandTypeEnum? = null
    private var changeDate = 0
    private var creationDate = 0
    private var currency: String? = null
    private var endPublishDate = 0
    private var features: Features? = null
    private var id: Long? = null
    private var isOffline = false
    private var image: String? = null
    private var mls = false
    private var offering: OfferingTypeEnum? = null
    private var officeId: Long? = null
    private var price = 0.0
    private var startPublishDate = 0
    private var status: StatusTypeEnum? = null
    private var type: PropertyTypeEnum? = null
    private var url: String? = null
    private var userId: Long? = null

    fun getAddress(): Address? {
        return address
    }

    fun setAddress(address: Address?) {
        this.address = address
    }

    fun getBrand(): BrandTypeEnum? {
        return brand
    }

    fun setBrand(brand: BrandTypeEnum?) {
        this.brand = brand
    }

    fun getChangeDate(): Int {
        return changeDate
    }

    fun setChangeDate(changeDate: Int) {
        this.changeDate = changeDate
    }

    fun getCreationDate(): Int {
        return creationDate
    }

    fun setCreationDate(creationDate: Int) {
        this.creationDate = creationDate
    }

    fun getCurrency(): String? {
        return currency
    }

    fun setCurrency(currency: String?) {
        this.currency = currency
    }

    fun getEndPublishDate(): Int {
        return endPublishDate
    }

    fun setEndPublishDate(endPublishDate: Int) {
        this.endPublishDate = endPublishDate
    }

    fun getFeatures(): Features? {
        return features
    }

    fun setFeatures(features: Features?) {
        this.features = features
    }

    fun getId(): Long? {
        return id
    }

    fun setId(id: Long?) {
        this.id = id
    }

    fun isOffline(): Boolean {
        return isOffline
    }

    fun setOffline(offline: Boolean) {
        isOffline = offline
    }

    fun getImage(): String? {
        if (image == null) return image
        if (!image!!.contains("https")) image = image!!.replace("http://", "https://")
        return image
    }

    fun setImage(image: String?) {
        this.image = image
    }

    fun isMls(): Boolean {
        return mls
    }

    fun setMls(mls: Boolean) {
        this.mls = mls
    }

    fun getOffering(): OfferingTypeEnum? {
        return offering
    }

    fun setOffering(offering: OfferingTypeEnum?) {
        this.offering = offering
    }

    fun getOfficeId(): Long? {
        return officeId
    }

    fun setOfficeId(officeId: Long?) {
        this.officeId = officeId
    }

    fun getPrice(): Double {
        return price
    }

    fun setPrice(price: Double) {
        this.price = price
    }

    fun getStartPublishDate(): Int {
        return startPublishDate
    }

    fun setStartPublishDate(startPublishDate: Int) {
        this.startPublishDate = startPublishDate
    }

    fun getStatus(): StatusTypeEnum? {
        return status
    }

    fun setStatus(status: StatusTypeEnum?) {
        this.status = status
    }

    fun getType(): PropertyTypeEnum? {
        return type
    }

    fun setType(type: PropertyTypeEnum?) {
        this.type = type
    }

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String?) {
        this.url = url
    }

    fun getUserId(): Long? {
        return userId
    }

    fun setUserId(userId: Long?) {
        this.userId = userId
    }

    fun isValid(): Boolean {
        return getType() != null && getCurrency() != null && getAddress() != null && getAddress()?.getLocation() != null
    }

    fun getImage(size: Int): String? {
        if (image!!.indexOf("lh3.googleusercontent.com") == -1) return image
        val sizeString = Math.min(size, 1600).toString()
        var temp = ""
        if (!image!!.contains("https")) image = image!!.replace("http://", "https://")
        temp = image!!
        if (temp.contains("=s")) {
            val index = temp.indexOf("=s") + 2
            if (temp.substring(index) != sizeString) temp.replace(temp.substring(index), sizeString)
        } else temp = String.format("%s=s%s", temp, sizeString)
        return temp
    }

    fun getStockImage(): Int {
        return when (getType()) {
            HOUSE, ROOM -> R.drawable.stock_house
            OFFICE -> R.drawable.stock_office
            RETAIL -> R.drawable.stock_retail
            LAND -> R.drawable.stock_land
            WAREHOUSE -> R.drawable.stock_warehouse
            APARTMENT -> R.drawable.stock_apartment
            INVESTMENT -> R.drawable.stock_investment
            else -> R.drawable.no_image_found
        }
    }

    fun isExpire(gmls: Boolean): Boolean {
        var expire = false
        if (!gmls) {
            val dateFormatFromInt = SimpleDateFormat("yyyyMMdd")
            try {
                val date = dateFormatFromInt.parse(endPublishDate.toString())
                val date1 = Date()
                val dias =
                    ((date.time - date1.time) / 86400000).toInt() + if (date.time - date1.time > 0) 1 else 0
                expire = dias <= 7
            } catch (e: Exception) {
            }
        }
        if (expire) if (!(status === StatusTypeEnum.ANNOUNCED)) expire = false
        return expire
    }

    fun getDayExpire(context: Context): String? {
        var dias = 0
        val dateFormatFromInt = SimpleDateFormat("yyyyMMdd")
        try {
            val date = dateFormatFromInt.parse(endPublishDate.toString())
            val date1 = Date()
            dias =
                ((date.time - date1.time) / 86400000).toInt() + if (date.time - date1.time > 0) 1 else 0
        } catch (e: Exception) {
        }
        return if (dias <= 0) "0 " + context.getString(R.string.days) else if (dias == 0) dias.toString() + context.getString(
            R.string.day
        ) else dias.toString() + context.getString(R.string.days)
    }
}