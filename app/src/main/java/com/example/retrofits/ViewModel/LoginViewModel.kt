package com.example.retrofits.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofits.Models.LoginRequest
import com.example.retrofits.Models.LoginResponse
import com.example.retrofits.Repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {
    var logInLiveData = MutableLiveData<LoginResponse>()
    var logInFailedLiveData = MutableLiveData<String>()
    var userRepository = UserRepository()

    fun logIn(logInRequest: LoginRequest){
        viewModelScope.launch {
            var response = userRepository.login(logInRequest,)
            if (response.isSuccessful){
                logInLiveData.postValue(response.body())
            }
            else{
                logInFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}