package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ReviewInformation extends AppCompatActivity {

    TextView tvSenderName, tvSenderCountry, tvSenderAddress, tvSenderContact, tvReceiverName, tvReceiverCountry, tvReceiverAddress, tvReceiverContact;
    ImageView circle_plus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_review_information);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        Intent i = getIntent();

        tvSenderName.setText(i.getStringExtra("key_SenderName"));
        tvSenderCountry.setText(i.getStringExtra("key_SenderCountry"));
        tvSenderAddress.setText(i.getStringExtra("key_SenderAddress"));
        tvSenderContact.setText(i.getStringExtra("key_SenderContact"));
        tvReceiverName.setText(i.getStringExtra("key_ReceiverName"));
        tvReceiverCountry.setText(i.getStringExtra("key_ReceiverCountry"));
        tvReceiverContact.setText(i.getStringExtra("key_ReceiverContact"));
        tvReceiverAddress.setText(i.getStringExtra("key_ReceiverAddress"));

        circle_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ReviewInformation.this,Sender.class);
                startActivity(i);
                finish();
            }
        });


    }

    private void init() {
        tvSenderName = findViewById(R.id.tvSenderName);
        tvSenderCountry = findViewById(R.id.tvSenderCountry);
        tvSenderAddress = findViewById(R.id.tvSenderAddress);
        tvSenderContact = findViewById(R.id.tvSenderContact);
        tvReceiverName = findViewById(R.id.tvReceiverName);
        tvReceiverCountry = findViewById(R.id.tvReceiverCountry);
        tvReceiverAddress = findViewById(R.id.tvReceiverAddress);
        tvReceiverContact = findViewById(R.id.tvReceiverContact);
        circle_plus=findViewById(R.id.circle_plus);
    }
}