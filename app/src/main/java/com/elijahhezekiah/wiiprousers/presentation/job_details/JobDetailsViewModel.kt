package com.elijahhezekiah.wiiprousers.presentation.job_details

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elijahhezekiah.wiiprousers.common.Resource
import com.elijahhezekiah.wiiprousers.data.mappers.toJobDetails
import com.elijahhezekiah.wiiprousers.domain.use_case.GetJobDetails.GetUserJobDetailsUseCase
import com.elijahhezekiah.wiiprousers.domain.use_case.get_userDetails.GetUserDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class JobDetailsViewModel @Inject constructor(
    private  val  getUserJobDetailsUseCase: GetUserJobDetailsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(JobDetailsState())
    val state: State<JobDetailsState> = _state

    init {

    }

    fun getUserJobDetails(userId: Int) {
        getUserJobDetailsUseCase(userId).onEach { result ->

            when (result) {
                is Resource.Error<*> -> {

                    _state.value = JobDetailsState(error = result.message ?: "An unexpected error occurred")
                }

                is Resource.Loading<*> -> {

                    _state.value = JobDetailsState(isFetching = true)
                }

                is Resource.Success<*> -> {
                   // val jobData = result.data?.map{it.toJobDetails(userId)}
                     //val job = jobData?.get(0)

                     Log.d("JobDetailsViewModel", "getUserJobDetails: ${result.data}")
                    _state.value = JobDetailsState(jobDetails = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }


}