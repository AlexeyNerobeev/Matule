package com.example.matule.getData

import android.util.Log
import com.example.matule.supabase.Connect.supabase
import com.example.matule.data.Profile
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

var profile: Profile = Profile(0, "", "", "", "", 0, "")

suspend fun GetProfile() {
    withContext(Dispatchers.IO) {
        try {
            val response = supabase.postgrest["profile"].select(
                columns = io.github.jan.supabase.postgrest.query.Columns.list(
                    "id",
                    "name",
                    "surname",
                    "adress",
                    "photo",
                    "user_id",
                    "phone"
                )
            ){
                filter {
                    and{
                        eq("user_id", user.id)
                    }
                }
            }.decodeSingle<Profile>()
            profile = response
        } catch (er: Exception) {
            Log.e("supa", er.message.toString())
            if (er.message.toString() == "List is empty.")
                profile = Profile(0, "", "", "", "", 0, "")
        }
    }
}