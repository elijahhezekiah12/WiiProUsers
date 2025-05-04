package com.elijahhezekiah.wiiprousers.presentation.job_details

import com.elijahhezekiah.wiiprousers.data.Users
import com.elijahhezekiah.wiiprousers.domain.model.JobDetails
import com.elijahhezekiah.wiiprousers.domain.model.UserDetails

data class JobDetailsState (
    val isFetching: Boolean = false,
    var jobDetails: JobDetails? = null,
    val error: String? = null
)