package com.example.retrofits.ViewModel

import androidx.lifecycle.MutableLiveData
import com.example.retrofits.Models.CoursesRequest
import com.example.retrofits.Models.CoursesResponse
import com.example.retrofits.Models.LoginResponse
import com.example.retrofits.Repository.UserRepository
import kotlinx.coroutines.CoroutineScope

class CoursesViewModel {
    var coursesLiveData = MutableLiveData<CoursesResponse>()
    var logInFailedLiveData = MutableLiveData<String>()
    var userRepository = UserRepository()

    fun Courses(coursesResponse: CoursesResponse, viewModelScope: Any){
        viewModelScope.launch {
            var response = userRepository.login(CoursesResponse)
            if (response.isSuccessful){
                coursesLiveData.postValue(coursesResponse.body())
            }
            else{
                logInFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}

private fun Any.launch(block: suspend CoroutineScope.() -> Unit) {

}
