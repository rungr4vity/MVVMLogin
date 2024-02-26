package com.example.mvvmlogin.ui.theme.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvmlogin.R
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)) {


        Login(Modifier.align(Alignment.Center),viewModel)
    }

}


@Composable
fun Login(modifier: Modifier, viewModel: LoginViewModel) {

    val email :String by viewModel.email.observeAsState(initial = "")
    val password :String by viewModel.password.observeAsState(initial = "")
    val loginEnabled : Boolean by viewModel.loginEnable.observeAsState(initial = false)
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)
    val coroutineScoope = rememberCoroutineScope()

    if(isLoading){
        Box(Modifier.fillMaxSize()){
                CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    } else {
        LazyColumn(modifier = modifier) {

            item{

                HeaderImage(modifier)
                Spacer(modifier = Modifier.padding(16.dp))
                EmailField(email) { viewModel.onLoginChanged(it, password) }
                Spacer(modifier = Modifier.padding(16.dp))
                PasswordField(password) { viewModel.onLoginChanged(email, it) }
                Spacer(modifier = Modifier.padding(16.dp))
                ForgotPasword(modifier)
                Spacer(modifier = Modifier.padding(16.dp))
                ButtonLogin(loginEnabled) {

                    coroutineScoope.launch {
                        viewModel.onLoginSelected()
                    }

                }
            } // end item



        }
    }
} // end

@Composable
fun ButtonLogin(loginEnabled: Boolean,onLoginSelected:() -> Unit) {
    Button(onClick = { onLoginSelected() },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            disabledContainerColor = Color.Red,
            disabledContentColor = Color.Green,
            contentColor = Color.White,

        )
        , enabled = loginEnabled


        ) {
        Text(text = "Login")
    }
}

@Composable
fun ForgotPasword(modifier: Modifier) {
    Text(text="Forgot password?",

        modifier.clickable {  },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold, color = Color.Red)
}

@Composable
fun PasswordField(password:String,onTextFieldChanged:(String)-> Unit) {
    TextField(
        value = password,
        onValueChange = {onTextFieldChanged(it)},
        modifier = Modifier.fillMaxWidth(),

        placeholder = { Text(text = "Password")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        shape = RoundedCornerShape(8.dp),

        colors = TextFieldDefaults.colors(
            //setting the text field background when it is focused
            focusedContainerColor = MaterialTheme.colorScheme.onPrimary,

            //setting the text field background when it is unfocused or initial state
            unfocusedContainerColor = Color.Transparent,

            //setting the text field background when it is disabled
            disabledContainerColor = Color.Transparent,
            ),
        )
}
@Composable
fun EmailField(email:String,onTextFieldChanged:(String)-> Unit) {

//    var email by remember {
//        mutableStateOf("")
//    }


    TextField(
        value = email,
        onValueChange = { onTextFieldChanged(it)  },

        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        shape = RoundedCornerShape(8.dp),

        colors = TextFieldDefaults.colors(
            //setting the text field background when it is focused
            focusedContainerColor = MaterialTheme.colorScheme.onPrimary,

            //setting the text field background when it is unfocused or initial state
            unfocusedContainerColor = Color.Transparent,

            //setting the text field background when it is disabled
            disabledContainerColor = Color.Transparent,


        ),


    )
}
@Composable
fun HeaderImage(modifier: Modifier) {
    Image(painter = painterResource(id = R.drawable.ilpacolo), contentDescription = "header",modifier = modifier
        .fillMaxWidth())
}