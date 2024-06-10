package com.example.mvvmlogin.data.spaces

import java.util.Date

data class spaces(
    val id: Int,
    val space: String,
    val description: String,
    val date_entry: Date,
    val userId: String,
)
