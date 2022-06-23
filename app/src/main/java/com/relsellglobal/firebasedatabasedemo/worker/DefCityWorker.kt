package com.relsellglobal.firebasedatabasedemo.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.relsellglobal.firebasedatabasedemo.repository.WeatherDataRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import android.util.Log
import com.relsellglobal.firebasedatabasedemo.MyApplication

class DefCityWorker (private val context: Context, params : WorkerParameters) : Worker(context,params) {
    override fun doWork(): Result {

        Log.v("DefCityWorker","Worker Called")

        var weatherDataRepository = MyApplication.getMyApplicationObj().weatherDataRepository

        CoroutineScope(Dispatchers.IO).launch {
            weatherDataRepository.insertDataIntoCitiesForUserFromNetwork()
        }

        return Result.success()
    }
}