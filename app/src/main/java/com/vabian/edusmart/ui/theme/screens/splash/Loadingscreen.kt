package com.vabian.edusmart.ui.theme.screens.splash

import android.annotation.SuppressLint
import android.widget.ProgressBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vabian.edusmart.R
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.vabian.edusmart.navigation.ROUT_DASHBOARD
import com.vabian.edusmart.navigation.ROUT_HOME
import com.vabian.edusmart.navigation.ROUT_REGISTER
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun LoadingScreen(navController: NavController){

    val coroutine = rememberCoroutineScope()
    coroutine.launch{
        delay(3000)
        navController.navigate(ROUT_REGISTER)
    }


    Column(
        modifier = Modifier.fillMaxSize().background(Color.Magenta),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "EduSmart",
            fontSize = 40.sp,
            fontFamily = androidx.compose.ui.text.font.FontFamily.Cursive,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(60.dp))



        //LoadingBar

        @SuppressLint("CoroutineCreationDuringComposition")
        @Composable
        fun LoadingScreen(navController: NavController) {
            var progress by remember { mutableStateOf(0f) }
            // Simulate loading with LaunchedEffect
            LaunchedEffect(Unit) {
                while (progress < 1f) {
                    delay(30)
                    progress += 0.01f
                }
                navController.navigate("login_screen") {
                    popUpTo("splash_screen") { inclusive = true }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {


                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "EduSmart",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(24.dp))

                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier
                        .width(200.dp)
                        .height(8.dp),
                    color = Color(0xFF3F51B5)
                )
            }
        }


        //End of LoadingBar

        Text(
            text = "Please Wait........",
            fontSize = 20.sp,
        )


    }
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview(){
    LoadingScreen(navController= rememberNavController())
}