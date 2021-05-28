package com.eachut.cylinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.ToggleButton

class PresettingActivity : AppCompatActivity() {
    private lateinit var changePassword: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presetting)

        changePassword = findViewById(R.id.changePassword)


    }
}