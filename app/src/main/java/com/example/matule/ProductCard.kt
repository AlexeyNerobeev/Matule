package com.example.matule

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
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
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

@Preview
@Composable
fun ProductCard() {
    Card(onClick = {},
        modifier = Modifier.background(Color.White, shape = RoundedCornerShape(16.dp)).size(160.dp, 182.dp),
        shape = RoundedCornerShape(16.dp)) {
        Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
            Box(modifier = Modifier.fillMaxWidth()){
                Image(painter = painterResource(R.drawable.card_cross), contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop)
                IconButton(onClick = {}) {
                    Image(painter = painterResource(R.drawable.heart_icon), contentDescription = null )
                }
            }
            Column(modifier = Modifier.padding(top = 12.dp).padding(horizontal = 9.dp)){
                Text(text = "BEST SELLER",
                    color = colorResource(R.color.button),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(500)
                )
                Text(text = "Nike Air Max",
                    color = colorResource(R.color.hint),
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            Row(modifier = Modifier.padding(top = 4.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "₽752.00",
                    Modifier.padding(start = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500)
                )
                IconButton(onClick = {}) {
                    Image(painter = painterResource(R.drawable.drop_to_cart), contentDescription = null)
                }
            }
        }
    }
}