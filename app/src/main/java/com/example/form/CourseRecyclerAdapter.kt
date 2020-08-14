package com.example.form

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_course2.view.*


class CourseAdapter (var courseList:List<Course>): RecyclerView.Adapter<CourseAdapter.CoursesViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):CoursesViewHolder {
        var itemView= LayoutInflater.from(parent.context).inflate(R.layout.course_row_item,parent,false)
        return CoursesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    override fun onBindViewHolder(holder:CoursesViewHolder, position: Int) {
        holder.rowView.tvCourseCode.text=courseList[position].courseCode
        holder.rowView.tvCourseName.text=courseList[position].courseName
        holder.rowView.tvCourseInstructor.text=courseList[position].courseInstructor
        holder.rowView.tvCourseDescription.text=courseList[position].courseDescription
    }
class CoursesViewHolder(val rowView: View):RecyclerView.ViewHolder(rowView)

}