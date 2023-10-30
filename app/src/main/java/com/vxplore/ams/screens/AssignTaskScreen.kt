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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.debduttapanda.j3lib.dep
import com.debduttapanda.j3lib.sep
import com.vxplore.ams.R

@Composable
fun AssignTaskScreen() {

    var isDropdownVisible by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("Recently assigned") }
    val items = listOf("Option 1", "Option 2", "Option 3")

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
                    .background(Color(0xFFFBFBFB))
                    .padding(horizontal = 16.dep)
                    .height(54.dep)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "",
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
                        contentDescription = "",
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
                        contentDescription = "",
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
                        contentDescription = "",
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
                        contentDescription = "",
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
                        text = "Assigned to",
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
                        text = "My Tasks",
                        fontSize = 10.sep,
                        color = Color(0xFF6D6D6D),
                        modifier = Modifier
                            .padding(start = 8.dep)
                    )
                     Row(
                         verticalAlignment = Alignment.CenterVertically
                     ) {

                     Text(
                         text = "Recently assigned",
                         fontSize = 12.sep,
                         color = Color.Black,
                         fontWeight = FontWeight.Bold,
                         modifier = Modifier
                             .padding(start = 8.dep)
                     )


                         Image(
                             painter = painterResource(id = R.drawable.dropdown),
                             contentDescription = "",
                             modifier = Modifier
                                 .height(20.dep)
                                 .width(20.dep)
                                 .clickable {


                                     Log.d("cdc", "clicked")
                                 }

                         )

                     }
                    if (isDropdownVisible) {

                        DropdownMenu(
                            expanded = isDropdownVisible,
                            onDismissRequest = {
                                isDropdownVisible = false
                            }
                        )
                        {
                            items.forEach{
                                item ->
                               DropdownMenuItem(text = { /*TODO*/ },
                                   onClick = {
                                       selectedItem = item
                                       isDropdownVisible = false
                                   }
                               )

                            }
                        }
                    }
                }
            }
        }
    }
}

/*@Composable
fun DropdownExample() {
    var isDropdownVisible by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("Recently assigned") }
    val items = listOf("Option 1", "Option 2", "Option 3")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Recently assigned",
                fontSize = 12.sep,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 8.dep)
            )


            Image(
                painter = painterResource(id = R.drawable.dropdown),
                contentDescription = "",
                modifier = Modifier
                    .height(20.dep)
                    .width(20.dep)
                    .clickable {


                        Log.d("cdc", "clicked")
                    }

            )

        }

        if (isDropdownVisible) {
            DropdownMenu(
                expanded = isDropdownVisible,
                onDismissRequest = {
                    isDropdownVisible = false
                }
            ) {
                items.forEach { item ->
                    DropdownMenuItem(
                        onClick = {
                            selectedItem = item
                            isDropdownVisible = false
                        }
                    ) {
                        Text(text = item)
                    }
                }
            }
        }
    }
}*/

@Preview(showSystemUi = true)
@Composable
fun previewAssignTask() {
    AssignTaskScreen()
}