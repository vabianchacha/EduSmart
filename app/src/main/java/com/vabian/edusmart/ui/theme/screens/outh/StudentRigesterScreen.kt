package com.vabian.edusmart.ui.theme.screens.outh

import android.Manifest
import android.app.Application
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.util.Base64
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.room.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.util.*

// ---------------------- DATA MODEL & DB SETUP ------------------------

@Entity(tableName = "students")
data class Student(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val admissionNo: String,
    val parentId: String,
    val parentPhone: String,
    val passportBase64: String
)

@Dao
interface StudentDao {
    @Insert
    suspend fun insert(student: Student)

    @Query("SELECT * FROM students")
    suspend fun getAll(): List<Student>
}

@Database(entities = [Student::class], version = 1)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao

    companion object {
        @Volatile private var INSTANCE: StudentDatabase? = null

        fun getDatabase(context: android.content.Context): StudentDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    StudentDatabase::class.java,
                    "student_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}

// ---------------------- VIEWMODEL ------------------------

class StudentViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = StudentDatabase.getDatabase(application).studentDao()

    fun registerStudent(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(student)
        }
    }
}

// ---------------------- UI SCREEN ------------------------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentRegisterScreen(navController: NavController) {
    val context = LocalContext.current
    val viewModel: StudentViewModel = ViewModelProvider(
        LocalContext.current as androidx.lifecycle.ViewModelStoreOwner
    )[StudentViewModel::class.java]

    var name by remember { mutableStateOf("") }
    var parentId by remember { mutableStateOf("") }
    var parentPhone by remember { mutableStateOf("") }
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, it)
        }
    }

    val admissionNumber = "ADM-${UUID.randomUUID().toString().substring(0, 6).uppercase()}"

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Register New Student") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("home") }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF880E4F),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFF880E4F),
                contentColor = Color.White
            ) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = false,
                    onClick = { navController.navigate("home") }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = false,
                    onClick = { navController.navigate("profile") }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Register New Student", fontSize = 22.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Student Name") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = parentId,
                onValueChange = { parentId = it },
                label = { Text("Parent ID Number") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = parentPhone,
                onValueChange = { parentPhone = it },
                label = { Text("Parent Phone Number") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text("Admission No: $admissionNumber", fontWeight = FontWeight.Medium)

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .size(120.dp)
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .clickable { imagePickerLauncher.launch("image/*") },
                contentAlignment = Alignment.Center
            ) {
                if (bitmap != null) {
                    Image(bitmap = bitmap!!.asImageBitmap(), contentDescription = null)
                } else {
                    Text("Upload Photo", color = Color.Gray)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    if (name.isNotEmpty() && parentId.isNotEmpty() && parentPhone.isNotEmpty() && bitmap != null) {
                        val base64Photo = bitmapToBase64(bitmap!!)
                        val student = Student(
                            name = name,
                            admissionNo = admissionNumber,
                            parentId = parentId,
                            parentPhone = parentPhone,
                            passportBase64 = base64Photo
                        )
                        viewModel.registerStudent(student)
                        name = ""
                        parentId = ""
                        parentPhone = ""
                        bitmap = null
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF880E4F))
            ) {
                Text("Register Student", color = Color.White)
            }

            // Extra content section (e.g., Terms and Conditions, info, etc.)
            Spacer(modifier = Modifier.height(30.dp))

            Text("By registering, you agree to our terms and conditions.", color = Color.Gray, fontSize = 12.sp)
        }
    }
}

// ---------------------- IMAGE TO BASE64 ------------------------

fun bitmapToBase64(bitmap: Bitmap): String {
    val outputStream = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
    return Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT)
}

// ---------------------- PREVIEW ------------------------

@Preview(showBackground = true)
@Composable
fun PreviewStudentRegister() {
    StudentRegisterScreen(navController = rememberNavController())
}
