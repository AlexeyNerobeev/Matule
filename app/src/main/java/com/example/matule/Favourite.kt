package com.example.matule

import kotlinx.serialization.Serializable

@Serializable
data class Favourite(
    val id: Int = 0,
    val sneaker_id: Int = 0,
    val user_id: Int = 0
)
