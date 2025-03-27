package org.example.project.data.remote.group

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.example.project.data.model.ResponseState

class GroupRepository(private val groupImpl: GroupImpl) {
    fun getGroup(groupId: Int): Flow<ResponseState> = flow {
        return@flow try {
            val result  = groupImpl.getGroup(groupId)
            emit (ResponseState.Success(result))
        }catch (e: Exception) {
            emit (ResponseState.Error(e.message.toString()))
        }
    }
}