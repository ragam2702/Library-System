package com.example.didasco.models

data class Attendance(
    val id: String = "",
    val studentId: String = "",
    val date: String = "",
    val status: String = "", // "present", "absent"
    val method: String = "" // "manual", "qr", "device"
)
