package com.example.wanderer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wanderer.utils.RvAdapter;
import com.example.wanderer.utils.TravelCard;

import java.util.ArrayList;
import java.util.List;

public class TravelList extends AppCompatActivity {
    private ImageView addTrip;
    List<TravelCard> trips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travel_list);

        addTrip = findViewById(R.id.addTrip);
        RecyclerView rv = findViewById(R.id.recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(this);

        trips = new ArrayList<>();
        trips.add(new TravelCard(1,"Viagem 1", 500));
        trips.add(new TravelCard(2,"Viagem 2", 500));
        trips.add(new TravelCard(3,"Viagem 3", 500));

        RvAdapter adapter = new RvAdapter(trips);

        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);

        addTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viagem = new Intent(TravelList.this, Fuel.class);
                startActivity(viagem);
            }
        });
    }
}
