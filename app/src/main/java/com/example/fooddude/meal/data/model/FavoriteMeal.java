package com.example.fooddude.meal.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Room entity representing a favorite meal.
 */
@Entity(tableName = "favorite_meals")
public class FavoriteMeal {
    @PrimaryKey
    @NonNull
    private String idMeal = "";

    private String strMeal;
    private String strMealThumb;
    private String strArea;
    private String strCategory;
    private String strInstructions;
    private String strYoutube;
    private String strIngredient1;
    private String strMeasure1;

    public FavoriteMeal(String idMeal, String strMeal, String strMealThumb,
                        String strArea, String strCategory, String strInstructions,
                        String strYoutube, String strIngredient1, String strMeasure1) {
        this.idMeal = idMeal;
        this.strMeal = strMeal;
        this.strMealThumb = strMealThumb;
        this.strArea = strArea;
        this.strCategory = strCategory;
        this.strInstructions = strInstructions;
        this.strYoutube = strYoutube;
        this.strIngredient1 = strIngredient1;
        this.strMeasure1 = strMeasure1;
    }


    @NonNull
    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(@NonNull String idMeal) {
        this.idMeal = idMeal;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public String getStrArea() {
        return strArea;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public String getStrIngredient1() {
        return strIngredient1;
    }

    public void setStrIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    public String getStrMeasure1() {
        return strMeasure1;
    }

    public void setStrMeasure1(String strMeasure1) {
        this.strMeasure1 = strMeasure1;
    }
}
