package com.vxplore.ams.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class  List(
    val CheckInTime:String,
    val CheckOutTime:String,

)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployeeDashBoard(){
    val checkedIn = remember{ mutableStateOf(false) }
    val list = mutableListOf<List>()
    list.add(List("5.2","2.3"))
    list.add(List("5.3","2.4"))
    list.add(List("5.2","2.5"))
    list.add(List("4.2","2.6"))
    list.add(List("9.2","2.4"))
    list.add(List("3.2","2.3"))
    list.add(List("1.2","2.4"))
    list.add(List("8.2","2.7"))
    list.add(List("4.2","2.9"))
    list.add(List("4.2","2.9"))
    list.add(List("4.2","2.9"))
    list.add(List("4.2","2.9"))
    list.add(List("4.2","2.9"))
    list.add(List("4.2","2.9"))
    list.add(List("4.2","2.9"))
    list.add(List("4.2","2.9"))
    list.add(List("4.2","2.9"))
    list.add(List("4.2","2.9"))
    list.add(List("4.2","2.9"))
    list.add(List("4.2","2.9"))
    Box (
        modifier= Modifier
            .fillMaxSize()
    ){
        Column {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                ) {
                    Button(
                        onClick =
                        {

                        },
                        colors = if (checkedIn.value == false) {//false
                            ButtonDefaults.buttonColors(Color.Green)
                        } else {
                            ButtonDefaults.buttonColors(Color.Red)
                        }
                    ) {
                        Text(
                            text = if (checkedIn.value == false) {//false
                                "Check In"
                            } else {
                                "Check Out"
                            },
                            color = if (checkedIn.value == false) {//false
                                Color.Black
                            } else {
                                Color.White
                            }
                        )
                    }
                }
            }

            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier= Modifier
                    .padding(bottom = 50.dp)
                    .fillMaxSize()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier= Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxSize()
                        .border(1.dp, Color.Gray)
                ) {
                    LazyColumn(modifier=Modifier.fillMaxSize()){
                        items(list){
                            Card(
                                elevation = CardDefaults.cardElevation(8.dp),
                                onClick = {

                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    //.wrapContentHeight()
                                    .border(1.dp, Color.Gray)
                            ) {
                                Row (
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier= Modifier
                                        .padding(horizontal = 8.dp)
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp)
                                ) {
                                    Text(text = "Today")

                                    Row {
                                        Text(text = "Working Hour: ")
                                        Text(text = it.CheckOutTime+" hr")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun previewDash(){
    EmployeeDashBoard()
}