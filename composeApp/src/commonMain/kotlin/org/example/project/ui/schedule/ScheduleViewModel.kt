package org.example.project.ui.schedule

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow

class ScheduleViewModel: ScreenModel {
    val state = MutableStateFlow(ScheduleScreenState())

}