package com.elijahhezekiah.wiiprousers.data

import retrofit2.http.GET

interface UsersApi {
    @GET("/users")
    suspend fun getUsers(): List<Users>
}