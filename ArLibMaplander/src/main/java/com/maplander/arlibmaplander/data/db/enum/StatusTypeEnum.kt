package com.maplander.arlibmaplander.data.db.model.gr.enum

import com.maplander.arlibmaplander.R

enum class StatusTypeEnum {
    NONE, READY, ANNOUNCED, DRAFT, HIDDEN, EXPIRED;

    open fun getStringRes(): Int {
        return when (this) {
            READY -> R.string.ready
            ANNOUNCED -> R.string.announced
            DRAFT -> R.string.draft
            HIDDEN -> R.string.hidden
            EXPIRED -> R.string.expired
            else -> R.string.empty
        }
    }

}