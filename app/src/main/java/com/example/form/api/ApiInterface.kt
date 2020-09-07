package com.example.form.api

import com.example.form.models.CourseRegistrationResponse
import com.example.form.models.CourseResponse
import com.example.form.models.RegistrationResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    @POST("register")
    fun registerStudent(@Body requestBody: RequestBody): Call<RegistrationResponse>

    @GET("login")
    fun getCourses(@Header("Authorization")accessToken:String) : Call<CourseResponse>

    @POST("student_id")
    fun registerCourses(@Body requestBody: RequestBody) : Call<CourseRegistrationResponse>
}
