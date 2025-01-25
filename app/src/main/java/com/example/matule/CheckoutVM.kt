package com.example.matule

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.matule.activities.Order_sum
import com.example.matule.activities.Sum
import com.example.matule.data.Orders
import com.example.matule.getData.profile
import com.example.matule.getData.sneakers
import com.example.matule.getData.user
import com.example.matule.supabase.Connect.supabase
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CheckoutVM(): ViewModel() {
    var email by mutableStateOf("")
    var phone by mutableStateOf("")
    var adress by mutableStateOf("")
    var sum by mutableFloatStateOf(0f)
    var orderSum by mutableFloatStateOf(0f)
    var total by mutableFloatStateOf(0f)
    var cardName by mutableStateOf("")
    var cardNumber by mutableStateOf("")

    fun ShowInfo(){
        email = user.login
        phone = profile.phone
        adress = profile.adress
        sum = Sum
        orderSum = Order_sum
        total = sum + orderSum
        cardName = "DbL Card"
        cardNumber = "**** **** 0696 4629"
    }

    suspend fun AddOrder(){
        withContext(Dispatchers.IO){
            try {
                val order = Orders(email = email, phone = phone, adress = adress, card_name = cardName,
                    card_number = cardNumber, sneaker_id = sneakers.id, user_id = user.id, sum = sum,
                    order_sum = orderSum)
                supabase.from("orders").insert(order)
            } catch (er: Exception){
                Log.e("supa", er.message.toString())
            }
        }
    }
}