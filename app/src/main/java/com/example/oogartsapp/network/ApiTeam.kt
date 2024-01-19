package com.example.oogartsapp.network

import com.example.oogartsapp.model.Team
import kotlinx.serialization.Serializable

@Serializable
data class ApiTeam(
    val id: Int,
    var firstName: String,
    var lastName: String,
    var role: String,
    var phoneNumber: String,
    var email: String,
    var availability: String,
) {
}


fun List<ApiTeam>.asDomainObjects(): List<Team> {
    return this.map {
        Team(
            id = it.id,
            firstName = it.firstName,
            lastName = it.lastName,
            role = it.role,
            phoneNumber = it.phoneNumber,
            email = it.email,
            availability = it.availability
        )
    }
}