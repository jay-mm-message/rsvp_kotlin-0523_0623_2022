package com.example.drawboardspace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    val TAG: String = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         *
        Android Kotlin 基本概念的相關詞彙
        Kotlin 集合
        List 類別
        Set 類別
        Map 類別
        Collection 變化
        高階函式和 Lambdas
        函式類型
        it: 單一參數的隱含名稱
        Lambda 函式
        高階函式
         */

        val topic1= listOf(
            "Lean: 瀏覽不同畫面",
            "Android Kotlin 基本概念的相關詞彙",
                    "Kotlin 集合",
                    "List 類別",
                    "Set 類別",
                    "Map 類別",
                    "Collection 變化",
                    "高階函式和 Lambdas",
                    "函式類型",
                    "it: 單一參數的隱含名稱",
                    "Lambda 函式",
                    "高階函式")
        Log.e(TAG, "${topic1}")

        val words = listOf("about", "acute", "awesome", "balloon", "best", "brief", "class", "coffee", "creative")
        Log.e(TAG, words.filter { it.startsWith("a", ignoreCase = true) }.toString())

        val num: Int = 10
        val triple: (Int)->Int = { it * 3 }
        Log.e(TAG, "triple(${num}): ${triple(num)}")

        val peopleAges = mutableMapOf<String, Int>(
            "Jay" to 100,
            "Ellen" to 50
        )

        peopleAges["Jay"] = 200

        Log.e(TAG, "${peopleAges}")

        peopleAges.forEach { Log.e(TAG, "${it.key} to ${it.value}")}
        Log.e(TAG, peopleAges.map { "${it.key} to ${it.value}" }.toString())
        System.out.println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", ") )

        var set1 = setOf<Int>(1, 2, 3)
        var set2 = setOf<Int>(3, 2, 1)

        if (set1 == set2) {
            Log.e(TAG, "set1 equal set2")
        } else {
            Log.e(TAG, "set1 not equal set2")
        }

        var buf: List<Int> =
            listOf<Int>(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)

        Log.e(TAG, "${buf}")

        var serOfNumber =
                buf.toSet()

        Log.e(TAG, "${serOfNumber}")
    }
}