package ru.anb.friends.main.dto

import com.vk.dto.common.id.UserId

data class Group(
    val id: UserId?,
    val name: String?,
    val imageUri:String? = null
)
