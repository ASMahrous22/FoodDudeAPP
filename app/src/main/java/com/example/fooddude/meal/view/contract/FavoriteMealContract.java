package com.example.fooddude.meal.view.contract;

import androidx.lifecycle.LiveData;
import java.util.List;
import com.example.fooddude.meal.data.model.FavoriteMeal;


public interface FavoriteMealContract
{
    interface Presenter
    {
        void insert(FavoriteMeal meal);
        void delete(FavoriteMeal meal);
        LiveData<Boolean> isFavorite(String mealId);
        LiveData<List<FavoriteMeal>> getAllFavorites();
    }

    interface View
    {
        void showFavorites(List<FavoriteMeal> meals);
        void showEmptyFavoritesMessage();
        void showFavoriteAddedMessage();
        void showFavoriteRemovedMessage();
    }
}
