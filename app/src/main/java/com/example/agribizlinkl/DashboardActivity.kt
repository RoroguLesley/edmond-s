package com.example.agribizlinkl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intentsactivity)

        val butn = findViewById<Button>(R.id.mBtnPrevpage)
        butn.setOnClickListener {
            val intent = Intent(this, intentsactivity::class.java)
            startActivity(intent)
        }
    }
}