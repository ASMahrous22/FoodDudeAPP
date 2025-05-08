package com.example.fooddude.meal.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fooddude.R;
import com.example.fooddude.meal.data.model.Country;
import com.example.fooddude.meal.presenter.CountryPresenter;
import com.example.fooddude.meal.view.adapter.CountryAdapter;
import com.example.fooddude.meal.view.contract.CountryContract;
import java.util.ArrayList;
import java.util.List;

public class CountryActivity extends AppCompatActivity implements CountryContract.View
{
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TextView emptyTextView;
    private CountryAdapter adapter;
    private CountryPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_screen);

        recyclerView = findViewById(R.id.rvCountries);
        progressBar = findViewById(R.id.progressBar);
        emptyTextView = findViewById(R.id.tvEmptyCountries);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CountryAdapter(new ArrayList<>(), country -> {
            Intent intent = new Intent(this, SearchActivity.class);
            intent.putExtra("FILTER_TYPE", "country");
            intent.putExtra("FILTER_VALUE", country.getStrArea());
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);

        presenter = new CountryPresenter(this);
        presenter.getCountries();
    }

    @Override
    public void showCountries(List<Country> countries)
    {
        runOnUiThread(() ->
        {
            progressBar.setVisibility(View.GONE);
            if (countries == null || countries.isEmpty())
            {
                emptyTextView.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
                emptyTextView.setText("No countries found.");
            }
            else
            {
                emptyTextView.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                adapter.setCountries(countries);
            }
        });
    }

    @Override
    public void showError(String message)
    {
        runOnUiThread(() ->
        {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        });
    }

}