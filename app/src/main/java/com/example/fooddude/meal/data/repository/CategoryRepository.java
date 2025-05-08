package com.example.fooddude.meal.data.repository;

import android.content.Context;
import com.example.fooddude.meal.data.local.db.MealDatabase;
import com.example.fooddude.meal.data.model.CategoryResponse;
import com.example.fooddude.meal.data.local.db.CategoryDao;
import com.example.fooddude.meal.data.model.Category;
import com.example.fooddude.meal.network.MealApiService;
import com.example.fooddude.meal.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.List;

public class CategoryRepository
{
    private final MealApiService apiService;
    private final com.example.fooddude.meal.data.local.db.CategoryDao categoryDao;

    public CategoryRepository(Context context) {
        this.apiService = RetrofitClient.getMealApiService();
        this.categoryDao = MealDatabase.getInstance(context).categoryDao();
    }

    public void getCategories(CategoryCallback callback) {
        apiService.getCategories().enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getCategories() != null) {
                    List<Category> categories = response.body().getCategories();
                    new Thread(() -> categoryDao.insertCategories(categories)).start();
                    callback.onSuccess(categories);
                } else {
                    List<Category> cachedCategories = categoryDao.getAllCategories();
                    if (cachedCategories != null && !cachedCategories.isEmpty()) {
                        callback.onSuccess(cachedCategories);
                    } else {
                        callback.onError("Failed to fetch categories");
                    }
                }
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t)
            {
                List<Category> cachedCategories = categoryDao.getAllCategories();
                if (cachedCategories != null && !cachedCategories.isEmpty()) {
                    callback.onSuccess(cachedCategories);
                } else {
                    callback.onError("Network error: " + t.getMessage());
                }
            }
        });
    }

    public interface CategoryCallback {
        void onSuccess(List<Category> categories);
        void onError(String errorMsg);
    }

}