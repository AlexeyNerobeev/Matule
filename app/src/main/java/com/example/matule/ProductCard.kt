package com.example.matule

import android.annotation.SuppressLint
import android.content.Intent
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
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
    val coroutine = rememberCoroutineScope()
    val card_photo = remember { mutableStateOf("") }
    val info = remember { mutableStateOf("") }
    val name = remember { mutableStateOf("") }
    val price = remember { mutableStateOf(0f) }
    coroutine.launch(Dispatchers.IO) {
        GetSneakers()
        card_photo.value = res.card_photo
        info.value = res.info
        name.value = res.name
        price.value = res.price
    }
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
//        val coroutine = rememberCoroutineScope()
//        LaunchedEffect(key1 = true) {
//            coroutine.launch(Dispatchers.IO) {
//                Connect.supabase.from("sneakers").select().decodeList<Sneakers>()
//            }
//        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = rememberImagePainter(card_photo.value), contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                IconButton(onClick = {}) {
                    Image(
                        painter = painterResource(R.drawable.favourite_heart_icon),
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
                fontWeight = FontWeight(500)
            )

            Box(modifier = Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.BottomEnd) {
                IconButton(
                    onClick = {},
                    modifier = Modifier.align(Alignment.BottomEnd)
                        .size(34.dp, 34.dp)
                        .clip(RoundedCornerShape(topStart = 16.dp))
                        .background(
                        colorResource(R.color.button)
                    )
                ) {
                    Image(
                        imageVector = Icons.Default.Add,
                        contentDescription = "add",
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier.offset(-3.dp, -3.dp)
                    )
                }
            }
        }
    }
}