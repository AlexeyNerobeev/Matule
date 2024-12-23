package com.example.matule

import android.util.Log
import com.example.matule.Connect.supabase
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

var notification: Notification = Notification(0, "", "", "", 0)

suspend fun GetNotification() {
    withContext(Dispatchers.IO) {
        try {
            val response = supabase.postgrest["notifications"].select(
                columns = io.github.jan.supabase.postgrest
                    .query.Columns.list(
                        "id",
                        "created_at",
                        "heading",
                        "text",
                        "user_id"
                    )
            ){
                filter {
                    and {
                        eq("user_id", user.id)
                    }
                }
            }.decodeSingle<Notification>()
                notification = response
        } catch (er: Exception) {
            Log.e("supa", er.message.toString())
            if (er.message.toString() == "List is empty.")
                notification = Notification(0, "", "", "", 0)
        }
    }
}