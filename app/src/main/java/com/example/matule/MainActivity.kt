package com.example.matule

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.matule.ui.theme.MatuleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MatuleTheme {
                mainScreen()
            }
        }
    }

    @Preview
    @Composable
    fun mainScreen(){
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->


            val font = FontFamily(
                Font(
                    resId = R.font.raleway_bold
                )
            )

            Column(
                modifier = Modifier.padding(innerPadding).fillMaxSize().background(colorResource(R.color.MainBackground)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = {}) {
                        Image(
                            painter = painterResource(R.drawable.menu_icon),
                            contentDescription = null
                        )
                    }
                    Row {
                        Image(
                            painter = painterResource(R.drawable.flash), contentDescription = null,
                            modifier = Modifier.align(Alignment.Top)
                        )
                        Text(
                            text = "Главная",
                            fontSize = 32.sp,
                            fontWeight = FontWeight(700),
                            fontFamily = font
                        )
                    }
                    IconButton(onClick = {}) {
                        Image(
                            painter = painterResource(R.drawable.cart_topbar),
                            contentDescription = null,
                            modifier = Modifier.padding(end = 5.dp)
                        )
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 19.dp)
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val searchField = rememberSaveable() { mutableStateOf("") }
                    OutlinedTextField(
                        onValueChange = { newSearch ->
                            searchField.value = newSearch
                        }, value = searchField.value,
                        shape = RoundedCornerShape(14.dp),
                        placeholder = {
                            Text(
                                text = "Поиск",
                                color = colorResource(R.color.hint),
                                fontSize = 12.sp,
                                fontWeight = FontWeight(500),
                                fontFamily = font,
                                modifier = Modifier.padding(start = 12.dp)
                            )
                        },
                        leadingIcon = {
                            IconButton(
                                onClick = {},
                                modifier = Modifier.padding(start = 26.dp)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.search_icon),
                                    contentDescription = null
                                )
                            }
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.White,
                            focusedBorderColor = Color.White,
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        )
                    )
                    IconButton(onClick = {}) {
                        Image(
                            painter = painterResource(R.drawable.filter_icon),
                            contentDescription = null
                        )
                    }
                }

                Column(
                    modifier = Modifier.padding(top = 24.dp).fillMaxWidth().padding(start = 20.dp)
                ) {
                    Text(
                        text = "Категории",
                        fontSize = 16.sp,
                        fontFamily = font,
                        fontWeight = FontWeight(600),
                        modifier = Modifier.align(Alignment.Start)
                    )
                    LazyRow(modifier = Modifier.padding(top = 16.dp).fillMaxWidth()) {
                        val textButtons = listOf("Все", "Outdoor", "Tennis")
                        for (text in textButtons) {
                            item {
                                Button(
                                    onClick = {},
                                    colors = ButtonDefaults.buttonColors(
                                        contentColor = Color.Black,
                                        containerColor = Color.White
                                    ),
                                    modifier = Modifier.size(110.dp, 40.dp).padding(end = 16.dp),
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Text(
                                        text = text,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight(400),
                                        fontFamily = font
                                    )
                                }
                            }
                        }
                    }
                }

                Row(
                    modifier = Modifier.padding(top = 24.dp).fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Популярное", fontSize = 16.sp, fontWeight = FontWeight(500))
                    Text(text = "Все", color = colorResource(R.color.button),
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = font,
                        modifier = Modifier.clickable { }
                    )
                }

                Row(
                    modifier = Modifier.padding(top = 30.dp).fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ProductCard()
                    ProductCard()
                }

                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 29.dp)
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Акции",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        fontFamily = font
                    )
                    Text(text = "Все",
                        color = colorResource(R.color.button),
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500),
                        modifier = Modifier.clickable { }
                    )
                }

                Image(
                    painter = painterResource(R.drawable.sale_main), contentDescription = null,
                    modifier = Modifier.padding(top = 20.dp).fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .clickable { },
                    contentScale = ContentScale.Crop
                )


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
                IconButton(onClick = {},
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
                        IconButton(onClick = {},
                            colors = IconButtonDefaults.iconButtonColors(
                                contentColor = colorResource(R.color.button)
                            )) {
                            Icon(painter = painterResource(R.drawable.home_bottomnav_icon),
                                contentDescription = null)
                        }
                        IconButton(onClick = {
                            val intent = Intent(this@MainActivity, FavouriteActivity::class.java)
                            startActivity(intent)
                        }) {
                            Icon(painter = painterResource(R.drawable.heart_bottomnav_icon),
                                contentDescription = null)
                        }
                    }
                    Row(horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth(1f)
                            .padding(start = 50.dp)){
                        IconButton(onClick = {}) {
                            Icon(painter = painterResource(R.drawable.notification_bottomnav_icon),
                                contentDescription = null)
                        }
                        IconButton(onClick = {}) {
                            Icon(painter = painterResource(R.drawable.profile_bottomnav_icon),
                                contentDescription = null)
                        }
                    }
                }
            }
        }
    }
}
