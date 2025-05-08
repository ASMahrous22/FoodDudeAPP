package com.example.fooddude.meal.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IngredientResponse
{
    @SerializedName("meals")
    private List<String> ingredients;

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
