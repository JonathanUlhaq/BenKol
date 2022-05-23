package com.example.benkol;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Pesan extends AppCompatActivity {

    ImageView sent,cameras,tampil_foto;
    EditText tulis;
    TextView text;

    private static final int pic_id = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);
        sent = findViewById(R.id.sent);
        tulis = findViewById(R.id.tulis);
        text = findViewById(R.id.text);
        tampil_foto = findViewById(R.id.tampil_foto);



        cameras = findViewById(R.id.cameras);
        cameras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent cameraa = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(cameraa,pic_id);

            }
        });

        sent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = tulis.getText().toString();
                text.setVisibility(View.VISIBLE);
                Log.e("Hak",message);
                text.setText(message);
            }
        });

    }

    @SuppressLint("MissingSuperCall")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == pic_id) {
            Bitmap photo = (Bitmap)data.getExtras()
                    .get("data");

            tampil_foto.setImageBitmap(photo);
            tampil_foto.setVisibility(View.VISIBLE);
        }

    }

    public void call(View view){
        Intent intent = new Intent(this, Call.class);
        startActivity(intent);
    }

    public void back(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}