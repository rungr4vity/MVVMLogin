package com.example.mvvmlogin.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCompositionContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvmlogin.ui.theme.login.ui.HomeScreen
import com.example.mvvmlogin.ui.theme.login.ui.LoginScreen
import com.example.mvvmlogin.ui.theme.login.ui.LoginViewModel

@Composable
fun AppNavigation() {

    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = AppScreens.LoginScreen.name
    ){
        //NavGraphBuilder
        composable(AppScreens.LoginScreen.name) {
            ////use dagger Hilt for dependecy injection
            LoginScreen(LoginViewModel(),navController)
        }

        composable(AppScreens.HomeScreen.name) {
            HomeScreen()
        }
    }
}