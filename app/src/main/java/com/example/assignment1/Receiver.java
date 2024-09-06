package com.example.assignment1;

import android.content.Intent;
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

public class Receiver extends AppCompatActivity {
    TextInputEditText tietReceiverAddress, tietReceiverCountry, tietReceiverContact, tietReceiverFullName, tietReceiverEmail;
    Button btnReceiverNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_receiver);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        btnReceiverNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=tietReceiverEmail.getText().toString();
                String name=tietReceiverFullName.getText().toString().trim();
                String contact=tietReceiverContact.getText().toString();
                String address=tietReceiverAddress.getText().toString().trim();
                String country=tietReceiverCountry.getText().toString().trim();
                if (email.isEmpty() || name.isEmpty() || contact.isEmpty() || address.isEmpty() || country.isEmpty())
                {
                    Toast.makeText(Receiver.this, "Fields cannot be Empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!email.contains("@gmail.com"))
                {
                    Toast.makeText(Receiver.this, "Please write valid Email Address", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent get=getIntent();
                Intent i=new Intent(Receiver.this, ReviewInformation.class);
                i.putExtra("key_ReceiverEmail",email);
                i.putExtra("key_ReceiverName",name);
                i.putExtra("key_ReceiverCountry",country);
                i.putExtra("key_ReceiverAddress",address);
                i.putExtra("key_ReceiverContact",contact);
                i.putExtra("key_SenderEmail",get.getStringExtra("key_SenderEmail"));
                i.putExtra("key_SenderName",get.getStringExtra("key_SenderName"));
                i.putExtra("key_SenderCountry",get.getStringExtra("key_SenderCountry"));
                i.putExtra("key_SenderAddress",get.getStringExtra("key_SenderAddress"));
                i.putExtra("key_SenderContact",get.getStringExtra("key_SenderContact"));

                startActivity(i);
                finish();

            }
        });

    }

    private void init() {
        btnReceiverNext = findViewById(R.id.btnReceiverNext);
        tietReceiverAddress = findViewById(R.id.tietReceiverAddress);
        tietReceiverContact = findViewById(R.id.tietReceiverContact);
        tietReceiverCountry = findViewById(R.id.tietReceiverCountry);
        tietReceiverFullName = findViewById(R.id.tietReceiverFullName);
        tietReceiverEmail = findViewById(R.id.tietReceiverEmail);
    }
}