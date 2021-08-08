package com.example.retrofits

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.*
import androidx.activity.viewModels
import com.example.retrofits.Api.ApiClient
import com.example.retrofits.Models.RegistrationRequest
import com.example.retrofits.Models.RegistrationResponse
import com.example.retrofits.ViewModel.UserViewModel
import com.example.retrofits.databinding.ActivityMainBinding
import org.json.JSONObject
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val userViewModel: UserViewModel by viewModels()

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnRegister.setOnClickListener {
            var regRequest = RegistrationRequest(
                Name = binding.etName.toString(),
                phone = binding.etPhone.text.toString(),
                Email = binding.etEmail.toString(),
                dob = binding.etDateOfBirth.toString(),
                password = binding.etPassword.toString(),
                Nationality=binding.spNationality.toString(),
                studentId = binding.etid.toString()
            )

            userViewModel.registerStudent(regRequest)
        }

        userViewModel.registrationLiveData.observe(this, { regResponse ->
            if (!regResponse.id.isNullOrEmpty()) {
                Toast.makeText(baseContext, "Registration successful", Toast.LENGTH_LONG).show()
            }
        })
        userViewModel.regFailedLiveData.observe(this, { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
    }
}

//    fun castViews() {
//        etName = findViewById(R.id.etName)
//        etDateOfBirth = findViewById(R.id.etDateOfBirth)
//        spNationality = findViewById(R.id.spNationality)
//        etEmail = findViewById(R.id.etEmail)
//        etphone = findViewById(R.id.etPhone)
//        btnRegister = findViewById(R.id.btnRegister)
//        etpassword = findViewById(R.id.etPassword)
//        var nationality = arrayOf("Kenyan", "Ugandan", "Rwandan", "South sudan")
//        var nationalityAdapter =
//            ArrayAdapter<String>(baseContext, android.R.layout.simple_spinner_item, nationality)
//        nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spNationality.adapter = nationalityAdapter
//        btnRegister.setOnClickListener {
//            var intent= Intent(baseContext,loginActivity::class.java)
//            startActivity(intent)
//        }
//        clickRegister()
//    }
//    fun clickRegister() {
//        var error = false
//        btnRegister.setOnClickListener {
//            var name = etName.text.toString()
//            if (name.isEmpty()) {
//                error = true
//                etName.setError("Name is required")
//            }
//            var dob = etDateOfBirth.text.toString()
//            if(dob.isEmpty()){
//                error=true
//                etDateOfBirth.setError("Date of birth required")
//            }
//            var nationality = spNationality.selectedItem.toString()
//            var password = etpassword.text.toString()
//            if (password.isEmpty()){
//                error=true
//                etpassword.setError("password required")
//            }
//            var phone = etphone.text.toString()
//            if(phone.isEmpty()){
//                error=true
//                etphone.setError("phoneNumber required")
//            }
//            var email = etEmail.text.toString()
//            if(email.isEmpty()) {
//                error = true
//                etEmail.setError("Email required")
//            }
//            var regestrationRequest=RegistrationRequest(
//                Name=name,phone=phone,Email=email,Nationality=nationality.toUpperCase(),dob=dob,password=password
//            )
//            var retrofit= ApiClient.buildApiClient(ApiInterface::class.java)
//            var request=retrofit.registerStudent(regestrationRequest)
//            request.enqueue(object :Callback<RegistrationResponse> {
//                override fun onResponse(
//                    call: Call<RegistrationResponse>,
//                    response: Response<RegistrationResponse>
//                ) {
//                    if (response.isSuccessful) {
//                        Toast.makeText(baseContext, "Registration Successful", Toast.LENGTH_LONG)
//                            .show()
//                        var intent = Intent(baseContext, loginActivity::class.java)
//                        startActivity(intent)
//                    }
//                    else{
//                        try {
//                            var error = JSONObject(response.errorBody()!!.string())
//                            Toast.makeText(baseContext, error.toString(), Toast.LENGTH_LONG)
//                                .show()
//                        } catch (e: Exception) {
//                            Toast.makeText(baseContext, e.message, Toast.LENGTH_LONG).show()
//                        }
//                    }
//                }
//                override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
//                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
//                }
//            })
//        }
//    }
//}
//
//
//data class ApiError(var errors: List<String>)