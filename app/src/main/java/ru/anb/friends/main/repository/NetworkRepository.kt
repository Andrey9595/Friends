package ru.anb.friends.main.repository

import kotlinx.coroutines.flow.Flow
import ru.anb.friends.main.state.GroupsState

interface NetworkRepository {
    fun getGroups():Flow<GroupsState>
}