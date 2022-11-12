package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText1 = findViewById(R.id.a)
        editText2 = findViewById(R.id.b)
        editText3 = findViewById(R.id.c)
        textView = findViewById(R.id.roots)
    }

    private fun discriminant(a: EditText, b: EditText, c:EditText): Double{
        val aCoef = Integer.parseInt(a.text.toString())
        val bCoef = Integer.parseInt(b.text.toString())
        val cCoef = Integer.parseInt(c.text.toString())
        return (bCoef * bCoef - 4 * aCoef * cCoef).toDouble()
    }

    private fun Double.format(digits: Int) = "%.${digits}f".format(this)

    private fun findRoots(a: EditText, b: EditText, c:EditText): String {
        if(a.text.toString() == "" || b.text.toString() == "" || c.text.toString() == ""){
            return "Incorrect input"
        }
        val aCoef = Integer.parseInt(a.text.toString())
        val bCoef = Integer.parseInt(b.text.toString())
        if (aCoef == 0) {
            return "Division by zero"
        }
        val desc = discriminant(a, b, c)
        return if (desc > 0){
            val x1 = (-bCoef + desc.pow(0.5)) / (2 * aCoef)
            val x2 = (-bCoef - desc.pow(0.5)) / (2 * aCoef)
            "x1 = ${x1.format(2)} \n x2 = ${x2.format(2)}"
        } else if (desc == 0.0){
            val x = -bCoef  / (2 * aCoef)
            "x = %.${x}f"
        } else{
            "No rational decisions"
        }

    }

   fun click(view: View){
        textView.text = findRoots(editText1, editText2, editText3)
    }


}