package com.elijahhezekiah.wiiprousers.presentation.user_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.elijahhezekiah.wiiprousers.presentation.user_list.components.UserListItem


@Composable
fun UserListScreen (
    onUserClick: (Int) -> Unit,
    viewModel: UserListViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.users) { user ->
                UserListItem(
                    user = user,
                    onItemClick = {
                        onUserClick(user.id)
                    }
                )
            }
        }


        if (state.error.isNotBlank()) {
            Text(
                text = state.error
            )
        }

        if (state.isLoading) {
            Text(
                text = "Loading"
            )

        }
    }
}

