package com.example.mvvmlogin.data.Locations

data class LocationsEntity(
    val id: Int,
    val title: String,
    val description: String,
    val latitude: Double,
    val longitude: Double,
    val addressDesc: String?,
    val url: String?,
    val img: String?,
    val icon: String?,
    val city: String?,
    val facebook: String?
)