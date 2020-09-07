package com.example.form.models

import com.google.gson.annotations.SerializedName

data class CourseRegistrationResponse (
    @SerializedName("message")var message:String,
    @SerializedName("access_token")var access_token:String,
    @SerializedName("student_id")var student_id:String
)