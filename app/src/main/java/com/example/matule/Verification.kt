package com.example.matule

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay

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
                val textFields = List(6) { rememberSaveable { mutableStateOf("") } }
                val tfColor = colorResource(R.color.TextFieldBackground)

                val focusRequesters = List(6) { FocusRequester() }

                for (i in textFields.indices) {
                    OutlinedTextField(
                        onValueChange = { newText ->
                            if (newText.length <= 1) {
                                textFields[i].value = newText
                                if (newText.length == 1 && i < textFields.lastIndex) {
                                    focusRequesters[i + 1].requestFocus()
                                }
                            }
                        },
                        singleLine = true,
                        value = textFields[i].value,
                        modifier = Modifier
                            .padding(top = 12.dp)
                            .size(46.dp, 99.dp)
                            .focusRequester(focusRequesters[i]),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = tfColor,
                            unfocusedBorderColor = tfColor,
                            focusedContainerColor = tfColor,
                            unfocusedContainerColor = tfColor,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        ),
                        shape = RoundedCornerShape(14.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        textStyle = TextStyle(
                            textAlign = TextAlign.Center,
                            color = Color.Black
                        )
                    )
                }
            }
            var timeLeft by remember { mutableStateOf(30) }
            var isTimerRunning by remember { mutableStateOf(false) }
            val textColor = if (timeLeft <= 0) Color.Blue else colorResource(R.color.sub_text_dark)

            LaunchedEffect(isTimerRunning) {
                if (isTimerRunning) {
                    while (timeLeft > 0) {
                        delay(1000)
                        timeLeft -= 1
                    }
                    isTimerRunning = false
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Отправить заново",
                    color = textColor,
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = font,
                    modifier = Modifier.clickable {
                        if(timeLeft == 0){
                            timeLeft = 30
                            isTimerRunning = true
                        }
                    }
                )
                Text(
                    text = String.format("%02d:%02d", timeLeft / 60, timeLeft % 60),
                    color = colorResource(R.color.sub_text_dark),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = font
                )
            }

            if (!isTimerRunning) {
                isTimerRunning = true
            }
        }
    }
}