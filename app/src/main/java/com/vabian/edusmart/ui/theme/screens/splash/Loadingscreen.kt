package com.vabian.edusmart.ui.theme.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vabian.edusmart.navigation.ROUT_REGISTER
import com.vabian.edusmart.ui.theme.yellow
import kotlinx.coroutines.delay
import com.vabian.edusmart.R // Ensure you have a logo in res/drawable or mipmap
import com.vabian.edusmart.navigation.ROUT_DASHBOARD

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun LoadingScreen(navController: NavController) {
    var progress by remember { mutableFloatStateOf(0f) }

    LaunchedEffect(Unit) {
        while (progress < 1f) {
            delay(30)
            progress += 0.01f
        }
        navController.navigate(ROUT_DASHBOARD) {
            popUpTo("splash_screen") { inclusive = true }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(yellow)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo/Image
        Image(
            painter = painterResource(id = R.drawable.waa), // Replace with your actual logo
            contentDescription = "App Logo",
            modifier = Modifier.size(120.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // App Name
        Text(
            text = "EduSmart",
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Cursive,
            color = Color.Black
        )

        // Subtitle / Slogan
        Text(
            text = "Smart Learning. Smarter Future.",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Progress Indicator
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier
                .width(250.dp)
                .height(15.dp),
            color = Color.Black,
            trackColor = Color.White
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Loading, please wait...",
            fontSize = 18.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(60.dp))

        // Footer / Credits
        Text(
            text = "Developed by Vabian Solutions",
            fontSize = 12.sp,
            color = Color.DarkGray
        )

        Text(
            text = "v1.0.0",
            fontSize = 12.sp,
            color = Color.DarkGray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    LoadingScreen(navController = rememberNavController())
}
