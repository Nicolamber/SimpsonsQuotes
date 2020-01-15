package com.nlambertucci.simpsonsquotes.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.nlambertucci.simpsonsquotes.model.Quotes
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://thesimpsonsquoteapi.glitch.me/"

interface RestAPIConnection {
   @GET("quotes")
   fun getQuotes(
       @Query("count") count: Int
   ): Call<List<Quotes>>
}