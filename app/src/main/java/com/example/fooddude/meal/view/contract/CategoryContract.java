package com.example.fooddude.meal.view.contract;

import com.example.fooddude.meal.data.model.Category;
import java.util.List;

public interface CategoryContract
{
    interface View
    {
        void showCategories(List categories);
        void showError(String message);
    }
}