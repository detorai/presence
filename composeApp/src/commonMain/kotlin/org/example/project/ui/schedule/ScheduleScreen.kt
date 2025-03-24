package org.example.project.ui.schedule

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.datetime.DayOfWeek
import org.example.project.ui.common.CommonBottomBar
import org.example.project.ui.common.CommonTopBarForWeek
import org.example.project.ui.common.WeekDaySelector

class ScheduleScreen: Screen {
    @Composable
    override fun Content() {
        val navigator  = LocalNavigator.currentOrThrow
        val viewModel: ScheduleViewModel = koinScreenModel()
        Scaffold(
            bottomBar = { CommonBottomBar(onSchedule = {}, onSettings = {}, onPerson = {})},
            topBar = { CommonTopBarForWeek("01.12")}
        ) {
            Schedule(viewModel)
        }
    }


    @Composable
    fun Schedule(viewModel: ScheduleViewModel){
        WeekDaySelector()
    }
}