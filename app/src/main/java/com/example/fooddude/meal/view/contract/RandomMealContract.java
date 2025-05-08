package com.example.fooddude.meal.view.contract;

import com.example.fooddude.meal.data.model.Meal;

import java.util.List;

public interface RandomMealContract
{
    interface View
    {
        void showLoading();
        void hideLoading();
        void showMeals(List<Meal> meals);
        void showError(String message);
    }

    interface Presenter
    {
        void loadRandomMeal();
        void onDestroy();  // to clean up any resources if needed
    }
}
