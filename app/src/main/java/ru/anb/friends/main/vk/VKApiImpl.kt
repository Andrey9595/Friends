package ru.anb.friends.main.vk

import android.util.Log
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.groups.GroupsService
import com.vk.sdk.api.groups.dto.GroupsGetObjectExtendedResponse
import com.vk.sdk.api.groups.dto.GroupsGetResponse
import com.vk.sdk.api.groups.dto.GroupsGroupFull
import kotlinx.coroutines.flow.flow
import ru.anb.friends.main.repository.VKApi
import ru.anb.friends.main.state.GroupsState

class VKApiImpl(private val userId: UserId?) : VKApi {
    override fun getGroups() = flow {
        val response = VK.executeSync(GroupsService().groupsGetExtended(userId))
        emit(response)
    }
}