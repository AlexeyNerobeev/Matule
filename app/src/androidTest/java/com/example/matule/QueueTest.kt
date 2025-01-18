package com.example.matule

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class QueueTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun Test(){
        composeTestRule.setContent {
            var isOnB2IsVisible by remember{ mutableStateOf(false)}
            if(isOnB2IsVisible){
                OnBoard2()
            } else{
                OnBoard1_Screen()
            }
        }
        composeTestRule.onNodeWithText("ДОБРО").assertIsDisplayed()
        composeTestRule.onNodeWithText("Начать").performClick()
    }
}