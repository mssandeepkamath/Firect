package com.example.firect

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlin.system.exitProcess

class BottomNavigation : AppCompatActivity() {
   var backPressedTime:Long=0
    lateinit var auth:FirebaseAuth

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        supportActionBar!!.hide()
        val fraghome = FragmentHome()
        loadFragment(fraghome)
        auth= FirebaseAuth.getInstance()

//         val namee =FirebaseAuth.getInstance().currentUser!!.displayName
//        val email=intent.getStringExtra("email")

//        val emailuser=findViewById<TextView>(R.id.emailuser)
//        val phoneuser=findViewById<TextView>(R.id.phoneuser)
//        val nameuser=findViewById<TextView>(R.id.nameuser)
//        emailuser.text=email
//        phoneuser.text=phonenum
//            nameuser.text=namee

        val bnb = findViewById<BottomNavigationView>(R.id.bnb)
        bnb.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_notifications -> {
                    val fraguser = FragmentUser()
                    loadFragment(fraguser)
                }
                R.id.navigation_dashboard -> {
                    val fragcart = FragmentCart()
                    loadFragment(fragcart)
                }

                R.id.navigation_home -> {
                    val fraghome = FragmentHome()
                    loadFragment(fraghome)
                }

            }


            true
        }


    }



    fun go(view: View) {

        val hey = Intent(this, FarmerList::class.java)
        startActivity(hey)


    }

    fun edit(view: android.view.View) {

        val intent = Intent(this, ConsumerRegistrationActivity::class.java)
        startActivity(intent)
    }

    fun logout(view: android.view.View) {
        FirebaseAuth.getInstance().signOut()
        Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ConsumerLoginActivity::class.java)
        startActivity(intent)
    }

    fun help(view: android.view.View) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data =
            Uri.parse("https://wallpaperaccess.com/full/2022181.jpg")
        startActivity(intent)
    }
    fun MyOrder(view: android.view.View) {
        val fragcart = FragmentCart()
        loadFragment(fragcart)
    }
    fun Account(view: android.view.View) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data=
            Uri.parse("https://wallpaperaccess.com/full/2022181.jpg")
        startActivity(intent)
    }

    fun Refund(view: android.view.View) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data =
            Uri.parse("https://wallpaperaccess.com/full/2022181.jpg")
        startActivity(intent)
    }

    fun profile(view: android.view.View) {
        val intent=Intent(Intent.ACTION_VIEW)
        intent.data=Uri.parse("https://writing303portfolio.files.wordpress.com/2013/05/keep-calm-work-in-progress-3.png")
        startActivity(intent)
    }



    private fun loadFragment(fragment1: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.fragmentView, fragment1)


        fragmentTransaction.commit()


    }

    fun ordernow(view: android.view.View) {
        val fraghome = FragmentHome()
        loadFragment(fraghome)
    }

    fun prev(view: android.view.View) {
        val intent=Intent(Intent.ACTION_VIEW)
        intent.data=Uri.parse("https://i.pinimg.com/originals/ae/8a/c2/ae8ac2fa217d23aadcc913989fcc34a2.png")
        startActivity(intent)
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
