package com.example.mvvmlogin.ui.theme.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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

@Preview
@Composable
fun LoginScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)) {


        Login(Modifier.align(Alignment.Center))
    }

}


@Composable
fun Login(modifier: Modifier) {

    Column(modifier = modifier) {
        HeaderImage(modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(16.dp))
        EmailField()
        Spacer(modifier = Modifier.padding(16.dp))
        PasswordField()
        Spacer(modifier = Modifier.padding(16.dp))
        ForgotPasword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.padding(16.dp))
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
fun PasswordField() {
    TextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth(),

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
fun EmailField() {
    TextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth(),
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
    Image(painter = painterResource(id = R.drawable.ilpacolo), contentDescription = "header",modifier = modifier )
}