package com.vxplore.ams.viewmodels

import androidx.compose.runtime.mutableStateListOf
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
import com.vxplore.ams.models.Taskitem
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
            "backtask"->{
                navigation.scope { navHostController, lifecycleOwner, activityService ->
                    navHostController.popBackStack()
                }
            }
            MyDataIds.note->{
                note.value = arg as String
            }
            MyDataIds.clickstep->{
                addstepbtnclicked.value =! addstepbtnclicked.value
            }
            MyDataIds.nexttaskbtn->{
                addstepbtnclicked.value =! addstepbtnclicked.value
            }
        }
    }
    private val taskitem = mutableStateListOf<Taskitem>()
    private val addstepbtnclicked = mutableStateOf(false)
    private val nexttaskbtn = mutableStateOf(false)
    init {
        resolver.addAll(
            DataIds.statusBarColor to _statusBarColor,
            MyDataIds.note to note,
            MyDataIds.stepitem to taskitem,
            MyDataIds.addstepbtnclicked to addstepbtnclicked,
            MyDataIds.nexttaskbtn to nexttaskbtn


            )
        _statusBarColor.value = StatusBarColor(
            color = Color.White,
            darkIcons = true
        )
        viewModelScope.launch {
            taskitem.add(Taskitem("Sub Task 1"))
            taskitem.add(Taskitem("Sub Task 2"))
            taskitem.add(Taskitem("Sub Task 3"))

        }

    }
}