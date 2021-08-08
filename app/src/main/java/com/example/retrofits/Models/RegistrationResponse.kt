package com.example.retrofits.Models

import com.google.gson.annotations.SerializedName

data class RegistrationResponse(
    var Name:String,
    var Email:String,
    @SerializedName("date_of_birth")var dob:String,
    var Nationality:String,
    var password:String,
    @SerializedName("phone_number") var phone:String,
    @SerializedName("student_id") var id:String
)

