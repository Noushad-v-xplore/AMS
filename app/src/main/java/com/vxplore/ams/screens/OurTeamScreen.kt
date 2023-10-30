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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.debduttapanda.j3lib.DataIds
import com.debduttapanda.j3lib.dep
import com.debduttapanda.j3lib.listState
import com.debduttapanda.j3lib.sep
import com.debduttapanda.j3lib.times
import com.vxplore.ams.MyDataIds
import com.vxplore.ams.R
import com.vxplore.ams.models.teamList
import com.vxplore.ams.models.teamName


@Composable
fun OurTeamScreen(
    teamName:SnapshotStateList<teamName> = listState(key = MyDataIds.teamName)
) {
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
            Spacer(modifier = Modifier.height(12.dep))
            Text(
                text = stringResource(id = R.string.our_team),
                fontSize = 24.sep,
                color = Color(0xFF6D6D6D),
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(12.dep))
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .background(Color(0xFFFBFBFB))
                            //.height(500.dep)
                            //.fillMaxHeight()
                            .fillMaxWidth()
                    ) {
                        items(teamName) {
                            Card(
                                modifier = Modifier
                                    .padding(start = 16.dep, end = 20.dep)
                                    //.border(2.dp, Color.Black)
                                    .background(color = Color.White)
                                    .height(106.dep)
                                    .fillMaxWidth(),
                                elevation = CardDefaults.cardElevation(8.dep),
                                shape = RoundedCornerShape(4.dep),
                                colors = CardDefaults.cardColors(Color.White)
                            ) {
                                Text(
                                    text = it.team,
                                    fontSize = 14.sep,
                                    color = Color(0xFF6D6D6D),
                                    modifier = Modifier
                                        .padding(top = 8.dep, start = 8.dep)
                                )
                                ImageStack()
                            }
                            Spacer(modifier = Modifier.height(20.dep))
                        }
                    }
                }
                Box(
                    contentAlignment = Alignment.BottomCenter,
                    modifier = Modifier
                        //.background(Color(0xFFF9F9F9))
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
        }
    }
}

@Composable
fun ImageStack(
    teamList:SnapshotStateList<teamList> = listState(key = MyDataIds.teamList)
) {
    val overlapOffsetX = 56.dep // Adjust the X-axis overlap offset
    val overlapOffsetY = 0.dep // Y-axis overlap offset
    Box(
        //contentAlignment = Alignment.Center,
        modifier = Modifier
            /* .padding(start = 17.dep, end = 10.dep)
            .height(73.dep)
            .fillMaxWidth()*/
            .fillMaxSize()
            //.border(1.dep, Color(0xFFEFEFEF), CircleShape)
            .clip(CircleShape)
    ) {
        val visibleImageCount = minOf(teamList.size, 5)
        val hiddenImageCount = maxOf(teamList.size - 4, 0)
        // Display up to 3 visible images with custom offsets
        for (i in 0 until visibleImageCount) {
            val imageOffsetX = i * overlapOffsetX
            val imageOffsetY = i * overlapOffsetY
            AsyncImage(
                model = teamList[i].Image, contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(top = 6.dep, start = 8.dep)
                    .offset { IntOffset(imageOffsetX.roundToPx(), imageOffsetY.roundToPx()) }
                    .size(56.dep)
                    .clip(CircleShape)
                    .border(0.5.dep, Color.White, CircleShape)
            )
            Box(
                modifier = Modifier
                    //.padding(end = 10.dep, bottom = 10.dep)
                    .height(73.dep)
                    .width(73.dep),
                contentAlignment = Alignment.BottomEnd
            ) {
                val status = teamList[i].status
                Icon(
                    painter = painterResource(id = R.drawable.present),
                    contentDescription = "",
                    tint = if (status == "Present") {
                        Color(0xFF7DE200)
                    } else if (status == "Leave") {
                        Color(0xFFFF9900)
                    } else {
                        Color(0xFFE43131)
                    },
                    modifier = Modifier
                        .padding(end = 12.dep, bottom = 12.dep)
                        .offset { IntOffset(imageOffsetX.roundToPx(), imageOffsetY.roundToPx()) }
                        .height(12.dep)
                        .width(12.dep)
                )
            }
            //StatusIcon(teamList[i].status)
        }
        if (hiddenImageCount > 0) {
            val hiddenImagesOffsetX = (visibleImageCount - 1) * overlapOffsetX
            val hiddenImagesOffsetY = (visibleImageCount - 1) * overlapOffsetY
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(top = 2.dep, start = 8.dep)
                    .offset {
                        IntOffset(
                            hiddenImagesOffsetX.roundToPx(),
                            hiddenImagesOffsetY.roundToPx()
                        )
                    }
                    //.clip(CircleShape)
                    .background(Color.White)
                    .size(73.dep)
            ) {
                Text(
                    text = "+$hiddenImageCount",
                    color = Color(0xFF6D6D6D),
                    fontSize = 14.sep,
                    modifier = Modifier
                        .padding(end = 28.dep, bottom = 16.dep)
                        .clickable {
                        }
                )
            }
        }
    }

}




@Preview(showSystemUi = true)
@Composable
fun previewOurTeamScreen() {
    OurTeamScreen()
}