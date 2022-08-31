package com.example.firect_direct_from_farm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView


@Suppress("DEPRECATION")
class Splash_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        //To make splash activity full screen
    window.setFlags(
       WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN
    )
        //Applying animation to imageview object
//        val splash_image=findViewById<ImageView>(R.id.splash_image)
//        val splash_animation=AnimationUtils.loadAnimation(this,R.anim.splash_anim)
//        splash_image.startAnimation(splash_animation)

       //After defined milisec the activity finishes
        Handler().postDelayed({
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },2200)





    }
}