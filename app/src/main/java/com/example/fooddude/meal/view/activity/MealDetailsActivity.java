package com.example.fooddude.meal.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;
import com.bumptech.glide.Glide;
import com.example.fooddude.R;
import com.example.fooddude.meal.data.model.Meal;
import com.example.fooddude.meal.data.model.MealResponse;
import com.example.fooddude.meal.data.remote.RemoteDataSource;
import com.example.fooddude.meal.data.repository.MealRepository;
import com.example.fooddude.meal.data.repository.FavoriteMealRepository;
import com.example.fooddude.meal.data.model.FavoriteMeal;

public class MealDetailsActivity extends AppCompatActivity {
    private TextView tvMealName, tvOrigin, tvCategory, tvInstructions, tvIngredients;
    private ImageView ivMealThumb;
    private Button btnFavorite;
    private PlayerView playerView;
    private ProgressBar progressBar;
    private ExoPlayer exoPlayer;
    private MealRepository mealRepository;
    private FavoriteMealRepository favoriteRepository;
    private Meal currentMeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_details_screen);

        tvMealName = findViewById(R.id.tvMealName);
        tvOrigin = findViewById(R.id.tvOrigin);
        tvCategory = findViewById(R.id.tvCategory);
        tvInstructions = findViewById(R.id.tvInstructions);
        tvIngredients = findViewById(R.id.tvIngredients);
        ivMealThumb = findViewById(R.id.ivMealThumb);
        btnFavorite = findViewById(R.id.btnFavorite);
        playerView = findViewById(R.id.playerView);
        progressBar = findViewById(R.id.progressBar);

        mealRepository = new MealRepository(new RemoteDataSource());
        favoriteRepository = new FavoriteMealRepository(this);

        String mealId = getIntent().getStringExtra("MEAL_ID");
        if (mealId != null) {
            loadMealDetails(mealId);
        }

        btnFavorite.setOnClickListener(v -> toggleFavorite());
    }

    private void loadMealDetails(String mealId) {
        progressBar.setVisibility(View.VISIBLE);
        mealRepository.getMealDetailsById(mealId, new RemoteDataSource.MealCallback() {
            @Override
            public void onSuccess(MealResponse mealResponse) {
                runOnUiThread(() -> {
                    progressBar.setVisibility(View.GONE);
                    if (mealResponse != null && mealResponse.getMeals() != null && !mealResponse.getMeals().isEmpty()) {
                        currentMeal = mealResponse.getMeals().get(0);
                        displayMealDetails(currentMeal);
                    } else {
                        Toast.makeText(MealDetailsActivity.this, "No meal details found", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onError(String message) {
                runOnUiThread(() -> {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(MealDetailsActivity.this, message, Toast.LENGTH_SHORT).show();
                });
            }
        });
    }

    private void displayMealDetails(Meal meal) {
        tvMealName.setText(meal.getStrMeal());
        tvOrigin.setText("Origin: " + (meal.getStrArea() != null ? meal.getStrArea() : "Unknown"));
        tvCategory.setText("Category: " + (meal.getStrCategory() != null ? meal.getStrCategory() : "Unknown"));
        tvInstructions.setText(meal.getStrInstructions());
        StringBuilder ingredients = new StringBuilder("Ingredients:\n");
        for (int i = 1; i <= 20; i++) {
            String ingredient = meal.getIngredient(i);
            String measure = meal.getMeasure(i);
            if (ingredient != null && !ingredient.isEmpty()) {
                ingredients.append("- ").append(ingredient).append(": ").append(measure != null ? measure : "").append("\n");
            }
        }
        tvIngredients.setText(ingredients.toString());
        Glide.with(this).load(meal.getStrMealThumb()).into(ivMealThumb);

        if (meal.getStrYoutube() != null && !meal.getStrYoutube().isEmpty()) {
            exoPlayer = new ExoPlayer.Builder(this).build();
            playerView.setPlayer(exoPlayer);
            exoPlayer.setMediaItem(androidx.media3.common.MediaItem.fromUri(meal.getStrYoutube()));
            exoPlayer.prepare();
        } else {
            playerView.setVisibility(View.GONE);
        }

        favoriteRepository.isFavorite(meal.getIdMeal()).observe(this, isFavorite -> {
            btnFavorite.setText(isFavorite ? "Remove from Favorites" : "Add to Favorites");
        });
    }

    private void toggleFavorite() {
        if (currentMeal == null) return;
        favoriteRepository.isFavorite(currentMeal.getIdMeal()).observe(this, isFavorite -> {
            if (isFavorite) {
                favoriteRepository.delete(new FavoriteMeal(
                        currentMeal.getIdMeal(),
                        currentMeal.getStrMeal(),
                        currentMeal.getStrMealThumb(),
                        currentMeal.getStrArea(),
                        currentMeal.getStrCategory(),
                        currentMeal.getStrInstructions(),
                        currentMeal.getStrYoutube(),
                        currentMeal.getStrIngredient1(),
                        currentMeal.getStrMeasure1()
                ));
                Toast.makeText(this, "Removed from Favorites", Toast.LENGTH_SHORT).show();
            } else {
                favoriteRepository.insert(new FavoriteMeal(
                        currentMeal.getIdMeal(),
                        currentMeal.getStrMeal(),
                        currentMeal.getStrMealThumb(),
                        currentMeal.getStrArea(),
                        currentMeal.getStrCategory(),
                        currentMeal.getStrInstructions(),
                        currentMeal.getStrYoutube(),
                        currentMeal.getStrIngredient1(),
                        currentMeal.getStrMeasure1()
                ));
                Toast.makeText(this, "Added to Favorites", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (exoPlayer != null) {
            exoPlayer.release();
        }
    }
}