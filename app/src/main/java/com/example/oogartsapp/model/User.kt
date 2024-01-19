package com.example.oogartsapp.model

data class User(
    val id: Int,
    var teamMemberId: Int?,
    var email: String,
    var passwordHash: String,
    var googleLoginId: String?,
    var twoFactorAuthEnabled: Boolean
)
