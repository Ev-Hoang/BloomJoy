package com.example.bloomjoy

import android.util.Patterns;

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import android.widget.Toast
import android.content.Intent

class LoginActivity : AppCompatActivity() {

    lateinit var loginEmail: EditText
    lateinit var loginPassword: EditText
    lateinit var signupRedirectText: TextView
    lateinit var loginButton: Button
    lateinit var auth: FirebaseAuth
    lateinit var forgotPassword: TextView

    //@SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loginEmail = findViewById<EditText>(R.id.loginEmail)
        loginPassword = findViewById<EditText>(R.id.loginPassword)
        loginButton = findViewById<Button>(R.id.loginButton)
        signupRedirectText = findViewById<TextView>(R.id.result)

        auth = FirebaseAuth.getInstance()

        loginButton.setOnClickListener {
            val email = loginEmail.text.toString()
            val pass = loginPassword.text.toString()

            if (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                if (pass.isNotEmpty()) {
                    auth.signInWithEmailAndPassword(email, pass)
                        .addOnSuccessListener {
                            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        }
                        .addOnFailureListener {
                            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                        }
                } else {
                    loginPassword.error = "Empty fields are not allowed"
                }
            } else {
                loginEmail.error = if (email.isEmpty()) "Empty fields are not allowed" else "Please enter correct email"
            }
        }
    }
}