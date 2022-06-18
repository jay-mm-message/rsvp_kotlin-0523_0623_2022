package com.example.drawboardspace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val TAG: String = "Draw_Board";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numbers = listOf<Int>(1, 2, 3, 5, 5)
        Log.e(TAG, "${numbers}")

        val setOfNumbers = numbers.toSet()
        Log.e(TAG, "${setOfNumbers}")
    }
}
