package com.example.fooddude.meal.presenter;

import com.example.fooddude.meal.data.model.MealResponse;
import com.example.fooddude.meal.data.remote.RemoteDataSource;
import com.example.fooddude.meal.data.repository.MealRepository;
import com.example.fooddude.meal.view.contract.SearchContract;

public class SearchPresenter implements SearchContract.Presenter {
    private final SearchContract.View view;
    private final MealRepository repository;

    public SearchPresenter(SearchContract.View view, MealRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void searchMeals(String query) {
        view.showLoading();
        repository.searchMeals(query, new RemoteDataSource.MealCallback() {
            @Override
            public void onSuccess(MealResponse mealResponse) {
                view.hideLoading();
                if (mealResponse != null && mealResponse.getMeals() != null) {
                    view.showSearchResults(mealResponse.getMeals());
                } else {
                    view.showError("No meals found for query: " + query);
                }
            }

            @Override
            public void onError(String errorMessage) {
                view.hideLoading();
                view.showError(errorMessage);
            }
        });
    }
}