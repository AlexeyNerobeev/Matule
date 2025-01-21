package com.example.matule.dataOperations

import android.util.Log
import com.example.matule.supabase.Connect.supabase
import com.example.matule.data.Cart
import com.example.matule.getData.sneakers
import com.example.matule.getData.user
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun AddCart() {
    withContext(Dispatchers.IO){
        try {
            val cart = Cart(user_id = user.id, sneaker_id = sneakers.id, count = 1)
            supabase.from("cart").insert(cart)
        } catch (er: Exception) {
            Log.e("supa", er.message.toString())
        }
    }
}

suspend fun DelCart(){
    withContext(Dispatchers.IO){
        try {
            supabase.from("cart").delete{
                filter {
                    eq("user_id", user.id)
                }
            }
        } catch (er: Exception) {
            Log.e("supa", er.message.toString())
        }
    }
}
