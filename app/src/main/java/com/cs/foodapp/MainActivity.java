package com.cs.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView r = findViewById(R.id.recyclerView);

Food [] f =Food.getFood();
        String [] names = new String[f.length];
        int [] imgs = new int[f.length];
        for (int i=0;i<names.length;i++)
        {
            imgs[i]=f[i].getImg();
            names[i]=f[i].getName();
        }
        r.setLayoutManager(new LinearLayoutManager(this));
        CustomAdapter adapter = new CustomAdapter(imgs,names);
        r.setAdapter(adapter);

    }
}