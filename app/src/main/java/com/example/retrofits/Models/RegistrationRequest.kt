package com.example.retrofits.Models

import com.google.gson.annotations.SerializedName

data class RegistrationRequest(
    var Name:String,
    var Email:String,
    @SerializedName ("date_of_birth")var dob:String,
    var Nationality:String,
    var password:String,
    var studentId:String,
    @SerializedName("phone_number") var phone:String
)
