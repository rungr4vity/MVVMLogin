package com.example.mvvmlogin.locations.presenter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue


class LocationsScreen {

}

@Composable
fun displayList(viewModel: LocationsViewModel) {

    val lista by viewModel.locations.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getAllLocations()
    }



    Column {
        if (viewModel.isLoading) {
            CircularProgressIndicator()
        } else {
            LazyColumn {
                items(lista) { location ->
                    Text(text = "")
                }
            }

        }
    }

}