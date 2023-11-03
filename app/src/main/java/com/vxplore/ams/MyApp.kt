package com.vxplore.ams

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.debduttapanda.j3lib.MyScreen
import com.vxplore.ams.screens.AdminDashBoard
import com.vxplore.ams.screens.AssignTaskScreen
import com.vxplore.ams.screens.EmployeeDashBoard
import com.vxplore.ams.screens.LoginScreen
import com.vxplore.ams.screens.MobileTeamScreen
import com.vxplore.ams.screens.OurTeamScreen
import com.vxplore.ams.screens.SplashScreen
import com.vxplore.ams.screens.TaskScreen
import com.vxplore.ams.screens.TodoScreen
import com.vxplore.ams.viewmodels.AdminDashboardViewModel
import com.vxplore.ams.viewmodels.AssignTaskViewModel
import com.vxplore.ams.viewmodels.EmployeeDashboardViewModel
import com.vxplore.ams.viewmodels.LoginViewModel
import com.vxplore.ams.viewmodels.MobileTeamViewModel
import com.vxplore.ams.viewmodels.OurTeamViewModel
import com.vxplore.ams.viewmodels.SplashViewModel
import com.vxplore.ams.viewmodels.TaskViewModel
import com.vxplore.ams.viewmodels.TodoViewModel

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(
        navController,
        startDestination = Routes.task.full
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

        MyScreen(
            navController = navController,
            route = Routes.todo.full,
            { viewModel<TodoViewModel>() }
        ) {
            TodoScreen()

        }
      /*  MyScreen(
            navController = navController,
            route = Routes.navdrawer.full,
            { viewModel<LoginViewModel>() }
        ) {
            NavigationScreen()
        }*/
        MyScreen(
            navController = navController,
            route = Routes.task.full,
            { viewModel<TaskViewModel>() }
        ) {
            TaskScreen()

        }
        MyScreen(
            navController = navController,
            route = Routes.mobileteam.full,
            { viewModel<MobileTeamViewModel>() }
        ) {
            MobileTeamScreen()

        }
        MyScreen(
            navController = navController,
            route = Routes.ourteam.full,
            { viewModel<OurTeamViewModel>() }
        ) {
            OurTeamScreen()

        }

        MyScreen(
            navController = navController,
            route = Routes.assigntask.full,
            { viewModel<AssignTaskViewModel>() }
        ) {
            AssignTaskScreen()

        }
    }
}