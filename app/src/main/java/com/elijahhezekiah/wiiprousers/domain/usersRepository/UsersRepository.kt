package com.elijahhezekiah.wiiprousers.domain.usersRepository

import com.elijahhezekiah.wiiprousers.data.Users

interface UsersRepository {

    suspend fun getUsers(): List<Users>

}

