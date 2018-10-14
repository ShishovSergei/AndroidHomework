package com.gmail.shishovergeiwork.lesson4

import android.app.Activity
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.*
import com.gmail.shishovergeiwork.androidhomework.R
import android.view.inputmethod.InputMethodManager.RESULT_UNCHANGED_SHOWN
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.inputmethod.EditorInfo
import android.widget.TextView




class Lesson4Activity : Activity() {

    lateinit var owlAnimation: AnimationDrawable
    lateinit var values: FloatArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson4)

        val imageView: ImageView = findViewById(R.id.animationImage)
        imageView.setBackgroundResource(R.drawable.animation)
        owlAnimation = imageView.background as AnimationDrawable
        owlAnimation.start()

        val createPieButton: Button = findViewById(R.id.createDiagramButton)
        createPieButton.setOnClickListener {
            try {
                values = floatArrayOf(findViewById<EditText>(R.id.Digit1).text.toString().toFloat(),
                        findViewById<EditText>(R.id.Digit2).text.toString().toFloat(),
                        findViewById<EditText>(R.id.Digit3).text.toString().toFloat())

                val diagramLayout = findViewById(R.id.diagramLayout) as LinearLayout
                values = calculateData(values)
                val pieDiagram: PieDiagram
                diagramLayout.addView(PieDiagram(this, values))
            } catch (e: Exception) {
                Toast.makeText(this, "Wrong input parameters :(", Toast.LENGTH_SHORT).show()
            }

        }

    }

    /*override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

    }*/

    private fun calculateData(data: FloatArray): FloatArray {
        var total = 0f
        for (i in data.indices) {
            total += data[i]
        }
        for (i in data.indices) {
            data[i] = 360 * (data[i] / total)
        }
        return data

    }
}