package com.gmail.shishovergeiwork.lesson6

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import com.gmail.shishovergeiwork.androidhomework.R


class Lesson6Activity : Activity() {

    lateinit var wifiService: WifiService
    var mBound: Boolean = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson6)

        startService(Intent(this, WifiService::class.java))

    }

    override fun onStart() {
        super.onStart()

        val intent = Intent(this, WifiService::class.java)
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE)

        val wifiButton: Button = findViewById(R.id.wifiCheckStateButton)
        wifiButton.setOnClickListener {
            if (mBound)
                wifiService.changeWifiState(applicationContext)
        }

    }

    override fun onStop() {
        super.onStop()
        stopService(Intent(this, WifiService::class.java))
    }


    private val mConnection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName,
                                        service: IBinder) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            val binder: WifiService.LocalBinder = service as WifiService.LocalBinder
            wifiService = binder.getService()
            mBound = true
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            mBound = false
        }
    }


}