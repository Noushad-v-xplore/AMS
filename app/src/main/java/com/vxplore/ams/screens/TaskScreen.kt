package com.vxplore.ams.screens

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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.debduttapanda.j3lib.NotificationService
import com.debduttapanda.j3lib.boolState
import com.debduttapanda.j3lib.dep
import com.debduttapanda.j3lib.listState
import com.debduttapanda.j3lib.notifier
import com.debduttapanda.j3lib.sep
import com.debduttapanda.j3lib.stringState
import com.vxplore.ams.MyDataIds
import com.vxplore.ams.R
import com.vxplore.ams.models.Taskitem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(
    note: State<String> = stringState(key = MyDataIds.note),
    notifier: NotificationService = com.debduttapanda.j3lib.notifier(),
    addstepbtnclicked: Boolean = boolState(key = MyDataIds.addstepbtnclicked).value,
) {
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
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = stringResource(id = R.string.back),
                    modifier = Modifier
                        .height(20.07.dep)
                        .width(24.87.dep)
                        .clickable {
                        }
                )
                Text(
                    text = stringResource(id = R.string.task),
                    fontSize = 24.sep,
                    color = Color(0xFF6D6D6D),
                    modifier = Modifier
                )
                Image(
                    painter = painterResource(id = R.drawable.tik),
                    contentDescription = stringResource(id = R.string.ok),
                    modifier = Modifier
                        .height(12.dep)
                        .width(16.dep)
                        .clickable {
                        }
                )
            }
            Column(
                modifier = Modifier
                    .padding(bottom = 16.dep)
                    .verticalScroll(rememberScrollState())
            ) {
                Card(
                    modifier = Modifier
                        .background(color = Color.White)
                        .heightIn(min = 132.dep, max = 1000.dep)
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(8.dp),
                    shape = RectangleShape,
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Text(
                        text = "Exoticamp Payment Gateway in Monday",
                        fontSize = 24.sep,
                        color = Color(0xFF707070),
                        modifier = Modifier
                            .padding(start = 18.dp, top = 24.dep, end = 18.dep)
                    )
                    if (!addstepbtnclicked) {

                        /* Row(
                             verticalAlignment = Alignment.CenterVertically,
                             //horizontalArrangement = Arrangement.SpaceBetween
                         ) {*/
                        Text(
                            text = stringResource(id = R.string.add_step),
                            fontSize = 14.sep,
                            color = Color(0xFF3055D0),
                            modifier = Modifier
                                .padding(start = 20.dep, top = 12.dep)
                                .clickable {
                                    notifier.notify(MyDataIds.clickstep)
                                }
                        )
                    }
                    if (addstepbtnclicked) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Add_Step()
                        }
                    }
                    //}
                }
                Card(
                    modifier = Modifier
                        .padding(start = 12.dep, end = 12.dep, top = 12.dep)
                        .background(color = Color.White)
                        .height(50.dep)
                        .clickable {
                        }
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dep),
                    shape = RoundedCornerShape(4.dep),
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
                            painter = painterResource(id = R.drawable.myday),
                            contentDescription = stringResource(id = R.string.add_to_my_day),
                            modifier = Modifier
                                .padding(start = 14.dep)
                                .height(27.45.dep)
                                .width(27.45.dep)
                        )
                        Text(
                            text = stringResource(id = R.string.add_to_my_day),
                            fontSize = 14.sep,
                            color = Color(0xFF909090),
                            modifier = Modifier
                                .padding(start = 8.dep)
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .padding(horizontal = 12.dep)
                        .padding(top = 8.dep, bottom = 8.dep)
                        .background(color = Color.White)
                        .height(126.dep)
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dep),
                    shape = RoundedCornerShape(4.dep),
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Row(
                        verticalAlignment = Alignment.Top,
                        //horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .background(color = Color.White)
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bell2),
                            contentDescription = stringResource(id = R.string.remind_me),
                            modifier = Modifier
                                .padding(start = 14.dep, top = 12.dp)
                                .height(16.76.dep)
                                .width(18.16.dep)
                        )
                        Text(
                            text = stringResource(id = R.string.remind_me),
                            fontSize = 14.sep,
                            color = Color(0xFF909090),
                            modifier = Modifier
                                .padding(start = 16.dep, top = 10.dp)
                                .clickable {
                                }
                        )
                    }
                    Divider(
                        color = Color(0xFFEDEDED),
                        modifier = Modifier
                            .padding(top = 12.dep)
                            .height(1.dep)
                            .fillMaxWidth()
                    )
                    Row(
                        verticalAlignment = Alignment.Top,
                        //horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .background(color = Color.White)
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.taskdate),
                            contentDescription = stringResource(id = R.string.add_due_date),
                            modifier = Modifier
                                .padding(start = 14.dep, top = 12.dp)
                                .height(16.49.dep)
                                .width(16.49.dep)
                        )
                        Text(
                            text = stringResource(id = R.string.add_due_date),
                            fontSize = 14.sep,
                            color = Color(0xFF909090),
                            modifier = Modifier
                                .padding(start = 16.dep, top = 10.dp)
                                .clickable {
                                }
                        )
                    }
                    Divider(
                        color = Color(0xFFEDEDED),
                        modifier = Modifier
                            .padding(top = 12.dep)
                            .height(1.dep)
                            .fillMaxWidth()
                    )
                    Row(
                        verticalAlignment = Alignment.Top,
                        //horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .background(color = Color.White)
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.repeat),
                            contentDescription = stringResource(id = R.string.repeat),
                            modifier = Modifier
                                .padding(start = 14.dep, top = 12.dp)
                                .height(19.77.dep)
                                .width(14.49.dep)
                        )
                        Text(
                            text = stringResource(id = R.string.repeat),
                            fontSize = 14.sep,
                            color = Color(0xFF909090),
                            modifier = Modifier
                                .padding(start = 16.dep, top = 10.dp)
                                .clickable {
                                }
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .padding(start = 12.dep, end = 12.dep)
                        .background(color = Color.White)
                        .height(50.dep)
                        .clickable {
                        }
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dep),
                    shape = RoundedCornerShape(4.dep),
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
                            painter = painterResource(id = R.drawable.attatch),
                            contentDescription = stringResource(id = R.string.add_file),
                            modifier = Modifier
                                .padding(start = 12.dep)
                                .height(21.33.dep)
                                .width(21.04.dep)
                        )
                        Text(
                            text = stringResource(id = R.string.add_file),
                            fontSize = 14.sep,
                            color = Color(0xFF909090),
                            modifier = Modifier
                                .padding(start = 16.dep)
                        )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(8.dep)
                )
                Card(
                    modifier = Modifier
                        .padding(start = 12.dep, end = 12.dep)
                        .background(color = Color.White)
                        .height(50.dep)
                        .clickable {
                        }
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dep),
                    shape = RoundedCornerShape(4.dep),
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .background(color = Color.White)
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(horizontal = 4.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.projectname),
                            contentDescription = stringResource(id = R.string.project_name),
                            modifier = Modifier
                                .padding(start = 12.dep)
                                .height(19.10.dep)
                                .width(19.03.dep)
                        )
                        Text(
                            text = stringResource(id = R.string.project_name),
                            fontSize = 14.sep,
                            color = Color(0xFF909090),
                            modifier = Modifier
                                .padding(start = 16.dep)
                        )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(8.dep)
                )
                Card(
                    modifier = Modifier
                        .padding(start = 12.dep, end = 12.dep)
                        .background(color = Color.White)
                        .height(50.dep)
                        .clickable {
                        }
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dep),
                    shape = RoundedCornerShape(4.dep),
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .background(color = Color.White)
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(horizontal = 4.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.user),
                            contentDescription = stringResource(id = R.string.assign_to),
                            modifier = Modifier
                                .padding(start = 12.dep)
                                .height(19.10.dep)
                                .width(19.03.dep)
                        )
                        Text(
                            text = stringResource(id = R.string.assign_to),
                            fontSize = 14.sep,
                            color = Color(0xFF909090),
                            modifier = Modifier
                                .padding(start = 16.dep)
                        )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(8.dep)
                )
                Card(
                    modifier = Modifier
                        .padding(start = 12.dep, end = 12.dep)
                        .background(color = Color.White)
                        .height(140.dep)
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dep),
                    shape = RoundedCornerShape(4.dep),
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    OutlinedTextField(
                        value = note.value,
                        onValueChange = {
                            notifier.notify(MyDataIds.note, it)
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        placeholder = {
                            Text(
                                stringResource(id = R.string.add_note),
                                color = Color(0xFF909090),
                                fontSize = 14.sep
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        textStyle = TextStyle(
                            color = Color(0xFF909090),
                            fontSize = 14.sep
                        ),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White
                        )
                    )
                }
                Spacer(
                    modifier = Modifier
                        .height(16.dep)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.created_on),
                            fontSize = 14.sep,
                            color = Color(0xFF909090),
                            modifier = Modifier
                                .padding(start = 12.dep)
                        )
                        Text(
                            text = "Sun, 20 Aug",
                            fontSize = 14.sep,
                            color = Color(0xFF909090),
                            modifier = Modifier
                                .padding(start = 4.dep)
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.delete),
                        contentDescription = stringResource(id = R.string.delete),
                        modifier = Modifier
                            .padding(end = 16.dep)
                            .height(19.38.dep)
                            .width(17.51.dep)
                            .clickable {
                            }
                    )
                }
            }
        }
    }
}

@Composable
fun Add_Step(
    taskitem: SnapshotStateList<Taskitem> = listState(key = MyDataIds.stepitem),
    notifier: NotificationService = notifier()
) {
    Column {

        LazyColumn(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 60.dep, max = 1000.dep)
        ) {
            items(taskitem) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(start = 18.dp, end = 18.dep, top = 12.dep)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = it.task,
                        fontSize = 14.sep,
                        color = Color(0xFF909090),

                    )


                    Image(
                        painter = painterResource(id = R.drawable.done),
                        contentDescription = stringResource(id =R.string.done),
                        modifier = Modifier
                            .height(20.dep)
                            .width(16.dep)
                            .clickable {

                            }
                    )
                }

                Divider(
                    color = Color(0xFFB6B3B3),
                    modifier = Modifier
                        .padding(horizontal = 18.dep)
                        .padding(top = 8.dep)
                        .height(1.dep)
                        .fillMaxWidth()

                )
            }
        }
     /*   Spacer(modifier = Modifier
            .height(4.dep)
            )*/
        Text(
            text = "Next Task",
            fontSize = 14.sep,
            color = Color(0xFF909090),
            modifier = Modifier
                .padding(start = 18.dp, top = 24.dep, end = 18.dep, bottom = 16.dep)
                .clickable {
                    notifier.notify(MyDataIds.nexttaskbtn)
                }
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun previewTask() {
    TaskScreen()
}