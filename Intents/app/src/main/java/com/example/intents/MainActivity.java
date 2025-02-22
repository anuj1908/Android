package com.example.intents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText txt1, txt2;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txt1=findViewById(R.id.et1);
        txt2=findViewById(R.id.et2);
        b1=findViewById(R.id.bt1);
        b2=findViewById(R.id.bt2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname= txt1.getText().toString();
                String lname = txt2.getText().toString();
                Intent intent = new Intent(getApplicationContext(),WelcomeActivity.class);
                intent.putExtra("fn", fname);
                intent.putExtra("ln", lname);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setText("");
                txt2.setText("");
            }
        });
    }
}