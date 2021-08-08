package com.example.retrofits.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofits.CourseAdapter
import com.example.retrofits.Courses
import com.example.retrofits.R

class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        var rvcourses=findViewById<RecyclerView>(R.id.rvcourses)
        var courseList= listOf(
            Courses("Python","Introduction","James Mwai","112"),
            Courses("Javascript","Datatypes","Purity","544"),
            Courses("Kotlin","Arrays","John","624"),
            Courses("Iot","Introduction","Yassin","56")
        )
        var courseAdapter= CourseAdapter(courseList)
        rvcourses.layoutManager=LinearLayoutManager(baseContext)
        rvcourses.adapter=courseAdapter
    }
}