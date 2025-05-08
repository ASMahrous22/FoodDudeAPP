package com.example.fooddude.meal.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class IngredientListResponse {

    @SerializedName("meals")
    private List<Ingredient> ingredients;

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public static class Ingredient {
        @SerializedName("strIngredient")
        private String strIngredient;

        public String getStrIngredient() {
            return strIngredient;
        }

        public void setStrIngredient(String strIngredient) {
            this.strIngredient = strIngredient;
        }
    }
}