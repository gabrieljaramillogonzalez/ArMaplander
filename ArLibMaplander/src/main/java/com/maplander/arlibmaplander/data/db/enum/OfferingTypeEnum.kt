package com.maplander.arlibmaplander.data.db.enum

import android.content.Context
import com.maplander.arlibmaplander.R

enum class OfferingTypeEnum {
    NONE,
    SALE,
    RENT,
    SENT_AND_RENT;

    open fun getDescription(context: Context): String? {
        return when (this) {
            SALE -> context.resources.getStringArray(R.array.offering_type_array)[0]
            RENT -> context.resources.getStringArray(R.array.offering_type_array)[1]
            else -> ""
        }
    }

    open fun toString(context: Context): String? {
        return when (this) {
            SALE -> context.resources.getString(R.string.sell)
            RENT -> context.resources.getString(R.string.lease)
            else -> ""
        }
    }

    open fun getDescription(context: Context, offeringType: String?): String? {
        return when (offeringType) {
            "SALE", "Venta" -> context.resources.getStringArray(R.array.offering_type_array)[0].toLowerCase()
            "RENT", "Renta" -> context.resources.getStringArray(R.array.offering_type_array)[1].toLowerCase()
            else -> ""
        }
    }
}