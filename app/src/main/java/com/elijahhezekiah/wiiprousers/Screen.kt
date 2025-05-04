package com.elijahhezekiah.wiiprousers

import kotlinx.serialization.Serializable

sealed class Screen  (val route: String){
    object Home: Screen("home")
    object Details: Screen("details")

}


@Serializable
data class UserRoute( val id: Int)

@Serializable
data object UserListRoute
