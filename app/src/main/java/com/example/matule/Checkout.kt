package com.example.matule

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
private fun Prev(){
    val n = rememberNavController()
    CheckoutScreen(n)
}

@Composable
fun CheckoutScreen(navController: NavController){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize().background(
                colorResource(R.color.MainBackground)
            )
                .padding(horizontal = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Image(
                        painter = painterResource(R.drawable.back_icon),
                        contentDescription = null
                    )
                }
                Text(
                    text = "Корзина",
                    fontFamily = font,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    modifier = Modifier.padding(start = 100.dp),
                    color = Color.Black
                )
            }
            Column(modifier = Modifier
                .padding(top = 46.dp)
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(16.dp))){
                Column(modifier = Modifier
                    .padding(horizontal = 20.dp)) {
                    Text(text = "Контактная информация",
                        fontSize = 14.sp,
                        fontFamily = font,
                        fontWeight = FontWeight(500),
                        color = Color.Black
                   )
                    Row(modifier = Modifier.padding(top = 16.dp)
                        .fillMaxWidth()){
                        Icon(painter = painterResource(R.drawable.email),
                            contentDescription = null,
                            tint = Color.Unspecified)
                        Row(modifier = Modifier
                            .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween){
                            Column(modifier = Modifier
                                .padding(start = 12.dp)) {
                                Text(text = "emmanueloyiboke@gmail.com",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(500),
                                    color = Color.Black
                                )
                                Text(text = "Email",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(500),
                                    color = colorResource(R.color.hint),
                                    modifier = Modifier
                                        .padding(top = 4.dp)
                                )
                            }
                            Icon(painter = painterResource(R.drawable.pen),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .clickable {  })
                        }
                    }
                    Row(modifier = Modifier.padding(top = 16.dp)
                        .fillMaxWidth()){
                        Icon(painter = painterResource(R.drawable.phone_icon),
                            contentDescription = null,
                            tint = Color.Unspecified)
                        Row(horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()) {
                            Column(modifier = Modifier
                                .padding(start = 12.dp)) {
                                Text(text = "+234-811-732-5298",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(500),
                                    color = Color.Black
                                )
                                Text(text = "Телефон",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(500),
                                    color = colorResource(R.color.hint)
                                )
                            }
                            Icon(painter = painterResource(R.drawable.pen),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .clickable {  })
                        }
                    }
                    Text(text = "Адрес",
                        fontSize = 14.sp,
                        fontFamily = font,
                        fontWeight = FontWeight(500),
                        color = Color.Black,
                        modifier = Modifier
                            .padding(top = 12.dp))
                    Row(modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "1082 Аэропорт, Нигерии",
                            fontSize = 12.sp,
                            fontWeight = FontWeight(500),
                            color = colorResource(R.color.hint))
                        Icon(painter = painterResource(R.drawable.select_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .clickable {  })
                    }
                    Image(painter = painterResource(R.drawable.map),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        contentScale = ContentScale.Crop)
                    Text(text = "Способ оплаты",
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = font,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(top = 12.dp)
                   )
                    Row(modifier = Modifier
                        .padding(top = 12.dp)){
                        Image(painter = painterResource(R.drawable.card_type),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp, 40.dp))
                        Row(horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()){
                            Column(modifier = Modifier
                                .padding(start = 12.dp)) {
                                Text(text = "DbL Card",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(500),
                                    color = Color.Black
                                )
                                Text(text = "**** **** 0696 4629",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(500),
                                    color = colorResource(R.color.hint))
                            }
                            Icon(painter = painterResource(R.drawable.select_icon),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically))
                        }
                    }
                }
            }
        }
    }
}