package com.example.homework3

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class ActivityB : AppCompatActivity() {

    private var backgroundColor = "#87CEEB"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            backgroundColor = savedInstanceState.getString("SAVED_COLOR", "#87CEEB")
        } else {
            val passedColor = intent.getStringExtra("BACKGROUND_COLOR")
            if (!passedColor.isNullOrEmpty()) {
                backgroundColor = passedColor
            }
        }

        createUI()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("SAVED_COLOR", backgroundColor)
    }

    private fun createUI() {
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.parseColor(backgroundColor))
            gravity = android.view.Gravity.CENTER
        }

        val buttonOpenC = Button(this).apply {
            text = "Open Activity C"
            textSize = 18f
            setBackgroundColor(Color.parseColor("#005F73"))
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