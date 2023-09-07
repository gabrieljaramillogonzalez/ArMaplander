package com.maplander.arlibmaplander.utils

import android.text.TextUtils
import com.google.gson.GsonBuilder

class CommonUtils {
    companion object{

        fun equals(o1: Any?, o2: Any?): Boolean {
            if (o1 == null && o2 == null) return true
            return if (o1 is String || o2 is String) {
                o1 == null && o2 == null || o1 != null && o1 == o2
            } else if (o1 is Long || o2 is Long) {
                o1 == null && o2 as Long? == 0L || o2 == null && o1 as Long? == 0L || o1 != null && o2 != null && (o1 as Long).toLong() == (o2 as Long).toLong()
            } else if (o1 is String || o2 is String) {
                o1 == null && TextUtils.isEmpty(o2 as String?) || TextUtils.isEmpty(o1 as String?) && o2 == null || o1 != null && o1 == o2
            } else if (o1 is Int || o2 is Int) {
                o1 == null && o2 as Int? == 0 || o2 == null && o1 as Int? == 0 || o1 != null && o2 != null && (o1 as Int).compareTo(
                    (o2 as Int?)!!
                ) == 0
            } else if (o1 is Double || o2 is Double) {
                o1 == null && o2 as Double? == 0.0 || o2 == null && o1 as Double? == 0.0 || o1 != null && o2 != null && (o1 as Double).compareTo(
                    (o2 as Double?)!!
                ) == 0
            } else if (o1 is Float || o2 is Float) {
                o1 == null && o2 as Float? == 0f || o2 == null && o1 as Float? == 0f || o1 != null && o2 != null && (o1 as Float).compareTo(
                    (o2 as Float?)!!
                ) == 0
            } else if (o1 is Boolean || o2 is Boolean) {
                o1 == null && !(o2 as Boolean?)!! || o2 == null && !(o1 as Boolean?)!! || o1 != null && o2 != null && (o1 as Boolean).compareTo(
                    (o2 as Boolean?)!!
                ) == 0
            } else if (o1 is Short || o2 is Short) {
                o1 == null && (o2 as Short?)!!.toInt() == 0 || o2 == null && (o1 as Short?)!!.toInt() == 0 || o1 != null && o2 != null && (o1 as Short).compareTo(
                    (o2 as Short?)!!
                ) == 0
            } else if (o1 is List<*> || o2 is List<*>) {
                o1 == null && o2 == null || o1 != null && (o1 as List<*>?)?.let {
                    compareCollections(
                        it,
                        o2 as List<*>?
                    )
                } == true
            } else o1 != null && o1 == o2
        }


        private fun compareCollections(o1: List<*>, o2: List<*>?): Boolean {
            if (o2 == null || o1.size != o2.size) return false
            for (i in o1.indices) {
                if (!equals(o1[i], o2[i])) return false
            }
            return true
        }


        fun <T> toJson(`object`: T?): String? {
            return if (`object` == null) null else GsonBuilder().create()
                .toJson(`object`, `object`.javaClass)
        }

        fun <T> toObject(json: String?, clazz: Class<*>?): T? {
            return if (json == null) null else GsonBuilder().create()
                .fromJson<Any>(json, clazz) as T
        }
    }
}