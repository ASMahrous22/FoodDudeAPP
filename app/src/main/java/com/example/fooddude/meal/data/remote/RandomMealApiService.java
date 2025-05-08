package com.example.fooddude.meal.data.remote;

import com.example.fooddude.meal.data.model.MealResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RandomMealApiService
{
    @GET("random.php")
    Call<MealResponse> getRandomMeal();
}
