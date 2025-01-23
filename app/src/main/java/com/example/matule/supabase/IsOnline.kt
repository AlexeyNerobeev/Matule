package com.example.matule.supabase

import android.content.Context
import android.net.ConnectivityManager


fun isOnline(context: Context): Boolean {
    val cm =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netInfo = cm.activeNetworkInfo
    if (netInfo != null && netInfo.isConnectedOrConnecting) {
        return true
    }
    return false
}