package com.example.matule.activities

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.matule.R
import com.example.matule.navigation.NavRoutes
import com.example.matule.ui.theme.MatuleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MatuleTheme {

            }
        }
    }
}

@Preview
@Composable
fun PrevMain(){
    val n = rememberNavController()
    MainScreen(n)
}

var category : String = ""

    @Composable
    fun MainScreen(navController: NavController){
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
                    IconButton(onClick = {
                        navController.navigate(NavRoutes.SideMenu.route)
                    }) {
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
                            fontFamily = font,
                            color = Color.Black
                        )
                    }
                    IconButton(onClick = {
                        navController.navigate(NavRoutes.Cart.route)
                    }) {
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
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val searchField = rememberSaveable() { mutableStateOf("") }
                    OutlinedTextField(
                        onValueChange = { newSearch ->
                            searchField.value = newSearch
                        }, value = searchField.value,
                        shape = RoundedCornerShape(14.dp),
                        maxLines = 1,
                        modifier = Modifier.weight(1f),
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
                            unfocusedContainerColor = Color.White,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        )
                    )
                    IconButton(onClick = {},
                        modifier = Modifier.padding(start = 14.dp)) {
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
                        color = Color.Black,
                        modifier = Modifier.align(Alignment.Start)
                    )
                    val buttonColor = remember { mutableIntStateOf(R.color.white) }
                    val textButtonColor = remember { mutableIntStateOf(R.color.black) }
                    LazyRow(modifier = Modifier.padding(top = 16.dp).fillMaxWidth()) {
                            item {
                                Button(
                                    onClick = {
                                        category = "Все"
                                        navController.navigate(NavRoutes.Categories.route)
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        contentColor = colorResource(textButtonColor.value),
                                        containerColor = colorResource(buttonColor.value)
                                    ),
                                    modifier = Modifier.size(120.dp, 40.dp).padding(end = 16.dp),
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Text(
                                        text = "Все",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight(400),
                                        fontFamily = font
                                    )
                                }
                            }
                        item {
                            Button(
                                onClick = {
                                    category = "Outdoor"
                                    navController.navigate(NavRoutes.Categories.route)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    contentColor = colorResource(textButtonColor.value),
                                    containerColor = colorResource(buttonColor.value)
                                ),
                                modifier = Modifier.size(120.dp, 40.dp).padding(end = 16.dp),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Text(
                                    text = "Outdoor",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = font
                                )
                            }
                        }
                        item {
                            Button(
                                onClick = {
                                    category = "Tennis"
                                    navController.navigate(NavRoutes.Categories.route)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    contentColor = colorResource(textButtonColor.value),
                                    containerColor = colorResource(buttonColor.value)
                                ),
                                modifier = Modifier.size(120.dp, 40.dp).padding(end = 16.dp),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Text(
                                    text = "Tennis",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = font
                                )
                            }
                        }
                        item {
                            Button(
                                onClick = {
                                    category = "Running"
                                    navController.navigate(NavRoutes.Categories.route)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    contentColor = colorResource(textButtonColor.value),
                                    containerColor = colorResource(buttonColor.value)
                                ),
                                modifier = Modifier.size(120.dp, 40.dp).padding(end = 16.dp),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Text(
                                    text = "Running",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(400),
                                    fontFamily = font
                                )
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
                    Text(text = "Популярное", fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Color.Black)
                    Text(text = "Все", color = colorResource(R.color.button),
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = font,
                        modifier = Modifier.clickable { }
                    )
                }

                LazyRow(
                    modifier = Modifier.padding(top = 30.dp).fillMaxWidth()
                        .padding(start = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    item{
                        ProductCard(navController)
                    }
                    item{
                        ProductCard(navController)
                    }
                    item{
                        ProductCard(navController)
                    }
                    item{
                        ProductCard(navController)
                    }
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
                        fontFamily = font,
                        color = Color.Black
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
                        IconButton(onClick = {},
                            colors = IconButtonDefaults.iconButtonColors(
                                contentColor = colorResource(R.color.button)
                            )) {
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
                        IconButton(onClick = {
                            navController.navigate(NavRoutes.Profile.route)
                        }) {
                            Icon(painter = painterResource(R.drawable.profile_bottomnav_icon),
                                contentDescription = null)
                        }
                    }
                }
            }
        }
    }

