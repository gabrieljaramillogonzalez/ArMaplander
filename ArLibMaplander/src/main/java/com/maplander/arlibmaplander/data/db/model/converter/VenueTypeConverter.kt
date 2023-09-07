package com.maplander.arlibmaplander.data.db.model.converter

import com.maplander.arlibmaplander.data.db.model.Location
import com.maplander.arlibmaplander.data.db.model.Venue
import com.maplander.arlibmaplander.data.db.model.VenueWrapper
import com.google.gson.*
import java.lang.reflect.Type

class VenueTypeConverter : JsonDeserializer<com.maplander.arlibmaplander.data.db.model.VenueWrapper> {
    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): com.maplander.arlibmaplander.data.db.model.VenueWrapper {
        val responseObject = json.asJsonObject

        if (validateResponse(responseObject)) {
            return com.maplander.arlibmaplander.data.db.model.VenueWrapper(getVenues(responseObject!!))
        }
        return (com.maplander.arlibmaplander.data.db.model.VenueWrapper(listOf()))
    }

    private fun validateResponse(json: JsonObject?): Boolean {
        return json != null
    }

    @Throws(JsonParseException::class)
    private fun getVenues(responseObject: JsonObject): List<com.maplander.arlibmaplander.data.db.model.Venue> {
        val venues = responseObject.getAsJsonArray("results")
        return venues.map<JsonElement, com.maplander.arlibmaplander.data.db.model.Venue> { getVenue(it.asJsonObject) }
    }

    @Throws(AssertionError::class)
    private fun getVenue(rawVenue: JsonObject): com.maplander.arlibmaplander.data.db.model.Venue {

        val name = rawVenue.getAsJsonPrimitive("name").asString
        val location = rawVenue.getAsJsonObject("location")

        val address = location.getAsJsonPrimitive("formatted_address")?.asString ?: "not set"
        val lat = rawVenue.getAsJsonObject("geocodes").getAsJsonObject("main").getAsJsonPrimitive("latitude").asDouble
        val long = rawVenue.getAsJsonObject("geocodes").getAsJsonObject("main").getAsJsonPrimitive("longitude").asDouble

        val categories = rawVenue.getAsJsonArray("categories").get(0)?.asJsonObject

        val iconURL = categories?.getAsJsonObject("icon")?.getAsJsonPrimitive("prefix")?.asString + "64.png"

        return com.maplander.arlibmaplander.data.db.model.Venue(
            name,
            address,
            Any(),
            0.0,
            Any(),
            iconURL,
            com.maplander.arlibmaplander.data.db.model.Location(lat, long, address, address),
            "",
            Any(),
            ""
        )
    }
}