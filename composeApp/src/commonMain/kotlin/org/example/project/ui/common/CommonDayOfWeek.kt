package org.example.project.ui.common

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.math.roundToInt


@Composable
fun WeekDaySelector() {
    val daysOfWeek = listOf("Пн", "Вт", "Ср", "Чт", "Пт")
    var currentDayIndex by remember { mutableStateOf(0) }
    val coroutineScope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxWidth()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            daysOfWeek.forEachIndexed { index, day ->
                val isSelected = index == currentDayIndex
                Box(
                    modifier = if (isSelected) Modifier
                        .size(45.dp, 32.dp)
                        .background(Color(0xFF2c2c2), RoundedCornerShape(8.dp))
                        .clickable {
                            if (index != currentDayIndex) {
                                coroutineScope.launch {
                                    currentDayIndex = index
                                }
                            }
                        }
                    else  Modifier.size(45.dp, 32.dp)
                        .clickable {
                            if (index != currentDayIndex) {
                                coroutineScope.launch {
                                    currentDayIndex = index
                                }
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = day,
                    )
                }
            }
        }
    }
}




