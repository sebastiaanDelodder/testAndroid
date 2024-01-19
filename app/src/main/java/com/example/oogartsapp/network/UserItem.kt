package com.example.oogartsapp.network

import kotlinx.serialization.Serializable

@Serializable
data class UserItem(
    val users: List<ApiUser>,
    val totalAmount: Int)

