package com.example.basicnavigation.settings

import androidx.navigation.NavController

const val settingsArg = "settingsArg"

const val settingsRouteNavigation = "settings_route"

fun NavController.navigateToSettings(settingsArg: String) {
    this.navigate("$settingsRouteNavigation/$settingsArg")
}