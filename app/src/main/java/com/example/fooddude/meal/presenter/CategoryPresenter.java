package com.example.fooddude.meal.presenter;

import com.example.fooddude.meal.data.model.Category;
import com.example.fooddude.meal.data.repository.CategoryRepository;
import com.example.fooddude.meal.view.contract.CategoryContract;
import java.util.List;

public class CategoryPresenter
{
    private final CategoryContract.View view;
    private final CategoryRepository repository;

    public CategoryPresenter(CategoryContract.View view, CategoryRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void getCategories()
    {
        repository.getCategories(new CategoryRepository.CategoryCallback() {
            @Override
            public void onSuccess(List<Category> categories) {
                view.showCategories(categories);
            }

            @Override
            public void onError(String errorMsg) {
                view.showError(errorMsg);
            }
        });
    }

}