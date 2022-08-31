package com.example.firect

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import java.util.*

class ConsumerLoginActivity : AppCompatActivity() {

    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consumer_login)
        supportActionBar!!.hide()
        auth=FirebaseAuth.getInstance()
        val forgot=findViewById<TextView>(R.id.forgot)
        val loginpassword=findViewById<EditText>(R.id.loginpassword)
        val loginemail=findViewById<EditText>(R.id.loginemail)



        forgot.setOnClickListener {
            val intent= Intent(this,ForgotPasswordActivity::class.java)
            startActivity(intent)


        }
        val tnc=findViewById<TextView>(R.id.tnc)
        tnc.setOnClickListener {
            val text=Intent(Intent.ACTION_VIEW)
            text.data= Uri.parse("https://i2.wp.com/learn.onemonth.com/wp-content/uploads/2017/08/1-10.png?fit=845%2C503&ssl=1")
            startActivity(text)

        }
        val show=findViewById<Button>(R.id.loginshowButton)

        val banner=findViewById<ImageView>(R.id.banner)
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
            Toast.makeText(this,"Welcome to Firect Web",Toast.LENGTH_LONG).show()
            val iv=Intent(Intent.ACTION_VIEW)
            iv.data= Uri.parse("https://protected-springs-10268.herokuapp.com/")
            startActivity(iv)

        }

        val submit=findViewById<Button>(R.id.submit)
        submit.setOnClickListener {
            val email:String = loginemail.text.toString().trim().lowercase(Locale.getDefault())
            val password:String=loginpassword.text.toString()

            if(email.isEmpty() || password.isEmpty())
            {
                Toast.makeText(this,"Fields cannot be left empty",Toast.LENGTH_LONG).show()
            }else {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            var username=auth.currentUser!!.displayName
                        Toast.makeText(this, "Welcome back ${username!!.toUpperCase()}", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, BottomNavigation::class.java)

                        startActivity(intent)
                    } else {
                        Toast.makeText(this, task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                    }

                    }
            }
        }

        val haveAcc=findViewById<TextView>(R.id.new2)
        haveAcc.setOnClickListener {
            val intent=Intent(this,ConsumerRegistrationActivity::class.java)
            startActivity(intent);
        }


    }
    override fun onBackPressed():Unit {
        val intent =Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}