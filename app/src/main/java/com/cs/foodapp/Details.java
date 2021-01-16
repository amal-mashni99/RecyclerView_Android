package com.cs.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Details extends AppCompatActivity {
    int count;
    TextView t4;
    ArrayList<Food> foods;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Food m = new Food();
         foods=m.getFoods();
        ImageView img = findViewById(R.id.imgD);
        TextView t1 = findViewById(R.id.nameD);
        TextView t2 = findViewById(R.id.description);
        TextView t3 = findViewById(R.id.price);
        t4 = findViewById(R.id.count);
         count = 1;
        Intent n = getIntent();
        i= n.getIntExtra("indix",0);
       // Drawable dr = ContextCompat.getDrawable(img.getContext(),R.drawable.img1);
       // img.setImageDrawable(dr);
        Glide.with(img.getContext())
                .load(foods.get(i).getImg())
                .into(img);
       t1.setText(foods.get(i).getName());
       t2.setText(foods.get(i).getDescription());
       t3.setText("Price= "+foods.get(i).getPrice()+"₪");
t4.setText(count+"");


    }

    public void incOnClick(View view) {


        count++;
       t4.setText(count+"");

    }

    public void decOnClick(View view) {

        count--;
        if (count == 0)
        {
            count =1;
            t4.setText(count+"");
        }
        t4.setText(count+"");

    }

    public void orderOnClick(View view) {

        Intent n= new Intent( this,OrderActivity.class);
        n.putExtra("name",foods.get(i).getName());
        n.putExtra("price",foods.get(i).getPrice());
        n.putExtra("count",count);
        startActivity(n);
    }
}