package com.example.retrofits.Ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.retrofits.Models.LoginRequest
import com.example.retrofits.R
import com.example.retrofits.ViewModel.LoginViewModel
import com.example.retrofits.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    val logInViewModel: LoginViewModel by viewModels()
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var btnlogin = findViewById<Button>(R.id.btnlogin)
        btnlogin.setOnClickListener {
            var intent = Intent(baseContext, CoursesActivity::class.java)
            startActivity(intent)


        }
        var binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("CODEHIVE_REG_PREFS", Context.MODE_PRIVATE)
        binding.btnlogin.setOnClickListener {
            var logInRequest = LoginRequest(
                binding.etemail.text.toString(),
                binding.etpass.text.toString()
            )
            logInViewModel.logIn(logInRequest)

        }
    }

    override fun onResume() {
        super.onResume()
        logInViewModel.logInLiveData.observe(this, { logInResponse ->
            Toast.makeText(baseContext, logInResponse.message, Toast.LENGTH_LONG).show()

            var accessToken = logInResponse.accessToken
            sharedPreferences.edit().putString("ACCESS_TOKEN", "accessToken").apply()

            var x = sharedPreferences.getString("ACCESS_TOKEN", "")
        })

        logInViewModel.logInFailedLiveData.observe(this, { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
            var binding = null
//            binding.tvLogInError.visibility = View.VISIBLE
//            binding.tvLogInError.text = error
        })
    }
}
