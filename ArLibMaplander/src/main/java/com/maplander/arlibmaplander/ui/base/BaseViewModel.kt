package com.maplander.arlibmaplander.ui.base

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.maplander.arlibmaplander.data.AppDataManager


open class BaseViewModel : ViewModel(){

    private lateinit var context : Context
    private lateinit var bundle: Bundle
    private var mDataManager: AppDataManager? = null

    open fun onAttach(bundle: Bundle,context: Context){
        this.context = context
        this.bundle = bundle
        this.mDataManager = AppDataManager(context)
    }

    open fun getMContext():Context{
        return context
    }

    open fun getMBundle():Bundle{
        return bundle
    }

    open fun getDataManager(): AppDataManager? {
        return mDataManager
    }
}