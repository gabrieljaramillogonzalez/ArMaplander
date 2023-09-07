package com.maplander.arlibmaplander.data.db.model.gr.model

import com.google.gson.annotations.SerializedName

class PlacesAppleBodyResponse {
    @SerializedName("results")
    private var results: List<ResultApple>? = null

    constructor() {
        results = ArrayList<ResultApple>()
    }

    constructor(results: List<ResultApple>?) {
        this.results = results
    }

    fun getResults(): List<ResultApple>? {
        return results
    }

    fun setResults(results: List<ResultApple>?) {
        this.results = results
    }
}