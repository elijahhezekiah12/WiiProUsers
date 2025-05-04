package com.elijahhezekiah.wiiprousers.domain.use_case.GetJobDetails

import android.util.Log
import com.elijahhezekiah.wiiprousers.common.Resource
import com.elijahhezekiah.wiiprousers.data.Users
import com.elijahhezekiah.wiiprousers.data.mappers.toJobDetails
import com.elijahhezekiah.wiiprousers.data.mappers.toUserDetails
import com.elijahhezekiah.wiiprousers.domain.model.JobDetails
import com.elijahhezekiah.wiiprousers.domain.model.UserDetails
import com.elijahhezekiah.wiiprousers.domain.usersRepository.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUserJobDetailsUseCase @Inject constructor(private val UserRepository: UsersRepository) {

    operator fun invoke(id: Int) : Flow<Resource<JobDetails>> = flow {
        try {
            emit(Resource.Loading())
            val userJobs = UserRepository.getUsers().find { it.id == id }
            emit(Resource.Success<JobDetails>(userJobs?.toJobDetails()))
            Log.d("This is  the usersJobs", "$userJobs")
        } catch (e: HttpException) {
            Log.d("This is  an error,", "$e")
            emit(Resource.Error<JobDetails>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            Log.d("This is  an error,", "$e")
            emit(Resource.Error<JobDetails>("Couldn't reach server. Check your internet connection."))
        }

    }
}