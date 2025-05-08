package com.example.fooddude.meal.data.remote;

import com.example.fooddude.meal.data.model.IngredientResponse;
import com.example.fooddude.meal.data.model.Meal;
import com.example.fooddude.meal.data.model.MealResponse;
import com.example.fooddude.meal.network.MealApiService;
import com.example.fooddude.meal.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDataSource {

    private final MealApiService apiService;

    public RemoteDataSource() {
        this.apiService = RetrofitClient.getMealApiService();
    }

    // Search for meals based on query
    public void searchMeals(String query, MealListCallback callback) {
        Call<MealResponse> call = getMealSearchCall(query);
        call.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getMeals() != null) {
                    callback.onSuccess(response.body().getMeals());
                } else {
                    callback.onError("Search failed: No results found for query '" + query + "'");
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                callback.onError("Network error during search: " + t.getMessage());
            }
        });
    }

    // Get a random meal
    public void getRandomMeal(MealDetailCallback callback) {
        apiService.getRandomMeal().enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getMeals() != null) {
                    callback.onSuccess(response.body().getMeals().get(0));  // Assume only one random meal
                } else {
                    callback.onError("Failed to fetch random meal: Empty response");
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                callback.onError("Network error fetching random meal: " + t.getMessage());
            }
        });
    }

    // Get meals by category
    public void getMealsByCategory(String category, MealListCallback callback) {
        apiService.getMealsByCategory(category).enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getMeals() != null) {
                    callback.onSuccess(response.body().getMeals());
                } else {
                    callback.onError("Failed to fetch meals for category '" + category + "': Empty response");
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                callback.onError("Network error fetching category '" + category + "': " + t.getMessage());
            }
        });
    }

    // Get meal details by ID
    public void getMealDetailsById(String id, MealDetailCallback callback) {
        apiService.getMealDetailsById(id).enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getMeals() != null) {
                    callback.onSuccess(response.body().getMeals().get(0));  // Assume only one meal detail
                } else {
                    callback.onError("Failed to fetch meal details for ID '" + id + "': Not found");
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                callback.onError("Network error fetching meal ID '" + id + "': " + t.getMessage());
            }
        });
    }

    // Helper method to determine the API call based on the query type
    private Call<MealResponse> getMealSearchCall(String query) {
        String queryValue = query.contains("=") ? query.substring(2) : query;

        if (query.startsWith("s=")) {
            return apiService.searchMeals(queryValue);
        } else if (query.startsWith("c=")) {
            return apiService.getMealsByCategory(queryValue);
        } else if (query.startsWith("a=")) {
            return apiService.searchMealsByCountry(queryValue);
        } else if (query.startsWith("i=")) {
            return apiService.searchMealsByIngredient(queryValue);
        } else {
            return apiService.searchMeals(query);
        }
    }

    // Get ingredients
    public void getIngredients(final IngredientCallback callback) {
        Call<IngredientResponse> call = apiService.getIngredients();
        call.enqueue(new Callback<IngredientResponse>() {
            @Override
            public void onResponse(Call<IngredientResponse> call, Response<IngredientResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body().getIngredients());
                } else {
                    callback.onError("Failed to fetch ingredients: Empty response");
                }
            }

            @Override
            public void onFailure(Call<IngredientResponse> call, Throwable t) {
                callback.onError("Network error fetching ingredients: " + t.getMessage());
            }
        });
    }

    // IngredientCallback interface
    public interface IngredientCallback {
        void onSuccess(List<String> ingredients);
        void onError(String errorMsg);
    }

    // MealListCallback interface
    public interface MealListCallback {
        void onSuccess(List<Meal> meals);
        void onError(String errorMsg);
    }

    // MealDetailCallback interface
    public interface MealDetailCallback {
        void onSuccess(Meal meal);
        void onError(String errorMsg);
    }

    // MealCallback interface
    public interface MealCallback {
        void onSuccess(MealResponse mealResponse);
        void onError(String errorMsg);
    }
}