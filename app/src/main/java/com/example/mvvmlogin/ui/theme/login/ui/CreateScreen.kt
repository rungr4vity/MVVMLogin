package com.example.mvvmlogin.ui.theme.login.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun CreateScreen(navController: NavController) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)) {

        Text(text = "create")
    }

}