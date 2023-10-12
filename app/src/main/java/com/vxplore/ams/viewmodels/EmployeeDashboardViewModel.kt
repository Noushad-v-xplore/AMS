package com.vxplore.ams.viewmodels

import android.os.Bundle
import androidx.compose.runtime.MutableState
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.debduttapanda.j3lib.ActivityService
import com.debduttapanda.j3lib.NotificationService
import com.debduttapanda.j3lib.PermissionHandler
import com.debduttapanda.j3lib.Resolver
import com.debduttapanda.j3lib.ResultingActivityHandler
import com.debduttapanda.j3lib.WirelessViewModelInterface

class EmployeeDashboardViewModel(
    override val navigation: MutableState<(suspend Bundle.(NavHostController, LifecycleOwner, ActivityService?) -> Unit)?>,
    override val notifier: NotificationService,
    override val permissionHandler: PermissionHandler,
    override val resolver: Resolver,
    override val resultingActivityHandler: ResultingActivityHandler,
    override val softInputMode: MutableState<Int>
) :WirelessViewModelInterface,ViewModel() {
}