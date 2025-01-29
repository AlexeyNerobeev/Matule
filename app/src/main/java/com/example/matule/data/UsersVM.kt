package com.example.matule.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class UsersVM: ViewModel() {
    var id by mutableIntStateOf(0)
    var login by mutableStateOf("")
    var password by mutableStateOf("")


}