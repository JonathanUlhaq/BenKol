package com.example.benkol;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemViewActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    ItemsModel itemsModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        imageView  = findViewById(R.id.iamgeViewItem);
        textView = findViewById(R.id.tvNameItem);

        Intent intent  = getIntent();

        if(intent.getExtras() != null){
            itemsModel = (ItemsModel) intent.getSerializableExtra("item");
            imageView.setImageResource(itemsModel.getImage());
            textView.setText(itemsModel.getName());
        }

    }
}
