package com.cidadelimpa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cidadelimpa.components.screens.HistoryPage
import com.cidadelimpa.components.screens.HomePage
import com.cidadelimpa.components.screens.LoginPage
import com.cidadelimpa.components.screens.SignUpPage
import com.cidadelimpa.components.screens.WelcomePage
import com.cidadelimpa.ui.theme.CidadeLimpaTheme
import com.cidadelimpa.view_model.LoginViewModel
import com.cidadelimpa.view_model.SignUpViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CidadeLimpaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "history"
                    ) {
                        composable(route = "welcome") { WelcomePage(navController) }
                        composable(route = "login") { LoginPage(navController, LoginViewModel()) }
                        composable(route = "sign_up") { SignUpPage(navController, SignUpViewModel()) }
                        composable(route = "home") { HomePage(navController) }
                        composable(route = "history") { HistoryPage(navController) }
                    }
                }
            }
        }
    }
}