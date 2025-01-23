package com.example.matule.activities

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.matule.R
import com.example.matule.dataOperations.UpdateUser
import com.example.matule.dataOperations.UpdateUserName
import com.example.matule.getData.GetProfile
import com.example.matule.getData.profile
import com.example.matule.getData.user
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Preview
@Composable
fun PrevEdit(){
    val n = rememberNavController()
    EditProfileScreen(n)
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun EditProfileScreen(navController: NavController) {
    val font = FontFamily(
        Font(
            resId = R.font.raleway_bold
        )
    )
    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val coroutine = rememberCoroutineScope()
    coroutine.launch(Dispatchers.IO) {
        GetProfile()
        name.value = profile.name
        email.value = user.login
        password.value = user.password
    }


    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize().background(Color.White)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Image(
                        painter = painterResource(R.drawable.back_icon_grey),
                        contentDescription = null
                    )
                }
                Text(
                    text = "Профиль",
                    fontFamily = font,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    modifier = Modifier.padding(start = 90.dp),
                    color = Color.Black
                )
            }
            Box(modifier = Modifier.padding(top = 40.dp)
                .size(80.dp, 82.dp)){
                Image(painter = painterResource(R.drawable.profile_image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop)
                Icon(painter = painterResource(R.drawable.edit_icon),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.align(Alignment.BottomEnd)
                        .padding(end = 7.dp)
                        .clickable {

                        })
            }
            Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
                .padding(top = 22.dp)) {
                Text(text = "Ваше имя",
                    color = colorResource(R.color.sub_text_dark),
                    fontWeight = FontWeight(600),
                    fontFamily = font,
                    fontSize = 16.sp)
                OutlinedTextField(onValueChange = {newTextName ->
                    name.value = newTextName
                },
                    maxLines = 1,
                    value = name.value,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(R.color.TextFieldBackground),
                        unfocusedBorderColor = colorResource(R.color.TextFieldBackground),
                        focusedContainerColor = colorResource(R.color.TextFieldBackground),
                        unfocusedContainerColor = colorResource(R.color.TextFieldBackground),
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    shape = RoundedCornerShape(14.dp),
                    placeholder = {Text(text = "Имя",
                        color = colorResource(R.color.hint),
                        fontFamily = com.example.matule.activities.font,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        modifier = Modifier.padding(start = 14.dp)
                    )})

                Text(text = "Email",
                    color = colorResource(R.color.sub_text_dark),
                    fontWeight = FontWeight(600),
                    fontFamily = font,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 30.dp))
                OutlinedTextField(onValueChange = {newTextEmail ->
                    email.value = newTextEmail
                },
                    maxLines = 1,
                    value = email.value,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(R.color.TextFieldBackground),
                        unfocusedBorderColor = colorResource(R.color.TextFieldBackground),
                        focusedContainerColor = colorResource(R.color.TextFieldBackground),
                        unfocusedContainerColor = colorResource(R.color.TextFieldBackground),
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    shape = RoundedCornerShape(14.dp),
                    placeholder = {Text(text = "Email",
                        color = colorResource(R.color.hint),
                        fontFamily = com.example.matule.activities.font,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        modifier = Modifier.padding(start = 14.dp)
                    )})

                Text(text = "Пароль",
                    color = colorResource(R.color.sub_text_dark),
                    fontWeight = FontWeight(600),
                    fontFamily = font,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 30.dp))
                OutlinedTextField(onValueChange = {newTextPassword ->
                    password.value = newTextPassword
                },
                    maxLines = 1,
                    value = password.value,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(R.color.TextFieldBackground),
                        unfocusedBorderColor = colorResource(R.color.TextFieldBackground),
                        focusedContainerColor = colorResource(R.color.TextFieldBackground),
                        unfocusedContainerColor = colorResource(R.color.TextFieldBackground),
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    shape = RoundedCornerShape(14.dp),
                    placeholder = {Text(text = "********",
                        color = colorResource(R.color.hint),
                        fontFamily = com.example.matule.activities.font,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        modifier = Modifier.padding(start = 14.dp)
                    )})

                Text(text = "Восстановить пароль",
                    modifier = Modifier.padding(top = 14.dp)
                        .align(Alignment.End)
                        .clickable {

                        },
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    color = colorResource(R.color.sub_text_dark)
                )

                Button(onClick = {
                    coroutine.launch(Dispatchers.IO) {
                        UpdateUserName(name.value)
                        UpdateUser(email.value, password.value)
                    }
                },
                    modifier = Modifier.padding(top = 30.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.button),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Сохранить",
                        fontSize = 14.sp,
                        fontFamily = font,
                        fontWeight = FontWeight(600)
                    )
                }
            }
        }
    }
}