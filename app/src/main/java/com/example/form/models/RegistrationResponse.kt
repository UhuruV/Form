package com.example.form.models

import com.example.form.activities.Student
import com.google.gson.annotations.SerializedName

data class RegistrationResponse(
    @SerializedName("messaage")var message:String,
    @SerializedName("student")var student: Student

)