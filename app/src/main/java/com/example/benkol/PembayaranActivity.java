package com.example.benkol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.RadioButton;

public class PembayaranActivity extends AppCompatActivity {

    AlphaAnimation animation = new AlphaAnimation(1F,0F);
    RadioButton tiga,empat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);




    }



    public void bayar (View view)
    {
        animation.setDuration(1000);
        view.startAnimation(animation);

        Intent intent = new Intent(this, RiwayatpembayaranActivity.class);
        startActivity(intent);
    }

    public void back (View view)
    {
        animation.setDuration(1000);
        view.startAnimation(animation);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }



}