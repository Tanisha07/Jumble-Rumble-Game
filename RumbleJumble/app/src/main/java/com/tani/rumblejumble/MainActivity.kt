package com.tani.rumblejumble

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.system.exitProcess

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

        textView10.setBackgroundColor(blue)
        textView12.setBackgroundColor(blue)
        textView13.setBackgroundColor(blue)
        textView14.setBackgroundColor(blue)
        textView15.setBackgroundColor(blue)
        textView16.setBackgroundColor(blue)

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

        button.setBackgroundColor(darkBlue)
        button.setTextColor(Color.WHITE)
       // button.setTextColor(darkBlue)


    }

    val handler = Handler()
    fun start (view: View){

        handler.postDelayed({val intents = Intent(applicationContext, Main2Activity::class.java)
            startActivity(intents)}, 1000)

    }
    //blue - 1a556d
    val blue:Int = Color.parseColor("#1a556d") //now white FFFFFF
    val darkBlue :Int = Color.parseColor("#154457")
    val color : Int = Color.parseColor("#2f3450")
    val white : Int = Color.parseColor("#FFFFFF") // now darkBlue 154457

    override fun onBackPressed() {

        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        val dialog: AlertDialog = builder.setTitle("Exit")
            .setMessage("Do you want to Exit?")
            .setPositiveButton("Quit") {
                    dialog, which ->  moveTaskToBack(true)
                exitProcess(-1)
            }
            .setNegativeButton("Cancel") { dialog, which -> dialog.dismiss()

            }
            .create()
        dialog.show()

        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(blue)
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(blue)
        //super.onBackPressed()
    }
}
