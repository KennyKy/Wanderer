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

public class Accommodation extends AppCompatActivity {
    private EditText avg_cost;
    private EditText total_nights;
    private EditText total_rooms;
    private Button next_page_button;
    private Switch switch1;
    private Shared shared;
    private TextView total_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accommodation);

        avg_cost = findViewById(R.id.avg_cost);
        total_nights = findViewById(R.id.total_nights);
        total_rooms = findViewById(R.id.total_rooms);
        next_page_button = findViewById(R.id.next_page_button);
        switch1 = findViewById(R.id.switch1);
        total_field = findViewById(R.id.total_field);

        float old_total = shared.getFloat("total_value");
        total_field.setText(Float.toString(old_total));

        shared = new Shared(Accommodation.this);

        next_page_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float total;

                if (switch1.isChecked()) {
                    total = (
                        Float.parseFloat(avg_cost.getText().toString()) *
                        Float.parseFloat(total_nights.getText().toString()) *
                        Float.parseFloat(total_rooms.getText().toString())
                    );
                } else {
                    total = 0;
                }

                shared.put("accommodation_total", total);
                shared.put("total_value", (total + old_total));
                shared.put("total_nights", total_nights);

                Intent createAccount = new Intent(Accommodation.this, Entertainment.class);
                startActivity(createAccount);
            }
        });
    }
}
