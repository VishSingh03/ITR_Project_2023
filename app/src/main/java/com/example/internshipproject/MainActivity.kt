package com.example.internshipproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btDice = findViewById<Button>(R.id.btn_roll)
        val btTip = findViewById<Button>(R.id.btn_tip)

        btTip.setOnClickListener {
            val intent = Intent (this, TipCalculator::class.java)
            startActivity(intent)
        }
        btDice.setOnClickListener {
            val intent = Intent (this,DiceRoller::class.java)
            startActivity(intent)
        }

        // button for image share simulator
        val btn_img = findViewById<Button>(R.id.button_img)

        btn_img.setOnClickListener{
            val intent = Intent(this,HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}