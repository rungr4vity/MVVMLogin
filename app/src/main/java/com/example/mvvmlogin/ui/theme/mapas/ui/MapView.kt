package com.example.mvvmlogin.ui.theme.mapas.ui


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.example.mvvmlogin.R
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.common.collect.MapMaker
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapView() {

    myGooglemaps()

}


@Composable
fun myGooglemaps() {
    val marker = LatLng(28.270833,-16.63916)

    GoogleMap(modifier = Modifier.fillMaxSize()) {
        Marker(
            position = marker,
            icon = BitmapDescriptorFactory.fromResource(R.drawable.cel),
            title = "My first marker",
            snippet = "Welcome to my description"

        )
    }
}


