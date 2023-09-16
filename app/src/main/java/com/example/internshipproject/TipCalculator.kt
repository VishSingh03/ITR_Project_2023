package com.example.internshipproject

import com.example.internshipproject.databinding.ActivityMainBinding



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.internshipproject.databinding.TipLayoutBinding
import java.text.NumberFormat

class TipCalculator: AppCompatActivity() {

    private lateinit var binding: TipLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = TipLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        if (cost == null) {
            binding.tipResult.text = ""
            return
        }

        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        var tip = tipPercentage * cost
        if (binding.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}