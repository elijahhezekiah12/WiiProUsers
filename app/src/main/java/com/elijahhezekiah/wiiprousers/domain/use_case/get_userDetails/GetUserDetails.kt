package com.elijahhezekiah.wiiprousers.domain.use_case.get_userDetails

import android.util.Log
import com.elijahhezekiah.wiiprousers.common.Resource
import com.elijahhezekiah.wiiprousers.data.mappers.toUserDetails
import com.elijahhezekiah.wiiprousers.domain.model.UserDetails
import com.elijahhezekiah.wiiprousers.domain.usersRepository.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUserDetails@Inject constructor(
    private val UserRepository: UsersRepository
) {
    operator fun invoke() : Flow<Resource<List<UserDetails>>> = flow {
        try {
            emit(Resource.Loading())
            val userDetails = UserRepository.getUsers().map { it.toUserDetails() }
            emit(Resource.Success<List<UserDetails>>(userDetails))
        } catch (e: HttpException) {
            Log.d("This is  an error,", "$e")
            emit(
                Resource.Error<List<UserDetails>>(
                    e.localizedMessage ?: "An unexpected error occured"
                )
            )
        } catch (e: IOException) {
            Log.d("This is  an error,", "$e")
            emit(Resource.Error<List<UserDetails>>("Couldn't reach server. Check your internet connection."))
        }
    }


}