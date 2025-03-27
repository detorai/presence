package org.example.project.ui.schedule

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDate
import kotlinx.datetime.Month
import org.example.project.data.model.ResponseState
import org.example.project.data.remote.schedule.ScheduleRepository
import org.example.project.domain.models.DaysOfWeek
import org.example.project.domain.models.MonthWithWeek
import org.example.project.domain.models.Schedule

class ScheduleViewModel(private val repository: ScheduleRepository): ScreenModel {
    val list = listOf(
        DaysOfWeek(
            first_date = LocalDate(2025, Month.MARCH, 24),
            last_date = LocalDate(2025,Month.MARCH,28)
        ),
        DaysOfWeek(
            first_date = LocalDate(2025, Month.APRIL, 24),
            last_date = LocalDate(2025,Month.MAY,28)
        ),
        DaysOfWeek(
            first_date = LocalDate(2025, Month.APRIL, 17),
            last_date = LocalDate(2025,Month.APRIL,21)
        ),
        DaysOfWeek(
            first_date = LocalDate(2025, Month.MAY, 24),
            last_date = LocalDate(2025,Month.MAY,28)
        )
    )
    val state = MutableStateFlow(ScheduleScreenState(data = MonthWithWeek(list)))


    fun getSchedule(groupId: Int){
        screenModelScope.launch {
            val result = repository.getSchedule(groupId)
            result.collect{response ->
                when (response) {
                    is ResponseState.Success<*> -> {
                        state.update{
                            it.copy(
                                schedule = response.data as List<Schedule>
                            )
                        }
                    }
                    is ResponseState.Error -> {
                        state.update{
                            it.copy(
                                error = response.error
                            )
                        }
                    }
                }
            }
        }
    }

}