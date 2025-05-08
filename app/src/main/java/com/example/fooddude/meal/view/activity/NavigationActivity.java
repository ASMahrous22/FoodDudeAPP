package com.example.fooddude.meal.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import androidx.appcompat.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.fooddude.R;
import com.example.fooddude.meal.view.activity.FavoritesActivity;
import com.example.fooddude.meal.view.activity.RandomMealActivity;
import com.example.fooddude.meal.view.activity.SearchActivity;
import com.example.fooddude.meal.view.activity.WeeklyPlanActivity;
import com.example.fooddude.meal.view.activity.ProfileActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationActivity extends AppCompatActivity
{
    private Button btnFavorites, btnWeeklyPlan, btnRandomMeal;
    private SearchView searchView;
    private RecyclerView rvMeals, rvCategories;
    private ViewPager2 viewPagerMealOfDay;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        initViews();
        setupTopButtons();
        setupBottomNavigation();
    }

    private void initViews() {
        searchView = findViewById(R.id.search_view);

        btnFavorites = findViewById(R.id.btn_favorites);
        btnWeeklyPlan = findViewById(R.id.btn_weekly_plan);
        btnRandomMeal = findViewById(R.id.btn_random_meal);

        rvMeals = findViewById(R.id.rv_meals);
        rvCategories = findViewById(R.id.rv_categories);
        viewPagerMealOfDay = findViewById(R.id.viewpager_meal_of_day);

        bottomNavigationView = findViewById(R.id.bottom_nav);
    }

    private void setupTopButtons() {
        btnFavorites.setOnClickListener(v ->
                startActivity(new Intent(this, FavoritesActivity.class)));

        btnWeeklyPlan.setOnClickListener(v ->
                startActivity(new Intent(this, WeeklyPlanActivity.class)));

        btnRandomMeal.setOnClickListener(v ->
                startActivity(new Intent(this, RandomMealActivity.class)));
    }

    private void setupBottomNavigation() {
        bottomNavigationView.setSelectedItemId(R.id.navigation_home); // highlight current

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id == R.id.navigation_home)
                {
                    //    startActivity(new Intent(NavigationActivity.this, HomeActivity.class));
                } else if (id == R.id.navigation_search) {
                    startActivity(new Intent(NavigationActivity.this, SearchActivity.class));
                } else if (id == R.id.navigation_favorites) {
                    startActivity(new Intent(NavigationActivity.this, FavoritesActivity.class));
                } else if (id == R.id.navigation_calendar) {
                    startActivity(new Intent(NavigationActivity.this, WeeklyPlanActivity.class));
                } else if (id == R.id.navigation_profile) {
                    startActivity(new Intent(NavigationActivity.this, ProfileActivity.class));
                }

                finish(); // to avoid backstack growing
                return true;
            }
        });
    }
}