package com.example.matule.data

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.matule.getData.user
import com.example.matule.supabase.Connect.supabase
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OrdersVM : ViewModel() {
    var email by mutableStateOf("")
    var phone by mutableStateOf("")
    var adress by mutableStateOf("")
    var cardName by mutableStateOf("")
    var cardNumber by mutableStateOf("")
    var sum by mutableFloatStateOf(0f)
    var orderSum by mutableFloatStateOf(0f)
    var total by mutableFloatStateOf(0f)
    var orderId by mutableIntStateOf(0)
    var userId by mutableIntStateOf(0)
    var sneakerId by mutableIntStateOf(0)

    suspend fun GetOrders(){
        withContext(Dispatchers.IO){
            try {
                val response = supabase.postgrest["orders"].select(
                    columns = Columns.list(
                        "id",
                        "created_at",
                        "order_number",
                        "sneaker_id",
                        "user_id",
                        "sum",
                        "order_sum",
                        "email",
                        "phone",
                        "adress",
                        "card_name",
                        "card_number"
                    )
                ){
                    filter {
                        and {
                            eq("user_id", user.id)
                        }
                    }
                }.decodeSingle<Orders>()
                if (response.user_id.toString().isNotEmpty()){
                    email = response.email
                    phone = response.phone
                    adress = response.adress
                    cardName = response.card_name
                    cardNumber = response.card_number
                    sum = response.sum
                    orderSum = response.order_sum
                    total = response.sum + response.order_sum
                    orderId = response.id
                    userId = response.user_id
                    sneakerId = response.sneaker_id
                } else{

                }
            } catch (er: Exception){
                Log.e("supa", er.message.toString())
            }
        }
    }

    suspend fun DeleteOrder(){
        withContext(Dispatchers.IO){
            supabase.from("orders").delete{
                filter {
                    and{
                        eq("user_id", user.id)
                        eq("order_id", orderId)
                    }
                }
            }
        }
    }
}