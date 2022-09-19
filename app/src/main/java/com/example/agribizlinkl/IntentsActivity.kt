package com.example.agribizlinkl
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.agribizlinkl.R
import com.example.agribizlinkl.WebpageActivity


class intentsactivity : AppCompatActivity() {

    var buttonSms:Button ?= null
    var buttonEmail:Button ?= null
    var buttonCamera:Button ?= null
    var buttonShare:Button ?= null
    var buttonMpesa:Button ?= null
    var buttonCall:Button ?= null
    var buttonweb:Button ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents)

        buttonSms = findViewById(R.id.mBtnSms)
        buttonEmail = findViewById(R.id.mBtnEmail)
        buttonCamera = findViewById(R.id.mBtnCamera)
        buttonShare = findViewById(R.id.mBtnShare)
        buttonMpesa = findViewById(R.id.mBtnMpesa)
        buttonCall = findViewById(R.id.mBtnCall)
        buttonweb = findViewById(R.id.mbtnWebpage)


        buttonSms!!.setOnClickListener {
            val uri = Uri.parse("smsto:0792130150")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "The SMS text")
            startActivity(intent)
        }
        buttonEmail!!.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "wedmund703@gmail.com ", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Job Application")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear Sir Kindly give me the interview")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }
        buttonCamera!!.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)
        }
        buttonShare!!.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")
            startActivity(shareIntent)
        }
        buttonMpesa!!.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }
        }
        buttonCall!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254792130150"))
            if (ContextCompat.checkSelfPermission(
                    this@intentsactivity,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@intentsactivity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }

        buttonweb!!.setOnClickListener {
            val intent =Intent(applicationContext,WebpageActivity::class.java)
            startActivity(intent)
        }

        val butn = findViewById<Button>(R.id.mBtnNextPage)
        butn.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

    }
}