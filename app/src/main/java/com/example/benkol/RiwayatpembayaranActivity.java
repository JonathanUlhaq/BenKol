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
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class RiwayatpembayaranActivity extends AppCompatActivity {
    RatingBar ratingBar;
    float myRating=0;
    AlphaAnimation animation = new AlphaAnimation(1F,0F);

    private static final int SPLASH_TIME = 2*1000;
    ProgressBar prg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayatpembayaran);
        ratingBar = findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                int rating = (int) v;
                String message = null;

                myRating = ratingBar.getRating();
                switch (rating){
                    case 1:
                        message = "saya kecewa";
                        break;
                    case 2:
                        message = "saya sedih";
                        break;
                    case 3:
                        message = "Biasa saja";
                        break;
                    case 4:
                        message = "Cukup memuaskan";
                        break;
                    case 5:
                        message = "Sangat memuaskan";
                        break;
                }
                Toast.makeText(RiwayatpembayaranActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public  void bantuan (View view)
    {
        Intent intent = new Intent(this, BantuancsActivity.class);
        startActivity(intent);
    }

    public void back (View view)
    {
        animation.setDuration(1000);
        view.startAnimation(animation);
        Intent intent = new Intent(this,PembayaranActivity.class);
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