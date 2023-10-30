package com.vxplore.ams.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.vxplore.ams.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminDashBoard(){

    Box(
        contentAlignment = Alignment.Center,
        modifier=Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues( 8.dp)

        ) {
            items(count = 100) { index ->
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        //.border(1.dp, color = Color.Magenta, shape = CircleShape)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier=Modifier
                            .padding(8.dp)
                            .clip(CircleShape)
                            .border(1.5.dp,Color.Gray, CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "",
                            tint = Color.LightGray,
                            modifier = Modifier.size(170.dp)
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(bottom = 8.dp),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Text(
                                text = "Name", modifier = Modifier
                                .background(Color.White)
                                .padding(4.dp),
                                color = Color.Black
                            )

                        }
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(3.dp),
                        contentAlignment = Alignment.TopEnd
                    ) {
                        IconButton(
                            onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = "",
                                modifier = Modifier.background(Color.White, CircleShape),
                                tint = Color.Black
                            )
                        }
                    }


                }
            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun Preview3(){
    AdminDashBoard()
}