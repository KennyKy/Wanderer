package com.example.wanderer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wanderer.database.dao.TravelDAO;
import com.example.wanderer.database.model.TravelModel;
import com.example.wanderer.utils.RvAdapter;
import com.example.wanderer.utils.Shared;

import java.util.ArrayList;
import java.util.List;

public class TravelList extends AppCompatActivity {
    private ImageView addTrip;
    private Shared shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travel_list);

        addTrip = findViewById(R.id.addTrip);
        RecyclerView rv = findViewById(R.id.recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        shared = new Shared(TravelList.this);

        TravelDAO dao = new TravelDAO(TravelList.this);
        ArrayList<TravelModel> travels = dao.Select(shared.getString("logged_user"));

        RvAdapter adapter = new RvAdapter(travels);

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
