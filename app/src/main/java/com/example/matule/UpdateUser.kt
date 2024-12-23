package com.example.matule

import android.util.Log
import com.example.matule.Connect.supabase
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun UpdateUser(login: String, password: String) {
    withContext(Dispatchers.IO){
        try {
            val newUser = Users(login = login, password = password)
            supabase.from("users").update(newUser){
                filter {
                    and {
                        eq("id", user.id)
                    }
                }
            }
        } catch (er: Exception) {
            Log.e("supa", er.message.toString())
        }
    }
}

suspend fun UpdateUserName(name: String){
    withContext(Dispatchers.IO){
        try {
            val name = Profile(name = name)
            supabase.from("profile").update(name){
                filter {
                    and {
                        eq("user_id", user.id)
                    }
                }
            }
        } catch (er: Exception) {
            Log.e("supa", er.message.toString())
        }
    }
}
