package com.nlambertucci.simpsonsquotes.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Service {

    fun initialize(): RestAPIConnection{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(RestAPIConnection::class.java)

        return apiService
    }
}