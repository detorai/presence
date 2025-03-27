package org.example.project.data.remote.schedule

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.project.data.model.ResponseState

class ScheduleRepository(private val scheduleImpl: ScheduleImpl) {
    fun getSchedule(groupId: Int):Flow<ResponseState> = flow {
        return@flow try {
            val result = scheduleImpl.getSchedule(groupId)
            emit( ResponseState.Success(result))
        } catch (e: Exception) {
            emit(ResponseState.Error(e.message.toString()))
        }
    }
}