package com.vabian.edusmart.ui.theme.screens.about



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vabian.edusmart.R
import com.vabian.edusmart.navigation.ROUT_HOME

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavController) {
    var selectedTab by remember { mutableStateOf(1) } // About tab selected

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("About EduSmart") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF3FB645),
                    titleContentColor = Color.White
                )
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Color(0xFF3FB645)) {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = { Icon(Icons.Default.Home, contentDescription = ROUT_HOME) },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = { Icon(Icons.Default.Info, contentDescription = "About") },
                    label = { Text("About") }
                )
                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    icon = { Icon(Icons.Default.Person, contentDescription = "Account") },
                    label = { Text("Account") }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // App Logo or Icon Placeholder
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF3FB645)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "App Logo",
                    tint = Color.White,
                    modifier = Modifier.size(50.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Welcome to EduSmart",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3FB645)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "EduSmart is your smart companion for modern education. Our app provides students, teachers, and institutions with tools to enhance learning, streamline communication, and foster academic success.",
                fontSize = 16.sp,
                color = Color.DarkGray,
                lineHeight = 22.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Key Features
            Text(
                text = "Key Features:",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF3FB645)
            )

            Spacer(modifier = Modifier.height(12.dp))

            FeatureItem("📚 Subject Management")
            FeatureItem("📊 Grade Tracking")
            FeatureItem("📨 Notifications and Announcements")
            FeatureItem("👨‍🏫 Teacher-parent Communication")

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Contact us: support@edusmart.com",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun FeatureItem(text: String) {
    Row(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(text = text, fontSize = 16.sp, color = Color.Black)
    }
}

@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    AboutScreen(navController = rememberNavController())
}
