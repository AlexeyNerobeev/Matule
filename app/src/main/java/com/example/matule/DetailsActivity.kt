package com.example.matule

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.matule.ui.theme.MatuleTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsActivity : ComponentActivity() {
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
fun PrevDetails(){
    val n = rememberNavController()
    detailsScreen(n)
}

    @SuppressLint("CoroutineCreationDuringComposition")
    @Composable
    fun detailsScreen(navController: NavController){

        val icon_id = remember { mutableIntStateOf(R.drawable.heart_icon) }
        val coroutine = rememberCoroutineScope()
        val detail_photo = remember { mutableStateOf("") }
        val gender = remember { mutableStateOf("") }
        val description = remember{ mutableStateOf("")}
        val name = remember { mutableStateOf("") }
        val price = remember { mutableStateOf(0f) }
        val textCart = remember { mutableStateOf("В корзину") }
        if (favourite.user_id == user.id){
            icon_id.value = R.drawable.favourite_heart_icon
        }
        if (cart.user_id == user.id) {
            textCart.value = "В корзине"
        }
        coroutine.launch(Dispatchers.IO) {
            detail_photo.value = sneakers.card_photo
            name.value = sneakers.name
            price.value = sneakers.price
            gender.value = sneakers.gender
            description.value = sneakers.description
        }

        val font = FontFamily(
            Font(
                resId = R.font.raleway_bold
            )
        )
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding).fillMaxSize().background(
                colorResource(R.color.MainBackground))) {
                Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically){
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Image(painter = painterResource(R.drawable.back_icon),
                            contentDescription = null)
                    }
                    Text(text = "Sneaker Shop",
                        fontFamily = font,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600)
                    )
                    IconButton(onClick = {}) {
                        Image(
                            painter = painterResource(R.drawable.cart_topbar),
                            contentDescription = null,
                            modifier = Modifier.padding(end = 5.dp)
                        )
                    }
                }

                Column(modifier = Modifier.padding(start = 20.dp).padding(top = 26.dp)) {
                    Text(text = name.value,
                        fontSize = 26.sp,
                        fontFamily = font,
                        fontWeight = FontWeight(700))
                    Text(text = gender.value,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = font,
                        color = colorResource(R.color.hint),
                        modifier = Modifier.padding(top = 8.dp))
                    Text(text = price.value.toString(),
                        modifier = Modifier.padding(top = 8.dp),
                        fontSize = 24.sp,
                        fontWeight = FontWeight(600)
                    )
                }

                Column(modifier = Modifier.padding(top = 14.dp)){
                    Image(painter = rememberImagePainter(detail_photo.value),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 67.dp),
                        contentScale = ContentScale.Crop)
                    var sliderPosition = remember { mutableStateOf(0f) }
                    Slider(
                        value = sliderPosition.value,
                        onValueChange = {sliderPosition.value = it},
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )
                    LazyRow(modifier = Modifier.fillMaxWidth().padding(top = 24.dp).padding(start = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        val cross = listOf(R.drawable.cross1, R.drawable.cross2,
                            R.drawable.cross3, R.drawable.cross4, R.drawable.cross5)
                        for(c in cross){
                            item{
                                Box(modifier = Modifier.size(56.dp, 56.dp)){
                                    Image(painter = painterResource(c), contentDescription = null,
                                        modifier = Modifier.fillMaxHeight(),
                                        contentScale = ContentScale.Crop)
                                }
                            }
                        }
                    }
                }

                Column(modifier = Modifier.padding(top = 33.dp).padding(horizontal = 20.dp)) {
                    Text(text = description.value,
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = colorResource(R.color.hint))
                    Text(text = "Подробнее",
                        color = colorResource(R.color.button),
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.End).padding(top = 9.dp)
                    )
                }

                ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                    val const = createRef()
                    Row(modifier = Modifier.fillMaxWidth().padding(top = 60.dp).padding(horizontal = 20.dp)
                        .padding(bottom = 40.dp)
                        .constrainAs(const){
                            bottom.linkTo(parent.bottom)
                        }){
                        IconButton(onClick = {
                            if(icon_id.value == R.drawable.heart_icon){
                                icon_id.value = R.drawable.favourite_heart_icon
                                coroutine.launch {
                                    AddFavourite()
                                    GetFavourite()
                                }
                            } else{
                                icon_id.value = R.drawable.heart_icon
                                coroutine.launch {
                                    DeleteFavourite()
                                    GetFavourite()
                                }
                            }
                        },
                            modifier = Modifier.size(52.dp, 52.dp)){
                            Image(painter = painterResource(icon_id.value),
                                contentDescription = null)
                        }
                        Button(onClick = {
                            if(textCart.value == "В корзину"){
                                textCart.value = "В корзине"
                                coroutine.launch {
                                    AddCart()
                                    GetCart()
                                }
                            } else{
                                navController.navigate(NavRoutes.Cart.route)
                            }
                        },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.button),
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth().height(52.dp).padding(start = 18.dp)) {
                            Image(painter = painterResource(R.drawable.cart_flact_button),
                                contentDescription = null)
                            Text(text = textCart.value)
                        }
                    }
                }
            }
        }
    }