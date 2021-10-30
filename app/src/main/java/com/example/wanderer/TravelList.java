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
    private RvAdapter adapter;
    private RecyclerView rv;
    private LinearLayoutManager llm;
    private ArrayList<TravelModel> travels;
    private TravelDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travel_list);

        addTrip = findViewById(R.id.addTrip);
        rv = findViewById(R.id.recycler_view);
        llm = new LinearLayoutManager(this);
        shared = new Shared(TravelList.this);

        dao = new TravelDAO(TravelList.this);
        travels = dao.Select(shared.getString("logged_user"));

        adapter = new RvAdapter(travels);

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
