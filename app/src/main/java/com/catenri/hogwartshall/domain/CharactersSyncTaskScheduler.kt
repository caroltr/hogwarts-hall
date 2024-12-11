package com.catenri.hogwartshall.domain

import android.content.Context
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.catenri.hogwartshall.worker.SyncWorker
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.concurrent.TimeUnit
import javax.inject.Inject

private const val REPEAT_INTERVAL_MINUTES = 15L
private const val WORK_NAME = "CharactersSyncTaskWorker"

class CharactersSyncTaskScheduler @Inject constructor(
    @ApplicationContext private val context: Context,
) {

    fun scheduleTask() {
        // Set to 15 min as it is the min required for Work Manager
        // in a real world scenario this could be less frequently, as the API content shouldn't change much
        val periodicWorkRequest = PeriodicWorkRequestBuilder<SyncWorker>(REPEAT_INTERVAL_MINUTES, TimeUnit.MINUTES)
            .setConstraints(
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()
            )
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            WORK_NAME,
            ExistingPeriodicWorkPolicy.CANCEL_AND_REENQUEUE,
            periodicWorkRequest
        )
    }
}