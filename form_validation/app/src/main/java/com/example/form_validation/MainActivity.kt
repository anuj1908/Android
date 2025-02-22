package com.example.form_validation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var usernameEditText :EditText;
    private lateinit var passwordEditText: EditText;
    private lateinit var submitButton: Button;
    private lateinit var resetButton: Button;
    private val correctUsername ="user"
    private val correctPassword="password"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        submitButton = findViewById(R.id.submitButton)
        resetButton = findViewById(R.id.resetButton)

        submitButton.setOnClickListener { onSubmit() }
        resetButton.setOnClickListener { onReset() }
    }
        private fun onSubmit() {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username == correctUsername && password == correctPassword) {
                Toast.makeText(this, "Correct username and password", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_SHORT).show()
            }
        }
        private fun onReset(){
            usernameEditText.text.clear()
            passwordEditText.text.clear()
        }

}