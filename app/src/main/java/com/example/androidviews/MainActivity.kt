package com.example.androidviews

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bundled: ActivityMainBinding

    private lateinit var planetSelected: Planet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bundled = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bundled.root)
        Toast.makeText(this, "Application Started", Toast.LENGTH_LONG).show()
        val editedText = bundled.showNameEt.text
        bundled.showNameBtnId.setOnClickListener {
            val planetWeight: Double = when(planetSelected) {
                Planet.MERCURY -> editedText.toString().toDouble() * 0.38
                Planet.VENUS -> editedText.toString().toDouble() * 0.91
                Planet.MARS -> editedText.toString().toDouble() * 0.38
                Planet.EARTH -> editedText.toString().toDouble() * 1
            }
            bundled.textView2.text = if(editedText.isNotEmpty()) "Your weight is $planetWeight" else "Please Enter Your Weight"
        }
    }

    fun onCheckBoxListener(view: View){
        view as CheckBox
        if(view.isChecked) {
            when (view.id) {
                R.id.mercuryId -> planetSelected =  Planet.MERCURY
                R.id.venusId -> planetSelected = Planet.VENUS
                R.id.marsId -> planetSelected = Planet.MARS
            }
        } else {
            planetSelected = Planet.EARTH
        }
    }
}

enum class Planet{
    MERCURY, VENUS, MARS, EARTH
}