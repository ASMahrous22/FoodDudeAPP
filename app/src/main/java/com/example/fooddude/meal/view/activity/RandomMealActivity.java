package com.example.fooddude.meal.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.fooddude.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddude.meal.data.local.LocalDataSource;
import com.example.fooddude.meal.data.model.Meal;
import com.example.fooddude.meal.data.remote.RemoteDataSource;
import com.example.fooddude.meal.data.repository.MealRepository;
import com.example.fooddude.meal.presenter.RandomMealPresenter;
import com.example.fooddude.meal.view.adapter.RandomMealAdapter;
import com.example.fooddude.meal.view.contract.RandomMealContract;

import java.util.ArrayList;
import java.util.List;

public class RandomMealActivity extends AppCompatActivity implements RandomMealContract.View {
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private RandomMealAdapter adapter;
    private RandomMealPresenter presenter;
    private LocalDataSource localDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_meal);

        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);

        // 1) Initialize LocalDataSource for favorites
        localDataSource = new LocalDataSource(this);

        // 2) Determine guest status (replace with your real auth check)
        boolean isGuest = false;

        // 3) Create the RecyclerView adapter with action listener
        RandomMealAdapter.OnMealActionListener actionListener =
                new RandomMealAdapter.OnMealActionListener() {
                    @Override
                    public void onAddToFavorites(Meal meal) {
                        localDataSource.insertMeals(
                                // wrap single meal in a List
                                java.util.Collections.singletonList(meal)
                        );
                        Toast.makeText(
                                RandomMealActivity.this,
                                meal.getStrMeal() + " added to favorites",
                                Toast.LENGTH_SHORT
                        ).show();
                    }

                    @Override
                    public void onRemoveFromFavorites(Meal meal) {
                        // You’ll need to add this to your DAO/LocalDataSource:
                        localDataSource.deleteMeal(meal);
                        adapter.setMeals(adapter.getCurrentMeals()); // refresh
                        Toast.makeText(
                                RandomMealActivity.this,
                                meal.getStrMeal() + " removed from favorites",
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                };

        adapter = new RandomMealAdapter(
                this,
                new ArrayList<>(), // start empty
                isGuest,
                actionListener
        );
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // 4) Wire up your presenter and repository
        MealRepository repository = new MealRepository(new RemoteDataSource());
        presenter = new RandomMealPresenter(this, repository);
        presenter.loadRandomMeal();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMeals(List<Meal> meals) {
        adapter.setMeals(meals);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, "Error: " + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}