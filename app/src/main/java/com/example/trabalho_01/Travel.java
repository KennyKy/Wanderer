package com.example.trabalho_01;

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
        list = findViewById(R.id.list);
        add = findViewById(R.id.add);

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO
                Toast.makeText(Travel.this, "LIST", Toast.LENGTH_SHORT).show();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fuel = new Intent(Travel.this, Fuel.class);
                startActivity(fuel);
            }
        });
    }
}
