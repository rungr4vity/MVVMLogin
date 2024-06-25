package com.example.mvvmlogin

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

import androidx.compose.ui.tooling.preview.Preview

import com.example.mvvmlogin.ui.navigation.AppNavigation
import com.example.mvvmlogin.ui.theme.MVVMLoginTheme
import dagger.hilt.android.AndroidEntryPoint


//ComponentActivity
//AppCompatActivity
@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    var TAG = "myCode:"
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG,"onCreate")

        setContent {
            MVVMLoginTheme {


                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    ////use dagger Hilt for dependecy injection
                    //LoginScreen(LoginViewModel())

                    AppNavigation()



                }
            }
        }

        //setupAuth()
    }


    override fun onStart() {
        super.onStart()

        Log.d(TAG,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }


    /*
    private var canAuthenticate = false
    private lateinit var promptInfo: BiometricPrompt.PromptInfo
    fun setupAuth() {
        if(androidx.biometric.BiometricManager.from(this).canAuthenticate(
                androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG or
                        androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL) == androidx.biometric.BiometricManager.BIOMETRIC_SUCCESS) {

                canAuthenticate = true
                promptInfo = BiometricPrompt.PromptInfo.Builder()
                    .setTitle("Auth biométrica")
                    .setSubtitle("Autenticate utilizando el sensor biométrico")
                    .setAllowedAuthenticators(androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG or
                    androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL)
                    .build()

        }
    }


    fun authenticate(auth: (auth: Boolean) -> Unit) {
        if (canAuthenticate) {
            BiometricPrompt(this, ContextCompat.getMainExecutor(this),
                object : BiometricPrompt.AuthenticationCallback() {

                    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                        super.onAuthenticationSucceeded(result)

                        auth(true)
                    }
            }).authenticate(promptInfo)
        } else {
            auth(true)
        }
    }

   */
} // end class





@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MVVMLoginTheme {
        Greeting("Android")
    }
}