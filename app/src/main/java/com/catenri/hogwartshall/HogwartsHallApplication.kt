package com.catenri.hogwartshall

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import com.catenri.hogwartshall.domain.CharactersSyncTaskScheduler
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class HogwartsHallApplication: Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    @Inject
    lateinit var taskScheduler: CharactersSyncTaskScheduler

    override fun onCreate() {
        super.onCreate()
        taskScheduler.scheduleTask()
    }

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
}