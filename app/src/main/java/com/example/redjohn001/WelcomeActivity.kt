package com.example.redjohn001

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val signInBtn: MaterialButton = findViewById(R.id.sign_in_button)
        val registerBtn: MaterialButton = findViewById(R.id.register_button)
        val enterViaCodeBtn: MaterialButton = findViewById(R.id.enter_via_code_button)

        signInBtn.setOnClickListener {
            val intent: Intent = Intent(applicationContext, MainRegistrationActivity::class.java)
            intent.putExtra("welcomeActivity", "SignIn")
            startActivity(intent)
        }

        registerBtn.setOnClickListener {
            val intent: Intent = Intent(applicationContext, MainRegistrationActivity::class.java)
            intent.putExtra("welcomeActivity", "Register")
            startActivity(intent)
        }

        enterViaCodeBtn.setOnClickListener {
            val intent: Intent = Intent(applicationContext, MainRegistrationActivity::class.java)
            intent.putExtra("welcomeActivity", "enterViaCode")
            startActivity(intent)
        }

    }
}