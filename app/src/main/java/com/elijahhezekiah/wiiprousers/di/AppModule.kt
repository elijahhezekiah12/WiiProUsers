package com.elijahhezekiah.wiiprousers.di

import com.elijahhezekiah.wiiprousers.common.Constants.BASE_URL
import com.elijahhezekiah.wiiprousers.data.UsersApi
import com.elijahhezekiah.wiiprousers.data.repository.UsersRepositoryImpl
import com.elijahhezekiah.wiiprousers.domain.usersRepository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMyApi(): UsersApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UsersApi::class.java)
    }


    @Provides
    @Singleton
    fun provideUsersRepository(api: UsersApi): UsersRepository {
        return UsersRepositoryImpl(api)

    }




}

