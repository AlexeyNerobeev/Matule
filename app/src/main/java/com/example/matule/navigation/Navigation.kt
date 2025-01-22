package com.example.matule.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.matule.activities.CategoriesScreen
import com.example.matule.activities.CheckoutScreen
import com.example.matule.activities.DetailOrder
import com.example.matule.activities.EditProfileScreen
import com.example.matule.activities.ForgotPasswordScreen
import com.example.matule.activities.MainScreen
import com.example.matule.activities.NotificationScreen
import com.example.matule.activities.OrdersScreen
import com.example.matule.activities.ProfileScreen
import com.example.matule.activities.RegistrationScreen
import com.example.matule.activities.SideMenuScreen
import com.example.matule.activities.VerificationScreen
import com.example.matule.activities.cartScreen
import com.example.matule.activities.detailsScreen
import com.example.matule.activities.favouriteScreen
import com.example.matule.activities.onBoard1_Screen
import com.example.matule.activities.onBoard3Screen
import com.example.matule.activities.onBoardScreen2
import com.example.matule.activities.signInScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoutes.SignIn.route){
        composable(NavRoutes.Main.route) { MainScreen(navController) }
        composable(NavRoutes.SignIn.route){ signInScreen(navController) }
        composable(NavRoutes.Registration.route){ RegistrationScreen(navController) }
        composable(NavRoutes.onBoard1.route) { onBoard1_Screen(navController) }
        composable(NavRoutes.onBoard2.route) { onBoardScreen2(navController) }
        composable(NavRoutes.onBoard3.route) { onBoard3Screen(navController) }
        composable(NavRoutes.Favourite.route) { favouriteScreen(navController) }
        composable(NavRoutes.Details.route) { detailsScreen(navController) }
        composable(NavRoutes.Cart.route) { cartScreen(navController) }
        composable(NavRoutes.Profile.route) { ProfileScreen(navController) }
        composable(NavRoutes.Notification.route) { NotificationScreen(navController) }
        composable(NavRoutes.SideMenu.route) { SideMenuScreen(navController) }
        composable(NavRoutes.EditProfile.route) { EditProfileScreen(navController) }
        composable(NavRoutes.ForgotPassword.route) { ForgotPasswordScreen(navController) }
        composable(NavRoutes.Verification.route) { VerificationScreen(navController) }
        composable(NavRoutes.Categories.route) { CategoriesScreen(navController) }
        composable(NavRoutes.Checkout.route){ CheckoutScreen(navController) }
        composable(NavRoutes.Orders.route){ OrdersScreen(navController)}
        composable(NavRoutes.DetailOrder.route){ DetailOrder(navController)}
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
    object EditProfile: NavRoutes("EditProfile")
    object ForgotPassword: NavRoutes("ForgotPassword")
    object Verification: NavRoutes("Verification")
    object Categories: NavRoutes("Categories")
    object Checkout: NavRoutes("Checkout")
    object Orders: NavRoutes("Orders")
    object DetailOrder: NavRoutes("DetailOrder")
}