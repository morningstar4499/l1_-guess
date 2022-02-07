package com.morningstar.l1_guess

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_record.*

class RecordActivity : AppCompatActivity() {
    val TAG = RecordActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)
        val count = intent.getIntExtra("COUNTER",-1)
        cnt_txv.setText(count.toString())
        btn_save.setOnClickListener{view->
            val nick:String = edtxv_nickname.text.toString()
            getSharedPreferences("guess", MODE_PRIVATE)
                .edit()
                .putInt("REC_COUNTER",count)
                .putString("REC_NICKNAME",nick)
                .commit()//一定在這一行把資料進去, apply找空擋儲存資料


            val tmpcnt =getSharedPreferences("guess", Context.MODE_PRIVATE)
                .getInt("REC_COUNTER",-1)
            val tmpstr =getSharedPreferences("guess", Context.MODE_PRIVATE)
                .getString("REC_NICKNAME",null)
            Log.d(TAG, "onCreate: tmpcnt="+tmpcnt+", REC_NICKNAME="+tmpstr)

        }
    }

}