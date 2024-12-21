package com.example.matule

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoutes.SignIn.route){
        composable(NavRoutes.Main.route) { MainScreen(navController) }
        composable(NavRoutes.SignIn.route){ signInScreen(navController) }
        composable(NavRoutes.Registration.route){ RegistrationScreen(navController)}
        composable(NavRoutes.onBoard1.route) { onBoard1_Screen(navController)}
        composable(NavRoutes.onBoard2.route) { onBoardScreen2(navController)}
        composable(NavRoutes.onBoard3.route) { onBoard3Screen(navController)}
        composable(NavRoutes.Favourite.route) { favouriteScreen(navController)}
        composable(NavRoutes.Details.route) { detailsScreen()}
        composable(NavRoutes.Cart.route) { cartScreen()}
        composable(NavRoutes.Profile.route) { ProfileScreen(navController)}
        composable(NavRoutes.Notification.route) { NotificationScreen(navController)}
        composable(NavRoutes.SideMenu.route) { SideMenuScreen(navController)}
    }
}

sealed class NavRoutes(val route: String){
    object SignIn: NavRoutes("signIn")
    object Main: NavRoutes("main")
    object Registration: NavRoutes("reg")
    object onBoard1: NavRoutes("onBoard1")
    object onBoard2: NavRoutes("onBoard2")
    object onBoard3: NavRoutes("onBoard3")
    object Favourite: NavRoutes("Favourite")
    object Details: NavRoutes("Details")
    object Cart: NavRoutes("Cart")
    object Profile: NavRoutes("Profile")
    object Notification: NavRoutes("Notification")
    object SideMenu: NavRoutes("SideMenu")
}