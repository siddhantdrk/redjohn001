package com.example.redjohn001

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainRegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_regestration_activty)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, EnterNewPasswordFragment()).commit()
    }
}