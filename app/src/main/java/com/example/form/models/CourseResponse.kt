package com.example.form.models

import com.example.form.activities.Courses
import com.google.gson.annotations.SerializedName

data class CourseResponse (
  @SerializedName("courses") var courses:List<Courses>
)