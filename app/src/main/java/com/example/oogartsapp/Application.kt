package com.example.oogartsapp

import android.app.Application
import com.example.oogartsapp.data.AppContainer
import com.example.oogartsapp.data.DefaultAppContainer

class Application : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
