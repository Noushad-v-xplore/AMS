package com.vxplore.ams.screens
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.debduttapanda.j3lib.dep
import com.debduttapanda.j3lib.listState
import com.debduttapanda.j3lib.sep
import com.debduttapanda.j3lib.str
import com.debduttapanda.j3lib.times
import com.vxplore.ams.MyDataIds
import com.vxplore.ams.R
import com.vxplore.ams.models.attendenceList
import com.vxplore.ams.models.taskList



@Composable
fun MobileTeamScreen(
    attendenceList: SnapshotStateList<attendenceList> = listState(key = MyDataIds.attendenceList),
    taskList: SnapshotStateList<taskList> = listState(key = MyDataIds.taskList)
) {
    val status = remember{ mutableStateOf("") }
    Box(
        modifier = Modifier
            .background(Color(0xFFFBFBFB))
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
                        .height(16.dep)
                        .width(18.dep)
                        .clickable {
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
            Spacer(modifier = Modifier.height(16.dep))
            Text(
                text = stringResource(id = R.string.mobile_app_team),
                fontSize = 14.sep,
                color = Color(0xFF6D6D6D),
                modifier = Modifier
            )
            LazyRow(
                modifier = Modifier
                    .padding(top = 12.dep, start = 16.dep, end = 16.dep)
                    .background(Color(0xFFFBFBFB))
                    .fillMaxWidth()
            ) {
                items(attendenceList) {
                    Box {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .height(73.dep)
                                .width(73.dep)
                                .border(1.dep, Color(0xFFEFEFEF), CircleShape)
                                .clip(CircleShape)
                        ) {
                            AsyncImage(
                                model = it.Image, contentDescription = "",
                                contentScale = ContentScale.Crop,
                            )
                        }
                        Box(
                            modifier = Modifier
                                //.padding(end = 10.dep, bottom = 10.dep)
                                .height(73.dep)
                                .width(73.dep),
                            contentAlignment = Alignment.BottomEnd
                        ) {
                            val status = it.status
                            Icon(
                                painter = painterResource(id = R.drawable.present),
                                contentDescription = "",
                                tint = if (status=="Present") {Color(0xFF7DE200)} else if(status =="Leave") {Color(0xFFFF9900)} else{Color(0xFFE43131)},
                                modifier = Modifier
                                    .padding(end = 5.dep)
                                    .height(16.dep)
                                    .width(16.dep)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(12.dep))
                }
            }
            Spacer(modifier = Modifier.height(36.dep))
            Box {
                LazyColumn(
                    modifier = Modifier
                        .background(Color(0xFFFBFBFB))
                        .height(500.dep)
                        //.fillMaxHeight()
                        .fillMaxWidth()
                ) {
                    items(taskList) {
                        Row(
                            modifier = Modifier
                                //.padding(start = 16.dep, end = 20.dep)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = it.Name,
                                fontSize = 10.sep,
                                color = Color(0xFF6D6D6D),
                                modifier = Modifier
                                    .padding(start = 16.dep)
                            )
                            Text(
                                text = it.Time,
                                fontSize = 10.sep,
                                color = Color(0xFF6D6D6D),
                                modifier = Modifier
                                    .padding(end = 20.dep)
                            )
                        }
                        Spacer(modifier = Modifier.height(6.dep))
                        Card(
                            modifier = Modifier
                                .padding(start = 16.dep, end = 20.dep)
                                //.border(2.dp, Color.Black)
                                .background(color = Color.White)
                                .height(136.dep)
                                .fillMaxWidth(),
                            elevation = CardDefaults.cardElevation(8.dep),
                            shape = RoundedCornerShape(4.dep),
                            colors = CardDefaults.cardColors(Color.White)
                        ) {
                            Row(
                                modifier = Modifier
                                    //.padding(start = 16.dep, end = 20.dep)
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = it.Task,
                                    fontSize = 14.sep,
                                    color = Color(0xFF6D6D6D),
                                    modifier = Modifier
                                        .padding(start = 14.dep)
                                )
                                CircularImageStack()
                            }
                            Text(
                                text = it.Project,
                                fontSize = 10.sep,
                                color = Color(0xFF1F72AA),
                                modifier = Modifier
                                    .padding(start = 14.dep)
                            )
                            Spacer(modifier = Modifier.height(9.dp))
                            Text(
                                text = it.Description,
                                fontSize = 11.sep,
                                color = Color(0xFF6D6D6D),
                                modifier = Modifier
                                    .padding(start = 14.dep, end = 12.dep)
                            )
                            Row(
                                modifier = Modifier
                                    .padding(top = 20.dep)
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    modifier = Modifier,
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.comment),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .padding(start = 14.dep)
                                            .height(11.43.dep)
                                            .width(11.43.dep)
                                    )
                                    Text(
                                        text = it.Comment,
                                        fontSize = 12.sep,
                                        color = Color(0xFF6D6D6D),
                                        modifier = Modifier
                                            .padding(start = 2.dep)
                                    )

                                    Image(
                                        painter = painterResource(id = R.drawable.boxtik),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .padding(start = 17.dep)
                                            .height(11.43.dep)
                                            .width(11.43.dep)
                                    )
                                    Text(
                                        text = it.Done,
                                        fontSize = 12.sep,
                                        color = Color(0xFF6D6D6D),
                                        modifier = Modifier
                                            .padding(start = 2.dep)
                                    )

                                    Image(
                                        painter = painterResource(id = R.drawable.tag),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .padding(start = 17.dep)
                                            .height(11.43.dep)
                                            .width(5.71.dep)
                                    )
                                    Text(
                                        text =it.Attachment,
                                        fontSize = 12.sep,
                                        color = Color(0xFF6D6D6D),
                                        modifier = Modifier
                                            .padding(start = 2.dep)
                                    )
                                }
                                Row {

                                    Image(
                                        painter = painterResource(id = R.drawable.calender),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .padding(end = 2.dep)
                                            .height(14.dep)
                                            .width(14.dep)
                                    )
                                    Text(
                                        text = it.Date,
                                        fontSize = 12.sep,
                                        color = Color(0xFF6D6D6D),
                                        modifier = Modifier
                                            .padding(end = 12.dep)
                                    )
                                }
                            }
                        }
                        Spacer(
                            modifier = Modifier
                                .height(50.dep)
                        )
                    }
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
    }
}

@Composable
fun CircularImageStack(
    cmntList: SnapshotStateList<String> = listState(key = MyDataIds.cmntList)
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
        val visibleImageCount = minOf(cmntList.size, 4)
        val hiddenImageCount = maxOf(cmntList.size - 4, 0)

        // Display up to 3 visible images with custom offsets
        for (i in 0 until visibleImageCount) {
            val imageOffsetX = i * overlapOffsetX
            val imageOffsetY = i * overlapOffsetY
            AsyncImage(
                model = cmntList[i],
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
                    .background(Color.Gray, CircleShape)
                    .size(imageSize)
            ) {
                Text(
                    text = "+$hiddenImageCount",
                    color = Color.White,
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun previewMobileTeamScreen() {
    MobileTeamScreen()
}