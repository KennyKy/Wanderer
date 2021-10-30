package com.example.wanderer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wanderer.database.dao.TravelDAO;
import com.example.wanderer.database.model.User;
import com.example.wanderer.utils.Shared;

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

                if (switch1.isChecked()) {
                    total = Float.parseFloat(cost.getText().toString()) + old_total;
                } else {
                    total = 0;
                }

                shared.put("entertainment_total", total);

                total_field.setText(Float.toString(total));
                name.setText("");
                cost.setText("");
            }
        });

        finalize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float total = shared.getFloat("entertainment_total");

                if (switch1.getShowText()) {
                    total += Float.parseFloat(cost.getText().toString());
                }

                shared.put("entertainment_total", total);
                shared.put("total_value", (total));

                int total_people = shared.getInt("total_people");
                float total_travel_cost = shared.getFloat("entertainment_total");
                float total_nights = shared.getInt("total_nights");
                float cost_per_person = total_travel_cost / total_people;

                Travel travel = new Travel();

                travel.setDistance(editDistance.getText().toString());
                travel.setEmail(editEmail.getText().toString());
                travel.setPassword(editPassword.getText().toString());


                Travel verifyTravel = new Travel();
                TravelDAO dao = new TravelDAO(Entertainment.this);

                verifyTravel = dao.select(travel.getUsername());

                name.setText("");
                cost.setText("");

                Intent travel = new Intent(Entertainment.this, Travel.class);
                startActivity(travel);
            }
        });
    }
}
