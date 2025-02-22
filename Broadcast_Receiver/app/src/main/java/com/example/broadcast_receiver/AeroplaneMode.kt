package com.example.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AeroplaneMode : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAeroplaneModeEnable = intent?.getBooleanExtra("state",false)?:return
        if (isAeroplaneModeEnable){
            Toast.makeText(context,"Aeroplane Mode on",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(context,"Aeroplane Mode off",Toast.LENGTH_SHORT).show()
        }
    }
}