package com.example.homework3

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.parseColor("#87CEEB"))
            gravity = android.view.Gravity.CENTER
        }

        val buttonOpenC = Button(this).apply {
            text = "Open Activity C"
            textSize = 18f
            setBackgroundColor(Color.BLUE)
            setTextColor(Color.WHITE)
            setPadding(50, 30, 50, 30)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            setOnClickListener {
                val intent = Intent(this@ActivityB, ActivityC::class.java)
                startActivity(intent)
            }
        }

        layout.addView(buttonOpenC)
        setContentView(layout)
    }
}