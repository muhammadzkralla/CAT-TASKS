package com.zkrallah.gymassistant

import android.app.Application

class GymApp : Application() {

    companion object {
        lateinit var ctx: Application
    }

    override fun onCreate() {
        ctx = this
        super.onCreate()
    }
}