package com.example.firect

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.FirebaseApiNotAvailableException
import com.google.firebase.auth.FirebaseAuth


class FragmentUser:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.activity_fragment_user,container,false)
        val pen=view.findViewById<ImageButton>(R.id.pen)
       val emailuser=view.findViewById<TextView>(R.id.emailuser)

      val nameuser=view.findViewById<TextView>(R.id.nameuser)
        nameuser.text=FirebaseAuth.getInstance().currentUser!!.displayName.toString().uppercase()
        emailuser.text=FirebaseAuth.getInstance().currentUser!!.email

        return view
    }



}