package com.example.matule

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.matule.ui.theme.MatuleTheme

class OnBoard3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MatuleTheme {
            }
        }
    }
}

@Composable
fun onBoard3Screen(navController: NavController){
    val gradientColorList = listOf(
        colorResource(R.color.GradientStart),
        colorResource(R.color.GradientEnd)
    )
    Column(modifier = Modifier.fillMaxSize().background(brush = GradientBrush(true, colors = gradientColorList)),
        horizontalAlignment = Alignment.CenterHorizontally){
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.padding(top = 37.dp)){
            Image(painter = painterResource(R.drawable.cross_onb3),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop)
            Image(painter = painterResource(R.drawable.smile_onb3),
                contentDescription = null,
                modifier = Modifier.align(Alignment.TopStart)
                    .padding(start = 55.dp, top = 28.dp))
        }
        val font = FontFamily(
            Font(
                resId = R.font.raleway_bold
            )
        )
        Text(text = "У вас есть сила, чтобы",
            fontSize = 34.sp,
            fontFamily = font,
            fontWeight = FontWeight(700),
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 30.dp)
                .padding(top = 60.dp)
        )
        Text(text = "В вашей комнате много красивых и привлекательных растений",
            fontSize = 16.sp,
            fontFamily = font,
            fontWeight = FontWeight(400),
            color = colorResource(R.color.sub_text_light),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 12.dp)
                .padding(horizontal = 26.dp)
        )
        Image(painter = painterResource(R.drawable.pagelunes_onb3),
            contentDescription = null,
            modifier = Modifier.padding(top = 40.dp))
        Button(onClick = {
            navController.navigate(NavRoutes.Main.route)
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            modifier = Modifier.fillMaxWidth().padding(top = 95.dp)
                .padding(horizontal = 20.dp),
            shape = RoundedCornerShape(13.dp)
        ) {
            Text(text = "Далее")
        }
    }
}


