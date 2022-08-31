package com.example.firect

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import java.util.*

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        val emailb=findViewById<EditText>(R.id.resetmail)
        val textbox=findViewById<TextView>(R.id.resettext)


        val send=findViewById<Button>(R.id.resetbutton)
        supportActionBar!!.hide()
        send.setOnClickListener {
            val email:String = emailb.text.toString().trim().lowercase(Locale.getDefault())

              if(email.isEmpty())
              {
                Toast.makeText(this,"Field cannot be empty",Toast.LENGTH_LONG).show()
              }else {
                  FirebaseAuth.getInstance().sendPasswordResetEmail("$email")
                      .addOnCompleteListener { task ->
                          if (task.isSuccessful) {
                              textbox.setTextColor(Color.parseColor("#0B581E"))
                              "Password reset link sent successfully to $email".also { textbox.text = it }
                          } else {
                              textbox.text = task.exception!!.message.toString().trim()
                          }

                      }
              }
        }
    }



}