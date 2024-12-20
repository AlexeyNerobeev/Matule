package com.example.matule

import android.util.Log
import com.example.matule.Connect.supabase
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun AddFavourite() {
    withContext(Dispatchers.IO){
        try {
            val favourite = Favourite(sneaker_id = sneakers.id, user_id = user.id)
            supabase.from("favourite").insert(favourite)
        } catch (er: Exception) {
            Log.e("supa", er.message.toString())
        }
    }
}

suspend fun DeleteFavourite(){
    withContext(Dispatchers.IO){
        try {
            supabase.from("favourite").delete{
                filter {
                    eq("user_id", user.id)
                }
            }
        } catch (er: Exception) {
            Log.e("supa", er.message.toString())
        }
    }
}