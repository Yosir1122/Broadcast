package com.example.broadcast

import androidx.lifecycle.MutableLiveData

object MyData {
    var isThereInternet = MutableLiveData<Boolean>()
    var isThereWifi = MutableLiveData<Boolean>()
    var isThereALocation = MutableLiveData<Boolean>()
}