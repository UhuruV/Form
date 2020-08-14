package com.example.form

import com.google.gson.annotations.SerializedName

data class RegistrationResponse(
    @SerializedName("messaage")var message:String,
    @SerializedName("student")var student:Student

)