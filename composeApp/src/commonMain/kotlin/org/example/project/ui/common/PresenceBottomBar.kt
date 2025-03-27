package org.example.project.ui.common


import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Composable
fun PresenceBottomBar(
    currentScreen: BottomBarScreen,
    onPerson: () -> Unit,
    onSchedule: () -> Unit,
    onSettings: () -> Unit,
){
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Профиль", "Расписание", "Настройки")

    BottomNavigation(
        backgroundColor = Color(0xFF2c2c2c)
    ){
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = {
                    when (index) {
                        0 -> {
                            Icon(
                                imageVector = if (currentScreen == BottomBarScreen.PERSON) Icons.Default.Person else Icons.Outlined.Person,
                                contentDescription = "",
                                tint = if (currentScreen == BottomBarScreen.PERSON) Color.White else Color(0xFFd9d9d9)
                            )
                        }
                        1 -> {
                            Icon(
                                imageVector = if (currentScreen == BottomBarScreen.SCHEDULE) Icons.Default.DateRange else Icons.Outlined.DateRange,
                                contentDescription = "",
                                tint = if (currentScreen == BottomBarScreen.SCHEDULE) Color.White else Color(0xFFd9d9d9)
                            )

                        }
                        2 -> {
                            Icon(
                                imageVector = if (currentScreen == BottomBarScreen.SETTINGS) Icons.Default.Settings else Icons.Outlined.Settings,
                                contentDescription = "",
                                tint = if (currentScreen == BottomBarScreen.SETTINGS) Color.White else Color(0xFFd9d9d9)

                            )
                        }
                    }
                },
                label = {
                    when (index) {
                        0 -> {
                            Text(
                                item,
                                color = if (selectedItem == 0) Color.White else Color(0xFFd9d9d9)
                            )
                        }
                        1 -> {
                            Text(
                                item,
                                color = if (selectedItem == 1) Color.White else Color(0xFFd9d9d9)
                            )

                        }
                        2 -> {
                            Text(
                                item,
                                color = if (selectedItem == 2) Color.White else Color(0xFFd9d9d9)
                            )
                        }
                    }
                },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    when (index) {
                        0 -> {
                            onPerson()
                        }
                        1 -> {
                            onSchedule()
                        }
                        2 -> {
                            onSettings()
                        }
                    }
                }
            )
        }
    }
}

enum class BottomBarScreen {
    SCHEDULE, PERSON, SETTINGS
}