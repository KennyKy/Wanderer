package com.example.trabalho_01.database.model;

public class Trip {
    public static final String
            TABLE_NAME="trips",
            DISTANCE_IN_KMS_COLUMN="distance_in_kms",
            NUMBER_OF_PEOPLE_COLUMN="number_of_people",
            TOTAL_COST_COLUMN="total_cost",
            USERNAME_COLUMN="username";

    public static final String
            CREATE_TABLE = "CREATE TABLE trips (distance_in_kms, number_of_people, total_cost, username);";

    public static final String
            DROP_TABLE = " drop table if exists users";

    private float distance_in_kms;
    private int number_of_people;
    private float total_cost;
    private String username;

    public float getDistance() {
        return distance_in_kms;
    }

    public void setDistance(float distance_in_kms) {
        this.distance_in_kms = distance_in_kms;
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