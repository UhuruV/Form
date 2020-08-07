package com.example.form

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import kotlinx.android.synthetic.main.course_row_item.view.*


class CourseRecyclerAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<CourseItem>=ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    class CourseViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        val courseName = itemView.course_name
        val course_id = itemView.course_id
        val course_code = itemView.course_code
        val course_instructor = itemView.course_instructor
        val course_description = itemView.course_description

        fun bind(course:CourseItem){
            courseName.setText(course.courseName)
            course_id.setText(course.courseId)
            course_code.setText(course.courseCode)
            course_description.setText(course.description)
            course_instructor.setText(course.instructor)
        }
    }
}
