package com.example.matule.getData

import android.util.Log
import com.example.matule.supabase.Connect.supabase
import com.example.matule.data.Users
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

var user = Users(0, "", "")

suspend fun GetUser(login: String) {
    withContext(Dispatchers.IO) {
        try {
            val response = supabase.postgrest["users"].select(
                columns = io.github.jan.supabase.postgrest.query.Columns.list(
                    "id",
                    "login",
                    "password"
                )
            ){
                filter {
                    and{
                        eq("login", login)
                    }
                }
            }.decodeSingle<Users>()
            user = response
        } catch (er: Exception) {
            Log.e("supa", er.message.toString())
        }
    }
}