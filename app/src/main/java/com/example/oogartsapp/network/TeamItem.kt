package com.example.oogartsapp.network

import kotlinx.serialization.Serializable

@Serializable
data class TeamItem(
    val team: List<ApiTeam>,
    val totalAmount: Int)

