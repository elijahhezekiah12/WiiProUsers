package com.elijahhezekiah.wiiprousers.presentation.job_details

import com.elijahhezekiah.wiiprousers.domain.model.JobDetails

data class JobDetailsState (
    val isFetching: Boolean = false,
    var jobDetails: JobDetails? = null,
    val error: String? = null
)