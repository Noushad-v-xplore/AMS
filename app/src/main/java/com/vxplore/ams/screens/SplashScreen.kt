package com.vxplore.ams.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.vxplore.ams.R

@Composable
fun SplashScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier= Modifier
            .fillMaxSize()
    ){
        AsyncImage(
            model = R.drawable.logo,
            contentDescription ="",
            modifier= Modifier.size(200.dp)
        )
    }
}
@Preview(showSystemUi = true)
@Composable
fun PreviewSplash() {
        SplashScreen()
}