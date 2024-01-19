package com.example.oogartsapp.data

import com.example.oogartsapp.model.User

object UserSampler {
    private val sampleEmails = mutableListOf(
        "john@gmail.com",
        "lisa@gmail.com",
        "jan@gmail.com",
        "bert@gmail.com",
        "jana@gmail.com",
        "tim@gmail.com",
        "tibo@gmail.com",
    )

    val getAll: () -> MutableList<User> = {
        val list = mutableListOf<User>()
        val indexId = 5
        for ((index, email) in sampleEmails.withIndex()) {
            list.add(
                User(
                    id = indexId + 1,
                    teamMemberId = index + 1,
                    email = email,
                    passwordHash = "Test123",
                    googleLoginId = "exampleGoogleId",
                    twoFactorAuthEnabled = true
                )
            )
        }
        list
    }
}
