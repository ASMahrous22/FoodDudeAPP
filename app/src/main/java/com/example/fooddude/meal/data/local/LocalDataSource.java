package com.example.fooddude.meal.data.local;

import android.content.Context;
import com.example.fooddude.meal.data.local.db.MealDao;
import com.example.fooddude.meal.data.local.db.MealDatabase;
import com.example.fooddude.meal.data.model.Meal;
import java.util.List;

public class LocalDataSource
{
    private final MealDao mealDao;

    public LocalDataSource(Context context)
    {
        this.mealDao = MealDatabase.getInstance(context).mealDao();
    }

    public void insertMeals(List<Meal> meals)
    {
        new Thread(() -> mealDao.insertMeals(meals)).start();
    }

    public List<Meal> getAllMeals()
    {
        return mealDao.getAllMeals();
    }

    public List<Meal> getMealById(String mealId)
    {
        return mealDao.getMealById(mealId);
    }

    public void deleteMeal(Meal meal)
    {
        new Thread(() -> mealDao.deleteMeal(meal)).start();
    }

    public void insertIngredients(List<String> ingredients)
    {
        // Should insert logic for ingredients if i wanna store them separately.
    }


}