package com.josus.activitylifecycle

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MessageActivity : AppCompatActivity() {

    lateinit var txtMessage:TextView
    var message="Custom Message"

    override fun onCreate(savedInstanceState: Bundle?) {
        title="Your Messages"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        txtMessage=findViewById(R.id.txtTyped)
        if (intent!=null){
         message= intent.getStringExtra("Msg").toString()
         txtMessage.text=message
        }

        }
}


