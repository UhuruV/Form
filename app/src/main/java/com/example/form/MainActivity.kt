package com.example.form

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_data_source.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvRegister.setOnClickListener {
            val intent=Intent(baseContext,RegistrationActivity::class.java)
        }
    }

    private  fun nameRecyclerView(){
        recycler_view.layoutManager= LinearLayoutManager(baseContext)
    }
    }

