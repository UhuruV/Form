package com.example.form

import com.google.gson.annotations.SerializedName

data class CourseResponse (
  @SerializedName("courses") var courses:List<Courses>
)