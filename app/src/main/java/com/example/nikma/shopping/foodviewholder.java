package com.example.nikma.shopping;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.net.URI;

public class foodviewholder extends RecyclerView.ViewHolder {
    private final ImageView imageView;
    private final TextView name;
    private final TextView desc;

    public foodviewholder(View itemView) {
        super(itemView);
        desc = itemView.findViewById(R.id.desc);
        imageView = itemView.findViewById(R.id.im);
        name = itemView.findViewById(R.id.name);
    }



    public void setDesc(String d) {
        desc.setText(d);
    }

    public void setImage(String image, Context context) {
        Glide.with(context).load(image).into(imageView);


    }
    public void setName(String n) {
        name.setText(n);
    }


}
