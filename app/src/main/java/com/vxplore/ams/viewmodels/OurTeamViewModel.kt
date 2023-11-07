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
import com.vxplore.ams.R
import com.vxplore.ams.Routes
import com.vxplore.ams.models.Drawerlist
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
            "backourteam"->{
                navigation.scope { navHostController, lifecycleOwner, activityService ->
                    navHostController.popBackStack()
                }
            }
            MyDataIds.clickOnMobileTeam->{
                clickOnMobileTeam.value = arg as teamName
                if (clickOnMobileTeam.value!!.team == "Mobile App Team"){
                    viewModelScope.launch {
                        navigation.scope { navHostController, lifecycleOwner, activityService ->
                            navHostController.navigate(Routes.mobileteam.full)
                        }
                    }
                }
            }
            MyDataIds.itemclick->{
                drawerlistapp.value = arg as Drawerlist
                if (drawerlistapp.value!!.text == "My Task"){
                    viewModelScope.launch {
                        navigation.scope { navHostController, lifecycleOwner, activityService ->
                            navHostController.navigate(Routes.assigntask.full)
                        }
                    }
                }
                if (drawerlistapp.value!!.text == "Teams"){
                    viewModelScope.launch {
                        navigation.scope { navHostController, lifecycleOwner, activityService ->
                            navHostController.navigate(Routes.ourteam.full)
                        }
                    }
                }
            }
        }
    }

    private val teamName = mutableStateListOf<teamName>()
    private val teamList = mutableStateListOf<teamList>()
    private val drawerlistInapp = mutableStateListOf<Drawerlist>()
    private val drawerlistapp = mutableStateOf<Drawerlist?>(null)
    private val clickOnMobileTeam = mutableStateOf<teamName?>(null)
    init {
        resolver.addAll(
            DataIds.statusBarColor to _statusBarColor,
            MyDataIds.teamName to teamName,
            MyDataIds.teamList to teamList,
            MyDataIds.drawerlist to drawerlistInapp
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


            drawerlistInapp.add(Drawerlist(R.drawable.myhome,"Home"))
            drawerlistInapp.add(Drawerlist(R.drawable.dotmenu,"My Task"))
            drawerlistInapp.add(Drawerlist(R.drawable.inbox,"Inbox"))
            drawerlistInapp.add(Drawerlist(R.drawable.rocket,"Projects"))
            drawerlistInapp.add(Drawerlist(R.drawable.report,"Reports"))
            drawerlistInapp.add(Drawerlist(R.drawable.goal,"Goals"))
            drawerlistInapp.add(Drawerlist(R.drawable.employee,"Employees"))
            drawerlistInapp.add(Drawerlist(R.drawable.team,"Teams"))
            drawerlistInapp.add(Drawerlist(R.drawable.settings,"Settings"))

        }
    }
}