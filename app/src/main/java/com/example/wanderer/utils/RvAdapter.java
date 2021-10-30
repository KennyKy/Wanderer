package com.example.wanderer.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wanderer.R;
import com.example.wanderer.database.model.TravelModel;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.PersonViewHolder> {
    List<TravelModel> trips;

    public RvAdapter(List<TravelModel> trips) {
        this.trips = trips;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int i) {
        holder.title.setText("Viagem " + Integer.toString(i));
        holder.people.setText(Integer.toString(trips.get(i).getNumberOfPeople()));
        holder.cost.setText(Float.toString(trips.get(i).getTotalCost()));
        holder.duration.setText(Float.toString(trips.get(i).getDuration()));
        holder.costPerPerson.setText(Float.toString(trips.get(i).getTotalCost() / trips.get(i).getNumberOfPeople()));
    }

    @Override
    public int getItemCount() {
        return trips.size();
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView title, people, duration, cost, costPerPerson;

        PersonViewHolder (View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            people = (TextView) itemView.findViewById(R.id.people);
            duration = (TextView) itemView.findViewById(R.id.duration);
            cost = (TextView) itemView.findViewById(R.id.cost);
            costPerPerson = (TextView) itemView.findViewById(R.id.cost_per_person);
        }
    }
}
