package com.maplander.arlibmaplander.data.db.model

class Geolocation(
    val latitude: String?,
    val longitude: String?
) {
    companion object {
        val EMPTY_GEOLOCATION = com.maplander.arlibmaplander.data.db.model.Geolocation(null, null)
    }
}
