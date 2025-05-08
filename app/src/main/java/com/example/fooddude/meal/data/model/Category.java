package com.example.fooddude.meal.data.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Room entity representing a meal category.
 */
@Entity(tableName = "categories")
public class Category {
    @PrimaryKey
    @NonNull
    private String idCategory = "";

    private String strCategory;
    private String strCategoryThumb;
    private String strCategoryDescription;

    // Getters

    /**
     * Gets the unique ID of the category.
     * @return Non-null category ID.
     */
    @NonNull
    public String getIdCategory() {
        return idCategory;
    }

    /**
     * Gets the name of the category.
     * @return Category name, or null if not available.
     */
    @Nullable
    public String getStrCategory() {
        return strCategory;
    }

    /**
     * Gets the URL of the category's thumbnail image.
     * @return Thumbnail URL, or null if not available.
     */
    @Nullable
    public String getStrCategoryThumb() {
        return strCategoryThumb;
    }

    /**
     * Gets the description of the category.
     * @return Description, or null if not available.
     */
    @Nullable
    public String getStrCategoryDescription() {
        return strCategoryDescription;
    }

    // Setters

    /**
     * Sets the unique ID of the category.
     * @param idCategory Non-null category ID.
     */
    public void setIdCategory(@NonNull String idCategory) {
        this.idCategory = idCategory;
    }

    /**
     * Sets the name of the category.
     * @param strCategory Category name.
     */
    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    /**
     * Sets the URL of the category's thumbnail image.
     * @param strCategoryThumb Thumbnail URL.
     */
    public void setStrCategoryThumb(String strCategoryThumb) {
        this.strCategoryThumb = strCategoryThumb;
    }

    /**
     * Sets the description of the category.
     * @param strCategoryDescription Description.
     */
    public void setStrCategoryDescription(String strCategoryDescription) {
        this.strCategoryDescription = strCategoryDescription;
    }
}