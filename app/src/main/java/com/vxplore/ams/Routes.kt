package com.vxplore.ams

object Routes {
    data class Route(
        val name: String,
        val args: String = ""
    ) {
        val full get() = "$name$args"
    }

    val splash = Route("splash")
    val login = Route("login")
    val employeeDashboard= Route("empdashboard")
    val adminDashboard = Route("adminDashboard")
    val todo = Route("todo")
    val navdrawer = Route("navdrawer")
    val task = Route("task")
    val mobileteam = Route("mobileteam")
    val ourteam = Route("ourteam")
    val assigntask = Route("assigntask")
}