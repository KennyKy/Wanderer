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

public class Snack extends AppCompatActivity {
    private EditText estimated_cost;
    private EditText total_snacks;
    private TextView total_field;

    private Button next_page_button;
    private Switch switch1;
    private Shared shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snack);

        estimated_cost = findViewById(R.id.estimated_cost);
        total_snacks = findViewById(R.id.total_snacks);
        total_field = findViewById(R.id.total_field);

        next_page_button = findViewById(R.id.next_page_button);
        switch1 = findViewById(R.id.switch1);

        float old_total = shared.getFloat("total_value");
        total_field.setText(Float.toString(old_total));

        shared = new Shared(Snack.this);

        next_page_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float total;

                if (switch1.isChecked()) {
                    total = (
                            Float.parseFloat(estimated_cost.getText().toString()) *
                            Float.parseFloat(total_snacks.getText().toString())
                    );
                } else {
                    total = 0;
                }

                shared.put("snack_total", total);
                shared.put("total_value", (total + old_total));

                Intent nextPage = new Intent(Snack.this, Accommodation.class);
                startActivity(nextPage);
            }
        });
    }
}
