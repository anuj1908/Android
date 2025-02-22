package com.example.animation

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val fadebtn = findViewById<Button>(R.id.fadebtn)
        val zoombtn = findViewById<Button>(R.id.zoombtn)
        val slidebtn = findViewById<Button>(R.id.slidebtn)
        val flashbtn = findViewById<Button>(R.id.flashbtn)
        val spinbtn = findViewById<Button>(R.id.spinbtn)
        val dropbtn = findViewById<Button>(R.id.dropbtn)

        fadebtn.setOnClickListener {
            val animation=AnimationUtils.loadAnimation(this@MainActivity,R.anim.fade)
            fadebtn.startAnimation(animation) }
        zoombtn.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this@MainActivity,R.anim.zoom)
            zoombtn.startAnimation(animation) }
        slidebtn.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this@MainActivity,R.anim.slide)
            slidebtn.startAnimation(animation) }
        flashbtn.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this@MainActivity,R.anim.flash)
            flashbtn.startAnimation(animation) }
        spinbtn.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this@MainActivity,R.anim.spin)
            spinbtn.startAnimation(animation) }
        dropbtn.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this@MainActivity,R.anim.drop)
            dropbtn.startAnimation(animation) }
    }
}