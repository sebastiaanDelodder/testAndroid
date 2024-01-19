package com.example.oogartsapp.network

import com.example.oogartsapp.model.Team
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TeamApiService {
    @GET("TeamMember")
    suspend fun getTeam(): TeamItem

    @POST("TeamMember")
    suspend fun createTeam(@Body team: Team?): Call<Void?>
}
