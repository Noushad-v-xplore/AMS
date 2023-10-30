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
            MyDataIds.navdrawer -> {
                NavDrawer()
            }
            MyDataIds.note->{
                note.value = arg as String
            }
            MyDataIds.floatingDialogue -> {
                openDialog.value=!openDialog.value
                //floatingDialogue()
            }
            MyDataIds.btnUploadclick -> {
                openDialog.value=!openDialog.value
                //floatingDialogue()
            }
        }
    }
    private val openDialog = mutableStateOf(false)
    private val overdue_list = mutableStateListOf<WorkList>()
    private val compleated_list = mutableStateListOf<CompletedList>()
    init {
        resolver.addAll(
            MyDataIds.statusBarColor to _statusBarColor,
            MyDataIds.floatingbtnClicked to openDialog,
            MyDataIds.note to note,
            MyDataIds.worklist to overdue_list,
            MyDataIds.compleated_list to compleated_list



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
        }



    }
    private fun NavDrawer(){
        /*viewModelScope.launch {
            navigation.scope { navHostController, lifecycleOwner, activityService ->
                navHostController.navigate(Routes.navdrawer.full)
            }
        }*/


    }

        }
