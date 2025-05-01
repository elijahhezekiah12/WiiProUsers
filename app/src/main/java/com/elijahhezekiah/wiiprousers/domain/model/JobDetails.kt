package com.elijahhezekiah.wiiprousers.domain.model

import com.elijahhezekiah.wiiprousers.data.Address
import com.elijahhezekiah.wiiprousers.data.Company

data class JobDetails(
    val company: Company,
    val address: Address,
    val website: String
)
