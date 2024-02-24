package com.example.mvvmlogin.ui.theme.login.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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

    }
}