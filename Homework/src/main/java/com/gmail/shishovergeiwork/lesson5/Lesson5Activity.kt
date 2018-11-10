package com.gmail.shishovergeiwork.lesson5

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.net.wifi.WifiManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.TextView
import com.gmail.shishovergeiwork.androidhomework.R

class Lesson5Activity : Activity() {

    private lateinit var wifiManager: WifiManager
    private lateinit var  wifiState: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson5)

        wifiState = this.findViewById(com.gmail.shishovergeiwork.androidhomework.R.id.wifiState)
        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        wifiState.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                wifiManager.setWifiEnabled(true)
                wifiState.setText("WiFi is ON")
                wifiState.setTextColor(Color.GREEN)
            } else {
                wifiManager.setWifiEnabled(false)
                wifiState.setText("WiFi is OFF")
                wifiState.setTextColor(Color.RED)
            }
        }

    }

    override fun onStart() {
        super.onStart()
        val intentFilter : IntentFilter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
        registerReceiver(wifiStateReceiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(wifiStateReceiver)
    }

    private val wifiStateReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val wifiStateExtra = intent?.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN)

            when (wifiStateExtra) {
                WifiManager.WIFI_STATE_ENABLED -> wifiState.setChecked(true)
                WifiManager.WIFI_STATE_ENABLED -> wifiState.setText("WiFi is ON")

                WifiManager.WIFI_STATE_DISABLED -> wifiState.setChecked(false)
                WifiManager.WIFI_STATE_DISABLED -> wifiState.setText("WiFi is OFF")

            }
        }


    }
}