package com.example.oogartsapp.network

import com.example.oogartsapp.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApiService {
    @GET("User")
    suspend fun getUsers(): UserItem

    @POST("User")
    suspend fun createUser(@Body user: User?): Call<Void?>
}
