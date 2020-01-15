package com.nlambertucci.simpsonsquotes.viewmodel


import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nlambertucci.simpsonsquotes.model.Quotes
import com.nlambertucci.simpsonsquotes.network.Service
import com.nlambertucci.simpsonsquotes.utils.SplashScreen
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {

    var quotes = MutableLiveData<List<Quotes>>()

    fun getQuotes(): LiveData<List<Quotes>>? {

        val api = Service.initialize().getQuotes(10)
        api.enqueue(object : Callback<List<Quotes>> {
            override fun onFailure(call: Call<List<Quotes>>, t: Throwable) {
                Log.e("ApiError", t.localizedMessage)
            }

            override fun onResponse(call: Call<List<Quotes>>, response: Response<List<Quotes>>) {
                quotes.value = response.body()
            }

        })
        return quotes
    }

}