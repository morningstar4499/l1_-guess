package com.morningstar.l1_guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val secretnumber = SecretNumber()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("mainActivity","secretnumber="+ secretnumber.secret)
    }
    fun check(v : View){
        val num = ed_number.text.toString().toInt()
        Log.d("mainActivity","number="+ num)
        val diff:Int =secretnumber.validate(num)
        var  mess= ""
        if(diff < 0){
            mess = "太大了"
        }
        else  if (diff > 0){
            mess = "太小了"
        }
        else if(diff == 0 ){
            mess = "right"
        }
        AlertDialog.Builder(this)
            .setTitle("message")
            .setMessage(mess)
            .setPositiveButton("ok",null)
            .show()

    }
}