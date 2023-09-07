package com.maplander.arlibmaplander.data.db.model.gr.enum

enum class BrandTypeEnum {
    NONE,
    OPI,
    AMPI,
    REMAX,
    CB,
    KW,
    GIZP,
    XV,
    WFGT,
    FIABCI,
    AMPICDMX,
    RV;
    open fun typeToEnum(type: Int): BrandTypeEnum? {
        return try {
            values()[type]
        } catch (e: Exception) {
            NONE
        }
    }
}