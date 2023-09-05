package com.maplander.armaplander

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maplander.arlibmaplander.ui.ar_properties.ArPropertiesActivity
import com.maplander.armaplander.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val intent = Intent(this , ArPropertiesActivity::class.java)
        startActivity(intent)
    }
}