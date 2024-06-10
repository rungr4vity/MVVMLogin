@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mvvmlogin.ui.theme.login.ui


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import java.time.LocalDate
import java.time.format.DateTimeFormatter

import androidx.compose.material3.DatePicker



@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen() {
    // Remembering the state of each field in the form
    val nameState = remember { mutableStateOf("") }
    val descriptionState = remember { mutableStateOf("") }
    val dateState = remember { mutableStateOf("") }
    val userState = remember { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current

    var selectedDate by remember { mutableStateOf(LocalDate.now()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Name field
        TextField(
            value = nameState.value,
            onValueChange = { nameState.value = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        // Description field
        TextField(
            value = descriptionState.value,
            onValueChange = { descriptionState.value = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )

        // Date picker field
       
        Text(
            text = "Selected Date: $selectedDate",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(onClick = { /* Do something with selectedDate */ }) {
            Text("Confirm")
        }




        // User field
        TextField(
            value = userState.value,
            onValueChange = { userState.value = it },
            label = { Text("User") },
            modifier = Modifier.fillMaxWidth()
        )

        // Submit button
        Button(
            onClick = {
                // Handle form submission here
                // For simplicity, we'll just print the values
                println("Name: ${nameState.value}")
                println("Description: ${descriptionState.value}")
                println("Date: ${dateState.value}")
                println("User: ${userState.value}")
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Submit")
        }
    }
}



