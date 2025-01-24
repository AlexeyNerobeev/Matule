package com.example.matule.activities

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
fun PrevLoyaltyCard(){
    val n = rememberNavController()
    LoyaltyCard(n)
}

@Composable
fun LoyaltyCard(navController: NavController) {
   Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
       Column(modifier = Modifier
           .padding(innerPadding)
           .fillMaxSize()
           .background(Color.White)
           .padding(horizontal = 20.dp)) {
           val context = LocalContext.current
           Box(modifier = Modifier
               .fillMaxWidth()){
               IconButton(onClick = {
                   navController.popBackStack()
                   requestWriteSettingsPermission(context)
                   setScreenBrightness(context, brightness)
               }) {
                   Icon(painter = painterResource(R.drawable.back_icon_grey),
                       contentDescription = null,
                       tint = Color.Unspecified)
               }
               Text(text = "Карта лояльности",
                   color = Color.Black,
                   fontSize = 16.sp,
                   fontWeight = FontWeight(600),
                   fontFamily = font,
                   modifier = Modifier
                       .align(Alignment.Center)
               )
           }
           Box(modifier = Modifier
               .fillMaxSize()){
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .background(color = colorResource(R.color.MainBackground),
                        RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center){
                    BarcodeScreen()
                }
           }
       }
   }
}