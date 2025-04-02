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
    lateinit var auth: FirebaseAuth
    lateinit var signupEmail: EditText
    lateinit var signupPassword: EditText
    lateinit var signupButton: Button
    lateinit var loginRedirectText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        auth = FirebaseAuth.getInstance();
        //signupEmail = findViewById(R.id.signup_email);
        //signupPassword = findViewById(R.id.signup_password);
        //signupButton = findViewById(R.id.signup_button);
        //loginRedirectText = findViewById(R.id.loginRedirectText);
    }
}