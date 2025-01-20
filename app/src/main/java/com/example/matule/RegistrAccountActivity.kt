package com.example.matule

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.matule.Connect.supabase
import com.example.matule.ui.theme.MatuleTheme
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegistrAccountActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MatuleTheme {

            }
        }
    }
}
val font = FontFamily(
    Font(
        resId = R.font.raleway_bold
    )
)

fun isEmailValid(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

@Preview
@Composable
fun PrevRegistration(){
val n = rememberNavController()
    RegistrationScreen(n)
}

suspend fun registration(login: String, password: String, navController: NavController,
                         name: String){
    withContext(Dispatchers.Main){
        try {
            if (login.isNotEmpty() && password.isNotEmpty()){
                val user = Users(login = login, password = password)
                supabase.from("users").insert(user)
                GetUser(user.login)
                GetSneakers()
                AddProfile(name)
                navController.navigate(NavRoutes.onBoard1.route)
            } else{

            }
        } catch (er: Exception) {
            Log.e("supa", er.message.toString())
        }
    }
}

@Composable
fun RegistrationScreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally) {
        val textName = rememberSaveable() { mutableStateOf("") }
        val textEmail = rememberSaveable() { mutableStateOf("") }
        val textPassword = rememberSaveable() { mutableStateOf("") }

        Text(
            text = "Регистрация",
            modifier = Modifier.padding(top = 78.dp),
            fontSize = 32.sp,
            fontFamily = font,
            fontWeight = FontWeight(700),
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        Text(
            text = "Заполните Свои данные или продолжите через социальные медиа",
            modifier = Modifier
                .padding(top = 8.dp)
                .padding(horizontal = 30.dp),
            textAlign = TextAlign.Center,
            fontFamily = font,
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
            color = colorResource(R.color.sub_text_dark)
        )

        Column(modifier = Modifier.padding(top = 30.dp)
            .padding(horizontal = 20.dp)
            .fillMaxWidth()) {
            Text(text  = "Ваше имя",
                fontSize = 16.sp,
                fontWeight = FontWeight(500),
                fontFamily = font,
                )
            val tfColor = colorResource(R.color.TextFieldBackground)
            OutlinedTextField(onValueChange = { newLogin ->
                textName.value = newLogin
            },
                maxLines = 1,
                value = textName.value,
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
                placeholder = {Text(text = "xxxxxxxx",
                    color = colorResource(R.color.hint),
                    fontFamily = font,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                    modifier = Modifier.padding(start = 14.dp)
                )})
            Text(text = "Email",
                modifier = Modifier.padding(top = 12.dp),
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                fontFamily = font)
            OutlinedTextField(onValueChange = { newLogin ->
                textEmail.value = newLogin
            },
                maxLines = 1,
                value = textEmail.value,
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
                modifier = Modifier.padding(top = 12.dp),
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                fontFamily = font
            )
            val isPasswordVisible = remember { mutableStateOf(false) }
            OutlinedTextField(onValueChange = {newPassword ->
                textPassword.value = newPassword
            },
                maxLines = 1,
                value = textPassword.value,
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth(),
                trailingIcon = { Icon(painter = painterResource(R.drawable.eye), contentDescription = null,
                    modifier = Modifier.clickable {
                        isPasswordVisible.value = !isPasswordVisible.value
                    })
                },
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

            Row(modifier = Modifier.padding(top = 12.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically){
                Image(painter = painterResource(R.drawable.pers_data_icon),
                    contentDescription = null)
                Text(text = "Даю согласие на обработку\nперсональных данных",
                    modifier = Modifier.padding(start = 12.dp),
                    fontSize = 16.sp,
                    fontFamily = font,
                    fontWeight = FontWeight(500),
                    color = colorResource(R.color.hint),
                    textDecoration = TextDecoration.Underline)
            }
        }

        val coroutine = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }
        SnackbarHost(hostState = snackbarHostState)
        Button(modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 24.dp)
            .fillMaxWidth(),
            onClick = {
                if(isEmailValid(textEmail.value)){
                    coroutine.launch(Dispatchers.IO) {
                        registration(textEmail.value, textPassword.value, navController,
                            textName.value)
                    }
                } else{
                    coroutine.launch {
                        snackbarHostState.showSnackbar(
                            "Некорректная почта",
                            withDismissAction = true
                        )
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.button),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(13.dp)) {
            Text(text = "Зарегистрироваться",
                fontSize = 14.sp,
                fontWeight = FontWeight(600),
                fontFamily = font)
        }
    }
    Box(
        modifier = Modifier.fillMaxSize().padding(bottom = 47.dp),
        contentAlignment = Alignment.BottomCenter
    ){
        Row {
            Text(text = "Есть аккаунт?",
                fontSize = 16.sp,
                fontWeight = FontWeight(500),
                fontFamily = font,
                color = colorResource(R.color.hint))
            Text(text = " Войти",
                fontSize = 16.sp,
                fontWeight = FontWeight(500),
                fontFamily = font,
                modifier = Modifier.clickable {
                    navController.navigate(NavRoutes.SignIn.route)
                })
        }
    }
}