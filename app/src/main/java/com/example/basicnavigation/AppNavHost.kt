package com.example.basicnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.basicnavigation.home.HomeScreen
import com.example.basicnavigation.home.homeRouteNavigation
import com.example.basicnavigation.profile.ProfileScreen
import com.example.basicnavigation.profile.navigateToProfile
import com.example.basicnavigation.profile.profileRouteNavigation
import com.example.basicnavigation.settings.SettingsScreen
import com.example.basicnavigation.settings.navigateToSettings
import com.example.basicnavigation.settings.settingsArg
import com.example.basicnavigation.settings.settingsRouteNavigation

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = homeRouteNavigation
    ) {
        composable(
            route = homeRouteNavigation
        ) {
            HomeScreen(
                navigateToProfile = { navController.navigateToProfile() }
            )
        }
        composable(
            route = profileRouteNavigation
        ) {
            ProfileScreen(
                navigateToSettings = { navController.navigateToSettings(it) }
            )
        }
        composable(
            route = "$settingsRouteNavigation/{$settingsArg}",
            arguments = listOf(
                navArgument(settingsArg) { type = NavType.StringType }
            )
        ) { backStackEntry ->
            SettingsScreen(
                settingsArg = backStackEntry.arguments?.getString(settingsArg)
            )
        }
    }
}