package com.example.homework3

import android.R
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.parseColor("#FFB6C1"))
            gravity = android.view.Gravity.CENTER
        }

        val buttonOpenB = Button(this).apply {
            text = "Open Activity B"
            textSize = 18f
            setBackgroundColor(Color.BLUE)
            setTextColor(Color.WHITE)
            setPadding(80, 40, 80, 40)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            setOnClickListener {

                    val intent = Intent(this@MainActivity, ActivityB::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_MULTIPLE_TASK
                    startActivity(intent)
            }
        }

        layout.addView(buttonOpenB)
        setContentView(layout)
    }
}