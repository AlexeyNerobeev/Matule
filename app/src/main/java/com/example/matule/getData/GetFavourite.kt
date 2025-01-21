package com.example.matule.getData

import android.annotation.SuppressLint
import android.util.Log
import com.example.matule.supabase.Connect.supabase
import com.example.matule.data.Favourite
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

var favourite: Favourite = Favourite(0, 0, 0)

@SuppressLint("SuspiciousIndentation")
suspend fun GetFavourite() {
    withContext(Dispatchers.IO) {
        try {
            val response = supabase.postgrest["favourite"].select(
                columns = io.github.jan.supabase.postgrest
                    .query.Columns.list(
                    "id",
                    "sneaker_id",
                    "user_id"
                )
            ){
                filter {
                    and {
                        eq("user_id", user.id)
                    }
                }
            }.decodeSingle<Favourite>()
            if(response.user_id.toString().isNotEmpty()){
                favourite = response
            }
        } catch (er: Exception) {
            Log.e("supa", er.message.toString())
            if (er.message.toString() == "List is empty.")
            favourite = Favourite(0, 0, 0)
        }
    }
}