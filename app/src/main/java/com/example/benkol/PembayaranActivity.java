package com.example.benkol;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class PembayaranActivity extends AppCompatActivity {

    AlphaAnimation animation = new AlphaAnimation(1F,0F);
    private static final int SPLASH_TIME = 2*1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);




    }


    @SuppressLint("Range")
    public void bayar (View view)
    {
        animation.setDuration(1000);
        view.startAnimation(animation);

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                this,R.style.BottomSheetDialogTheme
        );
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(
                R.layout.tujuan_bayar, (LinearLayout) findViewById(R.id.bayarr)
        );

        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                BottomSheetDialog bottomSheetDialoges = new BottomSheetDialog(
                        PembayaranActivity.this,R.style.BottomSheetDialogTheme
                );
                View bottomSheetViewes = LayoutInflater.from(getApplicationContext()).inflate(
                        R.layout.konfirmasi_pembayaran, (LinearLayout) findViewById(R.id.konfirmasi_pem)
                );

                bottomSheetDialog.cancel();
                bottomSheetDialoges.setContentView(bottomSheetViewes);
                bottomSheetDialoges.show();
            }
        }, SPLASH_TIME);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(PembayaranActivity.this,RiwayatpembayaranActivity.class);
                startActivity(intent);

            }
        }, SPLASH_TIME);
    }

    public void back (View view)
    {
        animation.setDuration(1000);
        view.startAnimation(animation);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }



}