package com.example.form;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText etName, etEmail, etPhone;
    RadioGroup rgGender;
    CheckBox cbTerms;
    Button btnsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        etName=findViewById(R.id.etName);
        etEmail=findViewById(R.id.etEmail);
        etPhone=findViewById(R.id.etPhone);
        rgGender=findViewById(R.id.rgGender);
        cbTerms=findViewById(R.id.cbTerms);
        btnsubmit=findViewById(R.id.btnsubmit);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etName.getText().toString();
                String email=etEmail.getText().toString();
                String phone=etPhone.getText().toString();
                int isSelected = rgGender.getCheckedRadioButtonId();
                RadioButton selectedGender = findViewById(isSelected);
                String gender = selectedGender.getText().toString();
                if(name.isEmpty() || email.isEmpty()|| phone.isEmpty() || isSelected==-1){
                    Toast.makeText(MainActivity.this,"Please fill out all the fields",Toast.LENGTH_SHORT).show();
                }
                else if (!cbTerms.isChecked()){
                    Toast.makeText(MainActivity.this,"Please agree to the terms and conditions",Toast.LENGTH_SHORT).show();
                }
                else {
                    String message = "Name: " + name + "\nEmail:" + email + "\nPhone:" + phone + "\nGender:" + gender;
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}