package com.example.matule

import android.content.Intent
import android.os.Bundle
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.matule.ui.theme.MatuleTheme

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MatuleTheme {
                signInScreen()
            }
        }
    }
    fun nextPage() {
        val intent = Intent(this@SignInActivity, MainActivity::class.java)
        startActivity(intent)
    }
    @Preview
    @Composable
    fun signInScreen(){
        Column(modifier = Modifier.fillMaxSize().background(Color.White),
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
                modifier = Modifier.padding(top = 8.dp).padding(horizontal = 30.dp),
                textAlign = TextAlign.Center,
                fontFamily = font,
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                color = colorResource(R.color.sub_text_dark))
            Column(modifier = Modifier.padding(horizontal = 20.dp).padding(top = 30.dp)) {
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
                }, value = textLogin.value,
                    modifier = Modifier.padding(top = 12.dp)
                        .fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = tfColor,
                        unfocusedBorderColor = tfColor,
                        focusedContainerColor = tfColor,
                        unfocusedContainerColor = tfColor
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
                    modifier = Modifier.align(Alignment.Start).padding(top = 30.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontFamily = font,
                    fontWeight = FontWeight(500),
                    color = Color.Black)
                val passwordText = rememberSaveable() { mutableStateOf("") }
                OutlinedTextField(onValueChange = {newPassword ->
                    passwordText.value = newPassword
                }, value = passwordText.value,
                    modifier = Modifier.padding(top = 12.dp)
                        .fillMaxWidth(),
                    trailingIcon = { Icon(painter = painterResource(R.drawable.eye), contentDescription = null,
                        modifier = Modifier.clickable {

                        })},
                    visualTransformation = PasswordVisualTransformation(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = tfColor,
                        unfocusedBorderColor = tfColor,
                        focusedContainerColor = tfColor,
                        unfocusedContainerColor = tfColor
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
                    modifier = Modifier.align(Alignment.End)
                        .padding(12.dp)
                        .clickable {

                        },
                    fontWeight = FontWeight(400),
                    fontSize = 12.sp,
                    fontFamily = font,
                    color = colorResource(R.color.sub_text_dark))
                Button(onClick = {
                    nextPage()
                },
                    modifier = Modifier.padding(top = 24.dp)
                        .fillMaxWidth().height(50.dp),
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
                Row(modifier = Modifier.constrainAs(const1){
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

                        })
                }
            }
        }
    }
}