package com.example.matule

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.matule.activities.onBoard1_Screen
import com.example.matule.activities.onBoard3Screen
import com.example.matule.activities.onBoardScreen2
import com.example.matule.navigation.NavRoutes
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class QueueTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun test(){
        composeTestRule.setContent {
            val navController = rememberNavController()
            NavHost(navController, "t1"){
                composable("t1"){
                    onBoard1_Screen(navController)
                }
                composable(NavRoutes.onBoard2.route){
                    onBoardScreen2(navController)
                }
                composable(NavRoutes.onBoard3.route){
                    onBoard3Screen(navController)
                }
            }
        }
        composeTestRule.onNodeWithText("Начать").assertIsDisplayed()
        composeTestRule.onNodeWithText("Начать").performClick()
        composeTestRule.onNodeWithText("Далее").assertIsDisplayed()
        composeTestRule.onNodeWithText("Далее").performClick()
    }
}