package com.tani.rumblejumble

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.Settings
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_start.*
import kotlinx.android.synthetic.main.activity_start2.*

class start : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        textView5.text=""
        level.text ="Chances : $chance"
       // button3.isFocusable= true




        countDownTimer = object : CountDownTimer(30000, 1000){
            override fun onTick(p0: Long) {
                val time=p0/1000
                timeLeft.text="Time : $time"



            }

            override fun onFinish() {
                val toast = Toast.makeText(applicationContext, "Times up", Toast.LENGTH_LONG).show()
                val intent= Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }




        }.start()




         bitmap  = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.grey)
    }
    var bitmap : Bitmap? = null
    var countDownTimer : CountDownTimer? = null

    var chance = Globals.ch

    fun check (view: View){
        if (textView5.text.toString()=="W H I L E ")
        { val toast = Toast.makeText(applicationContext, "Correct!", Toast.LENGTH_LONG).show()
            //button3.isFocusable=false
            countDownTimer!!.cancel()
            val intent = Intent(applicationContext, start2::class.java)
            startActivity(intent)

        }
        else
        { val toast = Toast.makeText(applicationContext, "Incorrect Answer", Toast.LENGTH_LONG).show()
            Globals.ch--
            level.text = "Chance : ${Globals.ch}"
            clean()
            if (Globals.ch == 0){
                val toast = Toast.makeText(applicationContext, "You ran out of chances", Toast.LENGTH_LONG).show()
                countDownTimer!!.cancel()
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        }

    }
    fun clear(view: View){
        /*textView5.text =""
        imageView.isEnabled = true
        imageView2.isEnabled = true
        imageView3.isEnabled = true
        imageView4.isEnabled = true
        imageView5.isEnabled =true

        imageView.setImageBitmap(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.w))
        imageView2.setImageBitmap(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.h))
        imageView3.setImageBitmap(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.i))
        imageView4.setImageBitmap(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.l))
        imageView5.setImageBitmap(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.e))*/
        clean()
    }
    fun e (view: View){
        textView5.append("E ")
        imageView5.isEnabled = false
        imageView5.setImageBitmap(bitmap)

    }
    fun w (view: View){
        textView5.append("W ")
        imageView.isEnabled = false
        imageView.setImageBitmap(bitmap)
    }
    fun h (view: View){
        textView5.append("H ")
       imageView2.isEnabled = false
       imageView2.setImageBitmap(bitmap)
    }
    fun i (view: View){
        textView5.append("I ")
        imageView3.isEnabled = false
        imageView3.setImageBitmap(bitmap)
    }
    fun l (view: View){
        textView5.append("L ")
        imageView4.isEnabled = false
        imageView4.setImageBitmap(bitmap)
    }
    fun clean (){
        textView5.text =""
        imageView.isEnabled = true
        imageView2.isEnabled = true
        imageView3.isEnabled = true
        imageView4.isEnabled = true
        imageView5.isEnabled =true

        imageView.setImageBitmap(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.w))
        imageView2.setImageBitmap(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.h))
        imageView3.setImageBitmap(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.i))
        imageView4.setImageBitmap(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.l))
        imageView5.setImageBitmap(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.e))
    }

}
