package com.example.didasco.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.didasco.models.Note
import com.example.didasco.viewmodels.NotesViewModel

@Composable
fun NotesScreen(navController: NavController, notesViewModel: NotesViewModel = NotesViewModel()) {
    var subject by remember { mutableStateOf("") }
    var unit by remember { mutableStateOf("") }
    val notes = remember { mutableStateOf(listOf<Note>()) }

    LaunchedEffect(subject, unit) {
        notes.value = notesViewModel.getNotes(subject, unit)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Notes", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = subject,
            onValueChange = { subject = it },
            label = { Text("Subject") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = unit,
            onValueChange = { unit = it },
            label = { Text("Unit") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(notes.value) { note ->
                Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = note.title, style = MaterialTheme.typography.headlineSmall)
                        Text(text = "Type: ${note.type}")
                        // Download button
                    }
                }
            }
        }
    }
}
