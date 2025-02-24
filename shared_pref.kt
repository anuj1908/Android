package com.example.shared_preference


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shared_preference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("mypref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        binding.apply {
            btnsave.setOnClickListener {
                val userName = edtusername.text.toString()
                val email = edtemail.text.toString()

                editor.apply {
                    putString("user_name", userName)
                    putString("email", email)
                    apply()
                }
            }

            btnload.setOnClickListener {
                val username = sharedPref.getString("user_name", null)
                val email = sharedPref.getString("email", null)

                txtusername.text = username ?: "No username found"
                txtemail.text = email ?: "No email found"
            }
        }
    }
}