package com.example.matule

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun PrevCategories(){
    val n = rememberNavController()
    CategoriesScreen(n)
}

@Composable
fun CategoriesScreen(navController: NavController) {
    val font = FontFamily(
        Font(
            resId = R.font.raleway_bold
        )
    )
    val categoryName = remember { mutableStateOf(category) }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize().background(
                colorResource(R.color.MainBackground)
            )
                .padding(horizontal = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = {
                    navController.popBackStack()
                },
                    modifier = Modifier.align(Alignment.CenterVertically)) {
                    Image(
                        painter = painterResource(R.drawable.back_icon),
                        contentDescription = null
                    )
                }
                Text(
                    text = categoryName.value,
                    fontFamily = font,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    modifier = Modifier.padding(start = 100.dp),
                    color = Color.Black
                )
            }
            Column(
                modifier = Modifier.padding(top = 16.dp).fillMaxWidth()
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
                val buttonColor2 = remember { mutableIntStateOf(R.color.white) }
                val textButtonColor2 = remember { mutableIntStateOf(R.color.black) }
                val buttonColor3 = remember { mutableIntStateOf(R.color.white) }
                val textButtonColor3 = remember { mutableIntStateOf(R.color.black) }
                if(categoryName.value == "Все"){
                    buttonColor.value = R.color.button
                    textButtonColor.value = R.color.white
                }
                if(categoryName.value == "Outdoor"){
                    buttonColor2.value = R.color.button
                    textButtonColor2.value = R.color.white
                }
                if(categoryName.value == "Tennis"){
                    buttonColor3.value = R.color.button
                    textButtonColor3.value = R.color.white
                }
                LazyRow(modifier = Modifier.padding(top = 16.dp).fillMaxWidth()) {
                    item {
                        Button(
                            onClick = {
                                if (category != "Все"){
                                    buttonColor.value = R.color.button
                                    textButtonColor.value = R.color.white
                                    buttonColor2.value = R.color.white
                                    textButtonColor2.value = R.color.black
                                    buttonColor3.value = R.color.white
                                    textButtonColor3.value = R.color.black
                                    category = "Все"
                                    categoryName.value = category
                                }
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
                                if (category != "Outdoor"){
                                    buttonColor2.value = R.color.button
                                    textButtonColor2.value = R.color.white
                                    buttonColor.value = R.color.white
                                    textButtonColor.value = R.color.black
                                    buttonColor3.value = R.color.white
                                    textButtonColor3.value = R.color.black
                                    category = "Outdoor"
                                    categoryName.value = category
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                contentColor = colorResource(textButtonColor2.value),
                                containerColor = colorResource(buttonColor2.value)
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
                                if (category != "Tennis"){
                                    buttonColor3.value = R.color.button
                                    textButtonColor3.value = R.color.white
                                    buttonColor.value = R.color.white
                                    textButtonColor.value = R.color.black
                                    buttonColor2.value = R.color.white
                                    textButtonColor2.value = R.color.black
                                    category = "Tennis"
                                    categoryName.value = category
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                contentColor = colorResource(textButtonColor3.value),
                                containerColor = colorResource(buttonColor3.value)
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
                }
            }
        }
    }
}