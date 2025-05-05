package com.vabian.edusmart.ui.theme.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vabian.edusmart.R
import com.vabian.edusmart.navigation.*
import com.vabian.edusmart.ui.theme.yellow
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    var selectedIndex by remember { mutableStateOf(0) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color(0xFF4CAF50)
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "User Navigation",
                    modifier = Modifier.padding(16.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                NavigationDrawerItem(
                    label = { Text("Register", color = Color.White) },
                    selected = false,
                    onClick = {
                        navController.navigate(ROUT_REGISTER)
                        coroutineScope.launch { drawerState.close() }
                    },
                    icon = {
                        Icon(Icons.Default.Person, contentDescription = "Admin", tint = Color.White)
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )

                NavigationDrawerItem(
                    label = { Text("Login", color = Color.White) },
                    selected = false,
                    onClick = {
                        navController.navigate(ROUT_LOGIN)
                        coroutineScope.launch { drawerState.close() }
                    },
                    icon = {
                        Icon(Icons.Default.Person, contentDescription = "Parent", tint = Color.White)
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("EduSmart Dashboard") },
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch { drawerState.open() }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF4CAF50),
                        titleContentColor = Color.White
                    )
                )
            },
            bottomBar = {
                BottomNavigationBar(
                    selectedIndex = selectedIndex,
                    onItemSelected = { index ->
                        selectedIndex = index
                        when (index) {
                            0 -> navController.navigate(ROUT_HOME)
                            1 -> navController.navigate(ROUT_START)
                            2 -> navController.navigate(ROUT_CONTACT)
                        }
                    }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {




                // Header
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF4CAF50))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.edulogo),
                            contentDescription = "Logo",
                            modifier = Modifier
                                .size(100.dp)
                                .clip(RoundedCornerShape(50.dp)),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Welcome to EduSmart",
                            fontSize = 26.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif
                        )
                        Text(
                            text = "Learn • Track • Grow",
                            fontSize = 16.sp,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                // Cards List
                DashboardCard("📚 Home", "Explore your dashboard", R.drawable.img_10) {
                    navController.navigate(ROUT_HOME)
                }

                DashboardCard("ℹ️ About", "Know more about EduSmart", R.drawable.img_16) {
                    navController.navigate(ROUT_ABOUT)
                }

                DashboardCard("🚀 Start", "Begin your learning journey", R.drawable.img_12) {
                    navController.navigate(ROUT_START)
                }

                DashboardCard("📞 Contact", "Reach out to us", R.drawable.img_11) {
                    navController.navigate(ROUT_CONTACT)
                }

                DashboardCard("📂 More", "Explore more features", R.drawable.img_13) {
                    navController.navigate(ROUT_MORE)
                }

                DashboardCard("🎯 Intents", "External actions", R.drawable.uniform) {
                    navController.navigate(ROUT_INTENT)
                }

                DashboardCard("🧩 Items", "View study materials", R.drawable.img_14) {
                    navController.navigate(ROUT_ITEM)
                }

                DashboardCard("🛠 Services", "Get app services", R.drawable.img_17) {
                    navController.navigate(ROUT_SERVICE)
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}



@Composable
fun DashboardCard(title: String, subtitle: String, imageRes: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .padding(vertical = 8.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = yellow),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = subtitle,
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.9f)
                )
            }
        }
    }
}

@Composable
fun BottomNavigationBar(selectedIndex: Int, onItemSelected: (Int) -> Unit) {
    NavigationBar(
        containerColor = Color(0xFF4CAF50),
        contentColor = Color.White
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = selectedIndex == 0,
            onClick = { onItemSelected(0) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.PlayArrow, contentDescription = "Start") },
            label = { Text("Start") },
            selected = selectedIndex == 1,
            onClick = { onItemSelected(1) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Phone, contentDescription = "Contact") },
            label = { Text("Contact") },
            selected = selectedIndex == 2,
            onClick = { onItemSelected(2) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen(navController = rememberNavController())
}
