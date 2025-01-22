package com.example.matule.activities

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.matule.R

@Preview
@Composable
fun PrevDetailOrder(){
    val n = rememberNavController()
    DetailOrder(n)
}

@Composable
fun DetailOrder(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(colorResource(R.color.MainBackground))
            .padding(horizontal = 20.dp)){
            Row(modifier = Modifier.fillMaxWidth()) {
                Box(modifier = Modifier.fillMaxWidth()){
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            painter = painterResource(R.drawable.back_icon),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                    Text(
                        text = "325556516",
                        modifier = Modifier
                            .align(Alignment.Center),
                        fontFamily = font,
                        fontWeight = FontWeight(500),
                         fontSize = 14.sp,
                        color = Color.Black
                    )
                }
            }
            Text(text = "7 мин назад",
                color = colorResource(R.color.hint),
                fontSize = 14.sp,
                fontWeight = FontWeight(500),
                modifier = Modifier.align(Alignment.End)
                    .padding(top = 17.dp)
            )
            Row(modifier = Modifier
                .padding(top = 17.dp)
                .fillMaxWidth()
                .background(Color.White)){
                Box(modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(vertical = 10.dp)
                    .background(colorResource(R.color.MainBackground),
                        RoundedCornerShape(16.dp))
                    .size(87.dp, 85.dp)){
                    Image(painter = painterResource(R.drawable.order_sneaker),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop)
                }
                Column(modifier = Modifier
                    .padding(start = 12.dp)
                    .padding(top = 12.dp)
                    .padding(end = 7.dp)) {
                    Text(text = "Nike Air Max 270\nEssential",
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = font)
                    Row(modifier = Modifier
                        .padding(top = 30.dp)){
                        Text(text = "₽814.15",
                            color = Color.Black,
                            fontWeight = FontWeight(500),
                            fontSize = 16.sp
                        )
                        Text(text = "₽60.20",
                            color = colorResource(R.color.hint),
                            fontSize = 16.sp,
                            fontWeight = FontWeight(500),
                            modifier = Modifier
                                .padding(start = 21.dp)
                        )
                    }
                }
            }
            Box(modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth()
                .background(Color.White,
                    RoundedCornerShape(16.dp))) {
                Column(modifier = Modifier
                    .padding(start = 20.dp)
                    .padding(top = 16.dp)) {
                    Text(text = "Контактная информация",
                        color = Color.Black,
                        fontWeight = FontWeight(500),
                        fontSize = 14.sp,
                        fontFamily = font
                    )
                    Row(modifier = Modifier
                        .padding(top = 16.dp)){
                        Icon(painter = painterResource(R.drawable.email),
                            contentDescription = null,
                            tint = Color.Unspecified)
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween) {
                            Column {
                                Text(text = "emmanueloyiboke@gmail.com",
                                    color = Color.Black,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(500)
                                )
                                Text(text = "Email",
                                    color = colorResource(R.color.hint),
                                    fontWeight = FontWeight(500),
                                    fontSize = 12.sp
                                )
                            }
                            Icon(painter = painterResource(R.drawable.pen),
                                contentDescription = null)
                        }
                    }
                    Row(modifier = Modifier
                        .padding(top = 16.dp)) {
                        Icon(painter = painterResource(R.drawable.phone_icon),
                            contentDescription = null,
                            tint = Color.Unspecified)
                        Row(modifier = Modifier
                            .padding(start = 12.dp)
                            .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween) {
                            Column{
                                Text(text = "+234-811-732-5298",
                                    color = Color.Black,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(500)
                                )
                                Text(text = "Телефон",
                                    color = colorResource(R.color.hint),
                                    fontWeight = FontWeight(500),
                                    fontSize = 12.sp,
                                    modifier = Modifier
                                        .padding(top = 4.dp)
                                )
                            }
                            Icon(painter = painterResource(R.drawable.pen),
                                contentDescription = null)
                        }
                    }
                    Text(text = "Адрес",
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = font,
                        modifier = Modifier
                            .padding(top = 12.dp))
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "1082 Аэропорт, Нигерии",
                            color = colorResource(R.color.hint),
                            fontWeight = FontWeight(500),
                            fontSize = 12.sp
                        )
                        Icon(painter = painterResource(R.drawable.select_icon),
                            contentDescription = null)
                    }
                    Image(painter = painterResource(R.drawable.map),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop)
                    Text(text = "Способ оплаты",
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = font,
                        modifier = Modifier
                            .padding(top = 12.dp)
                    )
                    Row(modifier = Modifier
                        .padding(top = 12.dp)){
                        Icon(painter = painterResource(R.drawable.card_type),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .size(40.dp, 40.dp))
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween) {
                            Column {
                                Text(text = "DbL Card",
                                    color = Color.Black,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(500)
                                )
                                Text(text = "**** **** 0696 4629",
                                    color = colorResource(R.color.hint),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(500),
                                    modifier = Modifier
                                        .padding(top = 4.dp)
                                )
                            }
                            Icon(painter = painterResource(R.drawable.select_icon),
                                contentDescription = null,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically))
                        }
                    }
                }
            }
            Image(painter = painterResource(R.drawable.qr_profile),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                contentScale = ContentScale.Crop)
        }
    }
}