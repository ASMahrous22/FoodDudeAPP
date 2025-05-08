package com.example.fooddude.meal.presenter;

import com.example.fooddude.meal.data.model.CountryResponse;
import com.example.fooddude.meal.network.MealApiService;
import com.example.fooddude.meal.network.RetrofitClient;
import com.example.fooddude.meal.view.contract.CountryContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryPresenter implements CountryContract.Presenter
{
    private final CountryContract.View view;
    private final MealApiService apiService;

    public CountryPresenter(CountryContract.View view)
    {
        this.view = view;
        this.apiService = RetrofitClient.getMealApiService();
    }

    @Override
    public void getCountries()
    {
        apiService.getCountries().enqueue(new Callback<CountryResponse>()
        {
            @Override
            public void onResponse(Call<CountryResponse> call, Response<CountryResponse> response)
            {
                if (response.isSuccessful() && response.body() != null)
                {
                    view.showCountries(response.body().getMeals());
                }
                else
                {
                    view.showError("No countries found");
                }
            }

            @Override
            public void onFailure(Call<CountryResponse> call, Throwable t)
            {
                view.showError(t.getMessage());
            }
        });
    }

}