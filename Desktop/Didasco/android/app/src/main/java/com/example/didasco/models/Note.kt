package com.example.didasco.models

data class Note(
    val id: String = "",
    val subject: String = "",
    val unit: String = "",
    val title: String = "",
    val type: String = "", // "pdf", "doc", "image"
    val url: String = "",
    val uploadedBy: String = "",
    val timestamp: Long = 0L
)
