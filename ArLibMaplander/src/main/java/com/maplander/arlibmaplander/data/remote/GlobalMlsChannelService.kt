package com.maplander.arlibmaplander.data.remote

import com.maplander.arlibmaplander.BuildConfig
import com.maplander.arlibmaplander.data.db.model.gr.model.PropertyLite
import com.maplander.arlibmaplander.data.db.model.model.FiltersBigQuery
import com.maplander.arlibmaplander.data.db.model.response.EntityCollectionResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface GlobalMlsChannelService {

    @POST(BuildConfig.FIABCI_CHANNEL_PATH+ "queryPropertyLiteWithFiltersPagedBQ")
    fun queryPropertyLiteWithFiltersPagedBQ(@Query("limit") limit: Int?, @Query("cursor") cursor: Int?, @Body filter: FiltersBigQuery?): Call<EntityCollectionResponse<PropertyLite?>?>?

}