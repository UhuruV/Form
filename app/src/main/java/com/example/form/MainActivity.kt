package com.example.form

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_data_source.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.etPassword
import kotlinx.android.synthetic.main.activity_registration.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvRegister.setOnClickListener {
            Intent(baseContext,RegistrationActivity::class.java)
            startActivity(Intent(baseContext,RegistrationActivity::class.java))

            regButton.setOnClickListener {
                val email = etEmailAddres.text.toString()
                val password = etPassword.text.toString()

            val requestBody= MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("email",email)
                .addFormDataPart("password",password)
                .build()
        }
    }
        recycler_view.layoutManager= LinearLayoutManager(baseContext)
    }

   fun loginStudents(requestBody: RequestBody){
       val apiClient=ApiClient.buildService(LoginApiInterface::class.java)
       val loginCall=apiClient.loginStudent(requestBody)
       loginCall.enqueue(object : Callback<LoginResponse>{
           override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
               Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
           }

           override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful){
                    Toast.makeText(baseContext,response.body()?.message,Toast.LENGTH_LONG).show()
                    startActivity(Intent(baseContext,MainActivity::class.java))
                }
               else{
                    Toast.makeText(baseContext,response.errorBody().toString(),Toast.LENGTH_LONG).show()
                }
           }
       })
   }
}






