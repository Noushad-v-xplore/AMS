package com.vxplore.ams.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.debduttapanda.j3lib.dep
import com.debduttapanda.j3lib.sep
import com.vxplore.ams.R

@Composable
fun NavigationScreen(
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Open)
){
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFF9F9F9)),
                    //contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dep)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = stringResource(id = R.string.logo),
                            modifier = Modifier
                                .height(104.dep)
                                .width(100.dep)
                        )

                        Text(
                            text = stringResource(id = R.string.vxplore_technologies),
                            fontSize = 24.sep,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF4D4D4D),
                            modifier = Modifier
                                .padding(start = 12.dep, top = 16.dep)
                        )
                        Row(
                            modifier = Modifier
                                .padding(start = 16.dep, top = 30.26.dep),
                            verticalAlignment = Alignment.CenterVertically,
                            //horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.myhome),
                                contentDescription = stringResource(id = R.string.home),
                                modifier = Modifier
                                    .height(32.74.dep)
                                    .width(32.74.dep),
                                contentScale = ContentScale.Fit
                            )
                            Spacer(
                                modifier = Modifier
                                    .width(28.dep)
                            )
                            Text(
                                text = stringResource(id = R.string.home),
                                fontSize = 18.sep,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF707070),
                                modifier = Modifier
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(start = 16.dep, top = 28.dep),
                            verticalAlignment = Alignment.CenterVertically,
                            //horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.dotmenu),
                                contentDescription = stringResource(id = R.string.mytask),
                                modifier = Modifier
                                    .height(25.73.dep)
                                    .width(24.74.dep)
                            )
                            Spacer(
                                modifier = Modifier
                                    .width(32.dep)
                            )
                            Text(
                                text = stringResource(id = R.string.mytask),
                                fontSize = 18.sep,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF707070),
                                modifier = Modifier
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(start = 16.dep, top = 28.dep),
                            verticalAlignment = Alignment.CenterVertically,
                            //horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.email),
                                contentDescription = stringResource(id = R.string.inbox),
                                modifier = Modifier
                                    .height(25.73.dep)
                                    .width(24.74.dep)
                            )
                            Spacer(
                                modifier = Modifier
                                    .width(32.dep)
                            )
                            Text(
                                text = stringResource(id = R.string.inbox),
                                fontSize = 18.sep,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF707070),
                                modifier = Modifier
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(start = 16.dep, top = 28.dep),
                            verticalAlignment = Alignment.CenterVertically,
                            //horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.rocket),
                                contentDescription = stringResource(id = R.string.projects),
                                modifier = Modifier
                                    .height(25.73.dep)
                                    .width(24.74.dep)
                            )
                            Spacer(
                                modifier = Modifier
                                    .width(32.dep)
                            )
                            Text(
                                text = stringResource(id = R.string.projects),
                                fontSize = 18.sep,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF707070),
                                modifier = Modifier
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(start = 16.dep, top = 28.dep),
                            verticalAlignment = Alignment.CenterVertically,
                            //horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.report),
                                contentDescription = stringResource(id = R.string.reports),
                                modifier = Modifier
                                    .height(24.73.dep)
                                    .width(24.74.dep)
                            )
                            Spacer(
                                modifier = Modifier
                                    .width(32.dep)
                            )
                            Text(
                                text = stringResource(id = R.string.reports),
                                fontSize = 18.sep,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF707070),
                                modifier = Modifier
                            )
                        }

                        Row(
                            modifier = Modifier
                                .padding(start = 16.dep, top = 28.dep),
                            verticalAlignment = Alignment.CenterVertically,
                            //horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.goal),
                                contentDescription = stringResource(id = R.string.goals),
                                modifier = Modifier
                                    .height(24.73.dep)
                                    .width(24.74.dep)
                            )
                            Spacer(
                                modifier = Modifier
                                    .width(32.dep)
                            )
                            Text(
                                text = stringResource(id = R.string.goals),
                                fontSize = 18.sep,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF707070),
                                modifier = Modifier
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(start = 16.dep, top = 28.dep),
                            verticalAlignment = Alignment.CenterVertically,
                            //horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.employee),
                                contentDescription = stringResource(id = R.string.employees),
                                modifier = Modifier
                                    .height(24.73.dep)
                                    .width(24.74.dep)
                            )
                            Spacer(
                                modifier = Modifier
                                    .width(32.dep)
                            )
                            Text(
                                text = stringResource(id = R.string.employees),
                                fontSize = 18.sep,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF707070),
                                modifier = Modifier
                            )
                        }

                        Row(
                            modifier = Modifier
                                .padding(start = 16.dep, top = 28.dep),
                            verticalAlignment = Alignment.CenterVertically,
                            //horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.team),
                                contentDescription = stringResource(id = R.string.teams),
                                modifier = Modifier
                                    .height(25.73.dep)
                                    .width(24.74.dep)
                            )
                            Spacer(
                                modifier = Modifier
                                    .width(32.dep)
                            )
                            Text(
                                text = stringResource(id = R.string.teams),
                                fontSize = 18.sep,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF707070),
                                modifier = Modifier
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(start = 16.dep, top = 28.dep),
                            verticalAlignment = Alignment.CenterVertically,
                            //horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.settings),
                                contentDescription = stringResource(id = R.string.settings),
                                modifier = Modifier
                                    .height(24.73.dep)
                                    .width(24.74.dep)
                            )
                            Spacer(
                                modifier = Modifier
                                    .width(32.dep)
                            )
                            Text(
                                text = stringResource(id = R.string.settings),
                                fontSize = 18.sep,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF707070),
                                modifier = Modifier
                            )
                        }
                    }
                }
            }
        }
    ) {
       TodoScreen()
    }
}

@Preview(showSystemUi = true)
@Composable
fun previewNav() {
    NavigationScreen()
}