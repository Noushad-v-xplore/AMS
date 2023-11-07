package com.vxplore.ams.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.debduttapanda.j3lib.dep
import com.debduttapanda.j3lib.sep
import com.vxplore.ams.R

@Composable
fun SplashScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(bottom = 100.dp)
            .background(color = Color(0xFFfffbff))
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier
                //.padding(bottom = 100.dp)
                .height(120.dp)
                .width(196.dp),
        )
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        Text(
            text = stringResource(id = R.string.vxplore_technologies),
            fontSize = 24.sep,
            color = Color(0xFF4D4D4D),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                //.padding(bottom = 100.dp)
                //.padding(start = 28.dep)
        )
    }
}
@Preview(showSystemUi = true)
@Composable
fun PreviewSplash() {
        SplashScreen()
}