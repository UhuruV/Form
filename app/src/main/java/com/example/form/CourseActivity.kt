package com.example.form

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_course.*

class CourseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course2)

        var courseList = listOf<Course>(
            Course("KT 101", "Kotlin", "Front-end mobile development", "Ann"),
            Course("Py 101", "Python", "Back-end development", "Kioko"),
            Course("Py 101", "Python", "Back-end development", "Kioko"),
            Course("Py 101", "Python", "Back-end development", "Kioko"),
            Course("Py 101", "Python", "Back-end development", "Kioko"),
            Course("Py 101", "Python", "Back-end development", "Kioko"),
            Course("Py 101", "Python", "Back-end development", "Kioko"),
            Course("Py 101", "Python", "Back-end development", "Kioko"),
            Course("Py 101", "Python", "Back-end development", "Kioko"),
            Course("Py 101", "Python", "Back-end development", "Kioko")
        )
        rvCourses.layoutManager = LinearLayoutManager(baseContext)
        rvCourses.adapter=CourseAdapter(courseList)
    }
}