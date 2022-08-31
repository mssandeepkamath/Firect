package com.example.firect

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {


    var backPressedTime:Long=0
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide();
        val logo = findViewById<ImageView>(R.id.logo)
        val animation = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
        logo.startAnimation(animation)
        val login1 = findViewById<CardView>(R.id.cv1)
        val login2 = findViewById<CardView>(R.id.cv2)
        val TandC=findViewById<TextView>(R.id.tnc)


        login1.setOnClickListener {
            val intent=Intent(this,FarmerLoginActivity::class.java)
            startActivity(intent)
        }
        login2.setOnClickListener {

            if(FirebaseAuth.getInstance().currentUser!=null)
            {
                val intent=Intent(this,BottomNavigation::class.java)
                startActivity(intent)
            }
            else {
                val intent = Intent(this, ConsumerLoginActivity::class.java)
                startActivity(intent)
            }
        }


    }


    override fun onBackPressed() {
        if (backPressedTime + 3000 > System.currentTimeMillis()) {
            super.onBackPressed()
            this.finishAffinity()
        } else {
            Toast.makeText(this, "Press back again to leave the app.", Toast.LENGTH_LONG).show()
        }
        backPressedTime = System.currentTimeMillis()
    }


}

