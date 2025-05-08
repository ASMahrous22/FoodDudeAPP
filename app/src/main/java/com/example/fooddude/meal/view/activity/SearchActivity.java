package com.example.fooddude.meal.view.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fooddude.R;
import com.example.fooddude.meal.data.remote.RemoteDataSource;
import com.example.fooddude.meal.data.repository.MealRepository;
import com.example.fooddude.meal.presenter.SearchPresenter;
import com.example.fooddude.meal.view.adapter.RandomMealAdapter;
import com.example.fooddude.meal.view.contract.SearchContract;
import com.example.fooddude.meal.data.model.Meal;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SearchActivity extends AppCompatActivity implements SearchContract.View {
    private EditText etSearch;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private RandomMealAdapter adapter;
    private SearchPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_screen);

        etSearch = findViewById(R.id.etSearch);
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);

        // adapter: guest = true so Add button disabled, Remove hidden
        adapter = new RandomMealAdapter(
                this,
                new ArrayList<>(),
                true, // treat search screen as guest (no fav actions)
                null
        );
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // repository only needs remote for search
        MealRepository repo = new MealRepository(new RemoteDataSource());
        presenter = new SearchPresenter(this, repo);

        // listen for IME search key
        etSearch.setOnEditorActionListener((TextView v, int actionId, KeyEvent event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                doSearch();
                return true;
            }
            return false;
        });
    }

    private void doSearch() {
        String query = etSearch.getText().toString().trim();
        if (query.isEmpty()) {
            Toast.makeText(this, "Enter a search term", Toast.LENGTH_SHORT).show();
            return;
        }
        presenter.searchMeals(query);
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
    public void showSearchResults(List<Meal> meals) {
        adapter.setMeals(meals);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, "Error: " + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}