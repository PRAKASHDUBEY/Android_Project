package com.example.diceroller

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = DICE(6)
        val diceroll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceroll.toString()
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceroll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)

        val luckyNumber = 6
/**
        if (diceroll == luckyNumber) {
            println("You win!")
        } else if (diceroll == 1) {
            println("So sorry! You rolled a 1. Try again!")
        } else if (diceroll == 2) {
            println("Sadly, you rolled a 2. Try again!")
        } else if (diceroll == 3) {
            println("Unfortunately, you rolled a 3. Try again!")
        } else if (diceroll == 4) {
            println("No luck! You rolled a 4. Try again!")
        } else {
            println("Apologies! you rolled a 5. Try again!")
        }**/
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val RollButton: Button = findViewById(R.id.button)
        RollButton.setOnClickListener {
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            rollDice()
        }
    }
}
class DICE(private val numside: Int) {
    fun roll(): Int {
        return (1..numside).random()
    }
}