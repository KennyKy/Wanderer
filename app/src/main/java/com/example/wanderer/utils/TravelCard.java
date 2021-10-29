package com.example.wanderer.utils;

public class TravelCard {
    private int days;
    private String name;
    private float total_cost;

    public TravelCard(int days, String name, float total_cost) {
        this.days = days;
        this.name = name;
        this.total_cost = total_cost;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTotalCost() {
        return total_cost;
    }

    public void setTotalCost(float total_cost) {
        this.total_cost = total_cost;
    }
}
