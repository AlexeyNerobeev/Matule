package com.example.matule.data

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.matule.supabase.Connect.supabase
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SneakersVM: ViewModel() {
    var sneakersList: List<Sneakers> = listOf()
    var sneakerId: Int = 0

    suspend fun GetSneakers(){
        withContext(Dispatchers.IO){
            try {
                val response = supabase.postgrest["sneakers"].select(
                    columns = Columns.list(
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
                ).decodeList<Sneakers>()
                sneakersList = response
            } catch (ex: Exception){
                Log.e("supa", ex.message.toString())
            }
        }
    }
}