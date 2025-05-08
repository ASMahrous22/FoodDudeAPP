package com.example.fooddude.meal.network;

import com.example.fooddude.meal.data.model.CategoryResponse;
import com.example.fooddude.meal.data.model.CountryResponse;
import com.example.fooddude.meal.data.model.IngredientListResponse;
import com.example.fooddude.meal.data.model.IngredientResponse;
import com.example.fooddude.meal.data.model.MealResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealApiService
{

    @GET("search.php") Call searchMeals(@Query("s") String query);

    @GET("filter.php")
    Call<MealResponse> getMealsByCategory(@Query("c") String category);

    @GET("filter.php")
    Call<MealResponse> searchMealsByCountry(@Query("a") String area);

    @GET("filter.php")
    Call<MealResponse> searchMealsByIngredient(@Query("i") String ingredient);

    @GET("filter.php")
    Call<MealResponse> filterByArea(@Query("a") String area);

    @GET("random.php")
    Call<MealResponse> getRandomMeal();

    @GET("lookup.php")
    Call<MealResponse> getMealDetailsById(@Query("i") String id);

    @GET("categories.php")
    Call<CategoryResponse> getCategories();

    @GET("list.php?a=list")
    Call<CountryResponse> getCountries();

    @GET("list.php?i=list")
    Call<IngredientResponse> getIngredients();
}
