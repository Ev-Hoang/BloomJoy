package com.example.bloomjoy

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

class SignupActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var signupEmail: EditText
    private lateinit var signupPassword: EditText
    private lateinit var signupButton: Button
    private lateinit var loginRedirectText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        auth = FirebaseAuth.getInstance()

//        signupEmail = findViewById(R.id.signup_email)
//        signupPassword = findViewById(R.id.signup_password)
//        signupButton = findViewById(R.id.signup_button)
//        loginRedirectText = findViewById(R.id.loginRedirectText)

        signupButton.setOnClickListener {
            val user = signupEmail.text.toString().trim()
            val pass = signupPassword.text.toString().trim()

            when {
                user.isEmpty() -> signupEmail.error = "Email cannot be empty"
                pass.isEmpty() -> signupPassword.error = "Password cannot be empty"
                else -> {
                    auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "SignUp Successful", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, LoginActivity::class.java))
                        } else {
                            Toast.makeText(this, "SignUp Failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }

        loginRedirectText.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}