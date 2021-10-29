package com.example.wanderer.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wanderer.R;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.PersonViewHolder> {
    List<TravelCard> trips;

    public RvAdapter(List<TravelCard> trips) {
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
        holder.title.setText(trips.get(i).getName());
        holder.date.setText(Integer.toString(trips.get(i).getDays()));
        holder.totalCost.setText(Float.toString(trips.get(i).getTotalCost()));
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
        TextView title, date, totalCost;

        PersonViewHolder (View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            title = (TextView) itemView.findViewById(R.id.title);
            date = (TextView) itemView.findViewById(R.id.date);
            totalCost = (TextView) itemView.findViewById(R.id.total_cost);
        }
    }
}
