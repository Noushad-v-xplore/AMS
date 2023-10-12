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
}