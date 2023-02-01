package com.kolpolok.nord.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kolpolok.nord.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
    }
}