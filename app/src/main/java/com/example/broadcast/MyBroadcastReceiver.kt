package com.example.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val networkHelper=NetworkHelper(context)
        MyData.isThereInternet.postValue(networkHelper.isNetworkConnected())
        MyData.isThereWifi.postValue(networkHelper.isNetworkConnected())
        MyData.isThereALocation.postValue(networkHelper.isLocationEnabled())
    }
}