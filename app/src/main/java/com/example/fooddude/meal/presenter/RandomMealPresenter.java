package com.example.fooddude.meal.presenter;

import com.example.fooddude.meal.data.model.MealResponse;
import com.example.fooddude.meal.data.remote.RemoteDataSource;
import com.example.fooddude.meal.data.repository.MealRepository;
import com.example.fooddude.meal.view.contract.RandomMealContract;

public class RandomMealPresenter implements RandomMealContract.Presenter {
    private final RandomMealContract.View view;
    private final MealRepository repository;

    public RandomMealPresenter(RandomMealContract.View view, MealRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void loadRandomMeal() {
        view.showLoading();
        repository.getRandomMeal(new RemoteDataSource.MealCallback() {
            @Override
            public void onSuccess(MealResponse mealResponse) {
                view.hideLoading();
                if (mealResponse != null && mealResponse.getMeals() != null) {
                    view.showMeals(mealResponse.getMeals());
                } else {
                    view.showError("No meals found");
                }
            }

            @Override
            public void onError(String message) {
                view.hideLoading();
                view.showError(message);
            }
        });
    }

    @Override
    public void onDestroy() {
        // If there is any subscriptions/disposables, clear them here
    }
}