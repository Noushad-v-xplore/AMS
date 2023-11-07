package com.vxplore.ams.screens

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.OpenableColumns
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.runtime.rememberUpdatedState
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.debduttapanda.j3lib.NotificationService
import com.debduttapanda.j3lib.dep
import com.debduttapanda.j3lib.depx
import com.debduttapanda.j3lib.listState
import com.debduttapanda.j3lib.notifier
import com.debduttapanda.j3lib.sep
import com.debduttapanda.j3lib.stringState
import com.debduttapanda.j3lib.times
import com.vxplore.ams.MyDataIds
import com.vxplore.ams.R
import com.vxplore.ams.models.Assigntasklist
import com.vxplore.ams.models.Commentlist
import com.vxplore.ams.models.SelectedFile
import com.vxplore.ams.models.Subtasklist
import com.vxplore.ams.ui.theme.Box_Blue
import com.vxplore.ams.ui.theme.Date_red
import com.vxplore.ams.ui.theme.Extra_light_Gray
import com.vxplore.ams.ui.theme.White_Background


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun AssignTaskScreen(
    description: State<String> = stringState(key = MyDataIds.description),
    questionfield: State<String> = stringState(key = MyDataIds.questionfield),
    subtasklist: SnapshotStateList<Subtasklist> = listState(key = MyDataIds.subtasklist),
    assigntasklist: SnapshotStateList<Assigntasklist> = listState(key = MyDataIds.assigntasklist),
    commentlist: SnapshotStateList<Commentlist> = listState(key = MyDataIds.commentlist),
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
                            notifier.notify(MyDataIds.btnBack)
                            Log.d("cdc", "clicked")
                        }
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.done),
                        contentDescription = stringResource(id = R.string.done),
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
            {
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    //.fillMaxWidth()
                    //.height(200.dep)
                    .padding(bottom = 8.dep)
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
                    ) {
                    }
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
                /* val context = LocalContext.current
                 var selectedPdfFileResourceId by remember { mutableStateOf<Int?>(null) }*/
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FilePickerScreen()
                    /* Column(
                         horizontalAlignment = Alignment.CenterHorizontally,
                         verticalArrangement = Arrangement.Center,
                         // contentAlignment = Alignment.Center,
                         modifier = Modifier
                             .padding(start = 16.dep, top = 8.dep)
                             .height(56.dep)
                             .width(56.dep)
                             .clip(RoundedCornerShape(4.dep))
                             .clickable(onClick = {
                                 val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                                     type = "application/pdf"
                                 }
                                 val filePickerIntent =
                                     Intent.createChooser(intent, "Select a PDF file")
                                 context.startActivity(filePickerIntent)
                             })
                             .drawBehind {
                                 drawRoundRect(
                                     color = Color.DarkGray,
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
                     if (selectedPdfFileResourceId != null) {
                         AsyncImage(
                             model = selectedPdfFileResourceId!!,
                             contentDescription = stringResource(id = R.string.add_attachment),
                             contentScale = ContentScale.Crop,
                             modifier = Modifier
                                 //.background(Color.Blue)
                                 .height(24.dep)
                                 .width(24.dep)
                         )

                         Image(
                             painter = painterResource(id = R.drawable.cancel),
                             contentDescription = "PDF Icon",
                             modifier = Modifier
                                 .padding(start = 12.dep)
                                 .size(16.dep)
                         )
                     }*/
                }
                Spacer(
                    modifier = Modifier
                        .height(12.dep)
                )
                /*  LazyColumn(
                      verticalArrangement = Arrangement.Center,
                      modifier = Modifier
                          //.padding(top = 20.dep,)
                          //.height(60.dep)
                          .fillMaxWidth()
                          //.wrapContentHeight()
                          .heightIn(min = 60.dep, max = 1000.dep)
                          //.weight(1f)
                          .clip(RoundedCornerShape(4.dep))
                          .background(Color(0xFFF5F5F5))
                  ) {
                      items(count = 1) {*/
                Box(
                    //contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(top = 20.dep)
                        .fillMaxWidth()
                        .heightIn(min = 80.dep, max = 1000.dep)
                        //.border(1.dep, Color.DarkGray, CircleShape)
                        .clip(RoundedCornerShape(4.dep))
                        .background(Color(0xFFF5F5F5))
                ) {
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(start = 16.dep, top = 12.dep)
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .height(28.dep)
                                    .width(28.dep)
                                    //.border(1.dep, Color(0xFFEFEFEF), CircleShape)
                                    .clip(CircleShape)
                                    .background(Color(0xFFFF817E))
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
                                    text = "Debdutta Panda created this task",
                                    fontSize = 12.sep,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(start = 8.dep)
                                )
                                Text(
                                    text = "19 Jul 2021",
                                    fontSize = 10.sep,
                                    color = Extra_light_Gray,
                                    //fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(start = 8.dep)
                                )
                            }
                        }
                        Spacer(
                            modifier = Modifier
                                .height(4.dep)
                        )
                        LazyColumn(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                //.padding(bottom = 12.dep)
                                //.height(60.dep)
                                .fillMaxWidth()
                                //.wrapContentHeight()
                                .heightIn(min = 60.dep, max = 1000.dep)
                            //.weight(1f)
                            //.clip(RoundedCornerShape(4.dep))
                            //.background(Color(0xFFF5F5F5))
                        ) {
                            items(assigntasklist) {
                                FlowRow(
                                    //verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .padding(horizontal = 16.dep)
                                        .padding(top = 4.dep),
                                    horizontalArrangement = Arrangement.spacedBy(8.dep)
                                ) {
                                    Text(
                                        text = it.Task,
                                        fontSize = 10.sep,
                                        color = Extra_light_Gray,
                                        maxLines = 5,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier
                                        //.padding(start = 8.dep)
                                    )
                                    Text(
                                        text = it.Date,
                                        fontSize = 10.sep,
                                        maxLines = 5,
                                        color = Extra_light_Gray,
                                        //fontWeight = FontWeight.Bold,
                                    )
                                }
                                Row(
                                    //verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .padding(start = 16.dep)
                                        .fillMaxWidth()
                                ) {
                                    Text(
                                        text = it.Comments.Comment,
                                        fontSize = 10.sep,
                                        maxLines = 5,
                                        color = Extra_light_Gray,
                                        //fontWeight = FontWeight.Bold,
                                    )
                                    AsyncImage(
                                        model = it.Comments.Emoji,
                                        contentDescription = stringResource(id = R.string.add_attachment),
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            //.padding(start = 4.dep)
                                            //.background(Color.Blue)
                                            .height(16.dep)
                                            .width(16.dep)
                                    )
                                }
                            }
                        }
                    }
                }
                /*   }
               }*/
                Spacer(
                    modifier = Modifier
                        .height(8.dep)
                )
                LazyRow(
                    modifier = Modifier
                        .padding(start = 16.dep, end = 16.dep)
                        .background(Color(0xFFFBFBFB))
                        .fillMaxWidth()
                ) {
                    items(commentlist) {
                        /*  Box(
                              contentAlignment = Alignment.Center,
                              modifier = Modifier
                                  //.padding(start = 16.dep)
                                  .height(40.dep)
                                  //.width(100.dep)
                                  .wrapContentWidth()
                                  //.fillMaxWidth()
                                  //.heightIn(min = 80.dep, max = 1000.dep)
                                  //.border(1.dep, Color.DarkGray, CircleShape)
                                  .clip(RoundedCornerShape(20.dep))
                                  .background(Color(0xFFF5F5F5))
                          )*/
                        val msg = "${it.Comment}+${it.Emoji}"
                        Button(
                            onClick = {
                                notifier.notify(com.vxplore.ams.MyDataIds.cmntbtn, msg)
                            },
                            modifier = Modifier
                                //.padding(start = 16.dep)
                                //.background(Color(0xFFF5F5F5))
                                .height(40.dep)
                                //.width(100.dep)
                                .wrapContentWidth()
                                //.fillMaxWidth()
                                //.heightIn(min = 80.dep, max = 1000.dep)
                                //.border(1.dep, Color.DarkGray, CircleShape)
                                .clip(RoundedCornerShape(20.dep)),
                            colors = ButtonDefaults.buttonColors(Color(0xFFF5F5F5)),
                        )
                        {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(horizontal = 8.dep)
                            ) {
                                Text(
                                    text = it.Comment,
                                    fontSize = 12.sep,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                    // .padding(horizontal = 8.dep)
                                )
                                AsyncImage(
                                    model = it.Emoji,
                                    contentDescription = stringResource(id = R.string.add_attachment),
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        //.padding(start = 4.dep)
                                        //.background(Color.Blue)
                                        .height(16.dep)
                                        .width(16.dep)
                                )
                            }
                        }
                        Spacer(
                            modifier = Modifier
                                .width(8.dep)
                        )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(12.dep)
                )
                OutlinedTextField(
                    value = questionfield.value,
                    onValueChange = {
                        notifier.notify(MyDataIds.questionfield, it)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    placeholder = {
                        Text(
                            "Ask a question or post an update...",
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
                        .fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.at),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(start = 16.dep)
                                .height(24.dep)
                                .width(24.dep)
                                .clickable {
                                }
                        )
                        Image(
                            painter = painterResource(id = R.drawable.camera),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(start = 20.dep)
                                .height(24.dep)
                                .width(24.dep)
                                .clickable {
                                }
                        )
                        Image(
                            painter = painterResource(id = R.drawable.image),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(start = 20.dep)
                                .height(24.dep)
                                .width(24.dep)
                                .clickable {
                                }
                        )
                        Image(
                            painter = painterResource(id = R.drawable.grayattach),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(start = 20.dep)
                                .height(24.dep)
                                .width(24.dep)
                                .clickable {
                                }
                        )
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(start = 20.dep)
                                .height(24.dep)
                                .width(24.dep)
                                .clickable {
                                }
                        )
                    }
                    RoundedImageStack()
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
    projectitems: SnapshotStateList<String> = listState(key = MyDataIds.projectitems)
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
@Composable
fun RoundedImageStack(
    imglist: SnapshotStateList<String> = listState(key = MyDataIds.imglist)
) {
    val overlapOffsetX = 12.dp // Adjust the X-axis overlap offset
    val overlapOffsetY = 0.dp // Y-axis overlap offset
    val imageSize = 26.dp
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(top = 7.dp, end = 10.dp)
            .height(imageSize)
            .width(108.dp)
            .clip(CircleShape)
    ) {
        val visibleImageCount = minOf(imglist.size, 4)
        val hiddenImageCount = maxOf(imglist.size - 4, 0)

        // Display up to 3 visible images with custom offsets
        for (i in 0 until visibleImageCount) {
            val imageOffsetX = i * overlapOffsetX
            val imageOffsetY = i * overlapOffsetY
            AsyncImage(
                model = imglist[i],
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .offset { IntOffset(imageOffsetX.roundToPx(), imageOffsetY.roundToPx()) }
                    .size(imageSize)
                    .clip(CircleShape)
                    .border(0.5.dep, Color.White, CircleShape)
            )
        }
        // Show the count of hidden images with a custom offset
        if (hiddenImageCount > 0) {
            val hiddenImagesOffsetX = (visibleImageCount - 1) * overlapOffsetX
            val hiddenImagesOffsetY = (visibleImageCount - 1) * overlapOffsetY
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .offset {
                        IntOffset(
                            hiddenImagesOffsetX.roundToPx(),
                            hiddenImagesOffsetY.roundToPx()
                        )
                    }
                    .clip(CircleShape)
                    .background(Color.LightGray, CircleShape)
                    .size(imageSize)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = stringResource(id = R.string.btn_subtask),
                    modifier = Modifier
                        .height(24.dep)
                        .width(24.dep)
                )
                /*Text(
                    text = "+$hiddenImageCount",
                    color = Color.White,
                )*/
            }
        }
    }
}

val stroke = Stroke(
    width = 2f,
    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
)
@Composable
fun FilePickerScreen(
    notifier: NotificationService = notifier(),
) {
    var selectedFileUri by remember { mutableStateOf<Uri?>(null) }
    val selectedFileName = remember { mutableStateOf<String?>(null) }
    var isPDFFile by remember { mutableStateOf(false) }
    var selectedFiles by remember { mutableStateOf<MutableList<SelectedFile>>(mutableListOf()) }
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let {
            selectedFileUri = it
            selectedFileName.value = getFileNameFromUri(context, uri)
            val fileName = getFileNameFromUri(context, uri)
            isPDFFile = selectedFileName.value?.endsWith(".pdf", ignoreCase = true) == true
            val selectedFile = SelectedFile(uri, fileName, isPDFFile)
            selectedFiles.add(selectedFile)
        }
    }
    val openFileIntentLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(start = 16.dep, top = 8.dep)
            .height(56.dep)
            .width(56.dep)
            .clip(MaterialTheme.shapes.small)
            .clickable {
                launcher.launch("*/*")
                notifier.notify(MyDataIds.onclickaddbtn)
            }
            .drawBehind {
                drawRoundRect(
                    color = Color.DarkGray,
                    style = stroke,
                    cornerRadius = CornerRadius(4.depx, 4.depx)
                )
            }
    ) {
        AsyncImage(
            model = R.drawable.add,
            contentDescription = "File Icon",
            modifier = Modifier
                .height(24.dep)
                .width(24.dep)
        )
    }
    selectedFileUri?.let {
        LazyRow(
            modifier = Modifier
                .padding(start = 16.dep)
                .background(Color(0xFFFBFBFB))
                .fillMaxWidth()
        ) {
            items(selectedFiles) { it ->
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(start = 8.dep)
                        .width(92.dep)
                        .clickable {
                            val openFileIntent = Intent(Intent.ACTION_VIEW)
                            openFileIntent.data = it.uri
                            openFileIntentLauncher.launch(openFileIntent)
                        }
                ) {
                    Row {
                        if (it.isPDF) {
                            Image(
                                painter = painterResource(id = R.drawable.pdf),
                                contentDescription = "File Icon",
                                modifier = Modifier
                                    .size(68.dp)
                            )
                        } else {
                            LoadSelectedImage(it.uri)
                        }
                        Image(
                            painter = painterResource(id = R.drawable.cancel),
                            contentDescription = "Cancel Icon",
                            modifier = Modifier
                                .size(16.dep)
                                .clickable {
                                    selectedFiles.remove(it)
                                    //selectedFiles.
                                }
                        )
                    }
                    Text(
                        text = it.fileName ?: "No file selected",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sep,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}
fun getFileNameFromUri(context: Context, uri: Uri): String? {
    val contentResolver = context.contentResolver
    val cursor = contentResolver.query(uri, null, null, null, null)
    val nameColumnIndex = cursor?.getColumnIndex(OpenableColumns.DISPLAY_NAME)
    return try {
        cursor?.moveToFirst()
        nameColumnIndex?.let {
            cursor?.getString(it)
        }
    } finally {
        cursor?.close()
    }
}
@SuppressLint("SuspiciousIndentation")
@Composable
fun LoadSelectedImage(uri: Uri) {
    val selectedImage = rememberImagePainter(data = uri)
    Image(
        painter = selectedImage,
        contentDescription = "Selected Image",
        modifier = Modifier
            .height(64.dep)
            .width(52.dep),
        contentScale = ContentScale.Crop,
        )
}
@Preview(showSystemUi = true)
@Composable
fun previewAssignTask() {
    AssignTaskScreen()
}