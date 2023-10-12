package com.vxplore.ams

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.debduttapanda.j3lib.MyScreen
import com.vxplore.ams.screens.AdminDashBoard
import com.vxplore.ams.screens.EmployeeDashBoard
import com.vxplore.ams.screens.LoginScreen
import com.vxplore.ams.screens.SplashScreen
import com.vxplore.ams.viewmodels.AdminDashboardViewModel
import com.vxplore.ams.viewmodels.EmployeeDashboardViewModel
import com.vxplore.ams.viewmodels.LoginViewModel
import com.vxplore.ams.viewmodels.SplashViewModel

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(
        navController,
        startDestination = Routes.adminDashboard.full
    ) {
        MyScreen(
            navController = navController,
            route = Routes.splash.full,
            { viewModel<SplashViewModel>() }
        ) {
            SplashScreen()
        }
        MyScreen(
            navController = navController,
            route = Routes.login.full,
            { viewModel<LoginViewModel>() }
        ) {
            LoginScreen()
        }
        MyScreen(
            navController = navController,
            route = Routes.employeeDashboard.full,
            { viewModel<EmployeeDashboardViewModel>() }
        ) {
            EmployeeDashBoard()
        }
        MyScreen(
            navController = navController,
            route = Routes.adminDashboard.full,
            { viewModel<AdminDashboardViewModel>() }
        ) {
            AdminDashBoard()
        }
    }
}