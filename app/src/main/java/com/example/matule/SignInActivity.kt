package com.example.matule

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.matule.Connect.supabase
import com.example.matule.ui.theme.MatuleTheme
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }
        enableEdgeToEdge()
        setContent {
            MatuleTheme {
                Navigation()
            }
        }
    }
}

    suspend fun authorization(login: String, password: String, navController: NavController) {
        withContext(Dispatchers.Main) {
            try {
                val response = supabase.postgrest["users"].select(
                    columns = io.github.jan.supabase.postgrest.query.Columns.list("login", "password")
                ){
                    filter {
                        and {
                            eq("login", login)
                        }
                    }
                }.decodeSingle<Users>()
                if (response.login.isNotEmpty() && response.password.isNotEmpty()){
                    if(response.password == password){
                        GetUser(login)
                        GetSneakers()
                        GetFavourite()
                        GetCart()
                        navController.navigate(NavRoutes.Main.route)
                    } else{

                    }
                } else{

                }
            } catch (er: Exception) {
                Log.e("supa", er.message.toString())
            }
        }
    }

@Preview
@Composable
private fun Prev() {
    val n = rememberNavController()
    signInScreen(n)
}
    
    @Composable
    fun signInScreen(navController: NavController){
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally) {
            val font = FontFamily(
                Font(
                    resId = R.font.raleway_bold
                )
            )
            Text(text = "Привет!",
                modifier = Modifier.padding(top = 78.dp),
                fontSize = 32.sp,
                fontFamily = font,
                fontWeight = FontWeight(700),
                textAlign = TextAlign.Center,
                color = Color.Black)
            Text(text = "Заполните Свои данные или продолжите через социальные медиа",
                modifier = Modifier
                    .padding(top = 8.dp)
                    .padding(horizontal = 30.dp),
                textAlign = TextAlign.Center,
                fontFamily = font,
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                color = colorResource(R.color.sub_text_dark))
            Column(modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(top = 30.dp)) {
                Text(text = "Email",
                    modifier = Modifier.align(Alignment.Start),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontFamily = font,
                    fontWeight = FontWeight(500),
                    color = Color.Black
                )
                val textLogin = rememberSaveable() { mutableStateOf("") }
                val tfColor = colorResource(R.color.TextFieldBackground)
                OutlinedTextField(onValueChange = { newLogin ->
                    textLogin.value = newLogin
                },
                    maxLines = 1,
                    value = textLogin.value,
                    modifier = Modifier
                        .padding(top = 12.dp)
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
                Text(text = "Пароль",
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(top = 30.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontFamily = font,
                    fontWeight = FontWeight(500),
                    color = Color.Black)
                val passwordText = rememberSaveable() { mutableStateOf("") }
                val isPasswordVisible = remember { mutableStateOf(false) }
                OutlinedTextField(onValueChange = {newPassword ->
                    passwordText.value = newPassword
                },
                    maxLines = 1,
                    value = passwordText.value,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth(),
                    trailingIcon = { Icon(painter = painterResource(R.drawable.eye), contentDescription = null,
                        modifier = Modifier.clickable {
                            isPasswordVisible.value = !isPasswordVisible.value
                        })},
                    visualTransformation = if (isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = tfColor,
                        unfocusedBorderColor = tfColor,
                        focusedContainerColor = tfColor,
                        unfocusedContainerColor = tfColor,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    shape = RoundedCornerShape(14.dp),
                    placeholder = {Text(text = "********",
                        color = colorResource(R.color.hint),
                        fontFamily = font,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        modifier = Modifier.padding(start = 14.dp)
                    )})
                Text(text = "Востановить",
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(12.dp)
                        .clickable {
                            navController.navigate(NavRoutes.ForgotPassword.route)
                        },
                    fontWeight = FontWeight(400),
                    fontSize = 12.sp,
                    fontFamily = font,
                    color = colorResource(R.color.sub_text_dark))
                    val coroutine = rememberCoroutineScope()
                Button(onClick = {
                    coroutine.launch(Dispatchers.IO) {
                        authorization(textLogin.value, passwordText.value, navController)
                    }
                },
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.button),
                        contentColor = Color.White
                    )) {
                    Text(text = "Войти",
                        fontFamily = font,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600)
                    )
                }
            }
            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                val const1 = createRef()
                Row(modifier = Modifier
                    .constrainAs(const1) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
                    .padding(bottom = 47.dp)){
                   Text(text = "Вы впервые?",
                       fontSize = 16.sp,
                       fontFamily = font,
                       fontWeight = FontWeight(500),
                       color = colorResource(R.color.hint))
                    Text(text = " Создать пользователя",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = font,
                        color = Color.Black,
                        modifier = Modifier.clickable {
                            navController.navigate(NavRoutes.Registration.route)
                        })
                }
            }
        }
    }
