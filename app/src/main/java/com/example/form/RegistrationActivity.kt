package com.example.form

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_registration.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        regButton.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmailAddres.text.toString()
            val phoneNumber = etPNnumber.text.toString()
            val password = etPassword.text.toString()
            val confirm = etConfirmPassword.text.toString()

            var requestBody= MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("first_name",name)
                .addFormDataPart("email",email)
                .addFormDataPart("password",password)
                .addFormDataPart("phone_number",phoneNumber)
                .addFormDataPart("last_name",confirm)
                .build()

            Toast.makeText(baseContext, password, Toast.LENGTH_LONG).show()
            Toast.makeText(baseContext, confirm, Toast.LENGTH_LONG).show()
            Toast.makeText(baseContext, email, Toast.LENGTH_LONG).show()
        }
    }
          fun registerStudents(requestBody: RequestBody){
              val apiClient=ApiClient.buildService(ApiInterface::class.java)
              val registrationCall=apiClient.registerStudent(requestBody)
              registrationCall.enqueue(object : Callback<RegistrationResponse>{
                  override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                      Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
                  }

                  override fun onResponse(
                      call: Call<RegistrationResponse>,
                      response: Response<RegistrationResponse>
                  ) {
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