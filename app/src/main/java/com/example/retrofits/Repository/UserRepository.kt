package com.example.retrofits.Repository

import com.example.retrofits.Api.ApiClient
import com.example.retrofits.ApiInterface
import com.example.retrofits.Models.LoginRequest
import com.example.retrofits.Models.LoginResponse
import com.example.retrofits.Models.RegistrationRequest
import com.example.retrofits.Models.RegistrationResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    var apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun registerStudent(registrationRequest: RegistrationRequest):
            Response<RegistrationResponse> = withContext(Dispatchers.IO){
                return@withContext Response
    }

    suspend fun login(logInRequest: LoginRequest):Response<LoginResponse> =
        withContext(Dispatchers.IO){

            var response = apiInterface.logInStudent(logInRequest)
            return@withContext response
        }
}