package com.example.learncoroutines._5_coroutines_with_api

import retrofit2.Response
import retrofit2.http.GET

interface MyApi {
    @GET("list-photo")
    suspend fun getUsers(): Response<User>
}