package com.vabian.edusmart.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vabian.edusmart.data.UserDatabase
import com.vabian.edusmart.repository.UserRepository
import com.vabian.edusmart.ui.theme.screens.about.AboutScreen
import com.vabian.edusmart.ui.theme.screens.contact.ContactScreen
import com.vabian.edusmart.ui.theme.screens.home.HomeScreen
import com.vabian.edusmart.ui.theme.screens.intent.IntentScreen
import com.vabian.edusmart.ui.theme.screens.item.ItemScreen
import com.vabian.edusmart.ui.theme.screens.outh.LoginScreen
import com.vabian.edusmart.ui.theme.screens.outh.RegisterScreen
import com.vabian.edusmart.ui.theme.screens.outh.StudentRegisterScreen
import com.vabian.edusmart.ui.theme.screens.splash.LoadingScreen
import com.vabian.edusmart.ui.theme.screens.splash.SplashScreen
import com.vabian.edusmart.viewmodel.AuthViewModel



@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH
) {
    val context = LocalContext.current


    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
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
                navController.navigate(ROUT_STUDENT) {
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

        composable(ROUT_STUDENT) {
            LoginScreen(authViewModel, navController) {
                navController.navigate(ROUT_LOGIN) {
                    popUpTo(ROUT_STUDENT) { inclusive = true }
                }
            }
        }

    }
}

@Composable
fun StartScreen(x0: NavHostController) {
    TODO("Not yet implemented")
}

@Composable
fun MoreScreen(x0: NavHostController) {
    TODO("Not yet implemented")
}

@Composable
fun ServiceScreen(x0: NavHostController) {
    TODO("Not yet implemented")
}

@Composable
fun DashboardScreen(x0: NavHostController) {
    TODO("Not yet implemented")
}
