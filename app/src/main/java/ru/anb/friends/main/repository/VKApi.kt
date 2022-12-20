package ru.anb.friends.main.repository

import com.vk.sdk.api.groups.dto.GroupsGetObjectExtendedResponse
import kotlinx.coroutines.flow.Flow

interface VKApi {
    fun getGroups(): Flow<GroupsGetObjectExtendedResponse>
}