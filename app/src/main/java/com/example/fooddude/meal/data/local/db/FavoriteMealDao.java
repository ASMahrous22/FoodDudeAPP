package com.example.fooddude.meal.data.local.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.fooddude.meal.data.model.FavoriteMeal;

import java.util.List;

/**
 * Data Access Object for FavoriteMeal entity.
 */
@Dao
public interface FavoriteMealDao {

    /**
     * Inserts a favorite meal into the database, replacing any existing entry with the same ID.
     * @param meal Favorite meal to insert.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(FavoriteMeal meal);

    /**
     * Deletes a favorite meal from the database.
     * @param meal Favorite meal to delete.
     */
    @Delete
    void delete(FavoriteMeal meal);

    /**
     * Retrieves all favorite meals from the database.
     * @return LiveData containing a list of all favorite meals.
     */
    @Query("SELECT * FROM favorite_meals")
    LiveData<List<FavoriteMeal>> getAllFavorites();

    /**
     * Checks if a meal is marked as a favorite.
     * @param mealId The ID of the meal to check.
     * @return LiveData containing true if the meal is a favorite, false otherwise.
     */
    @Query("SELECT EXISTS(SELECT 1 FROM favorite_meals WHERE idMeal = :mealId)")
    LiveData<Boolean> isFavorite(String mealId);
}