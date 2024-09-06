package com.example.assignment1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class Sender extends AppCompatActivity {
    TextInputEditText tietSenderAddress, tietSenderCountry, tietSenderContact, tietSenderFullName, tietSenderEmail;
    Button btnSenderNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sender);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        btnSenderNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = tietSenderEmail.getText().toString();
                String name = tietSenderFullName.getText().toString().trim();
                String contact = tietSenderContact.getText().toString();
                String address = tietSenderAddress.getText().toString().trim();
                String country = tietSenderCountry.getText().toString().trim();
                if (email.isEmpty() || name.isEmpty() || contact.isEmpty() || address.isEmpty() || country.isEmpty()) {
                    Toast.makeText(Sender.this, "Fields cannot be Empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!email.contains("@gmail.com"))
                {
                    Toast.makeText(Sender.this, "Please write valid Email Address", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = new Intent(Sender.this, Receiver.class);
                i.putExtra("key_SenderEmail", email);
                i.putExtra("key_SenderName", name);
                i.putExtra("key_SenderCountry", country);
                i.putExtra("key_SenderAddress", address);
                i.putExtra("key_SenderContact", contact);
                startActivity(i);
                finish();


            }
        });

    }

    private void init() {
        btnSenderNext = findViewById(R.id.btnSenderNext);
        tietSenderAddress = findViewById(R.id.tietSenderAddress);
        tietSenderCountry = findViewById(R.id.tietSenderCountry);
        tietSenderContact = findViewById(R.id.tietSenderContact);
        tietSenderFullName = findViewById(R.id.tietSenderFullName);
        tietSenderEmail = findViewById(R.id.tietSenderEmail);
    }
}