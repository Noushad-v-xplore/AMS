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
import com.vxplore.ams.models.teamList
import com.vxplore.ams.models.teamName
import kotlinx.coroutines.launch

class OurTeamViewModel(
) : WirelessViewModelInterface, ViewModel() {
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

    private val teamName = mutableStateListOf<teamName>()
    private val teamList = mutableStateListOf<teamList>()
    init {
        resolver.addAll(
            DataIds.statusBarColor to _statusBarColor,
            MyDataIds.teamName to teamName,
            MyDataIds.teamList to teamList,
            )
        _statusBarColor.value = StatusBarColor(
            color = Color.White,
            darkIcons = true
        )
        viewModelScope.launch {
            teamName.add(teamName("Mobile App Team"))
            teamName.add(teamName("Backend Developer"))


            teamList.add(
                teamList(
                    "Present",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Virat_Kohli_portrait.jpg/566px-Virat_Kohli_portrait.jpg"
                )
            )
            teamList.add(
                teamList(
                    "Present",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Virat_Kohli_portrait.jpg/566px-Virat_Kohli_portrait.jpg"
                )
            )
            teamList.add(
                teamList(
                    "Leave",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Virat_Kohli_portrait.jpg/566px-Virat_Kohli_portrait.jpg"
                )
            )
            teamList.add(
                teamList(
                    "Absent",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Virat_Kohli_portrait.jpg/566px-Virat_Kohli_portrait.jpg"
                )
            )
            teamList.add(
                teamList(
                    "Present",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Virat_Kohli_portrait.jpg/566px-Virat_Kohli_portrait.jpg"
                )
            )
            teamList.add(
                teamList(
                    "Present",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Virat_Kohli_portrait.jpg/566px-Virat_Kohli_portrait.jpg"
                )
            )
            teamList.add(
                teamList(
                    "Present",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Virat_Kohli_portrait.jpg/566px-Virat_Kohli_portrait.jpg"
                )
            )
            teamList.add(
                teamList(
                    "Present",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Virat_Kohli_portrait.jpg/566px-Virat_Kohli_portrait.jpg"
                )
            )
            teamList.add(
                teamList(
                    "Present",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Virat_Kohli_portrait.jpg/566px-Virat_Kohli_portrait.jpg"
                )
            )
            teamList.add(
                teamList(
                    "Present",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Virat_Kohli_portrait.jpg/566px-Virat_Kohli_portrait.jpg"
                )
            )

        }
    }
}