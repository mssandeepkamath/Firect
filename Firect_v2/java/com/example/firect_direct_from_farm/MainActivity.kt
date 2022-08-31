package com.example.firect_direct_from_farm


import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.firect_direct_from_farm.fragments.cartFragment
import com.example.firect_direct_from_farm.fragments.homeFragment
import com.example.firect_direct_from_farm.fragments.userFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    var permission_granted:Boolean=false //variable to check permission
    var permission_code=100//Assigned Code for Camera permission
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView=findViewById(R.id.bottom_navigation)
        replaceFragment(homeFragment.newInstance())



        thread {

            bottomNavigationView.setOnNavigationItemSelectedListener {

                when(it.itemId)
                {
                    R.id.home-> replaceFragment(homeFragment.newInstance())
                    R.id.cart->replaceFragment(cartFragment.newInstance())
                    R.id.user->replaceFragment(userFragment.newInstance())

                }
                true
            }

        }





    }




    fun checkpermission()   //Check Permission
    {
      val camera=ContextCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)
        if(camera == PackageManager.PERMISSION_GRANTED)
            permission_granted=true
        else
            makePermission()

    }

    fun makePermission()  //Request Permission
    {
        val camera=android.Manifest.permission.CAMERA
        ActivityCompat.requestPermissions(this, arrayOf(camera),permission_code)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==permission_code)
        {
            if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                permission_granted=true
            }
        }
    }

    fun qr_button(view:View) {
        checkpermission()
        if(permission_granted)
        {
            val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
        else
            Toast.makeText(this,"Please Grant Camera Permission\nAppInfo/Permissions/Camera/Allow",Toast.LENGTH_LONG).show()

    }

    fun replaceFragment(fragment:Fragment) {
        val layout=findViewById<FrameLayout>(R.id.frame_layout)
        supportFragmentManager.beginTransaction().replace(layout.id, fragment, "My Tag")
            .commit()

    }



}