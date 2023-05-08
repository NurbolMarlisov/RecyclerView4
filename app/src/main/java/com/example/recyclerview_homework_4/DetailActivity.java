package com.example.recyclerview_homework_4;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Flower flower = (Flower) getIntent().getSerializableExtra("flower");
        if (flower != null) {
            TextView nameTextView = findViewById(R.id.flower_name);
            nameTextView.setText(flower.getName());
            TextView colorTextView = findViewById(R.id.flower_color);
            colorTextView.setText(flower.getColor());
            TextView sumTextView = findViewById(R.id.flower_sum);
            sumTextView.setText(Integer.toString(flower.getSum()));
            ImageView imageView = findViewById(R.id.imageView_flower);
            imageView.setImageResource(flower.getImage());
        }


    }
}