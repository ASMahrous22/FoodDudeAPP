package com.example.fooddude.meal.presenter;

import com.example.fooddude.meal.data.local.db.FavoriteMealDao;
import com.example.fooddude.meal.data.model.FavoriteMeal;
import com.example.fooddude.meal.data.repository.FavoriteMealRepository;
import com.example.fooddude.meal.view.contract.FavoriteMealContract;
import androidx.lifecycle.LiveData;
import java.util.List;

public class FavoriteMealPresenter implements FavoriteMealContract.Presenter
{

    private final FavoriteMealRepository repository;

    public FavoriteMealPresenter(FavoriteMealRepository repository) {
        this.repository = repository;
    }

    @Override
    public void insert(FavoriteMeal meal) {
        repository.insert(meal);
    }

    @Override
    public void delete(FavoriteMeal meal) {
        repository.delete(meal);
    }

    @Override
    public LiveData<Boolean> isFavorite(String mealId) {
        return repository.isFavorite(mealId);
    }

    @Override
    public LiveData<List<FavoriteMeal>> getAllFavorites() {
        return repository.getAllFavorites();
    }
}
