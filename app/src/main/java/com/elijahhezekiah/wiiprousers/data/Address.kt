package com.elijahhezekiah.wiiprousers.data

data class Address(
    val city: String,
    val geo: Geo,
    val street: String,
    val suite: String,
    val zipcode: String
)
