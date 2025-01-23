package com.example.matule.activities

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.matule.R
import com.example.matule.getData.sneakers

@Preview
@Composable
fun PrevSearch(){
    val n = rememberNavController()
    SearchScreen(n)
}

@Composable
fun SearchScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .background(colorResource(R.color.MainBackground))
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 20.dp)) {
                Box(modifier = Modifier
                    .fillMaxWidth()){
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(painter = painterResource(R.drawable.back_icon),
                            contentDescription = null,
                            tint = Color.Unspecified)
                    }
                    Text(text = "Поиск",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight(600),
                        fontFamily = font,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            val search = remember { mutableStateOf("") }
            val searchList = remember { mutableListOf<String>() }
            val isSearchCorrect = remember{ mutableStateOf(false)}
            OutlinedTextField(
                value = search.value,
                onValueChange = {
                    search.value = it
                },
                keyboardActions = KeyboardActions(
                    onDone = {
                        if(search.value.isNotEmpty()){
                            searchList.add(search.value)
                            if(search.value == sneakers.name ||
                                search.value == sneakers.gender ||
                                search.value == sneakers.category){
                                isSearchCorrect.value = true
                            } else{
                                isSearchCorrect.value = false
                            }
                        }
                    }
                ),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 26.dp)
                    .clickable {
                        if(search.value.isNotEmpty()){
                            searchList.add(search.value)
                            if(search.value == sneakers.name ||
                                search.value == sneakers.gender ||
                                search.value == sneakers.category){
                                isSearchCorrect.value = true
                            } else{
                                isSearchCorrect.value = false
                            }
                        }
                    },
                leadingIcon = {
                    IconButton(onClick = {
                        searchList.add(search.value)
                        if(search.value == sneakers.name ||
                            search.value == sneakers.gender ||
                            search.value == sneakers.category){
                            isSearchCorrect.value = true
                        } else{
                            isSearchCorrect.value = false
                        }
                    },
                        modifier = Modifier
                            .padding(start = 14.dp)) {
                        Icon(
                            painter = painterResource(R.drawable.search_icon),
                            contentDescription = null
                        )
                    }
                },
                trailingIcon = {
                    IconButton(onClick = {

                    },
                        modifier = Modifier
                            .padding(end = 15.dp)) {
                        Icon(painter = painterResource(R.drawable.microphone),
                            contentDescription = null)
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedTextColor = Color.Black,
                    focusedTextColor = Color.Black,
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = Color.White
                ),
                placeholder = {
                    Text(text = "Поиск",
                        color = colorResource(R.color.hint),
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500))
                },
                shape = RoundedCornerShape(14.dp)
            )
            if (isSearchCorrect.value == true){
                LazyVerticalStaggeredGrid(
                    modifier = Modifier
                        .padding(top = 39.dp)
                        .fillMaxSize(),
                    columns = StaggeredGridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(13.dp),
                    verticalItemSpacing = 15.dp
                ) {
                    items(20) {_ ->
                        ProductCard(navController)
                    }
                }
            } else if (searchList.isNotEmpty()){
                LazyColumn(modifier = Modifier
                    .padding(top = 26.dp)
                    .fillMaxSize()) {
                    items(searchList.size){s ->
                        Row(modifier = Modifier
                            .padding(bottom = 16.dp)
                            .clickable {
                                search.value = searchList[s]
                            }){
                            Icon(painter = painterResource(R.drawable.time_icon),
                                contentDescription = null)
                            Text(text = "${searchList[s]}",
                                color = Color.Black,
                                fontWeight = FontWeight(500),
                                fontSize = 14.sp,
                                fontFamily = font,
                                modifier = Modifier.padding(start = 12.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}