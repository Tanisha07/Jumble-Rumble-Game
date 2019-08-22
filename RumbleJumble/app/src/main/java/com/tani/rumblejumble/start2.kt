package com.tani.rumblejumble

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_start.*
import kotlinx.android.synthetic.main.activity_start2.*

class start2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start2)

        textView11.text=""
        level2.text = "Chances : ${Globals.ch}"

        c =object : CountDownTimer(30000, 1000){
            override fun onTick(p0: Long) {
                val time=p0/1000
                timeLeft2.text="Time : $time"

            }

            override fun onFinish() {
                val toast = Toast.makeText(applicationContext, "Times up", Toast.LENGTH_LONG).show()
               // val intent= Intent(applicationContext, MainActivity::class.java)
               // startActivity(intent)
            }


        }.start()

        bitmap  = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.grey)
        score2.text="Score : 10"

    }

    var bitmap : Bitmap? = null
    var c: CountDownTimer?= null




    fun check (view: View){
        if (textView11.text.toString()=="E L S E ")
        { val toast = Toast.makeText(applicationContext, "Correct!", Toast.LENGTH_LONG).show()

        }
        else
        { val toast = Toast.makeText(applicationContext, "Incorrect Answer", Toast.LENGTH_LONG).show()
            Globals.ch--
            level2.text = "Chances : ${Globals.ch}"
            if (Globals.ch == 0){
                val toast = Toast.makeText(applicationContext, "You ran out of chances", Toast.LENGTH_LONG).show()
                c!!.cancel()
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        }

    }
    fun clear(view: View){
        /*textView11.text =""
       // imageView.isEnabled = true
        imageView6.isEnabled = true
        imageView7.isEnabled = true
        imageView8.isEnabled = true
        imageView51.isEnabled =true

       // imageView.setImageBitmap(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.w))
        imageView7.setImageBitmap(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.s))
        imageView51.setImageBitmap(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.e2))
        imageView8.setImageBitmap(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.l))
        imageView6.setImageBitmap(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.e))*/
        clean()
    }


    fun s (view: View){
        textView11.append("S ")
        imageView7.isEnabled = false
        imageView7.setImageBitmap(bitmap)

    }

    fun l (view: View){
        textView11.append("L ")
        imageView8.isEnabled = false
        imageView8.setImageBitmap(bitmap)

    }
    fun e2 (view: View){
        textView11.append("E ")
        imageView51.isEnabled = false
        imageView51.setImageBitmap(bitmap)

    }
    fun e (view: View){
        textView11.append("E ")
        imageView6.isEnabled = false
        imageView6.setImageBitmap(bitmap)

    }

    fun clean (){
        textView11.text =""
        // imageView.isEnabled = true
        imageView6.isEnabled = true
        imageView7.isEnabled = true
        imageView8.isEnabled = true
        imageView51.isEnabled =true

        // imageView.setImageBitmap(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.w))
        imageView7.setImageBitmap(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.s))
        imageView51.setImageBitmap(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.e2))
        imageView8.setImageBitmap(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.l))
        imageView6.setImageBitmap(BitmapFactory.decodeResource(applicationContext.resources, R.drawable.e))
    }

}
