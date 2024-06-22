package com.example.myapplication2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ePrompt = findViewById<EditText>(R.id.ePrompt)
        val submit = findViewById<Button>(R.id.button)
        val eResponse = findViewById<TextView>(R.id.textView)

        submit.setOnClickListener {
            val prompt = ePrompt.text.toString()
            val generativeModel = GenerativeModel(
                modelName = "gemini-pro",
                apiKey = ""  //add you api key
            )

            runBlocking {
                val response = generativeModel.generateContent(prompt)
                eResponse.text = response.text


            }

        }
    }
}
