package com.maplander.arlibmaplander.utils

import android.util.Log
import com.maplander.arlibmaplander.BuildConfig

class Logger {
    companion object{
        private val TAG: String = Logger::class.java.simpleName
        private const val EMPTY = ""

        fun v(tag: String?, format: String?, vararg args: Any?) {
            if (BuildConfig.DEBUG) Log.v(tag, format(format, *args as Array<out Any>)!!)
        }

        fun v(tag: String?, msg: String?, e: Throwable?) {
            if (BuildConfig.DEBUG) Log.v(tag, msg, e)
        }

        fun d(tag: String?, format: String?, vararg args: Any?) {
            if (BuildConfig.DEBUG) Log.d(tag, format(format, *args as Array<out Any>)!!)
        }

        fun d(tag: String?, msg: String?, e: Throwable?) {
            if (BuildConfig.DEBUG) Log.d(tag, msg, e)
        }

        fun w(tag: String?, format: String?, vararg args: Any?) {
            if (BuildConfig.DEBUG) Log.w(tag, format(format, *args as Array<out Any>)!!)
        }

        fun i(tag: String?, format: String?, vararg args: Any?) {
            if (BuildConfig.DEBUG) Log.i(tag, format(format, *args as Array<out Any>)!!)
        }

        fun e(tag: String?, format: String?, vararg args: Any?) {
            if (BuildConfig.DEBUG) Log.e(tag, format(format, *args as Array<out Any>)!!)
        }

        fun e(clazz: Class<*>, format: String?, vararg args: Any?) {
            if (BuildConfig.DEBUG) Log.e(
                clazz.javaClass.simpleName,
                format(format, *args as Array<out Any>)!!
            )
        }

        fun e(tag: String?, msg: String?, e: Throwable?) {
            e(tag, msg)
            if (BuildConfig.DEBUG) Log.e(tag, msg, e)
        }

        fun e(clazz: Class<*>, msg: String?, e: Throwable?) {
            e(clazz, msg)
            if (BuildConfig.DEBUG) Log.e(clazz.javaClass.simpleName, msg, e)
        }

        fun e(tag: String?, msg: String?) {
            if (BuildConfig.DEBUG) Log.e(tag, msg!!)
        }

        fun e(clazz: Class<*>, msg: String?) {
            if (BuildConfig.DEBUG) Log.e(clazz.javaClass.simpleName, msg!!)
        }

        private fun format(format: String?, vararg args: Any): String? {
            return try {
                String.format(format ?: EMPTY, *args)
            } catch (e: RuntimeException) {
                Logger.w(
                    TAG,
                    "format error. reason=%s, format=%s",
                    e.message,
                    format
                )
                String.format(EMPTY, format)
            }
        }
    }
}