package com.example.matule

import android.util.Log
import com.example.matule.Connect.supabase
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun AddProfile(name: String) {
    withContext(Dispatchers.IO){
        try {
            val profile = Profile(name = name, user_id = user.id)
            supabase.from("profile").insert(profile)
        } catch (er: Exception) {
            Log.e("supa", er.message.toString())
        }
    }
}

suspend fun UpdateProfile(name: String, surname: String, adress: String, phone: String){
    withContext(Dispatchers.IO){
        try {
            val profile = Profile(name = name, surname = surname, adress = adress, phone = phone)
            supabase.from("profile").update(profile){
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