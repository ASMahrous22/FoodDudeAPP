package com.example.fooddude.meal.view.contract;

import com.example.fooddude.meal.data.model.WeeklyPlan;

import java.util.List;

public interface WeeklyPlanContract
{
    interface View
    {
        void showWeek(List<WeeklyPlan> plans);
        void showError(String msg);
        void showLoading();
        void hideLoading();
    }

    interface Presenter
    {
        void loadWeek();
        void addMealToDate(long dateMillis, String mealId);
        void onDestroy();
    }
}