package com.example.matule

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class QueueTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test(){
        composeTestRule.setContent {
            val navController = rememberNavController()
            onBoard1_Screen(navController)
        }
        composeTestRule.onNodeWithText("Начать").assertIsDisplayed()
        composeTestRule.onNodeWithText("Начать").performClick()
        composeTestRule.onNodeWithText("Далее").assertIsDisplayed()
        composeTestRule.onNodeWithText("Далее").performClick()
    }
}