package com.example.basicnavigation.profile

import androidx.navigation.NavController

const val profileRouteNavigation = "profile_route"

fun NavController.navigateToProfile() {
    this.navigate(profileRouteNavigation)
}