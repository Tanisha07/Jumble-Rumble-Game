package com.tani.rumblejumble

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Globals.ch=3

        textView.setBackgroundColor(blue)
        textView2.setBackgroundColor(blue)
        textView3.setBackgroundColor(blue)
        textView6.setBackgroundColor(blue)
        textView8.setBackgroundColor(blue)
        textView9.setBackgroundColor(blue)

        textView10.setBackgroundColor(darkBlue)
        textView12.setBackgroundColor(darkBlue)
        textView13.setBackgroundColor(darkBlue)
        textView14.setBackgroundColor(darkBlue)
        textView15.setBackgroundColor(darkBlue)
        textView16.setBackgroundColor(darkBlue)

        textView.setTextColor(white)
        textView2.setTextColor(white)
        textView3.setTextColor(white)
        textView6.setTextColor(white)
        textView8.setTextColor(white)
        textView9.setTextColor(white)
        textView10.setTextColor(white)
        textView12.setTextColor(white)
        textView13.setTextColor(white)
        textView14.setTextColor(white)
        textView15.setTextColor(white)
        textView16.setTextColor(white)

        button.setBackgroundColor(color)
        button.setTextColor(white)


    }

    val handler = Handler()
    fun start (view: View){

        handler.postDelayed({val intents = Intent(applicationContext, Main2Activity::class.java)
            startActivity(intents)}, 1000)

    }
    val blue:Int = Color.parseColor("#1a556d")
    val darkBlue :Int = Color.parseColor("#154457")
    val color : Int = Color.parseColor("#2f3450")
    val white : Int = Color.WHITE
}
