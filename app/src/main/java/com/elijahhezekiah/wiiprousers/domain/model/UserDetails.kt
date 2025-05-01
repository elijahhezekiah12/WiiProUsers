package com.elijahhezekiah.wiiprousers.domain.model

import com.elijahhezekiah.wiiprousers.data.Address

data class UserDetails(
    val id: Int,
    val name: String,
    val username: String,
    val phone: String,
    val email: String,
    val address: Address,
)
