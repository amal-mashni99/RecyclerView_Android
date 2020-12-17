package com.cs.foodapp;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

   private int [] img;
    private String [] name;


    public CustomAdapter(int[] img, String[] name) {
        this.img = img;
        this.name = name;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        CardView view = (CardView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        final CardView card= viewHolder.cardView;
        ImageView imgv= card.findViewById(R.id.img);

        Drawable dr = ContextCompat.getDrawable(card.getContext(),img[position]);

        imgv.setImageDrawable(dr);

        final TextView text= card.findViewById(R.id.name);
        text.setText(name[position]);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n=  new Intent(card.getContext(), Details.class);
                n.putExtra("indix",position);

              card.getContext().startActivity(n);
            }
        });
    }
    @Override
    public int getItemCount() {
        return name.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView cardView) {
            super(cardView);
            // Define click listener for the ViewHolder's View
this.cardView=cardView;
        }


    }
}
