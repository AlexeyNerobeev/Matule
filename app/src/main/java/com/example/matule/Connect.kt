package com.example.matule

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object Connect {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://hpqqdtjqthqdockdsqwa.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImhwcXFkdGpxdGhxZG9ja2RzcXdhIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzQzMjM3MDcsImV4cCI6MjA0OTg5OTcwN30.0-gwM_p4S7oOz-vOX9yZl0CQg8pc1yN3wZJNwbE7_84"
    ) {
        install(Auth)
        install(Postgrest)
    }

}