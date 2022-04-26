package com.example.benkol;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Otp extends AppCompatActivity {
    private static final int SPLASH_TIME =  2*1000;
    TextView kirim,login,konfirmasi,deskripsi;
    ImageView simbol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        kirim = findViewById(R.id.kirim);

        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendBack();
            }
        });
    }

    @SuppressLint({"NewApi", "Range"})
    public void SendBack ()
    {
        setContentView(R.layout.acitivity_konfirmasi);
        konfirmasi = findViewById(R.id.konfirmasi);
        deskripsi = findViewById(R.id.deskripsi);
        simbol = findViewById(R.id.simbol);
        konfirmasi.setText("Pesan Berhasil dikirim Ulang");
        deskripsi.setText("Cek Pesan Kamu");
        simbol.setImageResource(R.drawable.ic_sms_check);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Otp.this,Login.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, SPLASH_TIME);


    }
}