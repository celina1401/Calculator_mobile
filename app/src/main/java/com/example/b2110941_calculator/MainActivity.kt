package com.example.b2110941_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.b2110941_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onDigit(view: View){
        binding.btn0.setOnClickListener {
            binding.tv.text = binding.tv.text.toString() + binding.btn0.text
        }

        binding.btn1.setOnClickListener{
            binding.tv.text = binding.tv.text.toString() + binding.btn1.text
        }

        binding.btn2.setOnClickListener {
            binding.tv.text = binding.tv.text.toString() + binding.btn2.text
        }

        binding.btn3.setOnClickListener {
            binding.tv.text = binding.tv.text.toString() + binding.btn3.text
        }

        binding.btn4.setOnClickListener {
            binding.tv.text = binding.tv.text.toString() + binding.btn4.text
        }

        binding.btn5.setOnClickListener {
            binding.tv.text = binding.tv.text.toString() + binding.btn5.text
        }

        binding.btn6.setOnClickListener {
            binding.tv.text = binding.tv.text.toString() + binding.btn6.text
        }

        binding.btn7.setOnClickListener {
            binding.tv.text = binding.tv.text.toString() + binding.btn7.text
        }

        binding.btn8.setOnClickListener {
            binding.tv.text = binding.tv.text.toString() + binding.btn8.text
        }

        binding.btn9.setOnClickListener {
            binding.tv.text = binding.tv.text.toString() + binding.btn9.text
        }
    }

    fun onOperator(view: View){
        binding.tv.text = binding.tv.text.toString() + (view as Button).text

//        binding.btnDiv.setOnClickListener {
//            binding.tv.text = binding.tv.text.toString() + binding.btnDiv.text
//        }
//        binding.btnMinus.setOnClickListener {
//            binding.tv.text = binding.tv.text.toString() + binding.btnMinus.text
//        }
//        binding.btnPlus.setOnClickListener {
//            binding.tv.text = binding.tv.text.toString() + binding.btnPlus.text
//        }
//        binding.btnMul.setOnClickListener {
//            binding.tv.text = binding.tv.text.toString() + binding.btnMul.text
//        }
    }

    fun onDecimalPoint(view: View){
//        binding.btnPoint.setOnClickListener {
            binding.tv.text = binding.tv.text.toString() + binding.btnPoint.text
//        }
    }

    fun clear(view: View){
//        binding.btnClr.setOnClickListener {
            binding.tv.text = ""
//        }
    }

    var result:Double = 0.0

    fun onEqual(view: View){
        var temp:String = binding.tv.text.toString()
        var arr : List <String> = kotlin.collections.listOf("+","-","*","")
        var tc : ArrayList <String> = ArrayList()
        if ("+" in temp){
            tc.add("+")
            var value = temp.split("+")
            result = value[0].toDouble() + value[1].toDouble()
        }
        else if ("-" in temp){
            tc.add("-")
            var value = temp.split("-")
            result = value[0].toDouble() - value[1].toDouble()
        }
        else if ("*" in temp){
            tc.add("*")
            var value = temp.split("*")
            result = value[0].toDouble() * value[1].toDouble()
        }
        else if ("/" in temp){
            tc.add("/")
            var value = temp.split("/")
            result = value[0].toDouble() / value[1].toDouble()
        }

        var i:Int
        var j:Int
        for (i in 0 .. tc.size){
            for (j in 0 .. arr.size){
                if (tc[i] == arr[j]) {
                    binding.tv.text = removeZeroAfterDot(result.toString())
                    return
                }
                if (tc[i] == "/") {
                    binding.tv.text = removeZeroAfterDot(result.toString())
                    return
                }
            }
        }
    }

    private fun removeZeroAfterDot(result: String): String {
        var temp = result.split(".0")
        return temp[0]
    }
}