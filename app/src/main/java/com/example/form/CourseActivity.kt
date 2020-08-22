package com.example.form

import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_course2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CourseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course2)

//        val courseList = listOf<Course>(
//            Course("KT 101", "Kotlin", "Front-end mobile development", "Ann"),
//            Course("Py 101", "Python", "Back-end development", "Kioko"),
//            Course("Entre 101", "Entreprenuership", "Entreprenuership", "Kioko"),
//            Course("PD 101", "Professional Development", "Professional Development", "Kioko"),
//            Course("Nav 101", "Navigating Your Journey", "Being Street Smart", "Kioko"),
//            Course("Eng 101", "English", "Ennglish", "Kioko"),
//            Course("MachL 101", "Machine Learning", "Machine Learning", "Kioko"),
//            Course("UI 101", "User Innterface", "Interactivity", "Kioko"),
//            Course("UX 101", "User Experience", "User Research", "Kioko"),
//            Course("JS 101", "JavaScript", "Front-end web development", "Kioko")
//        )
//        rvCourses.layoutManager = LinearLayoutManager(baseContext)
//        rvCourses.adapter=CourseAdapter(courseList)
//    }
    fetchCourses()
}
    private fun fetchCourses(){
    val sharedPreferences=PreferenceManager.getDefaultSharedPreferences(baseContext)
        val accessToken=sharedPreferences.getString("ACCESS_TOKEN_KEY"," ")
        val apiClient=ApiClient.buildService(ApiInterface::class.java)

        val courseCall=apiClient.getCourses("Bearer$accessToken")
        courseCall.enqueue(object :Callback<CourseResponse>{
            override fun onFailure(call: Call<CourseResponse>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<CourseResponse>,
                response: Response<CourseResponse>
            ) {
                if (response.isSuccessful){
                    val courseList=response.body()?.courses as List<Course>
                    val courseAdapter=CourseAdapter(courseList)

                    rvCourses.layoutManager = LinearLayoutManager(baseContext)
                    rvCourses.adapter = courseAdapter

                }
                else{
                    Toast.makeText(baseContext,response.errorBody().toString(),Toast.LENGTH_LONG).show()
                }
            }

        })
    }
}