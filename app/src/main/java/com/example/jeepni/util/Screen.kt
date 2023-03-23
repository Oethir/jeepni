package com.example.jeepni.util

sealed class Screen(val route : String) {

    object MainScreen : Screen("main_screen")
    object WelcomeScreen : Screen("welcome_screen")
    object LogInScreen : Screen("login_screen")
    object SignUpScreen: Screen("signup_screen")
    object AnalyticsScreen : Screen("analytics_screen")
    object CheckUpScreen : Screen ("checkup_screen")
    object ProfileScreen : Screen("profile_screen")


    fun withArgs(vararg args : String) : String {
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}
