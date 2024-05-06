package com.lennyrbriones.cronoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lennyrbriones.cronoapp.views.AddView
import com.lennyrbriones.cronoapp.views.EditView
import com.lennyrbriones.cronoapp.views.HomeView

@Composable
fun NavManager(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home"){
            HomeView(navController)
        }
        composable("AddView"){
            AddView(navController)
        }
        composable("EditView"){
            EditView(navController)
        }
    }
}