package com.example.matule

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.matule.ui.theme.MatuleTheme
import kotlinx.coroutines.delay


@SuppressLint("CustomSplashScreen")
class SplashScreen : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            MatuleTheme {
                splashScreen()
            }
        }
    }


@Composable
fun splashScreen() {
    LaunchedEffect(key1 = true){
        delay(2000)
        val navigate = Intent(this@SplashScreen, SignInActivity::class.java)
        startActivity(navigate)
    }
    val gradientColorList = listOf(colorResource(R.color.GradientStart),
        colorResource(R.color.GradientEnd))
Box(modifier = Modifier.fillMaxSize()
    .background(brush = GradientBrush(true, colors = gradientColorList)),
    contentAlignment = Alignment.Center){
    Image(painter = painterResource(R.drawable.splash_logo), contentDescription = "logo")
}
}
}