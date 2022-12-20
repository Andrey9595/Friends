package ru.anb.friends.main.repository

import com.vk.api.sdk.VK
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import ru.anb.friends.main.dto.Group
import ru.anb.friends.main.state.GroupsState
import ru.anb.friends.main.vk.VKApiImpl

class NetworkRepositoryImpl : NetworkRepository {
    val vKApi: VKApiImpl = VKApiImpl(VK.getUserId())
    override fun getGroups() = flow<GroupsState> {
        val groups = mutableListOf<Group>()
        vKApi.getGroups().collect {
            it.items.forEach { groupsFull->
                groups.add(Group(groupsFull.id,groupsFull.name,groupsFull.photo100))
            }

            emit(GroupsState.Success(groups))
        }
    }
}