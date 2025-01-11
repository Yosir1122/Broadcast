package com.example.broadcast

import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.broadcast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val networkChangeReceiver = MyBroadcastReceiver()
        val intentFilter = IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
        registerReceiver(networkChangeReceiver, intentFilter)
        MyData.isThereInternet.observe(this) {
            if (it) {
                binding.internet.text = "Internet connected"
            } else {
                binding.internet.text = "Internet disconnected"
            }
        }
        MyData.isThereWifi.observe(this) {
            if (it) {
                binding.wifi.text = "Wifi connected"
            } else {
                binding.wifi.text = "Wifi disconnected"
            }
        }
        val networkChangeReceiverLocation = MyBroadcastReceiverLocation()
        val intentFilterLocation = IntentFilter("android.location.PROVIDERS_CHANGED")
        registerReceiver(networkChangeReceiverLocation, intentFilterLocation)
        MyData.isThereALocation.observe(this) {
            if (it) {
                binding.location.text = "Location enabled"
            } else {
                binding.location.text = "Location disabled"
            }
        }
    }
}