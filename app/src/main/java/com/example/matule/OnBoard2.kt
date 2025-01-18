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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
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
import androidx.navigation.compose.rememberNavController
import com.example.matule.ui.theme.MatuleTheme

class OnBoard2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MatuleTheme {
            }
        }
    }
}

@Preview
@Composable
fun PrevOnB2(){
    val n = rememberNavController()
    onBoardScreen2(n)
}

    @Composable
    fun onBoardScreen2(navController: NavController){
        val gradientColorList = listOf(
            colorResource(R.color.GradientStart),
            colorResource(R.color.GradientEnd)
        )
        Column(modifier = Modifier.fillMaxSize()
            .background(brush = GradientBrush(true, colors = gradientColorList)),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.padding(top = 20.dp)){
                Image(painter = painterResource(R.drawable.cross_onb2), contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop)
                Image(painter = painterResource(R.drawable.smile_onb2),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.TopEnd)
                        .padding(top = 33.dp, end = 26.dp))
                Image(painter = painterResource(R.drawable.cruc),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.TopStart)
                        .padding(top = 36.dp, start = 27.dp))
            }
            val font = FontFamily(
                Font(
                    resId = R.font.raleway_bold
                )
            )
            Text(text = "Начнем\nпутешествие", fontSize = 34.sp,
                fontFamily = font,
                fontWeight = FontWeight(89),
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 60.dp)
            )
            Text(text = "Умная, великолепная и модная коллекция. Изучите сейчас",
                fontFamily = font,
                fontSize = 16.sp,
                color = colorResource(R.color.sub_text_light),
                fontWeight = FontWeight(48),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 30.dp).padding(top = 12.dp)
            )
            Image(painter = painterResource(R.drawable.pagelines_onb2),
                contentDescription = null,
                modifier = Modifier.padding(top = 40.dp))
        }
        Box(modifier = Modifier.fillMaxSize()){
            Button(onClick = {
                navController.navigate(NavRoutes.onBoard3.route)
            }, modifier = Modifier.fillMaxWidth()
                .height(86.dp)
                .padding(horizontal = 20.dp)
                .padding(bottom = 36.dp)
                .align(Alignment.BottomCenter),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(13.dp)) {
                Text(text = "Далее", fontSize = 14.sp,
                    fontFamily = font, fontWeight = FontWeight(600))
            }
        }

    }


