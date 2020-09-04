package com.example.form

import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.form.database.FormDatabase
import kotlinx.android.synthetic.main.activity_course2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CourseActivity : AppCompatActivity() {
    lateinit var database:FormDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course2)
        database=Room.databaseBuilder(baseContext,FormDatabase::class.java,"form-db").build()


        fetchCourses()
    }

    private fun fetchCourses() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", " ")
        val apiClient = ApiClient.buildService(ApiInterface::class.java)

        val courseCall = apiClient.getCourses("Bearer$accessToken")
        courseCall.enqueue(object : Callback<CourseResponse> {
            override fun onFailure(call: Call<CourseResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<CourseResponse>,
                response: Response<CourseResponse>
            ) {
                if (response.isSuccessful) {
                    val courseList = response.body()?.courses as List<Course>

                    Thread {
                        courseList.forEach { course ->
                            database.courseDao().insertCourse(course)
                        }
                    }.start()
                }

                fun displayCourses(course: List<Course>) {
                    val courseAdapter = CourseAdapter(
                        courses,
                        this
                    )

                    rvCourses.layoutManager = LinearLayoutManager(baseContext)
                    rvCourses.adapter = courseAdapter

                }
            }
                else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                   .show()

                }
            }

        })
    }
}


