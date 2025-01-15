package com.example.matule

import kotlinx.serialization.Serializable

@Serializable
data class Sneakers(
    val id: Int,
    val name: String,
    val gender: String,
    val price: Float,
    val description: String,
    val info: String,
    val card_photo: String,
    val detail_photo: String,
    val category: String
)