package com.example.fooddude.randommeal.view.contract;

import com.example.fooddude.randommeal.data.model.Meal;

import java.util.List;

public interface RandomMealContract {
    void loadRandomMeal();

    interface View {
        void showLoading();

        void hideLoading();

        void showMeals(List<Meal> meals);

        void showError(String message);
    }
}
