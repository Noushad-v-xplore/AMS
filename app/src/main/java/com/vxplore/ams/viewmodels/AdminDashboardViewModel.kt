package com.vxplore.ams.viewmodels

import android.os.Bundle
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.debduttapanda.j3lib.ActivityService
import com.debduttapanda.j3lib.Navigation
import com.debduttapanda.j3lib.NotificationService
import com.debduttapanda.j3lib.PermissionHandler
import com.debduttapanda.j3lib.Resolver
import com.debduttapanda.j3lib.ResultingActivityHandler
import com.debduttapanda.j3lib.SoftInputMode
import com.debduttapanda.j3lib.StatusBarColor
import com.debduttapanda.j3lib.WirelessViewModelInterface

class AdminDashboardViewModel(

) :WirelessViewModelInterface,ViewModel() {
    override val navigation = Navigation()
    override val permissionHandler = PermissionHandler()
    override val resultingActivityHandler = ResultingActivityHandler()
    private val _statusBarColor = mutableStateOf<StatusBarColor?>(null)
    override val softInputMode = mutableStateOf(SoftInputMode.adjustNothing)
    override val resolver = Resolver()
    override val notifier = NotificationService { id, arg ->
        when (id) {
        }
    }


}