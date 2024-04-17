package com.example.mvvmlogin.ui.theme.login.ui

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.mvvmlogin.ui.navigation.AppScreens
import kotlinx.coroutines.delay

class LoginViewModel: ViewModel() {



    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable:LiveData<Boolean> = _loginEnable


    private val _isLoading = MutableLiveData<Boolean>()
    var isLoading:LiveData<Boolean> = _isLoading

    fun onLoginChanged(email:String,password:String) {

        _email.value = email
        _password.value = password


        _loginEnable.value = isValidEmail(email) && isValidPassword(password)
        
    }



//    Here's a breakdown of the pattern:
//
//    ^: Asserts the start of the string.
//    (?=.*[A-Z]): Positive lookahead to ensure there is at least one uppercase letter.
//    (?=.*\\d): Positive lookahead to ensure there is at least one digit.
//    (?=.*[-+_!@#$%^&*.,?]): Positive lookahead to ensure there is at least one special character. You can modify the character set inside the square brackets to include any special characters you desire.
//    .{6}: Matches any character (except newline) exactly 6 times.
//    $: Asserts the end of the string.


    val passwordReg = Regex("^(?=.*[A-Z])(?=.*\\d)(?=.*[-+_!@#\$%^&*.,?]).{6}$")

    private fun isValidPassword(password:String): Boolean = passwordReg.matches(password)
    private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    suspend fun onLoginSelected(navController: NavController) {
        _isLoading.value = true
            delay(4000)
        _isLoading.value = false

        //navController.navigate(AppScreens.HomeScreen.name)

        navController.navigate(AppScreens.MapView.name)

    }

}