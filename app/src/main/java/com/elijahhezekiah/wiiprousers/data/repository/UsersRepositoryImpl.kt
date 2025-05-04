package com.elijahhezekiah.wiiprousers.data.repository

import com.elijahhezekiah.wiiprousers.data.Users
import com.elijahhezekiah.wiiprousers.data.UsersApi
import com.elijahhezekiah.wiiprousers.domain.usersRepository.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.concurrent.CopyOnWriteArrayList

class UsersRepositoryImpl(private val api: UsersApi) : UsersRepository {

    override suspend fun getUsers(): List<Users> {
        return api.getUsers()
    }

}


