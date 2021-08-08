package com.example.retrofits.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofits.Models.RegistrationRequest
import com.example.retrofits.Models.RegistrationResponse
import com.example.retrofits.Repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    var registrationLiveData = MutableLiveData<RegistrationResponse>()
    var regFailedLiveData = MutableLiveData<String>()
    var userRepository = UserRepository()

    fun registerStudent(registrationRequest: RegistrationRequest){
        viewModelScope.launch {
            var response = userRepository.registerStudent(registrationRequest)
            if (response.isSuccessful){
                registrationLiveData.postValue(response.body())
            }
            else{
                regFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}