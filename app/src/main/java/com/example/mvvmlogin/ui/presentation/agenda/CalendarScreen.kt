package com.example.mvvmlogin.ui.presentation.agenda

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import java.text.SimpleDateFormat

@Composable
fun CalendarForm() {
    val calendar = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val initialDate = dateFormat.format(calendar.time)

    var date by remember { mutableStateOf(initialDate) }
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var text3 by remember { mutableStateOf(initialDate) }
    var showDatePicker by remember { mutableStateOf(false) }
    var dayOfYear by remember { mutableStateOf(calendar.get(Calendar.DAY_OF_YEAR)) }
    var year by remember { mutableStateOf(calendar.get(Calendar.YEAR)) }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = text1,
            onValueChange = { text1 = it },
            label = { Text("Text Field 1") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Text Field 2") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Add a Row containing the IconButton and Text Field 3
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            IconButton(onClick = { showDatePicker = true }) {
                Icon(Icons.Filled.CalendarToday, contentDescription = "Pick a Date")
            }
            OutlinedTextField(
                value = text3,
                onValueChange = { text3 = it },
                label = { Text("Text Field 3") },
                modifier = Modifier.weight(1f)
            )
        }

        if (showDatePicker) {
            LaunchedEffect(Unit) {
                DatePickerDialog(
                    context,
                    { _, selectedYear, selectedMonth, selectedDay ->
                        calendar.set(selectedYear, selectedMonth, selectedDay)
                        date = dateFormat.format(calendar.time)
                        text3 = date  // Update text3 with the selected date
                        dayOfYear = calendar.get(Calendar.DAY_OF_YEAR)
                        year = selectedYear
                        showDatePicker = false
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
        }
    }
}