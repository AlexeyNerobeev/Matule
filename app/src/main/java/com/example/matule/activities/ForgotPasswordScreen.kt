package com.example.matule.activities

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import com.example.matule.R
import com.example.matule.navigation.NavRoutes

@Preview
@Composable
fun PrevForgotPassword(){
    val n = rememberNavController()
    ForgotPasswordScreen(n)
}

@Composable
fun ForgotPasswordScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()
        .background(Color.White)) { innerPadding ->
        val font = FontFamily(
            Font(
                resId = R.font.raleway_bold
            )
        )
        Column(modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .padding(innerPadding)
            .padding(horizontal = 20.dp)
            .padding(top = 23.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            IconButton(onClick = {
                navController.popBackStack()
            },
                modifier = Modifier.align(Alignment.Start)) {
                Icon(painter = painterResource(R.drawable.back_icon_grey),
                    contentDescription = null,
                    tint = Color.Unspecified)
            }
            Text(text = "Забыл пароль",
                color = Color.Black,
                fontSize = 32.sp,
                fontWeight = FontWeight(700),
                fontFamily = font,
                modifier = Modifier.padding(top = 20.dp)
            )
            Text(text = "Введите свою учетную запись\n" +
                    " для сброса",
                color = colorResource(R.color.sub_text_dark),
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                modifier = Modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center
                )
            val textLogin = rememberSaveable() { mutableStateOf("") }
            val tfColor = colorResource(R.color.TextFieldBackground)
            OutlinedTextField(onValueChange = { newLogin ->
                textLogin.value = newLogin
            },
                maxLines = 1,
                value = textLogin.value,
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = tfColor,
                    unfocusedBorderColor = tfColor,
                    focusedContainerColor = tfColor,
                    unfocusedContainerColor = tfColor,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
                shape = RoundedCornerShape(14.dp),
                placeholder = {Text(text = "xyz@gmail.com",
                    color = colorResource(R.color.hint),
                    fontFamily = font,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                    modifier = Modifier.padding(start = 14.dp)
                )})
            val openDialog = remember { mutableStateOf(false) }
            Button(onClick = {
                if(isEmailValid(textLogin.value)){
                    openDialog.value = true
                }
            },
                modifier = Modifier.padding(top = 40.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.button),
                    contentColor = Color.White
                )) {
                Text(text = "Отправить",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(600),
                    fontFamily = font)
            }
            if (openDialog.value) {
                AlertDialog(
                    containerColor = Color.White,
                    onDismissRequest = { openDialog.value = false
                                       navController.navigate(NavRoutes.Verification.route)},
                    icon = {Box(modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                        .background(colorResource(R.color.button)),
                        contentAlignment = Alignment.Center){
                        Icon(painter = painterResource(R.drawable.alert_dialog_icon),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier.size(24.dp))
                    }},
                    title = { Text(text = "Проверьте ваш email",
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontFamily = font,
                        fontWeight = FontWeight(700)
                    ) },
                    text = { Text("Мы отправили код восстановления пароля на вашу электронную почту.",
                        fontWeight = FontWeight(400),
                        fontSize = 16.sp,
                        color = colorResource(R.color.sub_text_dark)
                    ) },
                    confirmButton = {}
                )
            }
        }
    }
}