package com.tani.rumblejumble

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Globals.ch=3
    }
    fun start (view: View){
        val intents = Intent(applicationContext, Main2Activity::class.java)
        startActivity(intents)
    }
}
