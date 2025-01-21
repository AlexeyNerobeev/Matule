package com.example.matule.data

import kotlinx.serialization.Serializable

@Serializable
data class Cart(
    val id: Int = 0,
    val user_id: Int = 0,
    val sneaker_id: Int = 0,
    val count: Int = 1
)
