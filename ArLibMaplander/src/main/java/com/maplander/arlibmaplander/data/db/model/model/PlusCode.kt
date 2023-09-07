package com.maplander.arlibmaplander.data.db.model.gr.model

import com.google.gson.annotations.SerializedName

class PlusCode {
    @SerializedName("compound_code")
    private var compoundCode: String? = null

    @SerializedName("global_code")
    private var globalCode: String? = null

    fun getCompoundCode(): String? {
        return compoundCode
    }

    fun setCompoundCode(compoundCode: String?) {
        this.compoundCode = compoundCode
    }

    fun getGlobalCode(): String? {
        return globalCode
    }

    fun setGlobalCode(globalCode: String?) {
        this.globalCode = globalCode
    }
}