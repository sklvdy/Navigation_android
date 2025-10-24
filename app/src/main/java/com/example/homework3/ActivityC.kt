package com.example.homework3

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.parseColor("#98FB98"))
            gravity = android.view.Gravity.CENTER
        }

        val buttonOpenA = Button(this).apply {
            text = "Open Activity A"
            textSize = 18f
            setBackgroundColor(Color.BLUE)
            setTextColor(Color.WHITE)
            setPadding(50, 30, 50, 30)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            setOnClickListener {
                val intent = Intent(this@ActivityC, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
        }

        layout.addView(buttonOpenA)
        setContentView(layout)
    }
}