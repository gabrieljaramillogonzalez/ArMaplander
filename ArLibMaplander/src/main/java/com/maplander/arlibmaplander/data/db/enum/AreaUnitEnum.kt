package com.maplander.arlibmaplander.data.db.enum

import android.content.Context
import com.maplander.arlibmaplander.R

enum class AreaUnitEnum {
    NONE, M2, FT2;

    open fun toString(context: Context): String? {
        return when (this) {
            M2 -> context.getString(R.string.sq_m)
            FT2 -> context.getString(R.string.sq_ft)
            else -> ""
        }
    }
}