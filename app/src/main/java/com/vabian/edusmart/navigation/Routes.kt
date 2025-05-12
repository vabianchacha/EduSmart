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
const val ROUT_ADMIN_VIEW = "admin_content"




//Products6

const val ROUT_ADD_PRODUCT = "add_product"
const val ROUT_PRODUCT_LIST = "product_list"
const val ROUT_EDIT_PRODUCT = "edit_product/{productId}"

// ✅ Helper function for navigation
fun editProductRoute(productId: Int) = "edit_product/$productId"


