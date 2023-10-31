package com.vxplore.ams.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.debduttapanda.j3lib.DataIds
import com.debduttapanda.j3lib.NotificationService
import com.debduttapanda.j3lib.dep
import com.debduttapanda.j3lib.notifier
import com.vxplore.ams.MyDataIds

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Rnd(
    notifier:NotificationService = com.debduttapanda.j3lib.notifier()
){

    var gexpanded by remember {
        mutableStateOf(false)
    }
    var cexpanded by remember {
        mutableStateOf(false)
    }
    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4")
   ExposedDropdownMenuBox(
        expanded = gexpanded,
        onExpandedChange = {
            gexpanded = !gexpanded
        },
        /*modifier = Modifier
        .fillMaxWidth()
        .weight(1f),*/
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dep))
                .border(
                    width = 1.dep,
                    color = Color.Gray,
                    shape = RoundedCornerShape(8.dep)
                )
                /*.clickable {
                expanded = true
            }*/
                .padding(16.dep),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
              "njcfdn"
                //fontSize = 15.sep
            )

            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "",
            )
        }
        ExposedDropdownMenu(
            expanded = gexpanded,
            onDismissRequest = { gexpanded = !gexpanded },
            modifier = Modifier
                .background(
                    Color.White,
                    RoundedCornerShape(8.dep)
                )
        ) {
            items.forEach {items->
                DropdownMenuItem(text = { /*TODO*/ }, onClick = { /*TODO*/ })

            }
        }
    }
}
/*

DropdownMenuItem(
onClick = {
    notifier.notify(MyDataIds.items, it)
    gexpanded = !gexpanded
}
)*/
