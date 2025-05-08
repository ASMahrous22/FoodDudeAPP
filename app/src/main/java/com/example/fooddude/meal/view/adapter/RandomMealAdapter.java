package com.example.fooddude.meal.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.fooddude.R;
import com.example.fooddude.meal.data.model.Meal;
import com.example.fooddude.meal.view.activity.MealDetailsActivity;
import com.example.fooddude.auth.view.SignInActivity;
import java.util.List;

public class RandomMealAdapter extends RecyclerView.Adapter<RandomMealAdapter.MealViewHolder>
{
    private final Context context;
    private List<Meal> meals;
    private final boolean isGuest;
    private final OnMealActionListener listener;
    public interface OnMealActionListener
    {
        void onRemoveFromFavorites(Meal meal);
        void onAddToFavorites(Meal meal);
    }

    public RandomMealAdapter(Context context, List<Meal> meals, boolean isGuest, OnMealActionListener listener)
    {
        this.context = context;
        this.meals = meals;
        this.isGuest = isGuest;
        this.listener = listener;
    }

    public void setMeals(List<Meal> meals)
    {
        this.meals = meals;
        notifyDataSetChanged();
    }
    public List<Meal> getCurrentMeals()
    {
        return meals;
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.item_meal, parent, false);
        return new MealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position)
    {
        Meal meal = meals.get(position);
        holder.bind(meal);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, MealDetailsActivity.class);
            intent.putExtra("MEAL_ID", meal.getIdMeal());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount()
    {
        return meals != null ? meals.size() : 0;
    }

    class MealViewHolder extends RecyclerView.ViewHolder
    {
        private final ImageView ivMeal;
        private final TextView tvMealName;
        private final Button btnAddToFavorite;
        private final Button btnRemoveFromFavorite;

        MealViewHolder(@NonNull View itemView)
        {
            super(itemView);
            ivMeal = itemView.findViewById(R.id.ivMeal);
            tvMealName = itemView.findViewById(R.id.tvMealName);
            btnAddToFavorite = itemView.findViewById(R.id.btnAddToFavorite);
            btnRemoveFromFavorite = itemView.findViewById(R.id.btnRemoveFromFavorite);
        }

        void bind(Meal meal)
        {
            tvMealName.setText(meal.getStrMeal());
            Glide.with(context).load(meal.getStrMealThumb()).into(ivMeal);

            if (isGuest)
            {
                btnAddToFavorite.setVisibility(View.VISIBLE);
                btnAddToFavorite.setEnabled(true);
                btnAddToFavorite.setOnClickListener(v -> {
                    context.startActivity(new Intent(context, SignInActivity.class));
                });
                btnRemoveFromFavorite.setVisibility(View.GONE);
            }
            else
            {
                btnAddToFavorite.setVisibility(View.VISIBLE);
                btnRemoveFromFavorite.setVisibility(View.VISIBLE);
                btnRemoveFromFavorite.setOnClickListener(v -> listener.onRemoveFromFavorites(meal));
                btnAddToFavorite.setOnClickListener(v -> listener.onAddToFavorites(meal));
            }
        }
    }
}