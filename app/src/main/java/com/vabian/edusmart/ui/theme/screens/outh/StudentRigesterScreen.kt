package com.vabian.edusmart.ui.theme.screens.outh

import android.annotation.SuppressLint
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.vabian.edusmart.navigation.ROUT_LOGIN
import com.vabian.edusmart.viewmodel.StudentViewModel



@OptIn(ExperimentalMaterial3Api::class)


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun StudentRegisterScreen(
    navController: NavController,
    viewModel: StudentViewModel = viewModel()
) {
    var fullName by remember { mutableStateOf("") }
    var classLevel  by remember { mutableStateOf("classLevel") }
    var passportUri by remember { mutableStateOf("passportUri") }
    var admissionNumber by remember { mutableStateOf("admissionNumber") }


    val classOptions = listOf("Form 1", "Form 2", "Form 3", "Form 4")
    var expanded by remember { mutableStateOf(false) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        viewModel.updatePassport(uri)
    }
//////////
    Text("Back to Login",
        modifier = Modifier.clickable {
            navController.navigate("login")
        },
        color = Color.Gray
    )
//////////

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("Student Registration", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = fullName,
            onValueChange = {
                val it = ""
                viewModel.updateFullName(it)
            },
            label = { ("Full Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = admissionNumber,
            onValueChange = {},
            label = { ("Admission No.") },
            readOnly = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = classLevel,
                onValueChange = {},
                label = { ("Class Level") },
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.fillMaxWidth()
            )

            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                classOptions.forEach {
                    DropdownMenuItem(
                        text = { Text(it) },
                        onClick = {
                            viewModel.updateClassLevel(it)
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Upload Passport", fontSize = 14.sp)
        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .size(100.dp)
                .border(1.dp, Color.Gray)
                .clickable { imagePicker.launch("image/*") },
            contentAlignment = Alignment.Center
        ) {
            if (true) {
                Image(
                    painter = rememberAsyncImagePainter(passportUri),
                    contentDescription = "Passport",
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Text("Tap to select")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(

            onClick = {
                viewModel.saveStudentData()
                // navController.navigate("login") or show confirmation
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F51B5))
        ) {
            Text("Register", color = Color.White)
        }


        TextButton(
            onClick = { navController.navigate(ROUT_LOGIN) }
        ) {
            Text("Already student exist? Login")
        }

    }
}

