package com.example.matule

import kotlinx.serialization.Serializable

@Serializable
data class Users(
    val id: Int = 0,
    val login: String = "",
    val password: String = "",
)
