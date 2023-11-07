/*
package com.vxplore.ams.screens

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AppRegistration
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.debduttapanda.j3lib.NotificationService
import com.debduttapanda.j3lib.boolState
import com.debduttapanda.j3lib.dep
import com.debduttapanda.j3lib.intState
import com.vxplore.ams.MyDataIds
import com.vxplore.ams.R
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawerScreen(
    selectedDrawerMenu: Int = intState(key = MyDataIds.selectedDrawerMenu).value,
    //logoutDialogShow: Boolean = boolState(key = MyDataIds.logoutDialog).value,
    notifier : NotificationService = com.debduttapanda.j3lib.notifier(),
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Spacer(Modifier
                    .height(12.dep))
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "") },
                    label = { Text("Home") },
                    selected = 1 == selectedDrawerMenu,
                    onClick = {
                        scope.launch { drawerState.close() }
                        // notifier.notify(DataIds.selectedDrawerMenu,3)
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
                Spacer(Modifier.height(12.dep))
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.List, contentDescription = "") },
                    label = { Text("Order List") },
                    selected = 1 == selectedDrawerMenu,
                    onClick = {
                        scope.launch { drawerState.close() }
                        //notifier.notify(DataIds.selectedDrawerMenu,1)
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
                Spacer(Modifier.height(12.dep))
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.AppRegistration, contentDescription = "") },
                    label = { Text("Attendance") },
                    selected = 2 == selectedDrawerMenu,
                    onClick = {
                        scope.launch { drawerState.close() }
                        notifier.notify(MyDataIds.selectedDrawerMenu,2)
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
                Spacer(Modifier.height(12.dep))
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Logout, contentDescription = "") },
                    label = { Text("Logout") },
                    selected = 0 == selectedDrawerMenu,
                    onClick = {
                        scope.launch { drawerState.close() }
                        notifier.notify(MyDataIds.selectedDrawerMenu,0)
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
            }

        },
        //gesturesEnabled = false,
        drawerState = drawerState
    )
    {
    */
/* Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Behla Fashion Store",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch { drawerState.open() }
                            }
                        ){
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "hamburger",
                                tint = Color.White
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {
                                //Yet to be implemented
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.dot),
                                contentDescription = "bell",
                                tint = Color.White
                            )
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFFD1311A))
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        //notifier.notify(DataIds.GoToSalePage)
                        //Floating ActionButton
                    },
                    containerColor = Color(0xFFFFFFFF),
                    contentColor = Color.Black,
                    shape = CircleShape,
                    modifier = Modifier
                        .wrapContentSize()
                ) {
                    Icon(painterResource(id = R.drawable.camera), "floating action button.")
                }
            }
        )
        {

            TodoScreen()
            //dashboardBody(notifier)
        }*//*

    }
  */
/* if(logoutDialogShow){
        AlertDialog(
            onDismissRequest = {
                //notifier.notify(DataIds.logoutDialog,0)
            }, confirmButton = {
                TextButton(
                    onClick = {
                        // notifier.notify(DataIds.logoutDialog,1)
                    }
                ) {
                    Text("Yes")
                }

            },
            dismissButton = {
                Button(
                    onClick = {
                        //notifier.notify(DataIds.logoutDialog,-1)
                    }
                ) {
                    Text("Cancel")
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Logout,
                    contentDescription = "",
                    tint = Color.Red
                )
            },
            title = {
                Text("Logout")
            },
            text = {
                Text("Are you sure to logout?")
            }
        )
    }*//*


}

@Preview(showSystemUi = true)
@Composable
fun previewNav() {
    NavigationDrawerScreen()
}*/
