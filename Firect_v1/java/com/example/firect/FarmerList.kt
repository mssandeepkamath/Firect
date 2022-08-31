package com.example.firect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FarmerList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_farmer_list)
        supportActionBar!!.hide()

    }
}