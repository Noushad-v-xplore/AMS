package com.vxplore.ams.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.debduttapanda.j3lib.NotificationService
import com.debduttapanda.j3lib.boolState
import com.debduttapanda.j3lib.dep
import com.debduttapanda.j3lib.listState
import com.debduttapanda.j3lib.notifier
import com.debduttapanda.j3lib.sep
import com.debduttapanda.j3lib.stringState
import com.vxplore.ams.MyDataIds
import com.vxplore.ams.R
import com.vxplore.ams.models.CompletedList
import com.vxplore.ams.models.WorkList
import kotlinx.coroutines.launch




@Composable
fun TodoScreen(
    notifier: NotificationService = notifier(),
    floatingbtnState: Boolean = boolState(key = MyDataIds.floatingbtnClicked).value,
    overdue_list: SnapshotStateList<WorkList> = listState(key =MyDataIds.worklist),
    compleated_list: SnapshotStateList<CompletedList> = listState(key =MyDataIds.compleated_list)
) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .background(Color(0xFFF9F9F9))
            .fillMaxSize(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .background(Color(0xFFF9F9F9))
                    .padding(horizontal = 16.dep)
                    .height(54.dep)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = stringResource(id = R.string.menu),
                    modifier = Modifier
                        .height(18.dep)
                        .width(16.dep)
                        .clickable {
                            scope.launch { drawerState.open() }
                            notifier.notify(MyDataIds.navdrawer)
                            Log.d("cdc", "clicked")
                        }
                )
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = stringResource(id = R.string.logo),
                    modifier = Modifier
                        .height(44.dep)
                        .width(43.dep)
                )
                Image(
                    painter = painterResource(id = R.drawable.bell),
                    contentDescription = stringResource(id = R.string.notification),
                    modifier = Modifier
                        .height(24.72.dep)
                        .width(22.81.dep)
                )
            }
            Card(
                modifier = Modifier
                    //.background(color = Color(0xFFF9F9F9))
                    .height(1.dep)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(4.dep),
                colors = CardDefaults.cardColors(Color(0xFF00000029))
            ) {
            }
            Spacer(
                modifier = Modifier
                    .height(22.dep)
            )
            Text(
                text = stringResource(id = R.string.todo),
                fontSize = 24.sep,
                color = Color(0xFF6D6D6D),
                modifier = Modifier
            )
            Text(
                text = stringResource(id = R.string.today_overdue),
                fontSize = 10.sep,
                color = Color(0xFF6D6D6D),
                modifier = Modifier
                    .padding(start = 20.dep)
                    .align(Alignment.Start)
            )
            Spacer(
                modifier = Modifier
                    .height(6.dep)
            )
            LazyColumn(
                modifier = Modifier
                    .height(180.dep)
            ) {
                items(overdue_list) {
                    Card(
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp)
                            //.border(2.dp, Color.Black)
                            .background(color = Color.White)
                            .height(85.dp)
                            .fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(8.dp),
                        shape = RoundedCornerShape(4.dp),
                        colors = CardDefaults.cardColors(Color.White)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .background(color = Color.White)
                                .fillMaxWidth()
                                .padding(horizontal = 4.dp)
                                .height(52.dp)
                        ) {
                            Text(
                                text = it.Task,
                                fontSize = 14.sep,
                                color = Color(0xFF707070),
                                modifier = Modifier
                                    .padding(start = 8.dep)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.tik),
                                contentDescription = "",
                                modifier = Modifier
                                    .height(11.dep)
                                    .width(16.dep)
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            //horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .background(color = Color(0xFFF7F7F7))
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(horizontal = 4.dp)
                        )
                        {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                //horizontalArrangement = Arrangement.SpaceBetween
                            )
                            {
                                Image(
                                    painter = painterResource(id = R.drawable.date),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .padding(start = 4.dep)
                                        .height(11.dep)
                                        .width(16.dep)
                                )
                                Text(
                                    text = it.Date,
                                    fontSize = 10.sep,
                                    color = Color(0xFFC63434),
                                    modifier = Modifier
                                        .padding(start = 1.dep)
                                )
                            }
                            Spacer(
                                modifier = Modifier
                                    .width(8.dep)
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                //horizontalArrangement = Arrangement.SpaceBetween
                            )
                            {
                                Image(
                                    painter = painterResource(id = R.drawable.person),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .height(11.dep)
                                        .width(16.dep)
                                )
                                Text(
                                    text = it.Name,
                                    fontSize = 10.sep,
                                    color = Color(0xFF707070),
                                    modifier = Modifier
                                        .padding(start = 1.dep)
                                )
                            }
                            Spacer(
                                modifier = Modifier
                                    .width(8.dep)
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                //horizontalArrangement = Arrangement.SpaceBetween
                            )
                            {
                                Image(
                                    painter = painterResource(id = R.drawable.priority),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .height(11.dep)
                                        .width(16.dep)
                                )
                                Text(
                                    text = it.Priority,
                                    fontSize = 10.sep,
                                    color = Color(0xFF707070),
                                    modifier = Modifier
                                        .padding(start = 1.dep)
                                )
                            }
                        }
                    }
                    Spacer(
                        modifier = Modifier
                            .height(12.dep)
                    )
                }
            }
            Spacer(
                modifier = Modifier
                    .height(28.dep)
            )
            Text(
                text = stringResource(id = R.string.completed),
                fontSize = 10.sep,
                color = Color(0xFF6D6D6D),
                modifier = Modifier
                    .padding(start = 20.dep)
                    .align(Alignment.Start)
            )
            Spacer(
                modifier = Modifier
                    .height(6.dep)
            )
            LazyColumn(
                modifier = Modifier
                    .height(180.dep)
            ) {
                items(compleated_list) {
                    Card(
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp)
                            //.border(2.dp, Color.Black)
                            .background(color = Color.White)
                            .height(40.dp)
                            .fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(8.dp),
                        shape = RoundedCornerShape(4.dp),
                        colors = CardDefaults.cardColors(Color.White)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            //horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .background(color = Color.White)
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(horizontal = 4.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.greentik),
                                contentDescription = "",
                                modifier = Modifier
                                    .height(24.dep)
                                    .width(24.dep)
                            )
                            Text(
                                text = it.ColpletedTask,
                                fontSize = 14.sep,
                                color = Color(0xFF707070),
                                modifier = Modifier
                                    .padding(start = 1.dep)
                            )
                        }
                    }
                    Spacer(
                        modifier = Modifier
                            .height(8.dep)
                    )
                }
            }
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier
                    .background(Color(0xFFF9F9F9))
                    .fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .height(54.dep)
                        .background(Color(0xFF434343))
                        .padding(horizontal = 12.dep)
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.home),
                            contentDescription = stringResource(id = R.string.home),
                            modifier = Modifier
                                //.padding(start = 12.dep)
                                .height(20.89.dep)
                                .width(20.89.dep)
                                .clickable {
                                    Log.d("fgfg", "clicked")
                                }
                        )
                        Spacer(
                            modifier = Modifier
                                .height(4.dep)
                        )
                        Text(
                            text = stringResource(id = R.string.home),
                            fontSize = 10.sep,
                            color = Color(0xFFEFEFEF),
                            /* modifier = Modifier
                                 .padding(start = 8.dep)*/
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.task),
                            contentDescription = stringResource(id = R.string.mytask),
                            modifier = Modifier
                                //.padding(start = 8.dep)
                                .height(19.dep)
                                .width(19.dep)
                                .clickable {
                                    Log.d("fgfg", "clicked")
                                }
                        )
                        Spacer(
                            modifier = Modifier
                                .height(4.dep)
                        )
                        Text(
                            text = stringResource(id = R.string.mytask),
                            fontSize = 10.sep,
                            color = Color(0xFF6D6D6D),
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.inbox),
                            contentDescription = stringResource(id = R.string.inbox),
                            modifier = Modifier
                                //.padding(start = 4.dep)
                                .height(19.21.dep)
                                .width(22.41.dep)
                                .clickable {
                                    Log.d("fgfg", "clicked")
                                }
                        )
                        Spacer(
                            modifier = Modifier
                                .height(4.dep)
                        )
                        Text(
                            text = stringResource(id = R.string.inbox),
                            fontSize = 10.sep,
                            color = Color(0xFF6D6D6D),
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = stringResource(id = R.string.search),
                            modifier = Modifier
                                //.padding(start = 10.dep)
                                .height(19.21.dep)
                                .width(19.13.dep)
                                .clickable {
                                    Log.d("fgfg", "clicked")
                                }
                        )
                        Spacer(
                            modifier = Modifier
                                .height(4.dep)
                        )
                        Text(
                            text = stringResource(id = R.string.search),
                            fontSize = 10.sep,
                            color = Color(0xFF6D6D6D),
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bell2),
                            contentDescription = stringResource(id = R.string.notification),
                            modifier = Modifier
                                //.padding(start = 10.dep)
                                .height(20.68.dp)
                                .width(19.08.dp)
                                .clickable {
                                    Log.d("fgfg", "clicked")
                                }
                        )
                        Spacer(
                            modifier = Modifier
                                .height(4.dep)
                        )
                        Text(
                            text = stringResource(id = R.string.notification),
                            fontSize = 10.sep,
                            color = Color(0xFF6D6D6D),
                        )
                    }
                }
            }
        }
        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier
                .padding(end = 12.dep, bottom = 64.dep)
                .fillMaxSize()
        ) {
            if (!floatingbtnState) {
                Row(
                    modifier = Modifier
                        .wrapContentSize(),
                    horizontalArrangement = Arrangement.End
                ) {
                    FloatingActionButton(
                        onClick = {
                            notifier.notify(MyDataIds.floatingDialogue)
                        },
                        modifier = Modifier
                            .height(71.dep)
                            .width(71.dep),
                        shape = CircleShape,
                        containerColor = Color.White,
                        elevation = FloatingActionButtonDefaults.elevation(2.dep)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.add),
                            contentDescription = stringResource(id = R.string.add_task),
                            modifier = Modifier
                                .height(44.dep)
                                .width(24.dep)
                        )
                    }
                }
            }
            if (floatingbtnState) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    FloatingDialogue_ui()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FloatingDialogue_ui(
    note: State<String> = stringState(key = MyDataIds.note),
    notifier: NotificationService = com.debduttapanda.j3lib.notifier()
) {
    //val note = remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .padding(start = 16.dep, end = 4.dep)
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(4.dep)),
        //.background(Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.rocket),
                contentDescription = stringResource(id = R.string.projects),
                modifier = Modifier
                    .height(12.84.dep)
                    .width(12.84.dep)
            )
            Text(
                text = "Jaya Industry",
                fontSize = 12.sep,
                color = Color(0xFF707070),
                modifier = Modifier
                    .padding(start = 6.dep)
            )
            Spacer(
                modifier = Modifier
                    .height(8.dep)
            )
        }
        Card(
            modifier = Modifier
                //.padding(start = 20.dp, end = 20.dp)
                //.border(2.dp, Color.Black)
                .background(color = Color.White)
                .height(92.dp)
                .fillMaxWidth()
            //.fillMaxSize()
            ,
            elevation = CardDefaults.cardElevation(8.dep),
            shape = RoundedCornerShape(4.dep),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxWidth()
                    .padding(horizontal = 4.dep)
                    .height(55.dep)
            ) {
                OutlinedTextField(
                    value = note.value,
                    onValueChange = {
                        notifier.notify(MyDataIds.note, it)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    /* placeholder = {
                         Text(
                             "", color = Color(0xFF909090), fontSize = 14.sep
                         )
                     }*/
                    modifier = Modifier
                        // .border(1.dep, Color(0xFFF1F1F1), shape = RoundedCornerShape(4.dep))
                        .fillMaxHeight()
                        .width(250.dep),
                    textStyle = TextStyle(
                        color = Color(0xFF909090),
                        fontSize = 14.sep
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White
                    )
                )
                Image(
                    painter = painterResource(id = R.drawable.upload),
                    contentDescription = stringResource(id = R.string.upload),
                    modifier = Modifier
                        .padding(end = 8.dep)
                        .height(32.53.dep)
                        .width(32.53.dep)
                        .clickable {
                            notifier.notify(MyDataIds.btnUploadclick)
                        }
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .background(color = Color(0xFFEAEAEA))
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(start = 6.dp, end = 24.dep)
            )
            {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = stringResource(id = R.string.assign),
                        modifier = Modifier
                            .padding(start = 4.dep)
                            .height(11.dep)
                            .width(16.dep)
                    )
                    Text(
                        text = stringResource(id = R.string.assign),
                        fontSize = 10.sep,
                        color = Color(0xFF707070),
                        modifier = Modifier
                            .padding(start = 2.dep)
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.attatchment),
                        contentDescription = stringResource(id = R.string.attach),
                        modifier = Modifier
                            .height(15.7.dep)
                            .width(15.5.dep)
                    )
                    Text(
                        text = stringResource(id = R.string.attach),
                        fontSize = 10.sep,
                        color = Color(0xFF707070),
                        modifier = Modifier
                            .padding(start = 2.dep)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.duedate),
                        contentDescription = stringResource(id = R.string.due_date),
                        modifier = Modifier
                            .height(15.26.dep)
                            .width(15.63.dep)
                    )
                    Text(
                        text = stringResource(id = R.string.due_date),
                        fontSize = 10.sep,
                        color = Color(0xFF707070),
                        modifier = Modifier
                            .padding(start = 2.dep)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.priority),
                        contentDescription = stringResource(id = R.string.priority),
                        modifier = Modifier
                            .height(15.71.dep)
                            .width(15.71.dep)
                    )
                    Text(
                        text = stringResource(id = R.string.priority),
                        fontSize = 10.sep,
                        color = Color(0xFF707070),
                        modifier = Modifier
                            .padding(start = 2.dep)
                    )
                }
            }

        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun previewTodo() {
    TodoScreen()
}