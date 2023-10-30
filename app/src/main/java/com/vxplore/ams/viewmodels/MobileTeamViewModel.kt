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
import com.vxplore.ams.MyDataIds
import com.vxplore.ams.models.attendenceList
import com.vxplore.ams.models.taskList
import kotlinx.coroutines.launch

class MobileTeamViewModel  (
): WirelessViewModelInterface, ViewModel() {
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
    private val attendenceList = mutableStateListOf<attendenceList>()
    private val taskList = mutableStateListOf<taskList>()
    private val cmntList = mutableStateListOf<String>()
    init {
        resolver.addAll(
            DataIds.statusBarColor to _statusBarColor,
            MyDataIds.attendenceList to attendenceList,
            MyDataIds.taskList to taskList,
            MyDataIds.cmntList to cmntList


            )
        _statusBarColor.value = StatusBarColor(
            color = Color.White,
            darkIcons = true
        )
        viewModelScope.launch {
            attendenceList.add(
                attendenceList(
                    "Present",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/PM_Modi_2015.jpg/450px-PM_Modi_2015.jpg"
                )
            )
            attendenceList.add(
                attendenceList(
                    "Present",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/PM_Modi_2015.jpg/450px-PM_Modi_2015.jpg"
                )
            )
            attendenceList.add(
                attendenceList(
                    "Leave",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/PM_Modi_2015.jpg/450px-PM_Modi_2015.jpg"
                )
            )
            attendenceList.add(
                attendenceList(
                    "Absent",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/PM_Modi_2015.jpg/450px-PM_Modi_2015.jpg"
                )
            )
            attendenceList.add(
                attendenceList(
                    "Present",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/PM_Modi_2015.jpg/450px-PM_Modi_2015.jpg"
                )
            )
            attendenceList.add(
                attendenceList(
                    "Present",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/PM_Modi_2015.jpg/450px-PM_Modi_2015.jpg"
                )
            )
            attendenceList.add(
                attendenceList(
                    "Leave",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/PM_Modi_2015.jpg/450px-PM_Modi_2015.jpg"
                )
            )
            attendenceList.add(
                attendenceList(
                    "Absent",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/PM_Modi_2015.jpg/450px-PM_Modi_2015.jpg"
                )
            )
            attendenceList.add(
                attendenceList(
                    "Present",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/PM_Modi_2015.jpg/450px-PM_Modi_2015.jpg"
                )
            )
            attendenceList.add(
                attendenceList(
                    "Absent",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/PM_Modi_2015.jpg/450px-PM_Modi_2015.jpg"
                )
            )
            attendenceList.add(
                attendenceList(
                    "Present",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/PM_Modi_2015.jpg/450px-PM_Modi_2015.jpg"
                )
            )
            attendenceList.add(
                attendenceList(
                    "Present",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/9/90/PM_Modi_2015.jpg/450px-PM_Modi_2015.jpg"
                )
            )



            taskList.add(
                taskList(
                    "Rohit Manna",
                    "2hr 30m",
                    "Prescription Features",
                    "InstaHealth",
                    "Single Page Application(SPA) and SEO compatibility and Management RnD",
                    "12",
                    "8/20",
                    "2",
                    "24 March"
                )
            )
            taskList.add(
                taskList(
                    "Pappu Kumar",
                    "1hr 30m",
                    "Fixes",
                    "Farmology",
                    "Single Page Application(SPA) and SEO compatibility and Management RnD",
                    "12",
                    "12/20",
                    "4",
                    "24 March"
                )
            )




            cmntList.add("https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Virat_Kohli_portrait.jpg/566px-Virat_Kohli_portrait.jpg")
            cmntList.add("https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Virat_Kohli_portrait.jpg/566px-Virat_Kohli_portrait.jpg")
            cmntList.add("https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Virat_Kohli_portrait.jpg/566px-Virat_Kohli_portrait.jpg")
            cmntList.add("https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Virat_Kohli_portrait.jpg/566px-Virat_Kohli_portrait.jpg")
            cmntList.add("https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Virat_Kohli_portrait.jpg/566px-Virat_Kohli_portrait.jpg")
            cmntList.add("https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Virat_Kohli_portrait.jpg/566px-Virat_Kohli_portrait.jpg")
            cmntList.add("https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Virat_Kohli_portrait.jpg/566px-Virat_Kohli_portrait.jpg")
            cmntList.add("https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Virat_Kohli_portrait.jpg/566px-Virat_Kohli_portrait.jpg")
        }

    }
}