package com.example.nikma.shopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class intermediate extends AppCompatActivity {
        TextView txt1,txt2;
        Button button;
        int price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate);
        txt2 = findViewById(R.id.text2);
        button = findViewById(R.id.inter);
        Bundle extras = getIntent().getExtras();
        price = extras.getInt("data");
        txt2.setText(String.valueOf(price));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ie = new Intent(getApplicationContext(),paymentactivity.class);
                ie.putExtra("dataa",price);
                startActivity(ie);
            }
        });

    }
}
