package com.example.fooddude.meal.view.contract;

import com.example.fooddude.meal.data.model.Country;
import java.util.List;

public interface CountryContract
{
    interface View
    {
        void showCountries(List<Country> countries);

        void showError(String message);
    }

    interface Presenter
    {
        void getCountries();
    }

}