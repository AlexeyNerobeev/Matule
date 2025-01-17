package com.example.matule

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.collection.mutableFloatSetOf
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
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
import androidx.navigation.compose.rememberNavController
import com.example.matule.ui.theme.MatuleTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartActivity : ComponentActivity() {
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
fun PrevCart(){
    val n = rememberNavController()
    cartScreen(n)
}

var Sum: Float = 0f
var Order_sum: Float = 0f

    @SuppressLint("CoroutineCreationDuringComposition")
    @Composable
    fun cartScreen(navController: NavController){

        val coroutine = rememberCoroutineScope()
        val itemsCount = remember { mutableIntStateOf(0) }
        val name = remember { mutableStateOf("") }
        val price = remember{ mutableFloatStateOf(0f) }
        if(user.id == cart.user_id){
            itemsCount.value = cart.count
            name.value = sneakers.name
            price.value = sneakers.price
        }
        val sum = remember { mutableFloatStateOf(price.value * itemsCount.value) }
        val orderSum = remember { mutableFloatStateOf(itemsCount.value * 60.20f) }

        val font = FontFamily(
            Font(
                resId = R.font.raleway_bold
            )
        )
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding).fillMaxSize().background(
                colorResource(R.color.MainBackground)
            )
                .padding(horizontal = 20.dp)) {
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
                Text(text = "${itemsCount.value} товар(а/ов)",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    modifier = Modifier.padding(top = 16.dp),
                    color = Color.Black
                )
                LazyColumn(modifier = Modifier.padding(top = 8.dp)) {
                    if (itemsCount.value > 0) {
                        item {
                                var xOffset by remember { mutableStateOf(0f) }
                                val isSwipedRight = xOffset >= 68
                                val isSwipedLeft = xOffset <= -68

                                Row(modifier = Modifier.fillMaxWidth()
                                    .height(104.dp)
                                    .draggable(
                                        orientation = Orientation.Horizontal,
                                        state = rememberDraggableState { distance ->
                                            xOffset += distance
                                        }
                                    )) {
                                    if (isSwipedRight) {
                                        Box(
                                            modifier = Modifier.padding(end = 10.dp)
                                                .size(58.dp, 104.dp)
                                                .background(
                                                    colorResource(R.color.button),
                                                    shape = RoundedCornerShape(8.dp)
                                                )
                                        ) {
                                            Column(
                                                modifier = Modifier.fillMaxSize(),
                                                horizontalAlignment = Alignment.CenterHorizontally
                                            ) {
                                                IconButton(
                                                    onClick = {
                                                        if(itemsCount.value > 0)
                                                        itemsCount.value++
                                                        sum.value = price.value * itemsCount.value
                                                        orderSum.value = itemsCount.value * 60.20f
                                                    },
                                                    colors = IconButtonDefaults.iconButtonColors(
                                                        contentColor = Color.White
                                                    )
                                                ) {
                                                    Icon(
                                                        Icons.Filled.Add,
                                                        contentDescription = null
                                                    )
                                                }
                                                Text(
                                                    text = itemsCount.value.toString(),
                                                    fontSize = 14.sp,
                                                    fontFamily = font,
                                                    fontWeight = FontWeight(400),
                                                    color = Color.White,
                                                    textAlign = TextAlign.Center
                                                )
                                                IconButton(
                                                    onClick = {
                                                        if (itemsCount.value > 1){
                                                            itemsCount.value--
                                                            sum.value = price.value * itemsCount.value
                                                            orderSum.value = itemsCount.value * 60.20f
                                                        }
                                                    },
                                                    colors = IconButtonDefaults.iconButtonColors(
                                                        contentColor = Color.White
                                                    )
                                                ) {
                                                    Icon(
                                                        painter = painterResource(R.drawable.minus_icon),
                                                        contentDescription = null
                                                    )
                                                }
                                            }
                                        }
                                    }

                                    Box(
                                        modifier = Modifier
                                            .background(
                                                Color.White,
                                                shape = RoundedCornerShape(8.dp)
                                            )
                                            .weight(1f)
                                            .fillMaxHeight()
                                            .padding(start = if (isSwipedRight) 0.dp else 10.dp)
                                    ) {
                                        Row(modifier = Modifier.fillMaxSize()
                                            .clickable {
                                                navController.navigate(NavRoutes.Details.route)
                                            }) {
                                            Image(
                                                painter = painterResource(R.drawable.cart_cross),
                                                contentDescription = null,
                                                modifier = Modifier.fillMaxHeight()
                                                    .padding(vertical = 10.dp),
                                                contentScale = ContentScale.Crop
                                            )
                                            Column(
                                                modifier = Modifier
                                                    .padding(start = 30.dp)
                                                    .padding(end = 13.dp)
                                                    .padding(vertical = 29.dp),
                                                verticalArrangement = Arrangement.Center
                                            ) {
                                                Text(
                                                    text = name.value,
                                                    fontSize = 16.sp,
                                                    fontFamily = font,
                                                    fontWeight = FontWeight(500),
                                                    color = Color.Black
                                                )
                                                Text(
                                                    text = price.value.toString(),
                                                    modifier = Modifier.padding(top = 6.dp),
                                                    fontSize = 14.sp,
                                                    fontWeight = FontWeight(500),
                                                    color = Color.Black
                                                )
                                            }
                                        }
                                    }

                                    if (isSwipedLeft) {
                                        Box(
                                            modifier = Modifier
                                                .padding(start = 10.dp)
                                                .size(58.dp, 104.dp)
                                                .background(
                                                    Color.Red,
                                                    shape = RoundedCornerShape(8.dp)
                                                ),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            IconButton(
                                                onClick = {
                                                    coroutine.launch(Dispatchers.IO) {
                                                        DelCart()
                                                        GetCart()
                                                    }
                                                },
                                                colors = IconButtonDefaults.iconButtonColors(
                                                    contentColor = Color.White
                                                )
                                            ) {
                                                Icon(
                                                    painter = painterResource(R.drawable.delete_from_cart),
                                                    contentDescription = null
                                                )
                                            }
                                        }
                                    }
                                }

                        }
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
                                Sum = sum.value
                                Text(text = "₽${sum.value}",
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
                                Order_sum = orderSum.value
                                Text(text = "₽${orderSum.value}",
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
                                Text(text = "₽${sum.value + orderSum.value}",
                                    color = colorResource(R.color.button),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight(500)
                                )
                            }
                            Button(onClick = {
                                if(itemsCount.value != 0){
                                    navController.navigate(NavRoutes.Checkout.route)
                                }
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
                        }
                    }
                }
            }
        }
