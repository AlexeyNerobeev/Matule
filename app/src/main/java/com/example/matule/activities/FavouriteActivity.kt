package com.example.matule.activities

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.matule.data.SneakersVM
import com.example.matule.getData.favourite
import com.example.matule.getData.sneakers
import com.example.matule.getData.user
import com.example.matule.navigation.NavRoutes
import com.example.matule.ui.theme.MatuleTheme

class FavouriteActivity : ComponentActivity() {
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
fun PrevFavourite(){
    val n = rememberNavController()
    val vm = SneakersVM()
    favouriteScreen(n, vm)
}

    @SuppressLint("CoroutineCreationDuringComposition")
    @Composable
    fun favouriteScreen(navController: NavController, vm: SneakersVM){
        val font = FontFamily(
            Font(
                resId = R.font.raleway_bold
            )
        )
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(
                    colorResource(R.color.MainBackground)
                )) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
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
                        text = "Избранное",
                        fontFamily = font,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        color = Color.Black
                    )
                    Image(
                        painter = painterResource(R.drawable.heart_icon),
                        contentDescription = null,
                        modifier = Modifier.padding(end = 5.dp)
                    )
                }
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 32.dp)
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(15.dp),
                    verticalItemSpacing = 15.dp
                ) {
                    if(favourite.user_id == user.id){
                        items(vm.sneakersList.size){s ->
                            vm.sneakerId = s
                            ProductCard(navController, vm)
                        }
                    }
                }
            }
        }
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val const = createRef()
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(106.dp)
                .constrainAs(const) {
                    bottom.linkTo(parent.bottom)
                }){
                Image(painter = painterResource(R.drawable.bottombar_shape),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    contentScale = ContentScale.Crop)
                IconButton(onClick = {
                    navController.navigate(NavRoutes.Cart.route)
                },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = colorResource(R.color.button),
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .size(56.dp, 56.dp)
                        .align(Alignment.TopCenter)
                ) {
                    Image(painter = painterResource(R.drawable.cart_flact_button),
                        contentDescription = null)
                }
                Row(modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .padding(horizontal = 31.dp),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Row(horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .padding(end = 50.dp)){
                        IconButton(onClick = {
                            navController.navigate(NavRoutes.Main.route)
                        }) {
                            Icon(painter = painterResource(R.drawable.home_bottomnav_icon),
                                contentDescription = null)
                        }
                        IconButton(onClick = {},
                            colors = IconButtonDefaults.iconButtonColors(
                                contentColor = colorResource(R.color.button)
                            )) {
                            Icon(painter = painterResource(R.drawable.heart_bottomnav_icon),
                                contentDescription = null)
                        }
                    }
                    Row(horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth(1f)
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
