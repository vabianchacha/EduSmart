package com.vabian.edusmart.viewmodel

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vabian.edusmart.model.User
import com.vabian.edusmart.repository.UserRepository
import kotlinx.coroutines.launch
import java.util.UUID


class AuthViewModel (private val repository: UserRepository) : ViewModel() {
    var loggedInUser: ((User?) -> Unit)? = null

    fun registerUser(user: User) {
        viewModelScope.launch {
            repository.registerUser(user)
        }
    }

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            val user = repository.loginUser(email, password)
            loggedInUser?.invoke(user)
        }
    }

}

class StudentViewModel : ViewModel() {
    private val _fullName = mutableStateOf("")
    val fullName: String = _fullName.value

    private val _classLevel = mutableStateOf("Form 1")
    val classLevel: String = _classLevel.value

    private val _passportUri = mutableStateOf<Uri?>(null)
    val passportUri: Uri? = _passportUri.value

    val admissionNumber: String = UUID.randomUUID().toString().take(8)

    fun updateFullName(name: String) {
        _fullName.value = name
    }

    fun updateClassLevel(level: String) {
        _classLevel.value = level
    }

    fun updatePassport(uri: Uri?) {
        _passportUri.value = uri
    }

    fun saveStudentData() {
        // You can log here or save to Firebase/Room
        Log.d("StudentViewModel", "Saving: $fullName, $classLevel, $admissionNumber")
    }
}
