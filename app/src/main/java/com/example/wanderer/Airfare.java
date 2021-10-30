package com.example.wanderer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wanderer.utils.Shared;

public class Airfare extends AppCompatActivity {
    private EditText people_quantity;
    private EditText estimated_cost;
    private EditText car_rent;

    private Button next_page_button;
    private Switch switch1;
    private Shared shared;
    private TextView total_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.airfare);

        people_quantity = findViewById(R.id.people_quantity);
        estimated_cost = findViewById(R.id.estimated_cost);
        car_rent = findViewById(R.id.car_rent);
        total_field = findViewById(R.id.total_field);

        next_page_button = findViewById(R.id.next_page_button);
        switch1 = findViewById(R.id.switch1);

        float old_total = shared.getFloat("total_value");
        total_field.setText(Float.toString(old_total));

        shared = new Shared(Airfare.this);

        next_page_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float total;
                int totalPeople = Integer.parseInt(people_quantity.getText().toString());

                if (switch1.isChecked()) {
                    total = (
                            (
                                Float.parseFloat(estimated_cost.getText().toString()) *
                                Float.parseFloat(people_quantity.getText().toString())
                            ) + Float.parseFloat(car_rent.getText().toString())
                    );
                } else {
                    total = 0;
                }

                shared.put("total_people", totalPeople);
                shared.put("airfare_total", total);
                shared.put("total_value", (total + old_total));

                Intent nextPage = new Intent(Airfare.this, Snack.class);
                startActivity(nextPage);
            }
        });
    }
}
