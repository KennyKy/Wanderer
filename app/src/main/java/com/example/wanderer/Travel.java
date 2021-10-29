package com.example.wanderer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Travel extends AppCompatActivity {
    private Button list;
    private Button add;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travel);
        add = findViewById(R.id.add);
        list = findViewById(R.id.list);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fuel = new Intent(Travel.this, Fuel.class);
                startActivity(fuel);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fuel = new Intent(Travel.this, TravelList.class);
                startActivity(fuel);
            }
        });
    }
}
