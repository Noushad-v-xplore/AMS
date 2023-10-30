package com.vxplore.ams.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.debduttapanda.j3lib.DataIds
import com.debduttapanda.j3lib.Navigation
import com.debduttapanda.j3lib.NotificationService
import com.debduttapanda.j3lib.PermissionHandler
import com.debduttapanda.j3lib.Resolver
import com.debduttapanda.j3lib.ResultingActivityHandler
import com.debduttapanda.j3lib.SoftInputMode
import com.debduttapanda.j3lib.StatusBarColor
import com.debduttapanda.j3lib.WirelessViewModelInterface
import com.debduttapanda.j3lib.scope
import com.vxplore.ams.MyDataIds
import com.vxplore.ams.Routes
import kotlinx.coroutines.launch

class TaskViewModel (
): WirelessViewModelInterface, ViewModel() {
    override val navigation = Navigation()
    override val permissionHandler = PermissionHandler()
    override val resultingActivityHandler = ResultingActivityHandler()
    private val _statusBarColor = mutableStateOf<StatusBarColor?>(null)
    override val softInputMode = mutableStateOf(SoftInputMode.adjustPan)
    override val resolver = Resolver()
    private val note = mutableStateOf("")
    override val notifier = NotificationService { id, arg ->
        when (id) {
            MyDataIds.note->{
                note.value = arg as String
            }
        }
    }
    init {
        resolver.addAll(
            DataIds.statusBarColor to _statusBarColor,
            MyDataIds.note to note


            )
        _statusBarColor.value = StatusBarColor(
            color = Color.White,
            darkIcons = true
        )

    }
}