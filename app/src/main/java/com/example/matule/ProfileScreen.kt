package com.example.matule

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Preview
@Composable
fun PrevProfile(){
    val n = rememberNavController()
    ProfileScreen(n)
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ProfileScreen(navController: NavController) {
    val photo = remember { mutableStateOf("") }
    val name = remember { mutableStateOf("") }
    val surname = remember{ mutableStateOf("")}
    val adress = remember { mutableStateOf("") }
    val phone = remember{ mutableStateOf("")}
    val coroutine = rememberCoroutineScope()
    coroutine.launch(Dispatchers.IO) {
        GetProfile()
        photo.value = profile.photo
        name.value = profile.name
        surname.value = profile.surname
        adress.value = profile.adress
        phone.value = profile.phone
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
                        painter = painterResource(R.drawable.back_icon),
                        contentDescription = null
                    )
                }
                Text(
                    text = "Профиль",
                    fontFamily = font,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    modifier = Modifier.padding(start = 100.dp),
                    color = Color.Black
                )
            }
            Image(painter = rememberImagePainter(photo.value),
                contentDescription = null,
                modifier = Modifier.padding(top = 48.dp)
                    .size(96.dp, 96.dp))
            Text(text = "${name.value} ${surname.value}",
                modifier = Modifier.padding(top = 8.dp),
                color = Color.Black,
                fontWeight = FontWeight(600),
                fontSize = 20.sp,
                fontFamily = font
            )
            Text(text = "Изменить фото профиля",
                modifier = Modifier.padding(8.dp),
                color = colorResource(R.color.button),
                fontWeight = FontWeight(600),
                fontSize = 12.sp,
                fontFamily = font
            )
            Image(painter = painterResource(R.drawable.qr_profile),
                contentDescription = null,
                modifier = Modifier.padding(top = 11.dp)
                    .size(335.dp, 66.dp))

            LazyColumn(modifier = Modifier.padding(top = 20.dp)) {
                item {
                    Column {
                        Text(text = "Имя",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontFamily = font,
                            fontWeight = FontWeight(600)
                        )
                        OutlinedTextField(onValueChange = {newTextName ->
                            name.value = newTextName
                        },
                            maxLines = 1,
                            value = name.value,
                            modifier = Modifier
                                .padding(top = 12.dp)
                                .fillMaxWidth(),
                            trailingIcon = { Image(painter = painterResource(R.drawable.correct_image),
                                contentDescription = null,
                                modifier = Modifier.clickable {

                                })
                            },
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
                                fontFamily = font,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                modifier = Modifier.padding(start = 14.dp)
                )})
                    }
                }
                item {
                    Column(modifier = Modifier.padding(top = 16.dp)) {
                        Text(text = "Фамилия",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontFamily = font,
                            fontWeight = FontWeight(600)
                        )
                        OutlinedTextField(onValueChange = {newTextSurname ->
                            surname.value = newTextSurname
                        },
                            maxLines = 1,
                            value = surname.value,
                            modifier = Modifier
                                .padding(top = 12.dp)
                                .fillMaxWidth(),
                            trailingIcon = { Image(painter = painterResource(R.drawable.correct_image),
                                contentDescription = null,
                                modifier = Modifier.clickable {

                                })
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = colorResource(R.color.TextFieldBackground),
                                unfocusedBorderColor = colorResource(R.color.TextFieldBackground),
                                focusedContainerColor = colorResource(R.color.TextFieldBackground),
                                unfocusedContainerColor = colorResource(R.color.TextFieldBackground),
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black
                            ),
                            shape = RoundedCornerShape(14.dp),
                            placeholder = {Text(text = "Фамилия",
                                color = colorResource(R.color.hint),
                                fontFamily = font,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                modifier = Modifier.padding(start = 14.dp)
                            )})
                    }
                }
                item {
                    Column(modifier = Modifier.padding(top = 16.dp)) {
                        Text(text = "Адрес",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontFamily = font,
                            fontWeight = FontWeight(600)
                        )
                        OutlinedTextField(onValueChange = {newTextAdress ->
                            adress.value = newTextAdress
                        },
                            maxLines = 1,
                            value = adress.value,
                            modifier = Modifier
                                .padding(top = 12.dp)
                                .fillMaxWidth(),
                            trailingIcon = { Image(painter = painterResource(R.drawable.correct_image),
                                contentDescription = null,
                                modifier = Modifier.clickable {

                                })
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = colorResource(R.color.TextFieldBackground),
                                unfocusedBorderColor = colorResource(R.color.TextFieldBackground),
                                focusedContainerColor = colorResource(R.color.TextFieldBackground),
                                unfocusedContainerColor = colorResource(R.color.TextFieldBackground),
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black
                            ),
                            shape = RoundedCornerShape(14.dp),
                            placeholder = {Text(text = "Адрес",
                                color = colorResource(R.color.hint),
                                fontFamily = font,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                modifier = Modifier.padding(start = 14.dp)
                            )})
                    }
                }
                item {
                    Column(modifier = Modifier.padding(top = 16.dp)) {
                        Text(text = "Телефон",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontFamily = font,
                            fontWeight = FontWeight(600)
                        )
                        OutlinedTextField(onValueChange = {newTextPhone ->
                            phone.value = newTextPhone
                        },
                            maxLines = 1,
                            value = phone.value,
                            modifier = Modifier
                                .padding(top = 12.dp)
                                .fillMaxWidth(),
                            trailingIcon = { Image(painter = painterResource(R.drawable.correct_image),
                                contentDescription = null,
                                modifier = Modifier.clickable {

                                })
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = colorResource(R.color.TextFieldBackground),
                                unfocusedBorderColor = colorResource(R.color.TextFieldBackground),
                                focusedContainerColor = colorResource(R.color.TextFieldBackground),
                                unfocusedContainerColor = colorResource(R.color.TextFieldBackground),
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black
                            ),
                            shape = RoundedCornerShape(14.dp),
                            placeholder = {Text(text = "Телефон",
                                color = colorResource(R.color.hint),
                                fontFamily = font,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500),
                                modifier = Modifier.padding(start = 14.dp)
                            )})
                        Button(onClick = {
                            coroutine.launch(Dispatchers.IO) {
                                UpdateProfile(name.value, surname.value,
                                    adress = adress.value, phone.value)
                            }
                        },
                            modifier = Modifier.padding(top = 16.dp)
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.button),
                                contentColor = Color.White
                            )) {
                            Text(text = "Сохранить",
                                fontSize = 14.sp,
                                fontFamily = font,
                                fontWeight = FontWeight(500)
                            )
                        }
                    }
                }
                item{
                    Box(modifier = Modifier.padding(top = 16.dp)
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(Color.White))
                }
            }
        }
    }
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val const = createRef()
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(106.dp)
            .constrainAs(const){
                bottom.linkTo(parent.bottom)
            }){
            Image(painter = painterResource(R.drawable.bottombar_shape),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
                    .align(Alignment.BottomCenter),
                contentScale = ContentScale.Crop)
            IconButton(onClick = {
                navController.navigate(NavRoutes.Cart.route)
            },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = colorResource(R.color.button),
                    contentColor = Color.White
                ),
                modifier = Modifier.size(56.dp, 56.dp).align(Alignment.TopCenter)
            ) {
                Image(painter = painterResource(R.drawable.cart_flact_button),
                    contentDescription = null)
            }
            Row(modifier = Modifier.align(Alignment.Center).fillMaxWidth().padding(horizontal = 31.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(0.5f)
                        .padding(end = 50.dp)){
                    IconButton(onClick = {
                        navController.navigate(NavRoutes.Main.route)
                    }) {
                        Icon(painter = painterResource(R.drawable.home_bottomnav_icon),
                            contentDescription = null)
                    }
                    IconButton(onClick = {
                        navController.navigate(NavRoutes.Favourite.route)
                    }) {
                        Icon(painter = painterResource(R.drawable.heart_bottomnav_icon),
                            contentDescription = null)
                    }
                }
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(1f)
                        .padding(start = 50.dp)){
                    IconButton(onClick = {
                        navController.navigate(NavRoutes.Notification.route)
                    }) {
                        Icon(painter = painterResource(R.drawable.notification_bottomnav_icon),
                            contentDescription = null)
                    }
                    IconButton(onClick = {},
                        colors = IconButtonDefaults.iconButtonColors(
                            contentColor = colorResource(R.color.button)
                        )) {
                        Icon(painter = painterResource(R.drawable.profile_bottomnav_icon),
                            contentDescription = null)
                    }
                }
            }
        }
    }
}