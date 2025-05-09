package com.vabian.edusmart.navigation

const val ROUT_HOME = "home"
const val ROUT_ABOUT = "about"
const val ROUT_CONTACT = "contact"

const val ROUT_REGISTER = "register"
const val ROUT_LOGIN = "login"


const val ROUT_DASHBOARD = "dashboard"
const val ROUT_ADMINDASHBOARD = "admindashboard"
const val ROUT_SPLASH = "splash"
const val ROUT_LOADING = "loading"
const val ROUT_START = "start"
const val ROUT_MORE = "more"
const val ROUT_INTENT = "intent"
const val ROUT_SERVICE = "service"
const val ROUT_ITEM = "item"
const val ROUT_PARENTDASHBOARD = "parent"


//Content
const val ROUT_UPLOAD_CONTENT = "upload_content"
const val ROUT_VIEW_CONTENT = "view_content"



//student

const val ROUT_ADD_STUDENT = "add_student"
const val ROUT_STUDENT_LIST = "student_list"
const val ROUT_EDIT_STUDENT = "edit_student/{admissionNumber}"


// ✅ Helper function for navigation
fun editStudentRoute(admissionNumber: Int) = "edit_student/$admissionNumber"

