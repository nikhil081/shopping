package com.example.nikma.shopping;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DatabaseReference firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseDatabase = FirebaseDatabase.getInstance().getReference("food");
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<food, foodviewholder> firebaseRecyclerAdapter = new
                FirebaseRecyclerAdapter<food, foodviewholder>(food.class, R.layout.row, foodviewholder.class, firebaseDatabase) {


                    @Override
                    protected void populateViewHolder(foodviewholder viewHolder, food model, int position) {


                        viewHolder.setDesc(model.getDesc());
                        viewHolder.setImage(model.getImage(),MainActivity.this);
                        viewHolder.setName(model.getName());

                    }
                };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

}
