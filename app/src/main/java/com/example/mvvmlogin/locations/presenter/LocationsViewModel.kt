package com.example.mvvmlogin.locations.presenter

import androidx.lifecycle.ViewModel
import com.example.mvvmlogin.locations.model.Locations
import kotlinx.coroutines.flow.MutableStateFlow

class LocationsViewModel: ViewModel() {

    val isLoading: Boolean = true
    private val _locations:MutableStateFlow<List<Locations>>  = MutableStateFlow(emptyList())
    val locations = _locations




    fun addLocation(location: Locations) {
        //_locations.value = _locations.value + location
    }

    fun getAllLocations(){

    }
}