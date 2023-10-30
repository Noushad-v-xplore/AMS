package com.vxplore.ams.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.debduttapanda.j3lib.NotificationService
import com.debduttapanda.j3lib.dep
import com.debduttapanda.j3lib.sep
import com.debduttapanda.j3lib.stringState
import com.vxplore.ams.MyDataIds
import com.vxplore.ams.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    email: State<String> = stringState(key = MyDataIds.email),
    password: State<String> = stringState(key = MyDataIds.password),
    notifier: NotificationService = com.debduttapanda.j3lib.notifier(),
) {
    //val value2= remember{ mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 123.dep)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(id = R.string.logo),
            modifier = Modifier
                .height(84.dp)
                .width(82.dp),
        )
        Text(
            text = stringResource(R.string.sign_in_to_vxplore_technologies),
            fontSize = 12.sep,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF707070),
            modifier = Modifier
                .padding(bottom = 45.dep)
        )
        OutlinedTextField(
            value = email.value,
            onValueChange = {
                notifier.notify(MyDataIds.email, it)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            placeholder = {
                Text(stringResource(id = R.string.enter_your_email_id), color = Color(0xFFC7C7C7))
            },
            modifier = Modifier
                .padding(horizontal = 20.dep)
                .border(
                    width = 1.dep,
                    color = Color(0xFFF1F1F1),
                    shape = RoundedCornerShape(4.dep)
                )
                .fillMaxWidth(),
            textStyle = TextStyle(
                color = Color(0xFFC7C7C7),
                fontSize = 11.sep
            )
        )
        Spacer(
            modifier = Modifier
                .height(12.dep)
        )
        OutlinedTextField(
            value = password.value,
            onValueChange = {
                notifier.notify(MyDataIds.password, it)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            placeholder = {
                Text(
                    stringResource(id = R.string.password),
                    color = Color(0xFFC7C7C7)
                )
            },
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .border(1.dep, Color(0xFFF1F1F1), shape = RoundedCornerShape(4.dep))
                .fillMaxWidth(),
            textStyle = TextStyle(
                color = Color(0xFFC7C7C7),
                fontSize = 11.sep
            )
        )
        Spacer(
            modifier = Modifier
                .height(12.dep)
        )
        Button(
            onClick = {
                notifier.notify(com.vxplore.ams.MyDataIds.login)
            },
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .height(48.dep)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color(0xFF4FAC4C)),
            shape = RoundedCornerShape(4.dep)
        ) {
            Text(
                text = stringResource(id = R.string.login_now),
                fontSize = 12.sep,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Spacer(
            modifier = Modifier
                .padding(vertical = 30.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun previewLogin() {
    LoginScreen()
}