package com.example.intents;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WelcomeActivity extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);
        txt=findViewById(R.id.txt1);
        Intent intent=getIntent();
        String fname = intent.getStringExtra("fn");
        String lname = intent.getStringExtra("ln");
        txt.setText("Welcome! Your first name is"+fname+"and lastname is"+lname);
    }
}