package com.example.form.database

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager.getDefaultSharedPreferences
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.form.*
import com.example.form.activities.CourseActivity
import com.example.form.activities.RegistrationActivity
import com.example.form.api.ApiClient
import com.example.form.api.LoginApiInterface
import com.example.form.models.LoginResponse
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
            Intent(baseContext, RegistrationActivity::class.java)
            startActivity(Intent(baseContext, RegistrationActivity::class.java))

            regButton.setOnClickListener {
                val email = etEmailAddres.text.toString()
                val password = etPassword.text.toString()

            val requestBody= MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("email",email)
                .addFormDataPart("password",password)
                .build()

                if (email.isNullOrEmpty() || email.isBlank()){
                    etEmailAddres.error="Email is required"
        }
                if(password.isNullOrEmpty() || password.isBlank()){
                    etPassword.error="Please input password"
                }
    }
        recycler_view.layoutManager= LinearLayoutManager(baseContext)
    }

   fun loginStudents(requestBody: RequestBody){
       val apiClient= ApiClient.buildService(LoginApiInterface::class.java)
       val loginCall=apiClient.loginStudent(requestBody)
       loginCall.enqueue(object : Callback<LoginResponse>{
           override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
               Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

               
           }

           override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful){
                    Toast.makeText(baseContext,response.body()?.message,Toast.LENGTH_LONG).show()
                    startActivity(Intent(baseContext, MainActivity::class.java))
                    val accessToken=response.body()?.accessToken
                    val sharedPreferences= getDefaultSharedPreferences(baseContext)

                    val editor=sharedPreferences.edit()
                    editor.putString("ACCESS_TOKEN_KEY"," ")
                    editor.apply()

                    val intent=Intent(baseContext, CourseActivity::class.java)
                    startActivity(intent)
                    finish()
                }
               else{
                    Toast.makeText(baseContext,response.errorBody().toString(),Toast.LENGTH_LONG).show()
                }
           }
       })
   }
}



}






