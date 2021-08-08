package com.example.retrofits.Models

import com.google.gson.annotations.SerializedName

data class CoursesResponse(
    @SerializedName("course_name")var CourseName:String,
    @SerializedName("course_description") var CourseDescription:String,
    var Instructor:String,
    @SerializedName("course_code")var CourseCode:String
)
