package com.example.benkol;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class RiwayatpembayaranActivity extends AppCompatActivity {

    private static final int SPLASH_TIME = 2*1000;
    ProgressBar prg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayatpembayaran);
    }

    public  void bantuan (View view)
    {
        Intent intent = new Intent(this, BantuancsActivity.class);
        startActivity(intent);
    }

    @SuppressLint("Range")
    public void bukti (View view)
    {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                this,R.style.BottomSheetDialogTheme
        );
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(
                R.layout.loading, (LinearLayout) findViewById(R.id.downloadB)
        );

        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

        prg = bottomSheetView.findViewById(R.id.progressBar4);
        prg.setAlpha(SPLASH_TIME);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(RiwayatpembayaranActivity.this,MapsActivity.class);
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