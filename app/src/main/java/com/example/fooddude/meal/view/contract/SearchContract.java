package com.example.fooddude.meal.view.contract;

import com.example.fooddude.meal.data.model.Meal;

import java.util.List;

public interface SearchContract
{
    interface View
    {
        void showSearchResults(List<Meal> meals);
        void showError(String message);
        void showLoading();
        void hideLoading();
    }

    interface Presenter
    {
        void searchMeals(String query);
    }
}
