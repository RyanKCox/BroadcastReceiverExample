package com.revature.broadcastreceiverexample

import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.revature.broadcastreceiverexample.ui.theme.BroadcastReceiverExampleTheme

class MainActivity : ComponentActivity() {

    lateinit var airplaneReceiver: AirplaneModeChangeReceiver
    lateinit var wifiReceiver:WifiChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        airplaneReceiver = AirplaneModeChangeReceiver()
        wifiReceiver = WifiChangeReceiver()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(airplaneReceiver,it)
        }
        IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION).also {
            registerReceiver(wifiReceiver,it)
        }

        setContent {
            BroadcastReceiverExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(airplaneReceiver)
        unregisterReceiver(wifiReceiver)
    }
}