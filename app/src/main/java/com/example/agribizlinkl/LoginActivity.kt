package com.example.agribizlinkl
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        val loginButton: Button = findViewById(R.id.mBtnLogin)

        val registerText: TextView = findViewById(R.id.TextRegister_now)
        registerText.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

        auth = FirebaseAuth.getInstance()

        loginButton.setOnClickListener {
            login()
        }
    }

         private fun login() {
             val emaila = findViewById<EditText>(R.id.mEditEmail)
             val password = findViewById<EditText>(R.id.mEditPass_login)

            val email = emaila.text.toString()
            val pass = password.text.toString()
            // calling signInWithEmailAndPassword(email, pass)
            // function using Firebase auth object
            // On successful response Display a Toast
            auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, intentsactivity::class.java)
                    startActivity(intent)

                } else
                    Toast.makeText(this, "Log In failed ", Toast.LENGTH_SHORT).show()
            }
        }



    }


