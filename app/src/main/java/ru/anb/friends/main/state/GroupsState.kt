package ru.anb.friends.main.state

import ru.anb.friends.main.dto.Group

sealed class GroupsState {
    class Success(val listGroup: List<Group>): GroupsState()
    class Loading(): GroupsState()
    class Error(val exception: Throwable): GroupsState()
    class Empty(): GroupsState()
}