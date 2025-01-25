package com.example.matule.data

import kotlinx.serialization.Serializable

@Serializable
data class Orders(
    val id: Int = 0,
    val created_at: String = "",
    val order_number: Int = 0,
    val sneaker_id: Int = 0,
    val user_id: Int = 0,
    val sum: Float = 0f,
    val order_sum: Float = 0f,
    val email: String = "",
    val phone: String = "",
    val adress: String = "",
    val card_name: String = "",
    val card_number: String = ""
)
