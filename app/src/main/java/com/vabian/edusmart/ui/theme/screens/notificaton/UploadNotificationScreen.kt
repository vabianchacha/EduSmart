package com.vabian.edusmart.ui.theme.screens.notificaton




import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vabian.edusmart.model.Content
import com.vabian.edusmart.navigation.ROUT_ADMIN_VIEW
import com.vabian.edusmart.navigation.ROUT_HOME
import com.vabian.edusmart.navigation.ROUT_SERVICE
import com.vabian.edusmart.viewmodel.ContentViewModel
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UploadContentScreen(
    navController: NavController,
    contentViewModel: ContentViewModel,
    editingContentId: Int? = null
) {
    var selectedIndex by remember { mutableStateOf(0) }

    // Sample static recent notices
    val recentNotices = remember {
        listOf(
            "School will be closed tomorrow due to scheduled maintenance. Please make arrangements for your child.",
            "A parent-teacher meeting is scheduled for next week. Your attendance is highly encouraged.",
            "Please ensure that all outstanding fee balances are cleared before the new term begins.",
            "Midterm exams start on Monday. Kindly support your child in preparing adequately.",
            "The school sports day is on the 25th. Parents are welcome to attend and support.",
            "Parents are reminded to ensure their children bring proper school identification daily.",
            "Holiday assignments will be distributed on Friday. Kindly supervise their completion.",
            "Mock exam results for Form 4 students will be released this Friday. Please review them with your child.",
            "A school uniform inspection is scheduled for next week. Ensure your child is properly attired.",
            "The school canteen will be under renovation for two weeks. Kindly adjust your child’s meal plans accordingly."
        )
    }

    // Form fields
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }

    // Load existing content if editing
    LaunchedEffect(editingContentId) {
        if (editingContentId != null) {
            contentViewModel.loadContentById(editingContentId)
        }
    }

    // Collect the content to be edited
    val editingContent = contentViewModel.selectedContent.collectAsState().value
    val context = LocalContext.current

    // Populate form if editing
    LaunchedEffect(editingContent) {
        editingContent?.let {
            title = it.title
            description = it.description

        }
    }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("NOTICE") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Green,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Color.Green) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
                    label = { Text("Favorites") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex =1}
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Service") },
                    label = { Text("Service") },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
                        navController.navigate(ROUT_SERVICE)
                    }
                )
            }
        },

    ) { paddingValues ->
        // Scrollable content
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {



            // Notification input
            item {
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Notification") },
                    modifier = Modifier.fillMaxWidth()
                )
            }


            // Section heading
            item {
                Text("Recent Notifications", style = MaterialTheme.typography.labelLarge)
            }

            // Recent messages list – click to copy into description field
            items(recentNotices.size) { index ->
                val message = recentNotices[index]
                SelectionContainer {
                    Text(
                        text = "${index + 1}. $message",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                // When clicked, copy message into the notification field
                                description = message
                            }
                            .padding(vertical = 4.dp)
                    )
                }
            }

            // Submit button
            item {
                Spacer(Modifier.height(8.dp))
                Button(

                    onClick = {

                        val content = Content(
                            id = editingContent?.id ?: 0,
                            title = title,
                            description = description,

                        )

                        if (editingContent != null) {
                            contentViewModel.update(content)
                        } else {
                            contentViewModel.insert(content)
                        }
                        navController.navigate(ROUT_ADMIN_VIEW)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color.Green)
                )
                {
                    Text("Send Notification")
                }



            }

        }
    }

}
