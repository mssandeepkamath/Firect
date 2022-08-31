package com.example.firect

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class FarmerRegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_farmer_registration)
        supportActionBar!!.hide()
        val haveAcc=findViewById<TextView>(R.id.haveAcc)
        haveAcc.setOnClickListener {
            val intent=Intent(this,FarmerLoginActivity::class.java)
            startActivity(intent);
        }
        val tnc=findViewById<TextView>(R.id.tnc)
        tnc.setOnClickListener {
            val text=Intent(Intent.ACTION_VIEW)
            text.data= Uri.parse("https://i2.wp.com/learn.onemonth.com/wp-content/uploads/2017/08/1-10.png?fit=845%2C503&ssl=1")
            startActivity(text)
        }
        val registersubmit=findViewById<Button>(R.id.registersubmit)
        registersubmit.setOnClickListener {
            val intent=Intent(this,FarmerLoginActivity::class.java)
            startActivity(intent)
        }
        val show=findViewById<Button>(R.id.showButton)
        val loginpassword=findViewById<EditText>(R.id.password)
        show.setOnClickListener {
            if (show.text == "SHOW") {
                loginpassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                show.text = "HIDE"
            } else {
                loginpassword.transformationMethod = PasswordTransformationMethod.getInstance()
                show.text = "SHOW"
            }
        }
    }

}