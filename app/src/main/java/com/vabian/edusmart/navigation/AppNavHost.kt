package com.vabian.edusmart.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vabian.edusmart.data.ContentDatabase
import com.vabian.edusmart.data.UserDatabase
import com.vabian.edusmart.repository.ContentRepository
import com.vabian.edusmart.repository.UserRepository
import com.vabian.edusmart.ui.theme.screens.about.AboutScreen
import com.vabian.edusmart.ui.theme.screens.contact.ContactScreen
import com.vabian.edusmart.ui.theme.screens.dashboard.AdminDashboard
import com.vabian.edusmart.ui.theme.screens.dashboard.DashboardScreen
import com.vabian.edusmart.ui.theme.screens.dashboard.ParentDashboard
import com.vabian.edusmart.ui.theme.screens.home.HomeScreen
import com.vabian.edusmart.ui.theme.screens.intent.IntentScreen
import com.vabian.edusmart.ui.theme.screens.item.ItemScreen
import com.vabian.edusmart.ui.theme.screens.more.MoreScreen
import com.vabian.edusmart.ui.theme.screens.notificaton.UploadContentScreen
import com.vabian.edusmart.ui.theme.screens.notificaton.ViewContentScreen
import com.vabian.edusmart.ui.theme.screens.outh.LoginScreen
import com.vabian.edusmart.ui.theme.screens.outh.RegisterScreen
import com.vabian.edusmart.ui.theme.screens.service.ServiceScreen
import com.vabian.edusmart.ui.theme.screens.splash.LoadingScreen
import com.vabian.edusmart.ui.theme.screens.splash.SplashScreen
import com.vabian.edusmart.ui.theme.screens.start.StartScreen
import com.vabian.edusmart.viewmodel.AuthViewModel
import com.vabian.edusmart.viewmodel.ContentViewModel


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH,





) {
    val context = LocalContext.current


    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    )
    {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUT_CONTACT) {
            ContactScreen(navController)
        }
        composable(ROUT_DASHBOARD) {
            DashboardScreen(navController)
        }
        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUT_LOADING) {
            LoadingScreen(navController)
        }
        composable(ROUT_START) {
            StartScreen(navController)
        }
        composable(ROUT_MORE) {
            MoreScreen(navController)
        }
        composable(ROUT_INTENT) {
            IntentScreen(navController)
        }
        composable(ROUT_ITEM) {
            ItemScreen(navController)
        }
        composable(ROUT_ADMINDASHBOARD) {
            AdminDashboard(navController)
        }
        composable(ROUT_PARENTDASHBOARD) {
            ParentDashboard(navController)
        }

        composable(ROUT_SERVICE) {
            ServiceScreen(navController)
        }



        //AUTHENTICATION

        // Initialize Room Database and Repository for Authentication
        val appDatabase = UserDatabase.getDatabase(context)
        val authRepository = UserRepository(appDatabase.userDao())
        val authViewModel: AuthViewModel = AuthViewModel(authRepository)
        composable(ROUT_REGISTER) {
            RegisterScreen(authViewModel, navController) {
                navController.navigate(ROUT_LOGIN) {
                    popUpTo(ROUT_REGISTER) { inclusive = true }
                }
            }
        }

        composable(ROUT_LOGIN) {
            LoginScreen(authViewModel, navController) {
                navController.navigate(ROUT_HOME) {
                    popUpTo(ROUT_LOGIN) { inclusive = true }
                }
            }
        }



       //CONTENT

// Initialize Content Database and ViewModel
        val contentDatabase = ContentDatabase.getDatabase(context)
        val contentRepository = ContentRepository(contentDatabase.contentDao())
        val contentViewModel = ContentViewModel(contentRepository)

        composable(ROUT_UPLOAD_CONTENT) {
            UploadContentScreen(navController, contentViewModel)
        }
        composable(ROUT_VIEW_CONTENT) {
            ViewContentScreen(navController, contentViewModel) { id ->
                navController.navigate("upload_content?id=$id")
            }
        }














    }
}

