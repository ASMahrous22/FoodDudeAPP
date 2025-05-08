package com.example.fooddude.meal.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "weekly_plan")
public class WeeklyPlan
{
    @PrimaryKey(autoGenerate = true)
    private int id;
    private long dateMillis;       // start-of-day millis
    private String mealId;         // foreign key to Meal.idMeal

    public WeeklyPlan(long dateMillis, String mealId)
    {
        this.dateMillis = dateMillis;
        this.mealId = mealId;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public long getDateMillis() { return dateMillis; }
    public void setDateMillis(long dateMillis) { this.dateMillis = dateMillis; }
    public String getMealId() { return mealId; }
    public void setMealId(String mealId) { this.mealId = mealId; }
}