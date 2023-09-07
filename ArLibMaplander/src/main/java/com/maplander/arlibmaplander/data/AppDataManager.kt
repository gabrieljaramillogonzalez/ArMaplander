package com.maplander.arlibmaplander.data

import android.content.Context
import com.maplander.arlibmaplander.data.db.model.gr.model.PropertyLite
import com.maplander.arlibmaplander.data.db.model.model.FiltersBigQuery
import com.maplander.arlibmaplander.data.db.model.response.EntityCollectionResponse
import com.maplander.arlibmaplander.data.remote.AppApiHelper
import retrofit2.Callback

class AppDataManager(mConetxt: Context) {
    private var mConetxt : Context? = mConetxt
    private var mApiHelper : AppApiHelper? = null

    init {
        mApiHelper = AppApiHelper()
    }

    fun queryPropertyLiteWithFiltersPagedBQ(limit: Int?, cursor: Int?, filter: FiltersBigQuery?, callback: Callback<EntityCollectionResponse<PropertyLite?>?>? ) {
        mApiHelper?.queryPropertyLiteWithFiltersPagedBQ(limit, cursor, filter)?.enqueue(callback!!)
    }
}