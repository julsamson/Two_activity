package com.example.twoactivity

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var user = findViewById<EditText>(R.id.editTextText4)
        var age = findViewById<EditText>(R.id.editTextText5)
        var submit = findViewById<Button>(R.id.button)

        submit.setOnClickListener{
            val name = user.text.toString()
            val age = age.text.toString()
            val intent = Intent(this@MainActivity, secondactivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("age", age)
            startActivity(intent)
        }
    }
}