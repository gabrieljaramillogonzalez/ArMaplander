package com.maplander.arlibmaplander.data.remote

import com.maplander.arlibmaplander.data.db.model.gr.model.PropertyLite
import com.maplander.arlibmaplander.data.db.model.model.FiltersBigQuery
import com.maplander.arlibmaplander.data.db.model.response.EntityCollectionResponse
import retrofit2.Call

class AppApiHelper {
    private var globalMlsChannelService: GlobalMlsChannelService? = null

    constructor() {
        globalMlsChannelService = API.createService(GlobalMlsChannelService::class.java)
    }

    fun queryPropertyLiteWithFiltersPagedBQ(limit: Int?, cursor: Int?, filter: FiltersBigQuery?): Call<EntityCollectionResponse<PropertyLite?>?>? {
        return globalMlsChannelService?.queryPropertyLiteWithFiltersPagedBQ(null, null, filter)
    }
}