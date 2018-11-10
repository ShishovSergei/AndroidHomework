package com.gmail.shishovergeiwork.lesson6

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Binder
import android.os.IBinder
import android.widget.Toast


class WifiService : Service() {

    private val mBinder: IBinder = LocalBinder()
    lateinit var mContext: Context


    override fun onBind(p0: Intent?): IBinder {

        return mBinder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)

    }

    override fun onCreate() {
        super.onCreate()
        val intentFilter: IntentFilter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
        registerReceiver(wifiStateReceiver, intentFilter)

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(wifiStateReceiver)
    }

    class LocalBinder : Binder() {
        fun getService(): WifiService {
            return WifiService()
        }
    }

    fun changeWifiState(context: Context) {
        val wifiManager = context.getApplicationContext().getSystemService(Context.WIFI_SERVICE) as WifiManager

        if (wifiManager.isWifiEnabled)
            wifiManager.setWifiEnabled(false)
        else
            wifiManager.setWifiEnabled(true)
    }

    private val wifiStateReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val wifiStateExtra = intent?.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN)

            when (wifiStateExtra) {
                WifiManager.WIFI_STATE_ENABLED -> Toast.makeText(applicationContext,
                        "Wifi is On", Toast.LENGTH_SHORT).show()
                WifiManager.WIFI_STATE_DISABLED -> Toast.makeText(applicationContext,
                        "Wifi is Off", Toast.LENGTH_SHORT).show()
            }
        }


    }


}