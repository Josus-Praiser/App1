package com.josus.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

   lateinit var etMobileNumber:EditText
    lateinit var etPassword:EditText
    lateinit var btnLogin:Button
    lateinit var txtForgotPass:TextView
    lateinit var txtRegister:TextView
    val validMobileNumber="0123456789"
    val validPassword= arrayOf("tony","steve","bruce","thanos")
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)
        val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)


        if (isLoggedIn){
            val intent=Intent(this@LoginActivity,AvengersActivity::class.java)
            startActivity(intent)
        }
        

        title="Log In"

        etMobileNumber=findViewById(R.id.etMobileNumber)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)
        txtForgotPass=findViewById(R.id.txtForgotPass)
        txtRegister=findViewById(R.id.txtRegister)

        btnLogin.setOnClickListener {
            val mobilenumber=etMobileNumber.text.toString()
            val password=etPassword.text.toString()
            var nameOfAvenger="Avenger"

            val intent=Intent(this@LoginActivity,AvengersActivity::class.java)
            intent.putExtra("Name",nameOfAvenger)

                if ((mobilenumber==validMobileNumber)){
                    when (password) {
                        validPassword[0] -> {
                            nameOfAvenger="Iron Man"
                            savePreferences(nameOfAvenger)
                            startActivity(intent)

                        }
                        validPassword[1] -> {
                            nameOfAvenger="Captain America"
                            savePreferences(nameOfAvenger)
                            startActivity(intent)
                        }
                        validPassword[2] -> {

                            nameOfAvenger="Hulk"
                            savePreferences(nameOfAvenger)
                            startActivity(intent)
                        }
                        validPassword[3] -> {
                            nameOfAvenger="Avengers"
                            savePreferences(nameOfAvenger)
                            startActivity(intent)
                        }
                    }
                 }
            else{
                Toast.makeText(this@LoginActivity,"Incorrect Credentials",Toast.LENGTH_LONG).show()
            }

        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePreferences(title:String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title", title).apply()

    }
}