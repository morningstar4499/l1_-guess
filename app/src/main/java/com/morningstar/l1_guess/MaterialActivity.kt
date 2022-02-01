package com.morningstar.l1_guess

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_material.*

class MaterialActivity : AppCompatActivity() {
    val secretnumber = SecretNumber()
    val Tag = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
              //  .setAction("Action", null).show()
            AlertDialog.Builder(this)
                .setTitle("Replay game")
                .setMessage("Are u sure")
                .setPositiveButton(getString(R.string.ok),{dialog,which->
                    secretnumber.Reset()
                    txv_cnt.setText(secretnumber.count.toString())
                    Log.d(Tag,"secretnumber="+ secretnumber.secret)
                    txv_cnt.setText(secretnumber.count.toString() )
                    ed_number.setText("")

                })
                .setNeutralButton("Cancel",null)
                .show()
        }

    }
    fun check(v : View){

        val num = ed_number.text.toString().toInt()
        Log.d(Tag,"number="+ num)
        val diff:Int =secretnumber.validate(num)
        var  mess= ""
        if(diff < 0){
            mess = getString(R.string.bigger)
        }
        else  if (diff > 0){
            mess = getString(R.string.samll)
        }
        else if(diff == 0 ){
            if (secretnumber.count <=2 ){
                mess = getString(R.string.Excellent_The_number_is)+secretnumber.secret.toString()
            }
            else{
                mess = getString(R.string.u_get_it)
            }

        }
        txv_cnt.setText(secretnumber.count.toString() )
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.AlertDialog_messsage))
            .setMessage(mess)
            .setPositiveButton(getString(R.string.ok),null)
            .show()

    }

}