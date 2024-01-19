package com.example.oogartsapp.ui.navigation

import androidx.annotation.StringRes
import com.example.oogartsapp.R

enum class Destinations (@StringRes val title: Int) {
    Start(title = R.string.home),
    Team(title = R.string.team),
    Appointments(title = R.string.appointments),
}