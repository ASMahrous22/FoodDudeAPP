package com.example.fooddude.meal.data.local.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.fooddude.meal.data.model.Category;

import java.util.List;

/**
 * Data Access Object for Category entity.
 */
@Dao
public interface CategoryDao {

    /**
     * Inserts a list of categories into the database, replacing any existing categories with the same ID.
     * @param categories List of categories to insert.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCategories(List<Category> categories);

    /**
     * Retrieves all categories from the database.
     * @return List of all categories.
     */
    @Query("SELECT * FROM categories")
    List<Category> getAllCategories();
}