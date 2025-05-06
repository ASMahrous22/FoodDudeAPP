package com.example.fooddude.randommeal.data.remote;

import com.example.fooddude.randommeal.data.model.MealResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MealApiService
{
    @GET("random.php")
    Call<MealResponse> getRandomMeal();
}
