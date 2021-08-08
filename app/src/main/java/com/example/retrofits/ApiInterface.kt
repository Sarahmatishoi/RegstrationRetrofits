package com.example.retrofits

import com.example.retrofits.Models.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/students/register")
    fun registerStudent(@Body RegistrationRequest:RegistrationRequest ):Call<RegistrationResponse>
    abstract fun logInStudent(logInRequest: LoginRequest): Response<LoginResponse>

    interface ApiInterface {
        @POST("/students/register")
        suspend fun registerStudent(@Body registrationRequest: RegistrationRequest): Response<RegistrationResponse>

        @POST("/students/login")
        suspend fun loginStudent(@Body logInRequest: LoginRequest): Response<LoginResponse>
         @POST("courses")
         suspend fun courses(@Body coursesRequest:CoursesRequest):Response<CoursesResponse>
    }


}
