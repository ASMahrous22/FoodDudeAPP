package com.example.fooddude.randommeal.data.repository;

import com.example.fooddude.randommeal.data.local.LocalDataSource;
import com.example.fooddude.randommeal.data.model.Meal;
import com.example.fooddude.randommeal.data.remote.RemoteDataSource;
import com.example.fooddude.randommeal.network.NetworkCallback;
import java.util.List;


public class MealRepository
{
    private final LocalDataSource local;
    private final RemoteDataSource remote;

    public MealRepository(LocalDataSource local, RemoteDataSource remote)
    {
        this.local = local;
        this.remote = remote;
    }

    public void getRandomMeal(NetworkCallback<List<Meal>> callback)
    {
        remote.fetchRandomMeal(new NetworkCallback<Meal>()
        {
            @Override
            public void onSuccess(Meal meal)
            {
                local.saveMeal(meal);
                callback.onSuccess(local.getCachedMeals());
            }

            @Override
            public void onFailure(String message)
            {
                callback.onFailure(message);
            }
        });
    }
}


