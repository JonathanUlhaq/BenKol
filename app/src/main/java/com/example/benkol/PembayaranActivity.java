package com.example.benkol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PembayaranActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);


    }

    public void bayar (View view)
    {
        Intent intent = new Intent(this, RiwayatpembayaranActivity.class);
        startActivity(intent);
    }



}