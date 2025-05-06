package com.example.fooddude.randommeal.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.fooddude.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fooddude.randommeal.data.local.LocalDataSource;
import com.example.fooddude.randommeal.data.model.Meal;
import com.example.fooddude.randommeal.data.remote.RemoteDataSource;
import com.example.fooddude.randommeal.data.repository.MealRepository;
import com.example.fooddude.randommeal.presenter.RandomMealPresenter;
import com.example.fooddude.randommeal.view.adapter.RandomMealAdapter;
import com.example.fooddude.randommeal.view.contract.RandomMealContract;

import java.util.ArrayList;
import java.util.List;

public class RandomMealActivity extends AppCompatActivity implements RandomMealContract.View
{
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private RandomMealAdapter adapter;
    private RandomMealPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_meal);

        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new RandomMealAdapter(this, new ArrayList<>(), false, null);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        presenter = new RandomMealPresenter(
                this,
                new MealRepository(new LocalDataSource(), new RemoteDataSource())
        );

        presenter.loadRandomMeal();
    }

    @Override
    public void showLoading()
    {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading()
    {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMeals(List<Meal> meals)
    {
        adapter.setMeals(meals);
    }

    @Override
    public void showError(String message)
    {
        Toast.makeText(this, "Error: " + message, Toast.LENGTH_SHORT).show();
    }
}

