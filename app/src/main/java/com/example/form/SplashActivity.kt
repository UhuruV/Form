package com.example.form

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sharedPreferences=PreferenceManager.getDefaultSharedPreferences(baseContext)
        val accessToken=sharedPreferences.getString("ACCESS_TOKEN_KEY"," ")

        if (accessToken.isNullOrEmpty()){
            val intent= Intent(baseContext,RegistrationActivity::class.java)
            startActivity(intent)
        }
        else{
            val intent=Intent(baseContext,CourseActivity::class.java)
            startActivity(intent)
        }
    }
}