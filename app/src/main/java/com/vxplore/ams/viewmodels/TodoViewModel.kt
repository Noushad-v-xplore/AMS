package com.vxplore.ams.viewmodels

import androidx.compose.material3.DrawerValue
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
import com.debduttapanda.j3lib.scope
import com.vxplore.ams.MyDataIds
import com.vxplore.ams.R
import com.vxplore.ams.Routes
import com.vxplore.ams.models.CompletedList
import com.vxplore.ams.models.Drawerlist
import com.vxplore.ams.models.WorkList
import kotlinx.coroutines.launch

class TodoViewModel(


) : WirelessViewModelInterface, ViewModel() {

    override val navigation = Navigation()
    override val permissionHandler = PermissionHandler()
    override val resultingActivityHandler = ResultingActivityHandler()
    private val _statusBarColor = mutableStateOf<StatusBarColor?>(null)
    override val softInputMode = mutableStateOf(SoftInputMode.adjustPan)
    override val resolver = Resolver()
    private val note = mutableStateOf("")
    override val notifier = NotificationService { id, arg ->
        when (id) {
            /*MyDataIds.navdrawer -> {
                NavDrawer()
            }*/
            MyDataIds.note->{
                note.value = arg as String
            }
            MyDataIds.floatingDialogue -> {
                openDialog.value=!openDialog.value
            }
            MyDataIds.btnUploadclick -> {
                openDialog.value=!openDialog.value
            }
            MyDataIds.itemclick->{
                drawerlistmob.value = arg as Drawerlist
                if (drawerlistmob.value!!.text == "My Task"){
                    viewModelScope.launch {
                        navigation.scope { navHostController, lifecycleOwner, activityService ->
                            navHostController.navigate(Routes.assigntask.full)
                        }
                    }
                }
                if (drawerlistmob.value!!.text == "Teams"){
                    viewModelScope.launch {
                        navigation.scope { navHostController, lifecycleOwner, activityService ->
                            navHostController.navigate(Routes.ourteam.full)
                        }
                    }
                }
            }
        }
    }
    private val openDialog = mutableStateOf(false)
    private val overdue_list = mutableStateListOf<WorkList>()
    private val compleated_list = mutableStateListOf<CompletedList>()
    private val drawerlist = mutableStateListOf<Drawerlist>()
    private val drawerlistmob = mutableStateOf<Drawerlist?>(null)
    init {
        resolver.addAll(
            MyDataIds.statusBarColor to _statusBarColor,
            MyDataIds.floatingbtnClicked to openDialog,
            MyDataIds.note to note,
            MyDataIds.worklist to overdue_list,
            MyDataIds.compleated_list to compleated_list,
            MyDataIds.drawerlist to drawerlist,



        )
        _statusBarColor.value = StatusBarColor(
            color = Color.White,
            darkIcons = true
        )
        viewModelScope.launch {

            overdue_list.add(WorkList("Exoticamp Payment Gateway in Monday", "Rohit and Satam","Monday, 22 Aug","High"))
            overdue_list.add(WorkList("Exoticamp Payment Gateway in Monday", "Bipul and Avay","Monday, 22 Aug","High"))
            overdue_list.add(WorkList("Exoticamp Payment Gateway in Monday", "Sayan and Ram","Monday, 22 Aug","Medium"))
            overdue_list.add(WorkList("Exoticamp Payment Gateway in Monday", "Kohli and Rahul","Monday, 22 Aug","High"))

            compleated_list.add(CompletedList("Jaya Industry Vendor App Changes"))
            compleated_list.add(CompletedList("Jaya Industry Gateman Changes"))
            compleated_list.add(CompletedList("Jaya Industry Vendor App Changes"))
            compleated_list.add(CompletedList("Jaya Industry Gateman Changes"))

            drawerlist.add(Drawerlist(R.drawable.myhome,"Home"))
            drawerlist.add(Drawerlist(R.drawable.dotmenu,"My Task"))
            drawerlist.add(Drawerlist(R.drawable.inbox,"Inbox"))
            drawerlist.add(Drawerlist(R.drawable.rocket,"Projects"))
            drawerlist.add(Drawerlist(R.drawable.report,"Reports"))
            drawerlist.add(Drawerlist(R.drawable.goal,"Goals"))
            drawerlist.add(Drawerlist(R.drawable.employee,"Employees"))
            drawerlist.add(Drawerlist(R.drawable.team,"Teams"))
            drawerlist.add(Drawerlist(R.drawable.settings,"Settings"))
        }

    }
   /* private fun NavDrawer(){
        viewModelScope.launch {
            DrawerValue.Open
            navigation.scope { navHostController, lifecycleOwner, activityService ->
                navHostController.navigate(Routes.navdrawer.full)
            }
        }


    }*/
    /*fun openNavigationDrawer(navigationDrawerScreen: NavigationDrawerScreen) {
        navigationDrawerScreen.openDrawer()
    }*/

        }
