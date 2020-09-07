package com.example.form.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.form.models.Course

@Database(entities = arrayOf(Course::class),version = 1)
abstract class FormDatabase:RoomDatabase() {
    abstract fun courseDao():CourseDao

}