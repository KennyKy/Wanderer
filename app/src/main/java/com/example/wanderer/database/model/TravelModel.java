package com.example.wanderer.database.model;

public class TravelModel {
    public static final String
            TABLE_NAME="travels",
            DURATION_COLUMN="duration",
            NUMBER_OF_PEOPLE_COLUMN="number_of_people",
            TOTAL_COST_COLUMN="total_cost",
            USERNAME_COLUMN="username";

    public static final String
            CREATE_TABLE = "CREATE TABLE travels (duration, number_of_people, total_cost, username);";

    public static final String
            DROP_TABLE = " DROP TABLE IF EXISTS travels";

    private int duration;
    private int number_of_people;
    private float total_cost;
    private String username;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getNumberOfPeople() {
        return number_of_people;
    }

    public void setNumberOfPeople(int number_of_people) {
        this.number_of_people = number_of_people;
    }

    public float getTotalCost() {
        return total_cost;
    }

    public void setTotalCost(float total_cost) {
        this.total_cost = total_cost;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
