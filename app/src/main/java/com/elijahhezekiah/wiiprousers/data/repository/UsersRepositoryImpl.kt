package com.elijahhezekiah.wiiprousers.data.repository

import com.elijahhezekiah.wiiprousers.data.Users
import com.elijahhezekiah.wiiprousers.data.UsersApi
import com.elijahhezekiah.wiiprousers.domain.usersRepository.UsersRepository

class UsersRepositoryImpl(private val api: UsersApi) : UsersRepository {

    override suspend fun getUsers(): List<Users> {
        return api.getUsers()
    }

}