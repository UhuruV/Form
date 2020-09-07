package com.example.form.activities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "courses")
data class Courses(
    @PrimaryKey @SerializedName("course_id")var courseId:String,
    @SerializedName("course_name")var courseName:String,
    @SerializedName("course_code")var courseCode:String,
    @SerializedName("instructor")var instructor:String,
    @SerializedName("description")var description:String

)