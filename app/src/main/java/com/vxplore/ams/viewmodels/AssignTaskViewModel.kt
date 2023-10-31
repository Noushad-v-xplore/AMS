package com.vxplore.ams.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.debduttapanda.j3lib.Navigation
import com.debduttapanda.j3lib.NotificationService
import com.debduttapanda.j3lib.PermissionHandler
import com.debduttapanda.j3lib.Resolver
import com.debduttapanda.j3lib.ResultingActivityHandler
import com.debduttapanda.j3lib.SoftInputMode
import com.debduttapanda.j3lib.StatusBarColor
import com.debduttapanda.j3lib.WirelessViewModelInterface
import com.vxplore.ams.MyDataIds
import com.vxplore.ams.models.CompletedList
import com.vxplore.ams.models.Subtasklist
import com.vxplore.ams.models.WorkList
import kotlinx.coroutines.launch

class AssignTaskViewModel(


) : WirelessViewModelInterface, ViewModel() {

    override val navigation = Navigation()
    override val permissionHandler = PermissionHandler()
    override val resultingActivityHandler = ResultingActivityHandler()
    private val _statusBarColor = mutableStateOf<StatusBarColor?>(null)
    override val softInputMode = mutableStateOf(SoftInputMode.adjustPan)
    override val resolver = Resolver()
    private val description = mutableStateOf("")
    override val notifier = NotificationService { id, arg ->
        when (id) {
            MyDataIds.description -> {
                description.value = arg as String
            }
            MyDataIds.addsubtask -> {
                subtasklist.add(Subtasklist("hello this is status"))
            }

        }
    }
    private val taskitems = mutableStateListOf<String>()
    private val projectitems = mutableStateListOf<String>()
    private val subtasklist = mutableStateListOf<Subtasklist>()


    init {
        resolver.addAll(
            MyDataIds.statusBarColor to _statusBarColor,
            MyDataIds.description to description,
            MyDataIds.taskitems to taskitems,
            MyDataIds.projectitems to projectitems,
            MyDataIds.subtasklist to subtasklist


            )
        _statusBarColor.value = StatusBarColor(
            color = Color.White,
            darkIcons = true
        )
        viewModelScope.launch {
            taskitems.add("Recently assigned")
            taskitems.add("Not assigned")

            projectitems.add("Farmology Project")
            projectitems.add("Bikrimart Project")

            subtasklist.add(Subtasklist("hello this is status" ))

        }


    }

    fun addSubtask(subtask: Subtasklist) {
        subtasklist.add(subtask)
    }

}