package com.example.firect_direct_from_farm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firect_direct_from_farm.R


class cartFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val view= inflater.inflate(R.layout.fragment_cart, container, false)

        return view
    }

    companion object {

        fun newInstance(): cartFragment {
            return cartFragment()
        }
    }
}