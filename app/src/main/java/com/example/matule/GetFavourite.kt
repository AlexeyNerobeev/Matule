package com.example.matule

import android.util.Log
import com.example.matule.Connect.supabase
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

var favourite: Favourite = Favourite(0, 0, 0)

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
            ).decodeSingle<Favourite>()
            if (response.user_id == user.id){
                favourite = response
            } else{

            }
        } catch (er: Exception) {
            Log.e("supa", er.message.toString())
        }
    }
}