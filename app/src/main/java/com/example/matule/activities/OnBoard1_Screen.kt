package com.example.matule.activities

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.matule.R

@Preview
@Composable
fun OnBoard1_Screen() {
    val font = FontFamily(
        Font(
            resId = R.font.raleway_bold
        )
    )
    val gradientColorList = listOf(colorResource(R.color.GradientStart),
        colorResource(R.color.GradientEnd))
    Column(modifier = Modifier.fillMaxSize().background(brush = GradientBrush(true,
        colors = gradientColorList)
    ),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(top = 80.dp)) {
            Row(horizontalArrangement = Arrangement.Center){
               Image(painter = painterResource(R.drawable.onb_im1), contentDescription = "image")
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "ДОБРО", fontWeight = FontWeight(900), fontFamily = font, fontSize = 30.sp,
                        textAlign = TextAlign.Center, color = Color.White)
                    Text(text = "ПОЖАЛОВАТЬ", fontWeight = FontWeight(900), fontFamily = font, fontSize = 30.sp,
                        textAlign = TextAlign.Center, color = Color.White)
                }
            }
        }

            Box(contentAlignment = Alignment.Center) {
            Image(painter = painterResource(R.drawable.underline), contentDescription = null,
                modifier = Modifier.align(Alignment.TopCenter))
                Image(painter = painterResource(R.drawable.smile_group), contentDescription = null,
                    contentScale = ContentScale.Crop)
                    Image(
                        painter = painterResource(R.drawable.g), contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop)
                Image(painter = painterResource(R.drawable.undercrosslines), contentDescription = null,
                    modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 100.dp))
            }
    }

    Box(modifier = Modifier.fillMaxSize()){
        Button(onClick = {}, modifier = Modifier.fillMaxWidth()
            .height(86.dp)
            .padding(horizontal = 20.dp)
            .padding(bottom = 36.dp)
            .align(Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(13.dp)) {
            Text(text = "Начать", fontSize = 14.sp,
                fontFamily = font, fontWeight = FontWeight(600))
        }
    }
}

@Composable
fun GradientBrush(
    isVerticalGradient: Boolean,
    colors: List<Color>
): Brush {
    val endOffset = if (isVerticalGradient){
        Offset(0f, Float.POSITIVE_INFINITY)
    } else{
        Offset(Float.POSITIVE_INFINITY, 0f)
    }

    return Brush.linearGradient(
        colors = colors,
        start = Offset.Zero,
        end = endOffset
    )
}