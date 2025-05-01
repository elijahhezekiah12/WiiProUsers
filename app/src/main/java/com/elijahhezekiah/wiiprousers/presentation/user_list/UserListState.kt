package com.elijahhezekiah.wiiprousers.presentation.user_list

import com.elijahhezekiah.wiiprousers.domain.model.UserDetails

data class UserListState(
    val isLoading: Boolean = false,
    var users: List<UserDetails> = emptyList(),
    val error: String = ""
)
