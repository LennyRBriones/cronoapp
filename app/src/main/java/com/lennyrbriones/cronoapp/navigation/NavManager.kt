package com.lennyrbriones.cronoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lennyrbriones.cronoapp.viewModels.CronometerViewModel
import com.lennyrbriones.cronoapp.views.AddView
import com.lennyrbriones.cronoapp.views.EditView
import com.lennyrbriones.cronoapp.views.HomeView

@Composable
fun NavManager(cronometerVM : CronometerViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home"){
            HomeView(navController)
        }
        composable("AddView"){
            AddView(navController, cronometerVM)
        }
        composable("EditView"){
            EditView(navController)
        }
    }
}