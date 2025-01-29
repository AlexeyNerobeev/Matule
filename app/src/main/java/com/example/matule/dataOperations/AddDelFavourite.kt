package com.example.matule.dataOperations

import android.util.Log
import com.example.matule.supabase.Connect.supabase
import com.example.matule.data.Favourite
import com.example.matule.getData.sneakers
import com.example.matule.getData.user
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun AddFavourite() {
    withContext(Dispatchers.IO){
        try {
            val favourite = Favourite(sneaker_id = sneakers[0].id, user_id = user.id)
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