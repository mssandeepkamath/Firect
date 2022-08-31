package com.example.firect

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import java.util.*

class FragmentHome: Fragment() {
    lateinit var progressBar:ProgressBar
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.activity_fragment_home,container,false)
        val webView=view.findViewById<WebView>(R.id.webview)
        webView.loadUrl("https://serene-savannah-46364.herokuapp.com/")
        val websetting=webView.settings
       progressBar=view.findViewById<ProgressBar>(R.id.progress)
        websetting.useWideViewPort=true
        websetting.javaScriptEnabled=true
        webView.webViewClient= WebViewClient()
        return view
    }
    inner class WebViewClient : android.webkit.WebViewClient() {


        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return false
        }


        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            progressBar.visibility = View.GONE
        }
    }






}

