package com.vabian.edusmart.ui.theme.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import com.vabian.edusmart.R // Make sure your image resources exist

// Navigation route constants
const val ROUT_ABOUT = "about"
const val ROUT_CONTACT = "contact"
const val ROUT_START = "start"
const val ROUT_MORE = "more"
const val ROUT_INTENT = "intent"
const val ROUT_ITEM = "item"
const val ROUT_SERVICE = "service"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val selectedTab = remember { mutableStateOf(0) }
    val bottomNavIndex = remember { mutableStateOf(0) }
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }

    val screenRoutes = mapOf(
        "Start" to ROUT_START,
        "Intent" to ROUT_INTENT,
        "Item" to ROUT_ITEM,
        "Service" to ROUT_SERVICE
    )

    val searchResults = remember(searchQuery.text) {
        if (searchQuery.text.isBlank()) screenRoutes.keys.toList()
        else screenRoutes.keys.filter {
            it.contains(searchQuery.text.trim(), ignoreCase = true)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text("Edusmart")},
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
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
                listOf(
                    "Home" to Icons.Default.Home,
                    "About" to Icons.Default.Info,
                    "Contact" to Icons.Default.Call,
                    "More" to Icons.Default.MoreVert
                ).forEachIndexed { index, (label, icon) ->
                    NavigationBarItem(
                        selected = bottomNavIndex.value == index,
                        onClick = {
                            bottomNavIndex.value = index
                            searchQuery = TextFieldValue("")
                            when (label) {
                                "About" -> navController.navigate(ROUT_ABOUT)
                                "Contact" -> navController.navigate(ROUT_CONTACT)
                                "More" -> navController.navigate(ROUT_MORE)
                            }
                        },
                        icon = { Icon(icon, contentDescription = label) },
                        label = { Text(label) }
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            if (searchQuery.text.isNotBlank()) {
                Text(
                    "Search Results:",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                if (searchResults.isNotEmpty()) {
                    searchResults.forEach { item ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 6.dp)
                                .clickable {
                                    navController.navigate(screenRoutes[item] ?: ROUT_ABOUT)
                                    searchQuery = TextFieldValue("")
                                },
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F1E8))
                        ) {
                            Text(
                                text = item,
                                modifier = Modifier.padding(16.dp),
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                } else {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("No results found for \"${searchQuery.text}\".")
                    }
                }
            } else {
                TabRow(selectedTabIndex = selectedTab.value) {
                    Tab(
                        selected = selectedTab.value == 0,
                        onClick = { selectedTab.value = 0 },
                        text = { Text("Suggested") }
                    )
                    Tab(
                        selected = selectedTab.value == 1,
                        onClick = {
                            selectedTab.value = 1
                            navController.navigate(ROUT_ABOUT)
                        },
                        text = { Text("Activity") }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("Search in EduSmart") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, RoundedCornerShape(20.dp)),
                    singleLine = true,
                    shape = RoundedCornerShape(20.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Image Carousel
                ImageCarousel()

                Spacer(modifier = Modifier.height(24.dp))

                when (selectedTab.value) {
                    0 -> {
                        Text(
                            "Welcome to EduSmart",
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(bottom = 12.dp)
                        )

                        Text(
                            "Access features quickly using the options below:",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(bottom = 24.dp)
                        )

                        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                            screenRoutes.forEach { (label, route) ->
                                Card(
                                    shape = RoundedCornerShape(12.dp),
                                    elevation = CardDefaults.cardElevation(4.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { navController.navigate(route) }
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(16.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            contentDescription = null,
                                            tint = Color(0xFF3FB645),
                                            modifier = Modifier.size(40.dp)
                                        )
                                        Spacer(modifier = Modifier.width(16.dp))
                                        Text(
                                            text = "Go to $label",
                                            style = MaterialTheme.typography.titleMedium
                                        )
                                    }
                                }
                            }
                        }
                    }

                    1 -> {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Text("No activity available.")
                        }
                    }
                }
            }
        }
    }
}

// Carousel Composable
@Composable
fun ImageCarousel() {
    val images = listOf(
        R.drawable.img_6,
        R.drawable.img_7,
        R.drawable.img_8
    )

    var currentIndex by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000L)
            currentIndex = (currentIndex + 1) % images.size
        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = images[currentIndex]),
                contentDescription = "Carousel Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.3f)) // Optional dark overlay for better text visibility
            )
            Text(
                text = "Discover More with EduSmart",
                style = MaterialTheme.typography.titleMedium.copy(color = Color.White),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
