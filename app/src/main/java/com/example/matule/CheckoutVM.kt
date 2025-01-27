package com.example.matule

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.matule.activities.Order_sum
import com.example.matule.activities.Sum
import com.example.matule.data.Orders
import com.example.matule.data.Profile
import com.example.matule.getData.profile
import com.example.matule.getData.sneakers
import com.example.matule.getData.user
import com.example.matule.supabase.Connect.supabase
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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

    @Composable
    fun ShowInfo(){
        val coroutine = rememberCoroutineScope()
        email = user.login
        sum = Sum
        orderSum = Order_sum
        total = sum + orderSum
        cardName = "DbL Card"
        cardNumber = "**** **** 0696 4629"
        if (profile.phone.isEmpty() || profile.adress.isEmpty()){
            LaunchedEffect(Dispatchers.IO) {
                coroutine.launch {
                    GetPhoneAdress()
                }
            }
        } else{
            phone = profile.phone
            adress = profile.adress
        }
    }

    suspend fun AddOrder(){
        withContext(Dispatchers.IO){
            try {
                val order = Orders(email = email, phone = phone, adress = adress, card_name = cardName,
                    card_number = cardNumber, sneaker_id = sneakers.id, user_id = user.id, sum = sum,
                    order_sum = orderSum, created_at = "")
                supabase.from("orders").insert(order)
            } catch (er: Exception){
                Log.e("supa", er.message.toString())
            }
        }
    }

    suspend fun GetPhoneAdress(){
        withContext(Dispatchers.IO){
            try{
                val response = supabase.postgrest["profile"].select(
                    columns = Columns.list(
                        "user_id",
                        "phone",
                        "adress"
                    )
                ){
                    filter {
                        and{
                            eq("user_id", user.id)
                        }
                    }
                }.decodeSingle<Profile>()
                phone = response.phone
                adress = response.adress
            } catch (ex: Exception){
                Log.e("supa", ex.message.toString())
            }
        }
    }
}