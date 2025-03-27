package org.example.project.data.remote.group

import org.example.project.data.model.group.GroupResponse

class GroupImpl(private val groupInterface: GroupInterface) {
    suspend fun getGroup(groupId: Int): GroupResponse = groupInterface.getGroupStudents(groupId)
}