package com.elijahhezekiah.wiiprousers.data.mappers

import com.elijahhezekiah.wiiprousers.data.Address
import com.elijahhezekiah.wiiprousers.data.Users
import com.elijahhezekiah.wiiprousers.domain.model.JobDetails
import com.elijahhezekiah.wiiprousers.domain.model.UserDetails
import kotlin.String

fun Users.toUserDetails() : UserDetails {
     return UserDetails(
         id = id,
         name = name,
        username =username,
       phone = phone,
      email = email,
      address= address
     )
}

fun Users.toJobDetails() : JobDetails? {
    return JobDetails(
         company = company,
        website = website,
        address = address,
    )
}