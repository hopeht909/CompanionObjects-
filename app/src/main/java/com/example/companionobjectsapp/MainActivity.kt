package com.example.companionobjectsapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.doOnTextChanged

class MainActivity : AppCompatActivity() {
    lateinit var dayOrNightLayout : ConstraintLayout
    lateinit var etDayOrNight :EditText
    lateinit var btnChangeBG : Button
    lateinit var tvDayOrNight : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("Main Activity", "onCreate: ")

         dayOrNightLayout = findViewById(R.id.layout)
         etDayOrNight = findViewById(R.id.et_dayOrNight)
         btnChangeBG = findViewById(R.id.btnChangeBG)
         tvDayOrNight = findViewById(R.id.tv_dayOrNight)

        btnChangeBG.setOnClickListener(object : View.OnClickListener {

            override fun onClick(p0: View?) {
                var dayOrNightStr = etDayOrNight.text?.toString()
                when(dayOrNightStr?.toLowerCase()){
                    "day"->{val time = Time()
                        time.changeBackground(dayOrNightLayout,Time.day)
                        etDayOrNight.setTextColor(Color.BLACK)
                        tvDayOrNight.setTextColor(Color.BLACK)
                    }
                    "night"->{val time = Time()
                        time.changeBackground(dayOrNightLayout,Time.night)
                        etDayOrNight.setTextColor(Color.WHITE)
                        tvDayOrNight.setTextColor(Color.WHITE)
                    }
                }
            }

        })



    }
}
class Time {

    companion object{

        val night = 0
        val day = 1

    }

    fun changeBackground(layout:View,day:Int){

        when (day){
            0->{layout.setBackgroundResource(R.drawable.night)}
            1->{layout.setBackgroundResource(R.drawable.day)}
        }

    }
}