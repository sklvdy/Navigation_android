package com.example.homework3

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var generatedColor = "#FFB6C1"
    private var isColorModified = false
    private lateinit var colorEditText: EditText
    private lateinit var layout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            generatedColor = savedInstanceState.getString("GENERATED_COLOR", "#FFB6C1")
            isColorModified = savedInstanceState.getBoolean("IS_COLOR_MODIFIED", false)
        }

        createUI()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("GENERATED_COLOR", generatedColor)
        outState.putBoolean("IS_COLOR_MODIFIED", isColorModified)
    }
    private fun createUI() {
        layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.parseColor("#FFB6C1"))
            gravity = android.view.Gravity.CENTER
        }

        colorEditText = EditText(this).apply {
            hint = "Enter Color"
            setText(generatedColor)
            textSize = 16f
            setTextColor(Color.BLACK)
            setBackgroundColor(Color.WHITE)
            setPadding(40, 20, 40, 20)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(50, 0, 50, 10)
            }
        }

        val applyColorButton = Button(this).apply {
            text = "Apply Color"
            textSize = 14f
            setBackgroundColor(Color.parseColor("#94D2BD"))
            setTextColor(Color.WHITE)
            setPadding(30, 15, 30, 15)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 0, 0, 20)
            }

            setOnClickListener {
                applyColorFromEditText()
            }
        }

        val generateColorButton = Button(this).apply {
            text = "Generate Color"
            textSize = 16f
            setBackgroundColor(Color.parseColor("#0A9396"))
            setTextColor(Color.WHITE)
            setPadding(50, 25, 50, 25)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 0, 0, 30)
            }

            setOnClickListener {
                generateRandomColor()
            }
        }

        val buttonOpenB = Button(this).apply {
            text = "Open Activity B"
            textSize = 18f
            setBackgroundColor(Color.parseColor("#005F73"))
            setTextColor(Color.WHITE)
            setPadding(80, 40, 80, 40)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            setOnClickListener {
                val intent = Intent(this@MainActivity, ActivityB::class.java)
                if (isColorModified) {
                    intent.putExtra("BACKGROUND_COLOR", generatedColor)
                }
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_MULTIPLE_TASK
                startActivity(intent)
            }
        }

        layout.addView(colorEditText)
        layout.addView(applyColorButton)
        layout.addView(generateColorButton)
        layout.addView(buttonOpenB)

        setContentView(layout)
    }

    private fun generateRandomColor() {
        val random = java.util.Random()
        val color = String.format("#%06X", random.nextInt(0xFFFFFF + 1))

        generatedColor = color
        colorEditText.setText(color)
        isColorModified = true
    }

    private fun applyColorFromEditText() {
        val inputColor = colorEditText.text.toString().trim()

        if (isValidColor(inputColor)) {
            generatedColor = if (inputColor.startsWith("#")) inputColor else "#$inputColor"
            colorEditText.error = null
            isColorModified = generatedColor != "#FFB6C1"
        } else {
            colorEditText.error = "Invalid color format. Use #RRGGBB or RRGGBB"
        }
    }

    private fun isValidColor(color: String): Boolean {
        if (color.isEmpty()) return false

        val cleanColor = if (color.startsWith("#")) color.substring(1) else color
        if (cleanColor.length != 6) return false

        return cleanColor.matches("[0-9A-Fa-f]{6}".toRegex())
    }
}