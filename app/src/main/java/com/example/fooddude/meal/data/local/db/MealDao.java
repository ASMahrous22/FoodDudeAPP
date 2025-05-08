package com.example.fooddude.meal.data.local.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.fooddude.meal.data.model.Meal;

import java.util.List;

@Dao
public interface MealDao {

    /**
     * Inserts a list of meals into the database, replacing any existing meals with the same ID.
     * @param meals List of meals to insert.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMeals(List<Meal> meals);

    /**
     * Retrieves all meals from the database.
     * @return List of all meals.
     */
    @Query("SELECT * FROM meals")
    List<Meal> getAllMeals();

    /**
     * Retrieves meals by their ID.
     * @param mealId The ID of the meal to retrieve.
     * @return List of meals with the specified ID (typically one or none).
     */
    @Query("SELECT * FROM meals WHERE idMeal = :mealId")
    List<Meal> getMealById(String mealId);

    /**
     * Deletes a meal from the database.
     * @param meal The meal to delete.
     */
    @Delete
    void deleteMeal(Meal meal);

    /**
     * Retrieves a list of unique ingredients from all meals.
     * Combines distinct non-null and non-empty ingredients from strIngredient1 through strIngredient20.
     * @return List of unique ingredient strings.
     */
    @Query("SELECT DISTINCT strIngredient1 FROM meals WHERE strIngredient1 IS NOT NULL AND strIngredient1 != '' " +
            "UNION " +
            "SELECT DISTINCT strIngredient2 FROM meals WHERE strIngredient2 IS NOT NULL AND strIngredient2 != '' " +
            "UNION " +
            "SELECT DISTINCT strIngredient3 FROM meals WHERE strIngredient3 IS NOT NULL AND strIngredient3 != '' " +
            "UNION " +
            "SELECT DISTINCT strIngredient4 FROM meals WHERE strIngredient4 IS NOT NULL AND strIngredient4 != '' " +
            "UNION " +
            "SELECT DISTINCT strIngredient5 FROM meals WHERE strIngredient5 IS NOT NULL AND strIngredient5 != '' " +
            "UNION " +
            "SELECT DISTINCT strIngredient6 FROM meals WHERE strIngredient6 IS NOT NULL AND strIngredient6 != '' " +
            "UNION " +
            "SELECT DISTINCT strIngredient7 FROM meals WHERE strIngredient7 IS NOT NULL AND strIngredient7 != '' " +
            "UNION " +
            "SELECT DISTINCT strIngredient8 FROM meals WHERE strIngredient8 IS NOT NULL AND strIngredient8 != '' " +
            "UNION " +
            "SELECT DISTINCT strIngredient9 FROM meals WHERE strIngredient9 IS NOT NULL AND strIngredient9 != '' " +
            "UNION " +
            "SELECT DISTINCT strIngredient10 FROM meals WHERE strIngredient10 IS NOT NULL AND strIngredient10 != '' " +
            "UNION " +
            "SELECT DISTINCT strIngredient11 FROM meals WHERE strIngredient11 IS NOT NULL AND strIngredient11 != '' " +
            "UNION " +
            "SELECT DISTINCT strIngredient12 FROM meals WHERE strIngredient12 IS NOT NULL AND strIngredient12 != '' " +
            "UNION " +
            "SELECT DISTINCT strIngredient13 FROM meals WHERE strIngredient13 IS NOT NULL AND strIngredient13 != '' " +
            "UNION " +
            "SELECT DISTINCT strIngredient14 FROM meals WHERE strIngredient14 IS NOT NULL AND strIngredient14 != '' " +
            "UNION " +
            "SELECT DISTINCT strIngredient15 FROM meals WHERE strIngredient15 IS NOT NULL AND strIngredient15 != '' " +
            "UNION " +
            "SELECT DISTINCT strIngredient16 FROM meals WHERE strIngredient16 IS NOT NULL AND strIngredient16 != '' " +
            "UNION " +
            "SELECT DISTINCT strIngredient17 FROM meals WHERE strIngredient17 IS NOT NULL AND strIngredient17 != '' " +
            "UNION " +
            "SELECT DISTINCT strIngredient18 FROM meals WHERE strIngredient18 IS NOT NULL AND strIngredient18 != '' " +
            "UNION " +
            "SELECT DISTINCT strIngredient19 FROM meals WHERE strIngredient19 IS NOT NULL AND strIngredient19 != '' " +
            "UNION " +
            "SELECT DISTINCT strIngredient20 FROM meals WHERE strIngredient20 IS NOT NULL AND strIngredient20 != ''")
    List<String> getIngredients();
}