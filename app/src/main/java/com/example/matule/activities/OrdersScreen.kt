package com.example.matule.activities

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
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
import com.example.matule.navigation.NavRoutes

@Preview
@Composable
private fun PrevOrders(){
    val n = rememberNavController()
    OrdersScreen(n)
}

@Composable
fun OrdersScreen(navController: NavController) {
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
                    text = "Заказы",
                    fontFamily = font,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    modifier = Modifier.padding(start = 100.dp),
                    color = Color.Black
                )
            }
            LazyColumn(modifier = Modifier
                .padding(top = 16.dp)) {
                item{
                    Text(text = "Недавний",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(600),
                        fontFamily = font,
                        color = colorResource(R.color.black))
                    Row(modifier = Modifier.padding(top = 16.dp)
                        .background(Color.White, RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(NavRoutes.DetailOrder.route)
                        }){
                        Box(modifier = Modifier
                            .padding(vertical = 10.dp)
                            .padding(start = 10.dp)
                            .background(colorResource(R.color.MainBackground),
                                RoundedCornerShape(16.dp))
                            .size(87.dp, 85.dp)){
                            Image(painter = painterResource(R.drawable.order_sneaker),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize())
                        }
                        Column(modifier = Modifier
                            .padding(start = 14.dp)
                            .padding(top = 14.dp)
                            .padding(bottom = 11.dp)) {
                            Text(text = "№ 325556516",
                                color = colorResource(R.color.darkBlue),
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                fontFamily = font
                            )
                            Text(text = "Nike Air Max 270\nEssential",
                                color = Color.Black,
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                fontFamily = font,
                                modifier = Modifier
                                    .padding(top = 7.dp)
                            )
                            Row(modifier = Modifier
                                .padding(top = 5.dp)) {
                                Text(text = "$364.95",
                                    fontWeight = FontWeight(500),
                                    fontSize = 14.sp,
                                    color = Color.Black
                                )
                                Text(text = "$260.00",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(500),
                                    color = colorResource(R.color.hint),
                                    modifier = Modifier
                                        .padding(start = 20.dp))
                            }
                        }
                        Box(modifier = Modifier
                            .fillMaxSize()){
                            Text(text = "7 мин назад",
                                color = colorResource(R.color.hint),
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                modifier = Modifier.padding(top = 10.dp)
                                    .align(Alignment.TopEnd)
                                    .padding(end = 10.dp)
                            )
                        }
                    }
                    Row(modifier = Modifier.padding(top = 12.dp)
                        .background(Color.White, RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(NavRoutes.DetailOrder.route)
                        }){
                        Box(modifier = Modifier
                            .padding(vertical = 10.dp)
                            .padding(start = 10.dp)
                            .background(colorResource(R.color.MainBackground),
                                RoundedCornerShape(16.dp))
                            .size(87.dp, 85.dp)){
                            Image(painter = painterResource(R.drawable.order_sneaker),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize())
                        }
                        Column(modifier = Modifier
                            .padding(start = 14.dp)
                            .padding(top = 14.dp)
                            .padding(bottom = 11.dp)) {
                            Text(text = "№ 325556516",
                                color = colorResource(R.color.darkBlue),
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                fontFamily = font
                            )
                            Text(text = "Nike Air Max 270\nEssential",
                                color = Color.Black,
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                fontFamily = font,
                                modifier = Modifier
                                    .padding(top = 7.dp)
                            )
                            Row(modifier = Modifier
                                .padding(top = 5.dp)) {
                                Text(text = "$364.95",
                                    fontWeight = FontWeight(500),
                                    fontSize = 14.sp,
                                    color = Color.Black
                                )
                                Text(text = "$260.00",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(500),
                                    color = colorResource(R.color.hint),
                                    modifier = Modifier
                                        .padding(start = 20.dp))
                            }
                        }
                        Box(modifier = Modifier
                            .fillMaxSize()){
                            Text(text = "7 мин назад",
                                color = colorResource(R.color.hint),
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                modifier = Modifier.padding(top = 10.dp)
                                    .align(Alignment.TopEnd)
                                    .padding(end = 10.dp)
                            )
                        }
                    }
                }
                item{
                    Text(text = "Вчера",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(600),
                        fontFamily = font,
                        color = colorResource(R.color.black),
                        modifier = Modifier
                            .padding(top = 24.dp))
                    Row(modifier = Modifier.padding(top = 28.dp)
                        .background(Color.White, RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(NavRoutes.DetailOrder.route)
                        }){
                        Box(modifier = Modifier
                            .padding(vertical = 10.dp)
                            .padding(start = 10.dp)
                            .background(colorResource(R.color.MainBackground),
                                RoundedCornerShape(16.dp))
                            .size(87.dp, 85.dp)){
                            Image(painter = painterResource(R.drawable.order_sneaker),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize())
                        }
                        Column(modifier = Modifier
                            .padding(start = 14.dp)
                            .padding(top = 14.dp)
                            .padding(bottom = 11.dp)) {
                            Text(text = "№ 325556516",
                                color = colorResource(R.color.darkBlue),
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                fontFamily = font
                            )
                            Text(text = "Nike Air Max 270\nEssential",
                                color = Color.Black,
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                fontFamily = font,
                                modifier = Modifier
                                    .padding(top = 7.dp)
                            )
                            Row(modifier = Modifier
                                .padding(top = 5.dp)) {
                                Text(text = "$364.95",
                                    fontWeight = FontWeight(500),
                                    fontSize = 14.sp,
                                    color = Color.Black
                                )
                                Text(text = "$260.00",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(500),
                                    color = colorResource(R.color.hint),
                                    modifier = Modifier
                                        .padding(start = 20.dp))
                            }
                        }
                        Box(modifier = Modifier
                            .fillMaxSize()){
                            Text(text = "10:23",
                                color = colorResource(R.color.hint),
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                modifier = Modifier.padding(top = 10.dp)
                                    .align(Alignment.TopEnd)
                                    .padding(end = 10.dp)
                            )
                        }
                    }
                    Row(modifier = Modifier.padding(top = 12.dp)
                        .background(Color.White, RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(NavRoutes.DetailOrder.route)
                        }){
                        Box(modifier = Modifier
                            .padding(vertical = 10.dp)
                            .padding(start = 10.dp)
                            .background(colorResource(R.color.MainBackground),
                                RoundedCornerShape(16.dp))
                            .size(87.dp, 85.dp)){
                            Image(painter = painterResource(R.drawable.order_sneaker),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize())
                        }
                        Column(modifier = Modifier
                            .padding(start = 14.dp)
                            .padding(top = 14.dp)
                            .padding(bottom = 11.dp)) {
                            Text(text = "№ 325556516",
                                color = colorResource(R.color.darkBlue),
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                fontFamily = font
                            )
                            Text(text = "Nike Air Max 270\nEssential",
                                color = Color.Black,
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                fontFamily = font,
                                modifier = Modifier
                                    .padding(top = 7.dp)
                            )
                            Row(modifier = Modifier
                                .padding(top = 5.dp)) {
                                Text(text = "$364.95",
                                    fontWeight = FontWeight(500),
                                    fontSize = 14.sp,
                                    color = Color.Black
                                )
                                Text(text = "$260.00",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(500),
                                    color = colorResource(R.color.hint),
                                    modifier = Modifier
                                        .padding(start = 20.dp))
                            }
                        }
                        Box(modifier = Modifier
                            .fillMaxSize()){
                            Text(text = "18:34",
                                color = colorResource(R.color.hint),
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                modifier = Modifier.padding(top = 10.dp)
                                    .align(Alignment.TopEnd)
                                    .padding(end = 10.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}