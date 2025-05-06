package com.example.fooddude.randommeal.data.local;

import com.example.fooddude.randommeal.data.model.Meal;
import java.util.ArrayList;
import java.util.List;

public class LocalDataSource
{
    private List<Meal> cachedMeals = new ArrayList<>();

    public void saveMeal(Meal meal) {
        cachedMeals.add(meal);
    }

    public List<Meal> getCachedMeals() {
        return cachedMeals;
    }
}
