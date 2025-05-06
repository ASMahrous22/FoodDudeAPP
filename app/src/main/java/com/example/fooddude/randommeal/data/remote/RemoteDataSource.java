package com.example.fooddude.randommeal.data.remote;

import com.example.fooddude.randommeal.data.model.Meal;
import com.example.fooddude.randommeal.data.model.MealResponse;
import com.example.fooddude.randommeal.network.NetworkCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource
{
    private final MealApiService apiService;

    public RemoteDataSource()
    {
        apiService = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MealApiService.class);
    }

    public void fetchRandomMeal(NetworkCallback<Meal> callback) {
        apiService.getRandomMeal().enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getMeals() != null)
                {
                    callback.onSuccess(response.body().getMeals().get(0));
                }
                else
                {
                    callback.onFailure("Invalid response");
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t)
            {
                callback.onFailure(t.getMessage());
            }
        });
    }
}


