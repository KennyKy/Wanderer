package com.example.trabalho_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabalho_01.utils.Shared;

public class Entertainment extends AppCompatActivity  {
    private EditText name;
    private EditText cost;
    private TextView total_field;

    private Button add_new_entertainment;
    private Button finalize;
    private Switch switch1;
    private Shared shared;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entertainment);

        name = findViewById(R.id.name);
        cost = findViewById(R.id.cost);
        total_field = findViewById(R.id.total_field);

        add_new_entertainment = findViewById(R.id.add_new_entertainment);
        finalize = findViewById(R.id.finalize);
        switch1 = findViewById(R.id.switch1);

        float old_total = shared.getFloat("total_value");
        total_field.setText(Float.toString(old_total));

        shared = new Shared(Entertainment.this);

        add_new_entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float total;
                float old_total = shared.getFloat("entertainment_total");

                if (switch1.getShowText()) {
                    total = Float.parseFloat(cost.getText().toString()) + old_total;
                } else {
                    total = 0;
                }

                shared.put("entertainment_total", total);

                name.setText("");
                cost.setText("");
                switch1.setShowText(false);
            }
        });

        finalize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float total;
                float old_total = shared.getFloat("entertainment_total");

                if (switch1.getShowText()) {
                    total = Float.parseFloat(cost.getText().toString()) + old_total;
                } else {
                    total = 0;
                }

                shared.put("entertainment_total", total);
                shared.put("total_value", (total + old_total));

                name.setText("");
                cost.setText("");
                switch1.setShowText(false);
            }
        });
    }
}
