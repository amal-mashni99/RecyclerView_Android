package com.cs.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Food []f = Food.getFood();
        ImageView img = findViewById(R.id.imgD);
        TextView t1 = findViewById(R.id.nameD);
        TextView t2 = findViewById(R.id.description);
        TextView t3 = findViewById(R.id.price);

        Intent n = getIntent();
      int i= n.getIntExtra("indix",0);
        Drawable dr = ContextCompat.getDrawable(img.getContext(),f[i].getImg());
        img.setImageDrawable(dr);
       t1.setText(f[i].getName());
       t2.setText(f[i].getDescription());
       t3.setText("Price= "+f[i].getPrice()+"₪");



    }
}