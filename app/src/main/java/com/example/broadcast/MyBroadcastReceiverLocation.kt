package com.example.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyBroadcastReceiverLocation : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val networkHelper=NetworkHelper(context)
        MyData.isThereALocation.postValue(networkHelper.isLocationEnabled())
    }
}