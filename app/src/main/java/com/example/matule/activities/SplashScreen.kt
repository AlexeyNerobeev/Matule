package com.example.matule.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.example.matule.R
import com.example.matule.ui.theme.MatuleTheme
import kotlinx.coroutines.delay


@SuppressLint("CustomSplashScreen")
class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MatuleTheme {
                splashScreen()
            }
        }
    }

@Composable
fun splashScreen() {
    LaunchedEffect(key1 = true) {
        delay(2000)
        val intent = Intent(this@SplashScreen, SignInActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }
    val gradientColorList = listOf(
        colorResource(R.color.GradientStart),
        colorResource(R.color.GradientEnd)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = GradientBrush(
                    true,
                    colors = gradientColorList)
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.splash_logo),
            contentDescription = "logo"
        )
    }
}
}
