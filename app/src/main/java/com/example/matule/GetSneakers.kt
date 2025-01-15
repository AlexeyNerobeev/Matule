package com.example.matule

import android.util.Log
import com.example.matule.Connect.supabase
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

var sneakers: Sneakers = Sneakers(0, "", "", 0f, "", "", "", "", "")

suspend fun GetSneakers(){
    withContext(Dispatchers.IO) {
        try {
            val response = supabase.postgrest["sneakers"].select(
                columns = io.github.jan.supabase.postgrest.query.Columns.list(
                    "id",
                    "name",
                    "gender",
                    "price",
                    "description",
                    "info",
                    "card_photo",
                    "detail_photo",
                    "category"
                )
            ).decodeSingle<Sneakers>()
            sneakers = response
        } catch (er: Exception) {
            Log.e("supa", er.message.toString())
        }
    }
}