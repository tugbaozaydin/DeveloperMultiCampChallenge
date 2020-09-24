package com.tugbaozaydin.developermulticampchallenge

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("multicamp/communities")
     fun getData(): Call<List<Data>>

}