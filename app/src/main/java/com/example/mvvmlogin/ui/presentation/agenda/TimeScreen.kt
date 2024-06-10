package com.example.mvvmlogin.ui.presentation.agenda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Timer
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import java.util.*



@Composable
fun TimePickerForm() {
    var startTime by remember { mutableStateOf("") }
    var endTime by remember { mutableStateOf("") }
    var isStartTimePickerVisible by remember { mutableStateOf(false) }
    var isEndTimePickerVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = startTime,
            onValueChange = { startTime = it },
            label = { Text("Start Time") },
            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { isStartTimePickerVisible = true }) {
                    Icon(Icons.Default.Timer, contentDescription = "Select Start Time")
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = endTime,
            onValueChange = { endTime = it },
            label = { Text("End Time") },
            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { isEndTimePickerVisible = true }) {
                    Icon(Icons.Default.Timer, contentDescription = "Select End Time")
                }
            }
        )

        if (isStartTimePickerVisible) {
            TimePickerDialog(
                onTimeSelected = { selectedTime ->
                    startTime = selectedTime
                    isStartTimePickerVisible = false
                },
                onDismiss = { isStartTimePickerVisible = false }
            )
        }

        if (isEndTimePickerVisible) {
            TimePickerDialog(
                onTimeSelected = { selectedTime ->
                    endTime = selectedTime
                    isEndTimePickerVisible = false
                },
                onDismiss = { isEndTimePickerVisible = false }
            )
        }
    }
}

@Composable
fun TimePickerDialog(
    onTimeSelected: (String) -> Unit,
    onDismiss: () -> Unit
) {
    // Implementation of the Time Picker dialog goes here
    // This is a placeholder for the actual time picker dialog
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text("Select Time") },
        text = {
            Column {
                Text("Time picker implementation here")
            }
        },
        confirmButton = {
            Button(onClick = {
                // Simulate time selection
                val selectedTime = "12:00 PM"
                onTimeSelected(selectedTime)
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text("Cancel")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TimePickerFormPreview() {
    TimePickerForm()
}
