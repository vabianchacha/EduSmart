package com.vabian.edusmart.ui.theme.screens.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vabian.edusmart.R
import com.vabian.edusmart.navigation.ROUT_HOME
import com.vabian.edusmart.navigation.ROUT_REGISTER

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(navController: NavController) {
    var selectedTab by remember { mutableStateOf(0) }

    val sampleImages = listOf(
        painterResource(id = R.drawable.img_6),
        painterResource(id = R.drawable.img_7),
        painterResource(id = R.drawable.img_5)

    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("EduSmart Start") },
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
                    onClick = { selectedTab = 0
                        navController.navigate(ROUT_HOME)},
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = { Icon(Icons.Default.List, contentDescription = "Subjects") },
                    label = { Text("Subjects") }
                )
                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2
                        navController.navigate(ROUT_REGISTER)
                              },
                    icon = { Icon(Icons.Default.Person, contentDescription = "Register") },
                    label = { Text("Register") }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to EduSmart",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3FB645)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Empowering students through smart education tools.",
                fontSize = 16.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(20.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(sampleImages) { image: Painter ->
                    Image(
                        painter = image,
                        contentDescription = "Feature Image",
                        modifier = Modifier
                            .size(160.dp)
                            .padding(4.dp)
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(12.dp))
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = { /* navController.navigate("next_screen") */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF47B42F))
            ) {
                Icon(Icons.Default.PlayArrow, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Get Started", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    StartScreen(navController = rememberNavController())
}
