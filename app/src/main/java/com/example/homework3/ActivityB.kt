package com.example.homework3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val buttonOpenC = findViewById<Button>(R.id.buttonOpenC)

        buttonOpenC.setOnClickListener{
            val intent = Intent(this, ActivityC::class.java)
            startActivity(intent)
        }

    }
}