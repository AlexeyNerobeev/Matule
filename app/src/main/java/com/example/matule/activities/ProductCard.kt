package com.example.matule.activities

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.matule.R
import com.example.matule.dataOperations.AddCart
import com.example.matule.dataOperations.AddFavourite
import com.example.matule.dataOperations.DeleteFavourite
import com.example.matule.getData.GetCart
import com.example.matule.getData.GetFavourite
import com.example.matule.getData.cart
import com.example.matule.getData.favourite
import com.example.matule.getData.sneakers
import com.example.matule.getData.user
import com.example.matule.navigation.NavRoutes
import kotlinx.coroutines.launch

@Preview
@Composable
fun PrevProdCard(){
    val n = rememberNavController()
    ProductCard(n)
}



@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ProductCard(navController: NavController) {
    val cart_icon = remember{ mutableIntStateOf(R.drawable.plus)}
    val icon_id = remember { mutableIntStateOf(R.drawable.heart_icon) }
    val coroutine = rememberCoroutineScope()
    val card_photo = remember { mutableStateOf("") }
    val info = remember { mutableStateOf("") }
    val name = remember { mutableStateOf("") }
    val price = remember { mutableStateOf(0f) }
    if (favourite.user_id == user.id){
        icon_id.value = R.drawable.favourite_heart_icon
    }
    if (cart.user_id == user.id){
        cart_icon.value = R.drawable.cart
    }
    card_photo.value = sneakers.card_photo
    info.value = sneakers.info
    name.value = sneakers.name
    price.value = sneakers.price
    Card(
        onClick = {
            navController.navigate(NavRoutes.Details.route)
        },
        modifier = Modifier
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .size(160.dp, 182.dp),
        shape = RoundedCornerShape(16.dp),
        colors =
            CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = rememberImagePainter(card_photo.value), contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                IconButton(onClick = {
                if(icon_id.value == R.drawable.heart_icon){
                    icon_id.value = R.drawable.favourite_heart_icon
                    coroutine.launch {
                        AddFavourite()
                        GetFavourite()
                    }
                } else{
                    icon_id.value = R.drawable.heart_icon
                    coroutine.launch {
                        DeleteFavourite()
                        GetFavourite()
                    }
                }
                }) {
                    Image(
                        painter = painterResource(icon_id.value),
                        contentDescription = null
                    )
                }
            }
            Column(modifier = Modifier
                .padding(top = 12.dp)
                .padding(horizontal = 9.dp)) {
                Text(
                    text = info.value,
                    color = colorResource(R.color.button),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(500)
                )
                Text(
                    text = name.value,
                    color = colorResource(R.color.hint),
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = price.value.toString(),
                Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically),
                fontSize = 14.sp,
                fontWeight = FontWeight(500),
                color = Color.Black
            )

            Box(modifier = Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.BottomEnd) {
                IconButton(
                    onClick = {
                        if(cart_icon.value == R.drawable.plus){
                            cart_icon.value = R.drawable.cart
                            coroutine.launch {
                                AddCart()
                                GetCart()
                            }
                        } else{
                            navController.navigate(NavRoutes.Cart.route)
                        }
                    },
                    modifier = Modifier.align(Alignment.BottomEnd)
                        .size(34.dp, 34.dp)
                        .clip(RoundedCornerShape(topStart = 16.dp))
                        .background(
                        colorResource(R.color.button)
                    )
                ) {
                    Image(
                        painter = painterResource(cart_icon.value),
                        contentDescription = "add",
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier.offset(-3.dp, -3.dp)
                    )
                }
            }
        }
    }
}