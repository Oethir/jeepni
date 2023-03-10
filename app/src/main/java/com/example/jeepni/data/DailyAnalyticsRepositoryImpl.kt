package com.example.jeepni.data

import android.app.Application
import android.content.Context
import android.widget.Toast
import com.example.jeepni.getCurrentDateString
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.flow.Flow

class DailyAnalyticsRepositoryImpl (private val usersRef: CollectionReference, appContext: Application) : DailyAnalyticsRepository {
    private var context : Context
    init {
        context = appContext.applicationContext
    }

    override suspend fun logDailyStat(dailyStat: DailyAnalyticsModel) {
        usersRef.document("0")
            .collection("analytics")
            .document(getCurrentDateString())
            .set(dailyStat)
            .addOnSuccessListener {Toast.makeText(context, "saved", Toast.LENGTH_SHORT).show()} // not sure if this works
            .addOnFailureListener {}
    }

    override suspend fun updateDailyStat(dailyStat: DailyAnalyticsModel) {
        logDailyStat(dailyStat)
    }

    override suspend fun deleteDailyStat(dailyStat: DailyAnalyticsModel) {
        usersRef.document("0")
            .collection("analytics")
            .document(getCurrentDateString())
            .delete()
            .addOnSuccessListener {}
            .addOnFailureListener {}

    }

    override fun getDailyStats(): Flow<List<DailyAnalyticsModel>>? {
        // TODO: implement later. remove nullable operator from return type and on interface
        return null
    }

}