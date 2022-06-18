package com.example.dicerollerimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private final val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollButton)

        rollButton.setOnClickListener {
            diceRoll()
        }

        logging()
    }

    private fun logging() {
        Log.e(TAG, "----------")
        Log.e(TAG, "ERROR: a serious error like an app crash")
        Log.w(TAG, "WARN: warns about the potential for serious errors")
        Log.i(TAG, "INFO: reporting technical information, such as an operation succeeding")
        Log.d(TAG, "DEBUG: reporting technical information useful for debugging")
        Log.v(TAG, "VERBOSE: more verbose than DEBUG logs")
        Log.v(TAG, "----------")
    }


    private fun diceRoll() {

        val drawableResource = when (Dice(6).roll()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> {R.drawable.dice_6}
        }

        val drawImage: ImageView = findViewById(R.id.imageView)
        drawImage.setImageResource(drawableResource)

//        val diceImage: ImageView = findViewById(R.id.imageView)
//
//        when (Dice(6).roll()) {
//            1 -> {
//                diceImage.setImageResource(R.drawable.dice_1)
//            }
//            2 -> {
//                diceImage.setImageResource(R.drawable.dice_2)
//            }
//            3 -> {
//                diceImage.setImageResource(R.drawable.dice_3)
//            }
//            4 -> {
//                diceImage.setImageResource(R.drawable.dice_4)
//            }
//            5 -> {
//                diceImage.setImageResource(R.drawable.dice_5)
//            }
//            6 -> {
//                diceImage.setImageResource(R.drawable.dice_6)
//            }
//        }
    }
}

class Dice(private var sidesNum: Int) {
    fun roll(): Int {
        return (1..sidesNum).random()
    }
}