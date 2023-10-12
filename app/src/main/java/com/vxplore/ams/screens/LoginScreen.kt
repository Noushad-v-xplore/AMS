package com.vxplore.ams.screens

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.nio.file.WatchEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(){
    val value= remember{ mutableStateOf("") }
    val value2= remember{ mutableStateOf("") }

    Box(
        contentAlignment = Alignment.Center,
        modifier=Modifier.fillMaxSize()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "LOGIN",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 30.dp)
            )

            Card(
                elevation = CardDefaults.cardElevation(8.dp),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.wrapContentSize()
                ) {

                    Spacer(
                        modifier = Modifier.padding(vertical = 30.dp)
                    )
                    OutlinedTextField(
                        value = value.value,
                        onValueChange = { value.value = it },
                        modifier = Modifier
                            .padding(horizontal = 20.dp),
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 18.sp
                        )
                    )
                    Spacer(
                        modifier = Modifier.padding(vertical = 20.dp)
                    )
                    OutlinedTextField(
                        value = value2.value,
                        onValueChange = { value2.value = it },
                        modifier = Modifier
                            .padding(horizontal = 20.dp),
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 18.sp
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )
                    Spacer(
                        modifier = Modifier.padding(vertical = 20.dp)
                    )
                    Button(
                        onClick = { },
                        modifier = Modifier.width(180.dp)
                    ) {
                        Text(
                            text = "Login",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                    }
                    Spacer(
                        modifier = Modifier.padding(vertical = 30.dp)
                    )
                }
            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun previewLogin(){
    LoginScreen()
}