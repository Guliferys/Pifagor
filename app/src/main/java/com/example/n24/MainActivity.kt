package com.example.n24

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.n24.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickResult(view: View) {
        if(!isFieldEmpty()) {
            val result = getString(R.string.result_info) + getResult()
            binding.tvResult.text = result
        }
    }

    private fun isFieldEmpty():Boolean {
        binding.apply {
            if(edA.text.isNullOrEmpty()) edA.error = "Error. Enter A";
            if(edB.text.isNullOrEmpty()) edB.error = "Error. Enter B";
            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty();
        }
    }

    private fun getResult(): String {
        val a: Double
        val b: Double
        binding.apply {
            a = edA.text.toString().toDouble()
            b = edB.text.toString().toDouble()
        }
        val result = sqrt( (a.pow(2) + b.pow(2)) ) // Original value
        val result2 = String.format("%.2f", result)  // 2 nr after dot
        val result3 = result.roundToInt()  // rounded double
        return result2.toString()
    }

}