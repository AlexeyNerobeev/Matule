package com.example.matule.activities

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.matule.data.CheckoutVM
import com.example.matule.R
import com.example.matule.navigation.NavRoutes
import kotlinx.coroutines.launch

@Preview
@Composable
private fun PrevCheckout(){
    val n = rememberNavController()
    val vm = CheckoutVM()
    CheckoutScreen(n, vm)
}

@Composable
fun CheckoutScreen(navController: NavController, vm : CheckoutVM){
    vm.ShowInfo()
    val coroutine = rememberCoroutineScope()
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
            LazyColumn {
                item {

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
                        color = Color.Black,
                        modifier = Modifier
                            .padding(top = 16.dp)
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
                                Text(text = "${vm.email}",
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
                                Text(text = "${vm.phone}",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(500),
                                    color = Color.Black
                                )
                                Text(text = "Телефон",
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
                        Text(text = "${vm.adress}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight(500),
                            color = colorResource(R.color.hint))
                        Icon(painter = painterResource(R.drawable.select_icon),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .clickable {  })
                    }
                    Box(modifier = Modifier
                        .padding(top = 16.dp)){
                        Image(painter = painterResource(R.drawable.map),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentScale = ContentScale.Crop)
                        Image(painter = painterResource(R.drawable.blackout),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth(),
                            contentScale = ContentScale.Crop)
                        Column(modifier = Modifier
                            .align(Alignment.Center)
                            .padding(top = 19.dp)) {
                            Text(text = "Посмотреть на карте",
                                color = Color.White,
                                fontFamily = font,
                                fontWeight = FontWeight(700),
                                fontSize = 20.sp
                            )
                            Box(modifier = Modifier
                                .padding(top = 6.dp)
                                .background(colorResource(R.color.darkBlue),
                                    CircleShape)
                                .size(36.dp)
                                .align(Alignment.CenterHorizontally)){
                                Icon(painter = painterResource(R.drawable.marker),
                                    contentDescription = null,
                                    tint = Color.Unspecified,
                                    modifier = Modifier
                                        .align(Alignment.Center))

                            }
                        }
                    }
                    Text(text = "Способ оплаты",
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = font,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(top = 12.dp)
                   )
                    Row(modifier = Modifier
                        .padding(top = 12.dp)
                        .padding(bottom = 7.dp)){
                        Image(painter = painterResource(R.drawable.card_type),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp, 40.dp))
                        Row(horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()){
                            Column(modifier = Modifier
                                .padding(start = 12.dp)) {
                                Text(text = "${vm.cardName}",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(500),
                                    color = Color.Black
                                )
                                Text(text = "${vm.cardNumber}",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(500),
                                    color = colorResource(R.color.hint))
                            }
                            Icon(painter = painterResource(R.drawable.select_icon),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .clickable {

                                    })
                        }
                    }
                }
            }
                }
                item {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp))
                }
            }
        }
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter){
            Box(modifier = Modifier.background(Color.White)
                .fillMaxWidth()){
                Column(modifier = Modifier.padding(bottom = 32.dp)
                    .padding(horizontal = 20.dp)
                    .padding(top = 34.dp)
                    .background(Color.White)) {
                    Row(modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween){
                        Text(text = "Сумма",
                            fontFamily = font,
                            fontWeight = FontWeight(500),
                            fontSize = 16.sp,
                            color = colorResource(R.color.sub_text_dark))
                        Text(text = "₽${vm.sum}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight(500),
                            color = Color.Black
                        )
                    }
                    Row(modifier = Modifier.fillMaxWidth()
                        .padding(top = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "Доставка",
                            fontFamily = font,
                            fontWeight = FontWeight(500),
                            fontSize = 16.sp,
                            color = colorResource(R.color.sub_text_dark))
                        Text(text = "₽${vm.orderSum}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight(500),
                            color = Color.Black
                        )
                    }
                    Canvas(Modifier.padding(top = 16.dp).fillMaxWidth().background(Color.White)) {
                        val width = size.width
                        drawLine(
                            start = Offset(x= 0f, y = 0f),
                            end = Offset(x = width, y = 0f),
                            color = Color.Gray,
                            strokeWidth = 6.0f,
                            pathEffect = PathEffect.dashPathEffect(floatArrayOf(30f, 30f, 30f, 30f), phase = 0f)
                        )
                    }
                    Row(modifier = Modifier.padding(top = 16.dp)
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween){
                        Text(text = "Итого",
                            fontSize = 16.sp,
                            fontWeight = FontWeight(500),
                            fontFamily = font,
                            color = Color.Black
                        )
                        Text(text = "₽${vm.total}",
                            color = colorResource(R.color.button),
                            fontSize = 16.sp,
                            fontWeight = FontWeight(500)
                        )
                    }
                    val openDialog = remember { mutableStateOf(false) }
                    Button(onClick = {
                        coroutine.launch {
                            vm.AddOrder()
                        }
                        openDialog.value = true
                    },
                        modifier = Modifier.padding(top = 30.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = colorResource(R.color.button)
                        )) {
                        Text(text = "Оформить Заказ",
                            fontWeight = FontWeight(500),
                            fontSize = 14.sp,
                            fontFamily = font
                        )
                    }
                    if (openDialog.value) {
                        AlertDialog(
                            containerColor = Color.White,
                            onDismissRequest = { openDialog.value = false
                                navController.navigate(NavRoutes.Main.route)},
                            icon = {Box(modifier = Modifier
                                .size(134.dp)
                                .clip(CircleShape)
                                .background(colorResource(R.color.LightBlue)),
                                contentAlignment = Alignment.Center){
                                Image(painter = painterResource(R.drawable.happy_image),
                                    contentDescription = null,
                                    modifier = Modifier.size(86.dp))
                            }},
                            title = { Text(text = "Вы успешно\nоформили заказ",
                                fontSize = 20.sp,
                                color = Color.Black,
                                fontFamily = font,
                                fontWeight = FontWeight(700),
                                textAlign = TextAlign.Center
                            ) },
                            confirmButton = {
                                Button(onClick = {
                                    openDialog.value = false
                                    navController.navigate(NavRoutes.Main.route)
                                },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(51.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = colorResource(R.color.button),
                                        contentColor = Color.White
                                    ),
                                    shape = RoundedCornerShape(16.dp)) {
                                    Text(text = "Вернуться к покупкам",
                                        fontFamily = font,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight(500)
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}