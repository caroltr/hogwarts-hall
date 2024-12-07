package com.catenri.hogwartshall

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HogwartsHallApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}