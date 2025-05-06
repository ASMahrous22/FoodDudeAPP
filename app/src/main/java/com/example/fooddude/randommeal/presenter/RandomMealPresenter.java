package com.example.fooddude.randommeal.presenter;
import com.example.fooddude.randommeal.data.model.Meal;
import com.example.fooddude.randommeal.data.repository.MealRepository;
import com.example.fooddude.randommeal.view.contract.RandomMealContract;
import com.example.fooddude.randommeal.network.NetworkCallback;

import java.util.List;

public class RandomMealPresenter implements RandomMealContract
{
    private final RandomMealContract.View view;
    private final MealRepository repository;

    public RandomMealPresenter(RandomMealContract.View view, MealRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void loadRandomMeal()
    {
        view.showLoading();
        repository.getRandomMeal(new NetworkCallback<List<Meal>>()
        {
            @Override
            public void onSuccess(List<Meal> meals)
            {
                view.hideLoading();
                view.showMeals(meals);
            }

            @Override
            public void onFailure(String message)
            {
                view.hideLoading();
                view.showError(message);
            }
        });
    }

}
