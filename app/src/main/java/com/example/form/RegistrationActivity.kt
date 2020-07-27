package com.example.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        regButton.setOnClickListener {
            var name = etName.text.toString()
            var email = etEmailAddres.text.toString()
            var phoneNumber = etPNnumber.text.toString()
            var password = etPassword.text.toString()
            var confirm = etConfirmPassword.text.toString()
            Toast.makeText(baseContext, password, Toast.LENGTH_LONG).show()
            Toast.makeText(baseContext, confirm, Toast.LENGTH_LONG).show()
            Toast.makeText(baseContext, email, Toast.LENGTH_LONG).show()
        }
    }
}