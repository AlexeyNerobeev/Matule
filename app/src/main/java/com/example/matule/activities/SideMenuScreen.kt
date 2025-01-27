package com.example.matule.activities

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
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
import com.example.matule.navigation.NavRoutes

@Preview
@Composable
fun PrevSideMenu(){
    val n = rememberNavController()
    SideMenuScreen(n)
}

@Composable
fun SideMenuScreen(navController: NavController) {
    Scaffold(modifier = Modifier
        .background(colorResource(R.color.button))) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)
            .background(colorResource(R.color.button))
            .fillMaxSize()){
            Image(painter = painterResource(R.drawable.home_screen),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 49.dp)
                    .padding(start = 32.dp)
                    .padding(bottom = 97.dp)
                    .fillMaxHeight()
                    .align(Alignment.CenterEnd),
                contentScale = ContentScale.Crop)
                    Column(
                        modifier = Modifier.fillMaxHeight()
                            .padding(start = 20.dp)
                            .align(Alignment.CenterStart),
                    ) {
                        Image(
                            painter = painterResource(R.drawable.profile_image),
                            contentDescription = null,
                            modifier = Modifier.padding(top = 48.dp)
                                .padding(start = 15.dp)
                                .size(96.dp, 96.dp)
                        )
                        Text(
                            text = "Emmanuel Oyiboke",
                            modifier = Modifier.padding(top = 8.dp)
                                .padding(start = 15.dp),
                            color = Color.White,
                            fontWeight = FontWeight(600),
                            fontSize = 20.sp,
                            fontFamily = font
                        )
                        Column(
                            modifier = Modifier.padding(top = 55.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.clickable {
                                    navController.navigate(NavRoutes.EditProfile.route)
                                }) {
                                Icon(
                                    painter = painterResource(R.drawable.profile_bottomnav_icon),
                                    contentDescription = null,
                                    tint = Color.White
                                )
                                Text(text = "Профиль",
                                    color = Color.White,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(500),
                                    fontFamily = font,
                                    modifier = Modifier.padding(start = 22.dp))
                            }
                            Row(verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(top = 30.dp)
                                    .clickable {
                                        navController.navigate(NavRoutes.Cart.route)
                                    }) {
                                Icon(
                                    painter = painterResource(R.drawable.cart_flact_button),
                                    contentDescription = null,
                                    tint = Color.White
                                )
                                Text(text = "Корзина",
                                    color = Color.White,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(500),
                                    fontFamily = font,
                                    modifier = Modifier.padding(start = 22.dp))
                            }
                            Row(verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(top = 30.dp)
                                    .clickable {
                                        navController.navigate(NavRoutes.Favourite.route)
                                    }) {
                                Icon(
                                    painter = painterResource(R.drawable.heart_bottomnav_icon),
                                    contentDescription = null,
                                    tint = Color.White
                                )
                                Text(text = "Избранное",
                                    color = Color.White,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(500),
                                    fontFamily = font,
                                    modifier = Modifier.padding(start = 22.dp))
                            }
                            Row(verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(top = 30.dp)
                                    .clickable {
                                        navController.navigate(NavRoutes.Orders.route)
                                    }) {
                                Icon(
                                    painter = painterResource(R.drawable.orders_icon),
                                    contentDescription = null,
                                    tint = Color.White
                                )
                                Text(text = "Заказы",
                                    color = Color.White,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(500),
                                    fontFamily = font,
                                    modifier = Modifier.padding(start = 22.dp))
                            }
                            Row(verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(top = 30.dp)
                                    .clickable {
                                        navController.navigate(NavRoutes.Notification.route)
                                    }) {
                                Icon(
                                    painter = painterResource(R.drawable.notification_bottomnav_icon),
                                    contentDescription = null,
                                    tint = Color.White
                                )
                                Text(text = "Уведомления",
                                    color = Color.White,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(500),
                                    fontFamily = font,
                                    modifier = Modifier.padding(start = 22.dp))
                            }
                            Row(verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(top = 30.dp)) {
                                Icon(
                                    painter = painterResource(R.drawable.settings_icon),
                                    contentDescription = null,
                                    tint = Color.White
                                )
                                Text(text = "Настройки",
                                    color = Color.White,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(500),
                                    fontFamily = font,
                                    modifier = Modifier.padding(start = 22.dp))
                            }
                            Image(painter = painterResource(R.drawable.side_menu_line),
                                contentDescription = null,
                                modifier = Modifier.padding(top = 38.dp))
                            Row(verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(top = 30.dp)
                                    .clickable {
                                        navController.navigate(NavRoutes.SignIn.route){
                                            popUpTo(NavRoutes.SignIn.route)
                                        }
                                    }) {
                                Icon(
                                    painter = painterResource(R.drawable.left_icon),
                                    contentDescription = null,
                                    tint = Color.White
                                )
                                Text(text = "Выйти",
                                    color = Color.White,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(500),
                                    fontFamily = font,
                                    modifier = Modifier.padding(start = 22.dp))
                            }
                        }
                    }
                }
        }
    }
