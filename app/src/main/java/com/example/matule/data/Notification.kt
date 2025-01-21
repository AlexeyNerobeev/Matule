package com.example.matule.data

import kotlinx.serialization.Serializable

@Serializable
data class Notification(
    val id: Int = 0,
    val created_at: String = "",
    val heading: String = "",
    val text: String = "",
    val user_id: Int = 0
)