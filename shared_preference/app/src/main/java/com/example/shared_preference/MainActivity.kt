package com.example.shared_preference

import android.app.Activity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.shared_preference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var usernameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var SaveButton: Button
    private lateinit var LoadButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("mypref", MODE_PRIVATE)
        val editor = sharedPref.edit()
        binding.apply {
            btnsave.setOnClickListener{
                val username = usernameEditText.text.toString()
                val email = emailEditText.text.toString()

                editor.apply {
                    putString("username",username)
                    putString("email",email)
                    apply()
                }
            }
            btnload.setOnClickListener{
                val username = sharedPref.getString("username", null)
                val email = sharedPref.getString("email", null)
                txtusername.text = username?:"No username found"
                txtemail.text=email?:"No email found"
            }
        }


    }
}