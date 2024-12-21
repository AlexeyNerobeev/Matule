package com.example.matule

import android.util.Log
import com.example.matule.Connect.supabase
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
