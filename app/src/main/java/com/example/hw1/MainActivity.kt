package com.example.hw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var name: EditText? = null
    private var height: EditText? = null
    private var weight: EditText? = null
    private var age: EditText? = null
    private var button: Button? = null
    private var output: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.et_name)
        height = findViewById(R.id.et_height)
        weight = findViewById(R.id.et_weight)
        age = findViewById(R.id.et_age)
        button = findViewById(R.id.button)
        output = findViewById((R.id.tv_output))

        button?.setOnClickListener {
            val nameLen = name?.text.toString().count()
            val heightInt = height?.text.toString().toInt()
            val weightFloat = weight?.text.toString().toFloat()
            val ageInt = age?.text.toString().toInt()

            if (nameLen in 1..49
                && heightInt in 0..249
                && weightFloat > 0 && weightFloat < 250
                && ageInt in 0..149) {
                val value = (heightInt + weightFloat) / nameLen + ageInt
                output?.text = "Ответ: $value"
            } else {
                output?.text = "Данные введены некорректно."
            }
        }
    }
}