package com.example.didasco.viewmodels

import androidx.lifecycle.ViewModel
import com.example.didasco.models.Note
import com.google.firebase.database.FirebaseDatabase

class NotesViewModel : ViewModel() {
    private val db = FirebaseDatabase.getInstance().reference.child("notes")

    fun getNotes(subject: String, unit: String): List<Note> {
        // fetch from DB
        // for now, return empty
        return emptyList()
    }

    fun uploadNote(note: Note) {
        // upload
    }
}
