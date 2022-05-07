package com.example.benkol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Pesan extends AppCompatActivity {

    ImageView sent;
    EditText tulis;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);
        sent = findViewById(R.id.sent);
        tulis = findViewById(R.id.tulis);
        text = findViewById(R.id.text);




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

    public void call(View view){
        Intent intent = new Intent(this, Call.class);
        startActivity(intent);
    }

    public void back(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}