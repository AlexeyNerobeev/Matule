package com.example.matule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
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
import com.example.matule.ui.theme.MatuleTheme

class CartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MatuleTheme {
                cartScreen()
            }
        }
    }

    @Preview
    @Composable
    fun cartScreen(){
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
                    IconButton(onClick = {}) {
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
                        modifier = Modifier.padding(start = 100.dp)
                    )
                }
                Text(text = "3 товара",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    modifier = Modifier.padding(top = 16.dp)
                )
                LazyColumn(modifier = Modifier.padding(top = 8.dp)) {
                    item{
                        var xOffset by remember { mutableStateOf(0f) }
                        if(xOffset >= 68){
                            Row {
                                Box(modifier = Modifier.size(58.dp, 104.dp)
                                    .background(colorResource(R.color.button),
                                        shape = RoundedCornerShape(8.dp))){
                                    Column(modifier =  Modifier.fillMaxSize(),
                                        horizontalAlignment = Alignment.CenterHorizontally) {
                                        IconButton(onClick = {

                                        },
                                            colors = IconButtonDefaults.iconButtonColors(
                                                contentColor = Color.White
                                            )) {
                                            Icon(Icons.Filled.Add,
                                                contentDescription = null)
                                        }
                                        Text(text = "1",
                                            fontSize = 14.sp,
                                            fontFamily = font,
                                            fontWeight = FontWeight(400),
                                            color = Color.White,
                                            textAlign = TextAlign.Center
                                        )
                                        IconButton(onClick = {

                                        },
                                            colors = IconButtonDefaults.iconButtonColors(
                                                contentColor = Color.White
                                            )) {
                                            Icon(painter = painterResource(R.drawable.minus_icon),
                                                contentDescription = null)
                                        }
                                    }
                                }

                                Box(modifier = Modifier.padding(start = 10.dp)
                                    .fillMaxWidth()
                                    .height(104.dp)
                                    .background(Color.White, shape = RoundedCornerShape(8.dp))){
                                    Row(modifier = Modifier.fillMaxSize()) {
                                        Image(painter = painterResource(R.drawable.cart_cross),
                                            contentDescription = null,
                                            modifier = Modifier.fillMaxHeight()
                                                .padding(vertical = 10.dp),
                                            contentScale = ContentScale.Crop)
                                        Column(modifier = Modifier
                                            .padding(start = 30.dp)
                                            .padding(end = 13.dp)
                                            .padding(vertical = 29.dp),
                                            verticalArrangement = Arrangement.Center) {
                                            Text(text = "Nike Air Max 270",
                                                fontSize = 16.sp,
                                                fontFamily = font,
                                                fontWeight = FontWeight(500)
                                            )
                                            Text(text = "₽74.95",
                                                modifier = Modifier
                                                    .padding(top = 6.dp),
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight(500))
                                        }
                                    }
                                }
                            }
                        } else if (xOffset <= -68) {
                            Row(modifier = Modifier.fillMaxWidth()
                                .padding(horizontal = 20.dp)) {
                                Box(modifier = Modifier
                                    .size(267.dp, 104.dp)
                                    .background(Color.White, shape = RoundedCornerShape(8.dp))){
                                    Row(modifier = Modifier.fillMaxSize()) {
                                        Image(painter = painterResource(R.drawable.cart_cross),
                                            contentDescription = null,
                                            modifier = Modifier.fillMaxHeight()
                                                .padding(vertical = 10.dp),
                                            contentScale = ContentScale.Crop)
                                        Column(modifier = Modifier
                                            .padding(start = 30.dp)
                                            .padding(end = 13.dp)
                                            .padding(vertical = 29.dp),
                                            verticalArrangement = Arrangement.Center) {
                                            Text(text = "Nike Air Max 270",
                                                fontSize = 16.sp,
                                                fontFamily = font,
                                                fontWeight = FontWeight(500)
                                            )
                                            Text(text = "₽74.95",
                                                modifier = Modifier
                                                    .padding(top = 6.dp),
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight(500))
                                        }
                                    }
                                }

                                Box(modifier = Modifier
                                    .padding(start = 10.dp)
                                    .size(58.dp, 104.dp)
                                    .background(Color.Red,
                                        shape = RoundedCornerShape(8.dp)),
                                    contentAlignment = Alignment.Center){
                                    IconButton(onClick = {

                                    },
                                        colors = IconButtonDefaults.iconButtonColors(
                                            contentColor = Color.White
                                        )) {
                                        Icon(painter = painterResource(R.drawable.delete_from_cart),
                                            contentDescription = null)
                                    }
                                }
                            }
                        } else
                            Box(modifier = Modifier.fillMaxWidth()
                                .height(104.dp)
                                .background(Color.White, shape = RoundedCornerShape(8.dp))
                                .draggable(
                                    orientation = Orientation.Horizontal,
                                    state = rememberDraggableState { distance ->
                                        xOffset += distance
                                    }
                                )) {
                                Row(modifier = Modifier.fillMaxSize()) {
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
                                            text = "Nike Air Max 270",
                                            fontSize = 16.sp,
                                            fontFamily = font,
                                            fontWeight = FontWeight(500)
                                        )
                                        Text(
                                            text = "₽74.95",
                                            modifier = Modifier
                                                .padding(top = 6.dp),
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight(500)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }