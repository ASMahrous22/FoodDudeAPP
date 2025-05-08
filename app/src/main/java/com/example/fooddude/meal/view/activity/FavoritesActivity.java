package com.example.fooddude.meal.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fooddude.R;
import com.example.fooddude.meal.data.model.FavoriteMeal;
import com.example.fooddude.meal.data.repository.FavoriteMealRepository;
import com.example.fooddude.meal.presenter.FavoriteMealPresenter;
import com.example.fooddude.meal.view.adapter.MealAdapter;
import com.example.fooddude.meal.view.contract.FavoriteMealContract;

import java.util.ArrayList;
import java.util.List;

public class FavoritesActivity extends AppCompatActivity implements FavoriteMealContract.View
{

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TextView emptyTextView;
    private MealAdapter adapter;
    private FavoriteMealContract.Presenter presenter;
    private FavoriteMealRepository favoriteMealRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorites_screen);

        recyclerView = findViewById(R.id.rvFavorites);
        progressBar = findViewById(R.id.progressBar);
        emptyTextView = findViewById(R.id.tvEmptyFavorites);

        // Initialize the RecyclerView and the adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the repository and presenter
        favoriteMealRepository = new FavoriteMealRepository(this);
        FavoriteMealContract.Presenter presenter = new FavoriteMealPresenter(favoriteMealRepository);

        // Initialize the adapter and pass the presenter and lifecycle owner
        adapter = new MealAdapter(new ArrayList<>(), presenter, this);
        recyclerView.setAdapter(adapter);

        // Fetch all favorites from the repository
        favoriteMealRepository.getAllFavorites().observe(this, this::showFavorites);
    }

    private void observeFavorites() {
        presenter.getAllFavorites().observe(this, this::showFavorites);
    }

    @Override
    public void showFavorites(List<FavoriteMeal> meals) {
        progressBar.setVisibility(View.GONE);
        if (meals == null || meals.isEmpty()) {
            showEmptyFavoritesMessage();
        } else {
            emptyTextView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            adapter.setMeals(meals);
        }
    }

    @Override
    public void showEmptyFavoritesMessage()
    {
        emptyTextView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        emptyTextView.setText("No favorite meals found.");
    }

    @Override
    public void showFavoriteAddedMessage() {
        Toast.makeText(this, "Meal added to favorites!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFavoriteRemovedMessage() {
        Toast.makeText(this, "Meal removed from favorites!", Toast.LENGTH_SHORT).show();
    }
}
