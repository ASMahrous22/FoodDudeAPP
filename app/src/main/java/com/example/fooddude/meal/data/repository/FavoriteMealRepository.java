package com.example.fooddude.meal.data.repository;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.example.fooddude.meal.data.local.db.FavoriteMealDao;
import com.example.fooddude.meal.data.local.db.MealDatabase;
import com.example.fooddude.meal.data.model.FavoriteMeal;
import com.example.fooddude.meal.util.FirebaseSyncHelper;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FavoriteMealRepository {

    private final FavoriteMealDao favoriteMealDao;
    private final FirebaseSyncHelper firebaseSyncHelper;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public FavoriteMealRepository(Context context) {
        favoriteMealDao = MealDatabase.getInstance(context).favoriteMealDao();
        firebaseSyncHelper = new FirebaseSyncHelper();
    }

    public void insert(FavoriteMeal meal) {
        executor.execute(() -> {
            favoriteMealDao.insert(meal);
            firebaseSyncHelper.syncFavoriteMeal(meal);
        });
    }

    public void delete(FavoriteMeal meal) {
        executor.execute(() -> {
            favoriteMealDao.delete(meal);
            firebaseSyncHelper.deleteFavoriteMeal(meal.getIdMeal());
        });
    }

    public LiveData<List<FavoriteMeal>> getAllFavorites() {
        return favoriteMealDao.getAllFavorites();
    }

    public LiveData<Boolean> isFavorite(String mealId) {
        return favoriteMealDao.isFavorite(mealId);
    }
}
