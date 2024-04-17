package com.example.mvvmlogin.ui.theme.mapas.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun MapView() {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            com.google.android.gms.maps.MapView(context).apply {
                // Initialize the MapView
                onCreate(null)
            }
        },
        update = { mapView ->
            // Make sure you call the correct lifecycle methods
            mapView.onResume()
        }
    )
}