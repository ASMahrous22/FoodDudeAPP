package com.example.fooddude.meal.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CategoryResponse
{
    @SerializedName("categories") private List categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}