package com.example.dicerollerimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rollButton: Button = findViewById(R.id.rollButton)

        rollButton.setOnClickListener {
            diceRoll()
        }
    }

    private fun diceRoll() {
        val diceImage: ImageView = findViewById(R.id.imageView)

        when (Dice(6).roll()) {
            1 -> {
                diceImage.setImageResource(R.drawable.dice_1)
            }
            2 -> {
                diceImage.setImageResource(R.drawable.dice_2)
            }
            3 -> {
                diceImage.setImageResource(R.drawable.dice_3)
            }
            4 -> {
                diceImage.setImageResource(R.drawable.dice_4)
            }
            5 -> {
                diceImage.setImageResource(R.drawable.dice_5)
            }
            6 -> {
                diceImage.setImageResource(R.drawable.dice_6)
            }
        }
    }
}

class Dice(private var sidesNum: Int) {
    fun roll(): Int {
        return (1..sidesNum).random()
    }
}