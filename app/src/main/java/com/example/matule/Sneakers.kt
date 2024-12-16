package com.example.matule

import android.icu.lang.UCharacter.NumericType
import kotlinx.serialization.Serializable

@Serializable
data class Sneakers(
    val id: Int,
    val name: String,
    val gender: String,
    val price: NumericType,
    val description: String,
    val info: String,
    val cardPhoto: String,
    val detailPhoto: String
)