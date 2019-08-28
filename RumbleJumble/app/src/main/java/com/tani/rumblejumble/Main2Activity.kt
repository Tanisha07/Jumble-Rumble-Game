package com.tani.rumblejumble

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import java.lang.Compiler.enable
import java.nio.file.Files.delete
import java.util.*
import kotlin.concurrent.schedule
import kotlin.math.absoluteValue
import kotlin.random.Random

class Main2Activity : AppCompatActivity() {

    var countDownTimer:CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //setting the bg color of alphabet tiles to light blue
        setBlue()

        //setting the text color of alphabet tiles white
        setTextWhite()

        //starting a 45 sec timer
        countDownTimer = object : CountDownTimer(45000, 1000){
            override fun onTick(p0: Long) {
                val time=p0/1000
                txt_Time.text="Time : $time" //to display time left. it is updated every sec

            }

            override fun onFinish() {
                val toast = Toast.makeText(applicationContext, "Times up", Toast.LENGTH_LONG).show()
                Globals.S_No =1
                val intent= Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }




        }

        //calling this function to retrieve and display words from table
        setTextFromTable()

        /* database n table creation queries

            val pracDB = this.openOrCreateDatabase("words1", Context.MODE_PRIVATE,null)
            pracDB.execSQL("create table if not exists Jwords(number int(2), word varchar, hint varchar)")
           // pracDB.execSQL("insert into Jwords values ( 1, 'TRAGIC', 'adj. Causing or characterized by extreme distress or sorrow.')")
           // pracDB.execSQL("insert into Jwords values (2, 'UNIQUE', 'adj. One of its kind')")
           // pracDB.execSQL("delete from Jwords")
           // var cursor = pracDB.rawQuery("Select * from Jwords", null)

        } */


    }
    //converting the string color hex codes to int, so that it can be set in text or bg of the tiles
    val blue:Int = Color.parseColor("#1a556d")
    val darkBlue :Int = Color.parseColor("#154457")
    val color : Int = Color.parseColor("#2f3450")
    val white : Int = Color.WHITE

    //creating the onClick functions of the alphabet textViews (fun c1-c6 )
    fun c1(view: View){
        t1.setBackgroundColor(darkBlue)         //changing the bg color of the tiles
        txt_Answer.append(t1.text.toString())   //appending the tile text to ans textView
        t1.isEnabled = false                    //disabling the clicked tile
        t1.setTextColor(color)                  //changing the tile text color
    }
    fun c2(view: View){
        t2.setBackgroundColor(darkBlue)
        txt_Answer.append(t2.text.toString())
        t2.isEnabled = false
        t2.setTextColor(color)
    }
    fun c3(view: View){
        t3.setBackgroundColor(darkBlue)
        txt_Answer.append(t3.text.toString())
        t3.isEnabled = false
        t3.setTextColor(color)
    }
    fun c4(view: View){
        t4.setBackgroundColor(darkBlue)
        txt_Answer.append(t4.text.toString())
        t4.isEnabled = false
        t4.setTextColor(color)
    }
    fun c5(view: View){
        t5.setBackgroundColor(darkBlue)
        txt_Answer.append(t5.text.toString())
        t5.isEnabled = false
        t5.setTextColor(color)
    }
    fun c6(view: View){
        t6.setBackgroundColor(darkBlue)
        txt_Answer.append(t6.text.toString())
        t6.isEnabled = false
        t6.setTextColor(color)
    }

    //onClick function for "clear" button. it sets all tiles to initial lighter blue color, clears ans and enables all tiles
    fun clear(view: View){
        setBlue()
        setTextWhite()
        enable()
    }

    //onClick function for the check button- to check our ans
    fun check(view: View){
        try{
            val pracDB = this.openOrCreateDatabase("words1", Context.MODE_PRIVATE,null)
            val num = Globals.S_No     //global var to keep check of serial no of database rows
            var cursor = pracDB.rawQuery("select * from Jwords where number = $num", null)
            var word_index = cursor.getColumnIndex("word")
            cursor.moveToFirst()
            var word = cursor.getString(word_index) //getting the word from table
            if (word == txt_Answer.text.toString()){
                var toast = Toast.makeText(applicationContext,"Correct", Toast.LENGTH_LONG).show()
                Globals.inc()  //to increase global var S_No, so that next time next row is accessed
                countDownTimer!!.cancel()   //canceling the current times

                //Timer().schedule(1000) {} - for 1 sec delay

                //calling this function to retrieve and display words from table
                setTextFromTable()
            }
            else{
                var toast = Toast.makeText(applicationContext,"Incorrect Answer", Toast.LENGTH_LONG).show()
                setBlue()       //these 3 methods r to restore default conditions
                setTextWhite()
                enable()
            }

        }
        catch (e: Exception){
            e.printStackTrace()
        }
    }

    //fun to set alphabet tiles (light) blue, ie, the initial color
    fun setBlue() {
        t1.setBackgroundColor(blue)
        t2.setBackgroundColor(blue)
        t3.setBackgroundColor(blue)
        t4.setBackgroundColor(blue)
        t5.setBackgroundColor(blue)
        t6.setBackgroundColor(blue)
    }

    //fun to set the text color of the alphabet tiles white
    fun setTextWhite(){
        t1.setTextColor(white)
        t2.setTextColor(white)
        t3.setTextColor(white)
        t4.setTextColor(white)
        t5.setTextColor(white)
        t6.setTextColor(white)
    }

    //this is a function created to jumble up a given string
    fun jumble(string: String)
    : String {
        val s: String = string
        var len = s.length
        var strArr  = CharArray(len) //output array which will contain the jumbled word
        var arr = s.toCharArray() //input arr from string input
        for (n in 0 until s.length) {
           // val i: Int = Random.nextInt().absoluteValue % len
            var i = (0 until  len).random() //generating a random integer b/w 0 n current length of arr
            strArr[n]=arr[i]        //nth value of final arr given random val of input string arr
            arr = delete(arr, i)    //deleting the particular index val, so that it doesn't appear again
            len--                   // decreasing the length of the arr, since, we removed an element
        }
        var str = String(strArr)
        return str
    }

    //this is a fun created to delete a given index s an array by shifting all elements left
    fun delete(array: CharArray, index : Int) : CharArray {
        var ch: CharArray = array
        for(i in 0 until ch.size){
            if(i>index){
                var c =ch[i]
                ch[i-1] = c
            }
        }
        return ch
    }

    fun enable(){
        t1.isEnabled = true
        t2.isEnabled = true
        t3.isEnabled = true
        t4.isEnabled = true
        t5.isEnabled = true
        t6.isEnabled = true
        txt_Answer.text =""
    }

    //fun to get the word in table corresponding to a particular row no., jumbling it, and
    //displaying its letters on each alphabet tile
    fun setTextFromTable(){
        try{
            val pracDB = this.openOrCreateDatabase("words1", Context.MODE_PRIVATE,null)
            pracDB.execSQL("create table if not exists Jwords(number int(2), word varchar, hint varchar)")
            // pracDB.execSQL("insert into Jwords values ( 1, 'TRAGIC', 'adj. Causing or characterized by extreme distress or sorrow.')")
            // pracDB.execSQL("insert into Jwords values (2, 'UNIQUE', 'adj. One of its kind')")
            // pracDB.execSQL("delete from Jwords")
            // var cursor = pracDB.rawQuery("Select * from Jwords", null)
            val num = Globals.S_No
            var cursor = pracDB.rawQuery("Select * from Jwords where number = $num" +
                    "", null)   //getting all column values for a particular S_No
            val no_Index = cursor.getColumnIndex("number")
            val word_Index = cursor.getColumnIndex("word")
            val hint_Index = cursor.getColumnIndex("hint")

            cursor.moveToFirst()       //moving the cursor to the first value of the result
            txt_Hint.text = cursor.getString(hint_Index)    //setting text from hint column to hint textView
            val word = cursor.getString(word_Index)     //retrieving the word
            val jumbledWord = jumble(word)      //calling jumble() to jumble the word

            //letting individual char of the word to diff textViews
            t1.text= jumbledWord.get(0).toString()
            t2.text= jumbledWord.get(1).toString()
            t3.text= jumbledWord.get(2).toString()
            t4.text= jumbledWord.get(3).toString()
            t5.text= jumbledWord.get(4).toString()
            t6.text= jumbledWord.get(5).toString()
        }
        catch (e:Exception){
            e.printStackTrace()
        }

        setTextWhite()  //restoring the default values of the alphabet tiles
        setBlue()
        enable()
        countDownTimer!!.start()    //starting the timer again from the beginning
    }

   /*fun shuffle(s : String):  String{
        var shuffle = s.toCharArray()
        var s : String
         Collections.shuffle(Arrays.asList(shuffle))
        //for (i in shuffle){}
        val str = String(shuffle)
        return str
    }*/

}
