package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.viewmodel.CalculateViewmodel


@Composable
fun MainPage(viewmodel: CalculateViewmodel, navController: NavController) {
    var aValue by remember { mutableStateOf("") }
    var bValue by remember { mutableStateOf("") }
    var cValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth().padding(5.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = aValue,
            onValueChange = { aValue = it },
            label = { Text("Enter value for a") }
        )
        TextField(
            value = bValue,
            onValueChange = { bValue = it },
            label = { Text("Enter value for b") }
        )
        TextField(
            value = cValue,
            onValueChange = { cValue = it },
            label = { Text("Enter value for c") }
        )
        Button(
            onClick = {
                // Calculate delta and navigate to result page
                val a = aValue.toDoubleOrNull() ?: 0.0
                val b = bValue.toDoubleOrNull() ?: 0.0
                val c = cValue.toDoubleOrNull() ?: 0.0
                val delta = viewmodel.calculateDelta(a, b, c)
                // Navigate to result page
                navController.navigate("result/{${delta.toString()}}")

            }
        ) {
            Text("Calculate Delta")
        }
    }
}
