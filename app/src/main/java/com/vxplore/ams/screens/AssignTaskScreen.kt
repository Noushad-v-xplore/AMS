package com.vxplore.ams.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.debduttapanda.j3lib.NotificationService
import com.debduttapanda.j3lib.dep
import com.debduttapanda.j3lib.depx
import com.debduttapanda.j3lib.listState
import com.debduttapanda.j3lib.notifier
import com.debduttapanda.j3lib.sep
import com.debduttapanda.j3lib.stringState
import com.vxplore.ams.MyDataIds
import com.vxplore.ams.R
import com.vxplore.ams.models.Subtasklist
import com.vxplore.ams.ui.theme.Box_Blue
import com.vxplore.ams.ui.theme.Date_red
import com.vxplore.ams.ui.theme.Extra_light_Gray
import com.vxplore.ams.ui.theme.White_Background


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssignTaskScreen(
    description: State<String> = stringState(key = MyDataIds.description),
    subtasklist: SnapshotStateList<Subtasklist> = listState(key = MyDataIds.subtasklist),
    notifier: NotificationService = com.debduttapanda.j3lib.notifier(),
) {

    /*  var isDropdownVisible by remember { mutableStateOf(false) }
      var selectedItem by remember { mutableStateOf("Recently assigned") }
      val items = listOf("Option 1", "Option 2", "Option 3")*/

    //var subtaskLists by remember { mutableStateOf(listOf<Subtasklist>()) }
    Box(
        modifier = Modifier
            .background(Color(0xFFFBFBFB))
            .fillMaxSize(),
    ) {
        Column(
            //horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
            //.verticalScroll(rememberScrollState())
        ) {

            Row(
                modifier = Modifier
                    .background(Color(0xFFFBFBFB))
                    .padding(horizontal = 16.dep)
                    .height(54.dep)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = stringResource(id = R.string.back),
                    modifier = Modifier
                        .height(20.dep)
                        .width(20.dep)
                        .clickable {


                            Log.d("cdc", "clicked")
                        }

                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.tik),
                        contentDescription = stringResource(id = R.string.ok),
                        modifier = Modifier
                            .padding(end = 16.dep)
                            .height(20.dep)
                            .width(20.dep)
                            .clickable {


                                Log.d("cdc", "clicked")
                            }

                    )
                    Image(
                        painter = painterResource(id = R.drawable.thumb),
                        contentDescription = stringResource(id = R.string.favorite),
                        modifier = Modifier
                            .padding(end = 16.dep)
                            .height(20.dep)
                            .width(18.dep)
                            .clickable {


                                Log.d("cdc", "clicked")
                            }

                    )
                    Image(
                        painter = painterResource(id = R.drawable.share),
                        contentDescription = stringResource(id = R.string.share),
                        modifier = Modifier
                            .padding(end = 16.dep)
                            .height(20.dep)
                            .width(20.dep)
                            .clickable {


                                Log.d("cdc", "clicked")
                            }

                    )

                    Image(
                        painter = painterResource(id = R.drawable.dot),
                        contentDescription = stringResource(id = R.string.settings),
                        modifier = Modifier
                            .height(20.dep)
                            .width(20.dep)
                            .clickable {


                                Log.d("cdc", "clicked")
                            }

                    )
                }

            }
            Card(
                modifier = Modifier
                    //.background(color = Color(0xFFF9F9F9))
                    .height(1.dep)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(4.dep),
                colors = CardDefaults.cardColors(Color(0xFF00000029))
            )
            {}


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    //.height(200.dep)
                    .padding(bottom = 50.dep)
                    .verticalScroll(rememberScrollState())
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 8.dep, start = 16.dep)
                        .fillMaxWidth()
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier

                            .height(28.dep)
                            .width(28.dep)
                            .border(1.dep, Color(0xFFEFEFEF), CircleShape)
                            .clip(CircleShape)
                            .background(Color(0xFFFFC000))

                    ) {
                        AsyncImage(
                            model = R.drawable.person, contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(16.dep)
                                .width(16.dep)
                        )

                    }
                    Column {
                        Text(
                            text = stringResource(id = R.string.assigned_to),
                            fontSize = 10.sep,
                            color = Color(0xFF6D6D6D),
                            modifier = Modifier
                                .padding(start = 8.dep)
                        )


                        Text(
                            text = "vik",
                            fontSize = 12.sep,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(start = 8.dep)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 28.dep)
                    ) {
                        Text(
                            text = stringResource(id = R.string.my_tasks),
                            fontSize = 10.sep,
                            color = Color(0xFF6D6D6D),
                            modifier = Modifier
                                .padding(start = 8.dep)
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            TaskDropdown()
                        }
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 12.dep, start = 16.dep)
                        .fillMaxWidth()
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier

                            .height(28.dep)
                            .width(28.dep)
                            .border(.5.dep, Date_red, CircleShape)
                            .clip(CircleShape)
                            .background(Color(0xFFFBFBFB))

                    ) {
                        AsyncImage(
                            model = R.drawable.assigndate,
                            contentDescription = stringResource(id = R.string.assign_date),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(16.dep)
                                .width(16.dep)
                        )

                    }
                    Column {
                        Text(
                            text = stringResource(id = R.string.task_due),
                            fontSize = 10.sep,
                            color = Extra_light_Gray,
                            modifier = Modifier
                                .padding(start = 8.dep)
                        )


                        Text(
                            text = "20 Jul 2023",
                            fontSize = 12.sep,
                            color = Date_red,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(start = 8.dep)
                        )
                    }
                }

                Text(
                    text = stringResource(id = R.string.description),
                    fontSize = 12.sep,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF6D6D6D),
                    modifier = Modifier
                        .padding(start = 16.dep, top = 12.dep)
                )
                OutlinedTextField(
                    value = description.value,
                    onValueChange = {
                        notifier.notify(MyDataIds.description, it)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    placeholder = {
                        Text(
                            "Add more details to this task...",
                            color = Extra_light_Gray,
                            fontSize = 14.sep
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    textStyle = TextStyle(
                        color = Extra_light_Gray,
                        fontSize = 14.sep
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = White_Background,
                        unfocusedBorderColor = White_Background
                    )
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(horizontal = 16.dep)
                        .fillMaxWidth()
                ) {

                    Text(
                        text = stringResource(id = R.string.projects),
                        fontSize = 12.sep,
                        fontWeight = FontWeight.Bold,
                        color = Extra_light_Gray,
                        modifier = Modifier

                    )

                    Image(
                        painter = painterResource(id = R.drawable.dot),
                        contentDescription = stringResource(id = R.string.settings),
                        modifier = Modifier
                            .height(20.dep)
                            .width(20.dep)
                            .clickable {


                                Log.d("cdc", "clicked")
                            }

                    )

                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    //horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(horizontal = 16.dep)
                        .padding(top = 8.dep)
                        .fillMaxWidth()
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier

                            .height(14.dep)
                            .width(14.dep)
                            //.border(.5.dep, Box_Blue, RoundedCornerShape(4.dep))
                            .clip(RoundedCornerShape(4.dep))
                            .background(Box_Blue)

                    ) {}
                    ProjectDropdown()

                }

                Text(
                    text = stringResource(id = R.string.subtasks),
                    fontSize = 12.sep,
                    fontWeight = FontWeight.Bold,
                    color = Extra_light_Gray,
                    modifier = Modifier
                        .padding(top = 12.dep, start = 16.dep)

                )
                LazyColumn(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(top = 8.dep, start = 16.dep, end = 16.dep, bottom = 4.dep)
                        //.height(60.dep)
                        .fillMaxWidth()
                        //.wrapContentHeight()
                        .heightIn(min = 60.dep, max = 1000.dep)
                        //.weight(1f)
                        .clip(RoundedCornerShape(4.dep))
                        .background(Color(0xFFF5F5F5))
                ) {
                    items(subtasklist) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .padding(start = 16.dep)
                                    .height(24.dep)
                                    .width(24.dep)
                                    .border(1.dep, Color.DarkGray, CircleShape)
                                    .clip(CircleShape)
                                    .background(Color(0xFFF5F5F5))
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.tik),
                                    contentDescription = stringResource(id = R.string.ok),
                                    modifier = Modifier
                                        //.padding(end = 16.dep)
                                        .height(12.dep)
                                        .width(12.dep)
                                        .clickable {


                                            Log.d("cdc", "clicked")
                                        }

                                )


                            }

                            Text(
                                text = it.Subtask,
                                fontSize = 14.sep,
                                fontWeight = FontWeight.Bold,
                                color = Extra_light_Gray,
                                modifier = Modifier
                                    .padding(start = 8.dep)

                            )
                        }
                        Spacer(
                            modifier = Modifier
                                .height(4.dep)
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    Button(
                        onClick = {
                            notifier.notify(MyDataIds.addsubtask)
                        },
                        modifier = Modifier,
                        //.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(White_Background),
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.add),
                            contentDescription = stringResource(id = R.string.btn_subtask),
                            modifier = Modifier
                                .height(44.dep)
                                .width(24.dep)
                        )
                        Text(
                            text = stringResource(id = R.string.btn_subtask),
                            fontSize = 14.sep,
                            fontWeight = FontWeight.Bold,
                            color = Extra_light_Gray
                        )
                    }

                }

                Text(
                    text = stringResource(id = R.string.attachments),
                    fontSize = 12.sep,
                    fontWeight = FontWeight.Bold,
                    color = Extra_light_Gray,
                    modifier = Modifier
                        .padding(top = 8.dep, start = 16.dep)

                )

                //DashedBorderBox()
                val stroke = Stroke(
                    width = 2f,
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    // contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(start = 16.dep, top = 8.dep)
                        .height(56.dep)
                        .width(56.dep)
                        .clip(RoundedCornerShape(4.dep))
                        .clickable(onClick = {})
                        /*.border(
                            width = 1.dep,
                            color = JungleGreen,
                            shape = RoundedCornerShape(8.dep)
                        )*/
                        .drawBehind {
                            drawRoundRect(
                                color = Color.DarkGray,
                                //topLeft = Offset(15f, 15f),
                                //size = Size(size.width - 30f, size.height - 30f),
                                style = stroke,
                                cornerRadius = CornerRadius(4.depx, 4.depx)
                            )
                        }

                ) {
                    AsyncImage(
                        model = R.drawable.add,
                        contentDescription = stringResource(id = R.string.add_attachment),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(24.dep)
                            .width(24.dep)
                    )
                }
            }

        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskDropdown(
    taskitems: SnapshotStateList<String> = listState(key = MyDataIds.taskitems)
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("Recently assigned") }
    //val taskitems = listOf("Recently assigned", "Not assigned")
    Column(
        //modifier = Modifier.padding(16.dep)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { expanded = true }
        ) {
            Text(
                text = selectedItem,
                fontSize = 12.sep,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dep)
            )

            Image(
                painter = painterResource(id = R.drawable.dropdown),
                contentDescription = stringResource(id = R.string.dropdown),
                modifier = Modifier
                    .size(20.dep)
            )
        }

        if (expanded) {
            DropdownMenu(
                modifier = Modifier
                //.background(Color.White)
                ,
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                taskitems.forEach { item ->
                    DropdownMenuItem(
                        { Text(text = item) },
                        onClick = {
                            selectedItem = item
                            expanded = false
                        }
                    )


                }
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectDropdown(
    projectitems:SnapshotStateList<String> = listState(key = MyDataIds.projectitems)
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("Bikrimart Project") }

    Column(
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { expanded = true }
        ) {
            Text(
                text = selectedItem,
                fontSize = 12.sep,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dep)
            )

            Image(
                painter = painterResource(id = R.drawable.dropdown),
                contentDescription = stringResource(id = R.string.dropdown),
                modifier = Modifier
                    .size(20.dep)
            )
        }

        if (expanded) {
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                projectitems.forEach { item ->
                    DropdownMenuItem(
                        { Text(text = item) },
                        onClick = {
                            selectedItem = item
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun previewAssignTask() {
    AssignTaskScreen()
}