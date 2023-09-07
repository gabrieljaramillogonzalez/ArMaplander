package com.maplander.arlibmaplander.data.db.model.gr.enum

import android.content.Context
import com.maplander.arlibmaplander.R

enum class PropertyTypeEnum {
    NONE,
    HOUSE,
    OFFICE,
    RETAIL, //COMMERCE
    LAND,
    WAREHOUSE, //STORAGE
    APARTMENT,
    INVESTMENT,
    RESIDENTIAL, //LIVING
    ROOM;

    open fun getDescription(context: Context): String? {
        return when (this) {
            HOUSE -> context.getString(R.string.house)
            OFFICE -> context.getString(R.string.office)
            RETAIL -> context.getString(R.string.retail)
            LAND -> context.getString(R.string.land)
            WAREHOUSE -> context.getString(R.string.warehouse)
            APARTMENT -> context.getString(R.string.apartment)
            INVESTMENT -> context.getString(R.string.real_estate_investment)
            ROOM -> context.getString(R.string.room)
            RESIDENTIAL -> context.getString(R.string.dwelling)
            NONE -> ""
            else -> ""
        }
    }

    open fun getDescription(context: Context, propertyType: String?): String? {
        return when (propertyType) {
            "HOUSE" -> context.getString(R.string.the_house)
            "OFFICE" -> context.getString(R.string.the_office)
            "RETAIL" -> context.getString(R.string.the_retail)
            "LAND" -> context.getString(R.string.the_land)
            "WAREHOUSE" -> context.getString(R.string.the_warehouse)
            "APARTMENT" -> context.getString(R.string.the_apartment)
            "INVESTMENT" -> context.getString(R.string.the_real_estate_investment)
            "ROOM" -> context.getString(R.string.the_room)
            "NONE", "RESIDENTIAL" -> ""
            else -> ""
        }
    }

    open fun getDescriptionPlural(context: Context): String? {
        return when (this) {
            HOUSE -> context.getString(R.string.houses)
            OFFICE -> context.getString(R.string.officess)
            RETAIL -> context.getString(R.string.retails)
            LAND -> context.getString(R.string.lands)
            WAREHOUSE -> context.getString(R.string.warehouses)
            APARTMENT -> context.getString(R.string.apartments)
            INVESTMENT -> context.getString(R.string.real_estate_investments)
            ROOM -> context.getString(R.string.rooms)
            RESIDENTIAL -> context.getString(R.string.dwellings)
            NONE -> ""
            else -> ""
        }
    }

    open fun getDescriptionString(context: Context, propertyType: String?): String? {
        return when (propertyType) {
            "HOUSE", "Casa" -> context.getString(R.string.house)
            "OFFICE", "Oficina" -> context.getString(R.string.office)
            "RETAIL", "Comercio" -> context.getString(R.string.retail)
            "LAND", "Terreno" -> context.getString(R.string.land)
            "WAREHOUSE", "Bodega" -> context.getString(R.string.warehouse)
            "APARTMENT", "Departamento" -> context.getString(R.string.apartment)
            "INVESTMENT", "Inversión" -> context.getString(R.string.real_estate_investment)
            "ROOM", "Habitación" -> context.getString(R.string.room)
            "NONE", "RESIDENTIAL" -> ""
            else -> ""
        }
    }
}