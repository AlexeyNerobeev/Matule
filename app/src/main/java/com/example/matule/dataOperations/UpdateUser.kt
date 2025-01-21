package com.example.matule.dataOperations

import android.util.Log
import com.example.matule.supabase.Connect.supabase
import com.example.matule.data.Profile
import com.example.matule.data.Users
import com.example.matule.getData.user
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
