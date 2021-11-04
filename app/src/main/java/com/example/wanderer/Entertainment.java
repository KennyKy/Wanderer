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

import com.example.wanderer.database.model.TravelModel;
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
                float old_total = shared.getFloat("total_value");

                if (switch1.isChecked()) {
                    total = Float.parseFloat(cost.getText().toString()) + old_total;
                } else {
                    total = 0;
                }

                shared.put("entertainment_total", total);
                shared.put("total_value", total);

                total_field.setText(Float.toString(total));
                name.setText("");
                cost.setText("");
            }
        });

        finalize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float total = shared.getFloat("total_value");

                if (switch1.getShowText()) {
                    total = total + Float.parseFloat(cost.getText().toString());
                }

                shared.put("total_value", total);

                int total_people = shared.getInt("total_people");
                int total_nights = shared.getInt("total_nights");
                String username = shared.getString("logged_user");

                TravelModel travel = new TravelModel();

                travel.setDuration(total_nights);
                travel.setNumberOfPeople(total_people);
                travel.setTotalCost(total);
                travel.setUsername(username);

                TravelDAO dao = new TravelDAO(Entertainment.this);

                dao.Insert(travel);

                Intent travelIntent = new Intent(Entertainment.this, Travel.class);
                startActivity(travelIntent);
            }
        });
    }
}
