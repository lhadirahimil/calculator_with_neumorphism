package com.hadirahimi.neocalculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.neocalculator.R
import com.example.neocalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , View.OnClickListener
{
    private lateinit var binding : ActivityMainBinding
    private var dotUsed = false
    private  var firstNumber : Double = 0.0
    private  var number2 : Double = 0.0
    private  var op : Char = '.'
    
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        viewBinding()
    }
    
    private fun viewBinding()
    {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    
    override fun onClick(v : View?)
    {
        if (binding.tvResult.text.toString() == "0" && v?.id != R.id.btnDot) binding.tvResult.text = ""
        when (v?.id)
        {
            R.id.btn0 -> binding.tvResult.append("0")
            R.id.btn1 -> binding.tvResult.append("1")
            R.id.btn2 -> binding.tvResult.append("2")
            R.id.btn3 -> binding.tvResult.append("3")
            R.id.btn4 -> binding.tvResult.append("4")
            R.id.btn5 -> binding.tvResult.append("5")
            R.id.btn6 -> binding.tvResult.append("6")
            R.id.btn7 -> binding.tvResult.append("7")
            R.id.btn8 -> binding.tvResult.append("8")
            R.id.btn9 -> binding.tvResult.append("9")
            R.id.btnDot ->
            {
                
                if (! dotUsed)
                {
                    binding.tvResult.append(".")
                    dotUsed = true
                }
            }
            R.id.btnClear -> {
                tvResultEmpty()
                dotUsed = false
            }
            R.id.btnBackspace ->
            {
                val value = binding.tvResult.text.toString()
                if (binding.tvResult.text.toString().length > 1)
                {
                    if (value.takeLast(1) == ".") dotUsed = false
                    binding.tvResult.text = value.dropLast(1)
                }
                else {
                    tvResultEmpty()
                    dotUsed = false
                }
            }
            R.id.btnDevision -> {
                checkFirstNumberNull()
                firstNumber = binding.tvResult.text.toString().toDouble()
                op = '/'
                dotUsed = false
                tvResultEmpty()
            }
            R.id.btnTimes -> {
                checkFirstNumberNull()
                firstNumber = binding.tvResult.text.toString().toDouble()
                op = '×'
                dotUsed = false
                tvResultEmpty()
            }
            R.id.btnMinus -> {
                checkFirstNumberNull()
                firstNumber = binding.tvResult.text.toString().toDouble()
                op = '-'
                dotUsed = false
                tvResultEmpty()
            }
            R.id.btnPlus -> {
                checkFirstNumberNull()
                firstNumber = binding.tvResult.text.toString().toDouble()
                op = '+'
                dotUsed = false
                tvResultEmpty()
            }
            R.id.btnResult ->{
                checkSecondNumberNull()
                var number2 = binding.tvResult.text.toString().toDouble()
                tvResultEmpty()
                dotUsed = false
                when(op)
                {
                    '/'->{
                        binding.tvResult.text = (firstNumber / number2).toString()
                    }
                    '×'->{
                        binding.tvResult.text = (firstNumber * number2).toString()
                    }
                    '+'->{
                        binding.tvResult.text = (firstNumber + number2).toString()
                    }
                    '-'->{
                        binding.tvResult.text = (firstNumber - number2).toString()
                    }
                }
            }
        }
    }
    
    private fun checkFirstNumberNull()
    {
        if (binding.tvResult.text.isNullOrEmpty())
            binding.tvResult.text = "0"
    }
    private fun checkSecondNumberNull()
    {
        if (binding.tvResult.text.isNullOrEmpty())
            binding.tvResult.text = "0"
    }
    
    private fun tvResultEmpty()
    {
        binding.tvResult.text = "0"
    }
}