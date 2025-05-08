package com.example.fooddude.meal.data.repository;

import com.example.fooddude.meal.data.model.Meal;
import com.example.fooddude.meal.data.model.MealResponse;
import com.example.fooddude.meal.data.remote.RemoteDataSource;

import java.util.List;

public class MealRepository {

    private final RemoteDataSource remoteDataSource;

    public MealRepository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public void searchMeals(String query, RemoteDataSource.MealCallback callback) {
        remoteDataSource.searchMeals(query, new RemoteDataSource.MealListCallback() {
            @Override
            public void onSuccess(List<Meal> meals) {
                MealResponse response = new MealResponse();
                response.setMeals(meals);
                callback.onSuccess(response);
            }

            @Override
            public void onError(String errorMsg) {
                callback.onError(errorMsg);
            }
        });
    }

    public void getRandomMeal(RemoteDataSource.MealCallback callback) {
        remoteDataSource.getRandomMeal(new RemoteDataSource.MealDetailCallback() {
            @Override
            public void onSuccess(Meal meal) {
                MealResponse response = new MealResponse();
                response.setMeals(List.of(meal)); // Wrap single meal in a list
                callback.onSuccess(response);
            }

            @Override
            public void onError(String errorMsg) {
                callback.onError(errorMsg);
            }
        });
    }

    public void getMealsByCategory(String category, RemoteDataSource.MealCallback callback) {
        remoteDataSource.getMealsByCategory(category, new RemoteDataSource.MealListCallback() {
            @Override
            public void onSuccess(List<Meal> meals) {
                MealResponse response = new MealResponse();
                response.setMeals(meals);
                callback.onSuccess(response);
            }

            @Override
            public void onError(String errorMsg) {
                callback.onError(errorMsg);
            }
        });
    }

    public void getMealDetailsById(String id, RemoteDataSource.MealCallback callback) {
        remoteDataSource.getMealDetailsById(id, new RemoteDataSource.MealDetailCallback() {
            @Override
            public void onSuccess(Meal meal) {
                MealResponse response = new MealResponse();
                response.setMeals(List.of(meal)); // Wrap single meal in a list
                callback.onSuccess(response);
            }

            @Override
            public void onError(String errorMsg) {
                callback.onError(errorMsg);
            }
        });
    }

    public void getIngredients(RemoteDataSource.MealCallback callback) {
        // Since MealCallback expects MealResponse, ingredients are not directly supported
        callback.onError("Ingredients fetch not supported with MealCallback");
        /*
        // Alternative: If ingredients need to be supported, use IngredientCallback
        remoteDataSource.getIngredients(new RemoteDataSource.IngredientCallback() {
            @Override
            public void onSuccess(List<String> ingredients) {
                // Handle ingredients if needed, but MealCallback expects MealResponse
                callback.onError("Ingredients cannot be mapped to MealResponse");
            }

            @Override
            public void onError(String errorMsg) {
                callback.onError(errorMsg);
            }
        });
        */
    }
}