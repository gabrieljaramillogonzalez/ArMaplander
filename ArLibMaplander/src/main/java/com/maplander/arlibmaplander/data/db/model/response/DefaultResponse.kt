package com.maplander.arlibmaplander.data.db.model.response

import com.maplander.arlibmaplander.utils.CommonUtils

open class DefaultResponse {
    var code = 0
    var description: String? = null

    constructor() {}
    constructor(code: Int, description: String?) {
        this.code = code
        this.description = description
    }

    override fun toString(): String {
        return CommonUtils.toJson(this).toString()
    }
}
