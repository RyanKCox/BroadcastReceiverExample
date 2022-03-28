package com.revature.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.widget.Toast

class WifiChangeReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        val isWifiEnabled =
            intent?.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
                WifiManager.WIFI_STATE_UNKNOWN)?: return

        if (isWifiEnabled == WifiManager.WIFI_STATE_ENABLED){
            Toast.makeText(
                context,"Wifi is Enabled", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(
                context,"Wifi is Disabled", Toast.LENGTH_LONG).show()
        }
    }


}