package com.example.matule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun PrevVerification() {
    val n = rememberNavController()
    VerificationScreen(n)
}

@Composable
fun VerificationScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()
        .background(Color.White)) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier.align(Alignment.Start)
            ) {
                Icon(
                    painter = painterResource(R.drawable.back_icon),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
            Text(
                text = "OTP проверка",
                fontSize = 32.sp,
                fontFamily = font,
                fontWeight = FontWeight(700),
                color = Color.Black,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = "Пожалуйста, проверьте свою электронную почту, чтобы увидеть код подтверждения",
                color = colorResource(R.color.sub_text_dark),
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "OTP Код",
                fontSize = 21.sp,
                fontFamily = font,
                fontWeight = FontWeight(600),
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.Start)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                val text1 = rememberSaveable() { mutableStateOf("") }
                val text2 = rememberSaveable() { mutableStateOf("") }
                val text3 = rememberSaveable() { mutableStateOf("") }
                val text4 = rememberSaveable() { mutableStateOf("") }
                val text5 = rememberSaveable() { mutableStateOf("") }
                val text6 = rememberSaveable() { mutableStateOf("") }
                val tfColor = colorResource(R.color.TextFieldBackground)
                OutlinedTextField(
                    onValueChange = { newText ->
                        text1.value = newText
                    },
                    maxLines = 1,
                    value = text1.value,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .size(46.dp, 99.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = tfColor,
                        unfocusedBorderColor = tfColor,
                        focusedContainerColor = tfColor,
                        unfocusedContainerColor = tfColor,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    shape = RoundedCornerShape(14.dp)
                )
                OutlinedTextField(
                    onValueChange = { newText ->
                        text2.value = newText
                    },
                    maxLines = 1,
                    value = text2.value,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .size(46.dp, 99.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = tfColor,
                        unfocusedBorderColor = tfColor,
                        focusedContainerColor = tfColor,
                        unfocusedContainerColor = tfColor,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    shape = RoundedCornerShape(14.dp)
                )
                OutlinedTextField(
                    onValueChange = { newText ->
                        text3.value = newText
                    },
                    maxLines = 1,
                    value = text3.value,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .size(46.dp, 99.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = tfColor,
                        unfocusedBorderColor = tfColor,
                        focusedContainerColor = tfColor,
                        unfocusedContainerColor = tfColor,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    shape = RoundedCornerShape(14.dp)
                )
                OutlinedTextField(
                    onValueChange = { newText ->
                        text4.value = newText
                    },
                    maxLines = 1,
                    value = text4.value,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .size(46.dp, 99.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = tfColor,
                        unfocusedBorderColor = tfColor,
                        focusedContainerColor = tfColor,
                        unfocusedContainerColor = tfColor,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    shape = RoundedCornerShape(14.dp)
                )
                OutlinedTextField(
                    onValueChange = { newText ->
                        text5.value = newText
                    },
                    maxLines = 1,
                    value = text5.value,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .size(46.dp, 99.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = tfColor,
                        unfocusedBorderColor = tfColor,
                        focusedContainerColor = tfColor,
                        unfocusedContainerColor = tfColor,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    shape = RoundedCornerShape(14.dp)
                )
                OutlinedTextField(
                    onValueChange = { newText ->
                        text6.value = newText
                    },
                    maxLines = 1,
                    value = text6.value,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .size(46.dp, 99.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = tfColor,
                        unfocusedBorderColor = tfColor,
                        focusedContainerColor = tfColor,
                        unfocusedContainerColor = tfColor,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    shape = RoundedCornerShape(14.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Отправить заново",
                    color = colorResource(R.color.sub_text_dark),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = font
                )
                Text(
                    text = "00:30",
                    color = colorResource(R.color.sub_text_dark),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = font
                )
            }
        }
    }
}