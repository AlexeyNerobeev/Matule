package com.example.matule

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun PrevNotification(){
    val n = rememberNavController()
    NotificationScreen(n)
}

@Composable
fun NotificationScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()
        .background(Color.White)) { innerPadding ->
        val font = FontFamily(
            Font(
                resId = R.font.raleway_bold
            )
        )
        LazyColumn(modifier = Modifier.fillMaxSize().padding(innerPadding)
            .padding(horizontal = 20.dp)
            .background(Color.White)) {
            items(15){
                Box(modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth()
                    .background(colorResource(R.color.MainBackground),
                        shape = RoundedCornerShape(12.dp))){
                    Column(modifier = Modifier.padding(horizontal = 16.dp)
                        .padding(top = 16.dp)) {
                        Text(text = "Заголовок",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontFamily = font,
                            fontWeight = FontWeight(700)
                        )
                        Text(text = "Lorem ipsum dolor sit amet consectetur. Venenatis pulvinar lobortis risus consectetur morbi egestas id in bibendum. Volutpat nulla urna sit sed diam nulla.",
                            modifier = Modifier.padding(top = 8.dp),
                            textAlign = TextAlign.Start,
                            color = Color.Black,
                            fontSize = 12.sp,
                            fontFamily = font,
                            fontWeight = FontWeight(500)
                        )
                        Text(text = "27.01.2024, 15:42",
                            modifier = Modifier.padding(top = 16.dp)
                                .padding(bottom = 16.dp),
                            color = colorResource(R.color.sub_text_dark),
                            fontFamily = font,
                            fontWeight = FontWeight(500),
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val const = createRef()
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(106.dp)
            .constrainAs(const){
                bottom.linkTo(parent.bottom)
            }){
            Image(painter = painterResource(R.drawable.bottombar_shape),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
                    .align(Alignment.BottomCenter),
                contentScale = ContentScale.Crop)
            IconButton(onClick = {
                navController.navigate(NavRoutes.Cart.route)
            },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = colorResource(R.color.button),
                    contentColor = Color.White
                ),
                modifier = Modifier.size(56.dp, 56.dp).align(Alignment.TopCenter)
            ) {
                Image(painter = painterResource(R.drawable.cart_flact_button),
                    contentDescription = null)
            }
            Row(modifier = Modifier.align(Alignment.Center).fillMaxWidth().padding(horizontal = 31.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(0.5f)
                        .padding(end = 50.dp)){
                    IconButton(onClick = {
                        navController.navigate(NavRoutes.Main.route)
                    }) {
                        Icon(painter = painterResource(R.drawable.home_bottomnav_icon),
                            contentDescription = null)
                    }
                    IconButton(onClick = {
                        navController.navigate(NavRoutes.Favourite.route)
                    }) {
                        Icon(painter = painterResource(R.drawable.heart_bottomnav_icon),
                            contentDescription = null)
                    }
                }
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(1f)
                        .padding(start = 50.dp)){
                    IconButton(onClick = {},
                        colors = IconButtonDefaults.iconButtonColors(
                            contentColor = colorResource(R.color.button)
                        )) {
                        Icon(painter = painterResource(R.drawable.notification_bottomnav_icon),
                            contentDescription = null)
                    }
                    IconButton(onClick = {
                        navController.navigate(NavRoutes.Profile.route)
                    }) {
                        Icon(painter = painterResource(R.drawable.profile_bottomnav_icon),
                            contentDescription = null)
                    }
                }
            }
            }
        }
}