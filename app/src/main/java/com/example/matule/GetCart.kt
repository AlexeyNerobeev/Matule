package com.example.matule

import android.util.Log
import com.example.matule.Connect.supabase
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

var cart: Cart = Cart(0, 0, 0, 0)

suspend fun GetCart() {
    withContext(Dispatchers.IO) {
        try {
            val response = supabase.postgrest["cart"].select(
                columns = io.github.jan.supabase.postgrest
                    .query.Columns.list(
                        "id",
                        "user_id",
                        "sneaker_id",
                        "count"
                    )
            ){
                filter {
                    and {
                        eq("user_id", user.id)
                    }
                }
            }.decodeSingle<Cart>()
            if(response.user_id.toString().isNotEmpty()){
                cart = response
            }
        } catch (er: Exception) {
            Log.e("supa", er.message.toString())
            if (er.message.toString() == "List is empty.")
                cart = Cart(0, 0, 0, 1)
        }
    }
}