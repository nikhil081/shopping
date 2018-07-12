package com.example.nikma.shopping;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    FirebaseRecyclerAdapter<food, foodviewholder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        databaseReference = FirebaseDatabase.getInstance().getReference("food");
        Query query = FirebaseDatabase.getInstance().getReference("food");

        FirebaseRecyclerOptions<food> options = new FirebaseRecyclerOptions.Builder<food>()
                .setQuery(query, food.class)
                .build();
        adapter = new FirebaseRecyclerAdapter<food, foodviewholder>(options) {
            @NonNull
            @Override
            public foodviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
                return new foodviewholder(v);
            }

            @Override
            protected void onBindViewHolder(foodviewholder holder, int position, final food model) {

                holder.setDesc(model.getDesc());
                holder.setImage(model.getPhotourl(),MainActivity.this);
                holder.setName(model.getName());
                holder.setPrice(model.getPrice());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i =new Intent(getApplicationContext(),intermediate.class);
                        int price = model.getPrice();
                        i.putExtra("data",price);
                        startActivity(i);

                    }
                });

            }
        };
        recyclerView.setAdapter(adapter);

    }

    private void logout() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Intent i = new Intent(getApplicationContext(),login.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
