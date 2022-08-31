package com.example.firect

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FarmerLoginActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_farmer_login)
        supportActionBar!!.hide()
        val forgot=findViewById<TextView>(R.id.forgot)
        val tnc=findViewById<TextView>(R.id.tnc)
        val show=findViewById<Button>(R.id.loginshowButton)
        val banner=findViewById<ImageView>(R.id.banner)
        val loginpassword=findViewById<EditText>(R.id.loginpassword)
        forgot.setOnClickListener {
            val intent= Intent(this,ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        tnc.setOnClickListener {
            val text=Intent(Intent.ACTION_VIEW)
            text.data= Uri.parse("https://i2.wp.com/learn.onemonth.com/wp-content/uploads/2017/08/1-10.png?fit=845%2C503&ssl=1")
            startActivity(text)
        }
        show.setOnClickListener {
            if (show.text == "SHOW") {
                loginpassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                show.text = "HIDE"
            } else {
                loginpassword.transformationMethod = PasswordTransformationMethod.getInstance()
                show.text = "SHOW"
            }
        }

        banner.setOnClickListener {
            val iv=Intent(Intent.ACTION_VIEW)
            iv.data= Uri.parse("https://protected-springs-10268.herokuapp.com/")
            startActivity(iv)

        }

        val haveAcc=findViewById<TextView>(R.id.new1)
        haveAcc.setOnClickListener {
            val intent=Intent(this,FarmerRegistrationActivity::class.java)
            startActivity(intent);
        }


    }
}