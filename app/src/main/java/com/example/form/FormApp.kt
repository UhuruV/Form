package com.example.form

import android.app.Application
import com.facebook.stetho.Stetho

class FormApp:Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}