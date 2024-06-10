package com.example.mvvmlogin.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCompositionContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvmlogin.ui.presentation.agenda.CalendarForm
import com.example.mvvmlogin.ui.presentation.agenda.TimePickerForm
import com.example.mvvmlogin.ui.theme.login.ui.HomeScreen
import com.example.mvvmlogin.ui.theme.login.ui.LoginScreen
import com.example.mvvmlogin.ui.theme.login.ui.LoginViewModel
import com.example.mvvmlogin.ui.theme.mapas.ui.MapView

@RequiresApi(Build.VERSION_CODES.O)
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
            //LoginScreen(LoginViewModel(),navController)

            //CalendarForm()
            TimePickerForm()
        }

        composable(AppScreens.HomeScreen.name) {
            HomeScreen()
        }

        composable(AppScreens.MapView.name) {
            MapView()
        }
    }
}