package com.vxplore.ams.viewmodels

import android.net.Uri
import android.util.Log
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
import com.vxplore.ams.models.Assigntasklist
import com.vxplore.ams.models.Comment
import com.vxplore.ams.models.Commentlist
import com.vxplore.ams.models.SelectedFile
import com.vxplore.ams.models.Subtasklist
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
    private val questionfield = mutableStateOf("")
    override val notifier = NotificationService { id, arg ->
        when (id) {
            "backassigntask"->{
                navigation.scope { navHostController, lifecycleOwner, activityService ->
                    navHostController.popBackStack()
                }
            }
            MyDataIds.description -> {
                description.value = arg as String
            }
            MyDataIds.questionfield -> {
                questionfield.value = arg as String
            }
            MyDataIds.addsubtask -> {
                subtasklist.add(Subtasklist("hello this is status"))
            }
            MyDataIds.onclickaddbtn -> {

            }
            MyDataIds.cmntbtn -> {
                item.value = arg as String
                val split= item.value.split("+")
                Log.d("bcvjh","$split")
                cmnt.value = split[0]
                emoji.value = split[1]
                assigntasklist.add(Assigntasklist("","", Comment(cmnt.value,emoji.value)))
            }
            MyDataIds.btnBack->{
                navigation.scope { navHostController, lifecycleOwner, activityService ->
                    navHostController.popBackStack()
                }
            }

        }
    }
    private val taskitems = mutableStateListOf<String>()
    private val projectitems = mutableStateListOf<String>()
    private val subtasklist = mutableStateListOf<Subtasklist>()
    private val assigntasklist = mutableStateListOf<Assigntasklist>()
    private val commentlist = mutableStateListOf<Commentlist>()
    private val item = mutableStateOf("")
    private val cmnt = mutableStateOf("")
    private val emoji = mutableStateOf("")
    private val imglist = mutableStateListOf<String>()
    private val selectedFiles = mutableStateListOf<SelectedFile>()



    init {
        resolver.addAll(
            MyDataIds.statusBarColor to _statusBarColor,
            MyDataIds.description to description,
            MyDataIds.taskitems to taskitems,
            MyDataIds.projectitems to projectitems,
            MyDataIds.subtasklist to subtasklist,
            MyDataIds.assigntasklist to assigntasklist,
            MyDataIds.commentlist to commentlist,
            MyDataIds.questionfield to questionfield,
            MyDataIds.imglist to imglist,
            MyDataIds.selectedFiles to selectedFiles,



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

            assigntasklist.add(Assigntasklist("Debdutta Panda added to Bikrimart Project","19 Jul 2021", Comment(cmnt.value,emoji.value)))
            assigntasklist.add(Assigntasklist("Debdutta Panda added to Bikrimart Project","19 Jul 2021",Comment(cmnt.value,emoji.value)))
            assigntasklist.add(Assigntasklist("Debdutta Panda changed the due date to 20 Jul 2021","19 Jul 2021",Comment(cmnt.value,emoji.value)))

            commentlist.add(Commentlist("Thanks, on it!","https://t4.ftcdn.net/jpg/04/89/39/47/360_F_489394725_Oox6jg48u2K0FSk4RlPCzqkU7Qvu2BSu.jpg"))
            commentlist.add(Commentlist("I have a question...",""))
            commentlist.add(Commentlist("Mind if I changed it...",""))
            commentlist.add(Commentlist("No problem...",""))
            commentlist.add(Commentlist("Done...",""))

            imglist.add("https://img.freepik.com/free-psd/google-icon-isolated-3d-render-illustration_47987-9777.jpg")
            imglist.add("https://img.freepik.com/free-psd/google-icon-isolated-3d-render-illustration_47987-9777.jpg")
            imglist.add("https://img.freepik.com/free-psd/google-icon-isolated-3d-render-illustration_47987-9777.jpg")
            imglist.add("https://img.freepik.com/free-psd/google-icon-isolated-3d-render-illustration_47987-9777.jpg")
            imglist.add("https://img.freepik.com/free-psd/google-icon-isolated-3d-render-illustration_47987-9777.jpg")
            imglist.add("https://img.freepik.com/free-psd/google-icon-isolated-3d-render-illustration_47987-9777.jpg")
            imglist.add("https://img.freepik.com/free-psd/google-icon-isolated-3d-render-illustration_47987-9777.jpg")



        }


    }

    fun addSubtask(subtask: Subtasklist) {
        subtasklist.add(subtask)
    }

}