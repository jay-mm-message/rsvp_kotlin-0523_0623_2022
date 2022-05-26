package com.example.diceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
//import android.widget.Toast

class MainActivity : AppCompatActivity() {

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollBtn: Button = findViewById(R.id.rollButton)
        rollBtn.setOnClickListener { rollDice() }
//        {
//            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT);
//            toast.show()
//            rollDice()
//        }

        val rollBtn2: Button = findViewById(R.id.rollButton2)
        rollBtn2.setOnClickListener { rollDice2() }
    }

    private fun rollDice2() {
        //TODO("Not yet implemented")
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update the screen with the dice roll
        val result: TextView = findViewById(R.id.resultTextView2)
        result.text = diceRoll.toString()
    }

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRool = dice.roll()

        // Update the screen with the dice roll
        val result: TextView = findViewById(R.id.resultTextView)
        result.text = diceRool.toString()
    }

    class Dice(private var sidesNum: Int) {
        fun roll(): Int {
            return (1..sidesNum).random()
        }
    }
}