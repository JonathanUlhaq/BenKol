package com.example.benkol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Otp extends AppCompatActivity {

    TextView kirim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        kirim = findViewById(R.id.kirim);

        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Otp.this,"OTP berhasil dikirim",Toast.LENGTH_SHORT);
            }
        });
    }
}