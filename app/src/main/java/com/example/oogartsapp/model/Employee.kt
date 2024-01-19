package com.example.oogartsapp.model

import java.time.LocalDate
import java.util.Date

data class Employee(
    var firstName: String,
    var lastName: String,
    var birthDate: LocalDate,
    var group: Group,
    var bio: String = "",
    val imageRes: Int = 0,
)