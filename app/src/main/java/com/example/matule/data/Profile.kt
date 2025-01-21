package com.example.matule.data

import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    val id: Int = 0,
    val name: String = "",
    val surname: String = "",
    val adress: String = "",
    val photo: String = "",
    val user_id: Int = 0,
    val phone: String = ""
)