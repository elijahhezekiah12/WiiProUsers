package com.elijahhezekiah.wiiprousers.presentation.user_list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.elijahhezekiah.wiiprousers.domain.use_case.get_userDetails.GetUserDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import com.elijahhezekiah.wiiprousers.common.Resource
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUserListUseCase: GetUserDetails
) :ViewModel() {

    private  val _state = mutableStateOf(UserListState())
    val state : State<UserListState> = _state

    init {
        getUsers()
    }


    private fun getUsers() {
        getUserListUseCase().onEach { result ->

            when (result) {
                is Resource.Success -> {

                    _state.value = UserListState(users = result.data ?: emptyList())

                }

                is Resource.Error<*> -> {

                    _state.value = UserListState(error = result.message ?: "An unexpected error occured")
                }

                is Resource.Loading<*> -> {

                    _state.value = UserListState(isLoading = true)

                }
            }

        }.launchIn(viewModelScope)
    }

}