package com.maplander.armaplander.api

import com.maplander.arlibmaplander.model.VenueWrapper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

interface FoursquareAPI {

    companion object {
        const val BASE_URL = "https://api.foursquare.com/v3/places/"
    }

    @Headers("Authorization:fsq3tbyJ5iFRHvh2wkMs/Pyf5knvh/Dsh0ZPLLYvB9DiFPQ=")
    @GET("search")
    fun searchVenues(@QueryMap params: Map<String, String>): Call<VenueWrapper>
}