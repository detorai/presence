package org.example.project.ui.schedule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.datetime.Month
import org.example.project.domain.models.formatWeek
import org.example.project.domain.models.toRussianName
import org.example.project.ui.common.BottomBarScreen
import org.example.project.ui.common.PresenceBottomBar
import org.example.project.ui.common.ScheduleCard

data class ScheduleScreen(private val groupId: Int): Screen {
    @Composable
    override fun Content() {
        val navigator  = LocalNavigator.currentOrThrow
        val viewModel: ScheduleViewModel = koinScreenModel()
        val state = viewModel.state.collectAsState().value


        var currentScreen = BottomBarScreen.SCHEDULE
        LaunchedEffect(Unit){
            viewModel.getSchedule(groupId)
            state.error = state.schedule.toString()
        }
        Scaffold(
            bottomBar = {
                PresenceBottomBar(
                    currentScreen = currentScreen,
                    onPerson = { currentScreen = BottomBarScreen.PERSON },
                    onSchedule = { currentScreen = BottomBarScreen.SCHEDULE },
                    onSettings = { currentScreen = BottomBarScreen.SETTINGS }
                )
            },
        ) {
            Schedule(viewModel)
        }
    }


    @Composable
    fun Schedule(viewModel: ScheduleViewModel){
        val state = viewModel.state.collectAsState().value
        val groupedWeeks = remember(state.data) {
            state.data.weekList.groupBy { it.first_date.month }
                .toList()
                .sortedByDescending { (month, _) -> month }
        }
        Column(
            modifier = Modifier.fillMaxSize().padding(32.dp)
        ) {
            LazyColumn {
                groupedWeeks.forEach { (month, weeks) ->
                    item {
                        MonthHeader(month = month)
                    }

                    items(weeks.sortedByDescending { it.first_date }) { week ->
                        ScheduleCard(text = week.formatWeek(), onClick = {})
                    }
                }
            }
        }
    }
    @Composable
    private fun MonthHeader(month: Month) {
        Text(
            text = month.toRussianName(),
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}