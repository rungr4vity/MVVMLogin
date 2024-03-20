package com.example.mvvmlogin

import android.content.ContentValues.TAG
import android.hardware.biometrics.BiometricManager
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.example.mvvmlogin.ui.navigation.AppNavigation
import com.example.mvvmlogin.ui.theme.MVVMLoginTheme
import com.example.mvvmlogin.ui.theme.login.ui.LoginScreen
import com.example.mvvmlogin.ui.theme.login.ui.LoginViewModel
import com.google.android.gms.tasks.OnCompleteListener

//ComponentActivity
//AppCompatActivity
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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