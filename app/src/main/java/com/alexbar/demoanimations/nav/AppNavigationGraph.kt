package com.alexbar.demoanimations.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alexbar.demoanimations.screens.list.ListScreen
import com.alexbar.demoanimations.screens.onboarding.OnboardingScreen

@Composable
fun AppNavigationGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screens.OnboardingScreen.route
    ) {
        composable(route = Screens.OnboardingScreen.route) {
            OnboardingScreen {
                navController.navigate(Screens.ListScreen.route)
            }
        }
        composable(route = Screens.ListScreen.route) {
            ListScreen ()
        }
    }
}
