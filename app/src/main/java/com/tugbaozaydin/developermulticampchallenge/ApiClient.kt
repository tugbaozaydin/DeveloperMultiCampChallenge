package com.tugbaozaydin.developermulticampchallenge

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit {
        if (retrofit == null)
            retrofit =
                Retrofit.Builder().baseUrl("https://5f6642a143662800168e7538.mockapi.io/").addConverterFactory(GsonConverterFactory.create()).build()

        return retrofit as Retrofit
    }

}


