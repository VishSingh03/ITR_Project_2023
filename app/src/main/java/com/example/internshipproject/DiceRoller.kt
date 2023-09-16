package com.example.internshipproject

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DiceRoller: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.roller_layout)
        val rollButton: Button = findViewById(R.id.roll)
        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            val dice = Dice()
            val firstD = dice.roll()
            val secD = dice.roll()
            val diceImage2: ImageView = findViewById(R.id.imgD2)
            val diceImage1: ImageView = findViewById(R.id.imgD1)
            val drawableResource1 = when (firstD) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            val drawableResource2 = when (secD) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            diceImage1.setImageResource(drawableResource1)
            diceImage2.setImageResource(drawableResource2)

        }
    }
}

class Dice() {
    fun roll(): Int = (1..6).random()
}