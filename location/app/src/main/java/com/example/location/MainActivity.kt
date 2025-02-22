package com.example.location

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.common.api.GoogleApi.Settings
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class MainActivity : AppCompatActivity() {
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var tvlatitude:TextView
    private lateinit var tvlongitude:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(this)
        tvlatitude=findViewById(R.id.tv_latitude)
        tvlongitude=findViewById(R.id.tv_longitude)
        getCurrentLocation()
    }
    private fun getCurrentLocation(){
        if(checkPermission()){
            if(isLocationEnabled()){
                fusedLocationProviderClient.lastLocation.addOnCompleteListener(this){
                    task -> val location: Location? = task.result
                    if (location == null){
                        Toast.makeText(this,"No location received", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Toast.makeText(this, "Location retrived", Toast.LENGTH_SHORT).show()
                        tvlatitude.text = location.latitude.toString()
                        tvlongitude.text = location.longitude.toString()
                    }
                }
                }
            else{
                Toast.makeText(this,"Turn on the LOcation",Toast.LENGTH_SHORT).show()
                val intent = Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        }else{
            requestPermission()
        }
    }
    private fun isLocationEnabled():Boolean {
        val locationManager: LocationManager =
            getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    private fun requestPermission(){
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION), PERMISSION_REQUEST_ACCESS_LOCATION)
    }
    companion object{
        private const val PERMISSION_REQUEST_ACCESS_LOCATION=100
    }
    private fun checkPermission():Boolean{
        return ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)==
                PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode== PERMISSION_REQUEST_ACCESS_LOCATION){
            if(grantResults.isNotEmpty() && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(applicationContext,"Permission Granted",Toast.LENGTH_SHORT).show()
                getCurrentLocation()
            }else{
                Toast.makeText(applicationContext,"Permission Denied",Toast.LENGTH_SHORT).show()
            }
        }
    }
}