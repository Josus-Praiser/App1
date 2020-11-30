package com.josus.activitylifecycle
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AvengersActivity : AppCompatActivity() {

    lateinit var btnSendMessage:Button
    lateinit var etMessage:EditText

    lateinit var btnlogout:Button
    var titleName:String?="Avengers"
   lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        setContentView(R.layout.scrollview_avenger)
        println("OnCreate called")

        btnSendMessage=findViewById(R.id.btnSend)
        etMessage=findViewById(R.id.etMsg)

        btnlogout=findViewById(R.id.btn_log_out)

        btnSendMessage.setOnClickListener {

            val intent = Intent(this@AvengersActivity, MessageActivity::class.java)
            val msg = etMessage.text.toString()
            intent.putExtra("Msg",msg)
            startActivity(intent)
        }

      titleName=sharedPreferences.getString("Title","The Avengers")
            title = titleName

        btnlogout.setOnClickListener {
            val newintent=Intent(this@AvengersActivity,LoginActivity::class.java)
            sharedPreferences.edit().clear().apply()
            finish()
        }



    }

}