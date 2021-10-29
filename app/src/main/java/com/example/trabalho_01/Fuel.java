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

public class Fuel extends AppCompatActivity  {
    private EditText km_total;
    private EditText fuel_by_km;
    private EditText avg_fuel_cost;
    private EditText total_cars;
    private TextView total_field;

    private Button next_page_button;
    private Switch switch1;
    private Shared shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fuel);

        km_total = findViewById(R.id.km_total);
        fuel_by_km = findViewById(R.id.fuel_by_km);
        avg_fuel_cost = findViewById(R.id.avg_fuel_cost);
        total_cars = findViewById(R.id.total_cars);
        total_field = findViewById(R.id.total_field);

        next_page_button = findViewById(R.id.next_page_button);
        switch1 = findViewById(R.id.switch1);

        shared = new Shared(Fuel.this);

        next_page_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float total;

                if (switch1.isChecked()) {
                    total = (
                            Float.parseFloat(km_total.getText().toString()) /
                            Float.parseFloat(fuel_by_km.getText().toString()) *
                            Float.parseFloat(avg_fuel_cost.getText().toString()) *
                            Float.parseFloat(total_cars.getText().toString())
                    );
                } else {
                    total = 0;
                }

                shared.put("fuel_total", total);
                shared.put("total_value", (total));

                Intent nextPage = new Intent(Fuel.this, Airfare.class);
                startActivity(nextPage);
            }
        });
    }
}
