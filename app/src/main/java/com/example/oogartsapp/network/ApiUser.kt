package com.example.oogartsapp.network

import com.example.oogartsapp.model.User
import kotlinx.serialization.Serializable

@Serializable
data class ApiUser(
    val id: Int,
    val teamMemberId: Int?,
    val email: String,
    val passwordHash: String?,
    val googleLoginId: String?,
    val twoFactorAuthEnabled: Boolean,
) {
}


fun List<ApiUser>.asDomainObjects(): List<User> {
    return this.map {
        User(
            id = it.id,
            teamMemberId = it.teamMemberId ?: 0,
            email = it.email,
            passwordHash = it.passwordHash ?: "",
            googleLoginId = it.googleLoginId ?: "",
            twoFactorAuthEnabled = it.twoFactorAuthEnabled
        )
    }
}