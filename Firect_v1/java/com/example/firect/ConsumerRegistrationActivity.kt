package com.example.firect

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.system.exitProcess

class ConsumerRegistrationActivity : AppCompatActivity() {

    lateinit var authh:FirebaseAuth
    val database=Firebase.database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consumer_registration)
        supportActionBar!!.hide()
        val haveAcc=findViewById<TextView>(R.id.haveAcc)
        authh= FirebaseAuth.getInstance()


        haveAcc.setOnClickListener {
            val intent= Intent(this,ConsumerLoginActivity::class.java)
            startActivity(intent)
        }
        val tnc=findViewById<TextView>(R.id.tnc)
        tnc.setOnClickListener {
            val text=Intent(Intent.ACTION_VIEW)
            text.data= Uri.parse("https://i2.wp.com/learn.onemonth.com/wp-content/uploads/2017/08/1-10.png?fit=845%2C503&ssl=1")
            startActivity(text)
        }
        val registersubmit=findViewById<Button>(R.id.registersubmitcon)
        val show=findViewById<Button>(R.id.showButtoncon)
        val reshow=findViewById<Button>(R.id.reShowButtoncon)
        val registerPassword=findViewById<EditText>(R.id.passwordcon)
        val reRegisterPassword=findViewById<EditText>(R.id.repasswordcon)
        val emailbox=findViewById<EditText>(R.id.emailcon)
        val name=findViewById<EditText>(R.id.namecon)
        val phone=findViewById<EditText>(R.id.phonecon)
        val addresses=findViewById<EditText>(R.id.addresscon)

        show.setOnClickListener {
            if (show.text == "SHOW") {
                registerPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                show.text = "HIDE"
            } else {
                registerPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                show.text = "SHOW"
            }
        }
        reshow.setOnClickListener {
            if (reshow.text == "SHOW") {
                reRegisterPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                reshow.text = "HIDE"
            } else {
                reRegisterPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                reshow.text = "SHOW"
            }
        }

        registersubmit.setOnClickListener {
            val password:String=registerPassword.text.toString()
            val email=emailbox.text.toString()
            val repassword:String=reRegisterPassword.text.toString()
            val namee:String= name.text.toString().trim().lowercase(Locale.getDefault())
            val phonenum=phone.text.toString().trim()
            val addresss =addresses.text.toString()

            if(phonenum.length!=10)
            {
                Toast.makeText(this,"Enter valid phone number",Toast.LENGTH_LONG).show()
            }
            else if(namee.isEmpty() || addresss.isEmpty() || phonenum.isEmpty() || email.isEmpty() || password.isEmpty() || repassword.isEmpty())
            {
                Toast.makeText(this,"Fields cannot be left empty",Toast.LENGTH_LONG).show()
            }
             else if (password != repassword) {
                Toast.makeText(this, "Passwords doesn't match", Toast.LENGTH_LONG).show()
            }
            else {
                authh.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->


                       if (task.isSuccessful) {

                           val userprofilename=UserProfileChangeRequest.Builder()
                               .setDisplayName(namee)
                               .build()



                           authh.currentUser!!.updateProfile(userprofilename)

                       database.reference.child("User").child("name")
                           .setValue(namee, DatabaseReference.CompletionListener { error, ref ->
                               if(error!=null)
                               {
                                   ref.child("email")
                                       .setValue(email, DatabaseReference.CompletionListener { error, ref ->
                                           if(error!=null)
                                           {
                                               ref.child("Phone")
                                                   .setValue(phonenum)
                                           }
                                       })
                               }
                           })

                           Toast.makeText(this, "Successfully registered", Toast.LENGTH_LONG).show()

                           val intent = Intent(this, BottomNavigation::class.java)
//                           intent.putExtra("name",namee)
//                           intent.putExtra("email",email)
//                           intent.putExtra("phonenum",phonenum)
                           startActivity(intent)

                      }
                        else
                       {
                           Toast.makeText(this, task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                       }


                    }
            }



        }




    }

    override fun onBackPressed():Unit {
       val intent=Intent(this,ConsumerLoginActivity::class.java)
        startActivity(intent)
    }
}