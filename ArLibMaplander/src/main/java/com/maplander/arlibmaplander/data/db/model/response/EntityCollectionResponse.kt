package com.maplander.arlibmaplander.data.db.model.response

import com.maplander.arlibmaplander.utils.CommonUtils

class EntityCollectionResponse<T> : DefaultResponse {
    var items: List<T>? = null
    var nextPageToken: String? = null

    constructor() : super() {}
    constructor(code: Int, description: String?, items: List<T>?, nextPageToken: String?) : super(
        code,
        description
    ) {
        this.items = items
        this.nextPageToken = nextPageToken
    }

    override fun toString(): String {
        return CommonUtils.toJson(this).toString()
    }
}
