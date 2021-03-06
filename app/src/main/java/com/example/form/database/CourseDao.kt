package com.example.form.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.form.models.Course

interface CourseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCourse(course: Course)

    @Query("SELECT * FROM courses")
    fun getAllCourses():List<Course>

}