package com.example.agribizlinkl
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class WebpageActivity : AppCompatActivity() {
    var myWebView:WebView ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webpage)
        myWebView = findViewById(R.id.mWebOne)
//        Activity javascript support as your web view
        var settings = myWebView!!.settings
        settings.javaScriptEnabled =true
//        Finally load the website on the web view
        myWebView!!.loadUrl("https://coastfarmcare.com/")
    }
}