package com.example.fooddude.randommeal.view.adapter;

import android.content.Context;
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
import com.example.fooddude.randommeal.data.model.Meal;

import java.util.List;

public class RandomMealAdapter extends RecyclerView.Adapter<RandomMealAdapter.MealViewHolder>
{
    private final Context context;
    private final List<Meal> mealList;
    private final boolean isGuest;

    public void setMeals(List<Meal> meals)
    {
        this.mealList.clear();
        this.mealList.addAll(meals);
        notifyDataSetChanged();
    }

    // Optional click listeners
    public interface OnMealActionListener
    {
        void onRemoveFromFavorites(Meal meal);
        void onAddToFavorites(Meal meal);
    }

    private final OnMealActionListener actionListener;

    public RandomMealAdapter(Context context, List<Meal> mealList, boolean isGuest, OnMealActionListener actionListener)
    {
        this.context = context;
        this.mealList = mealList;
        this.isGuest = isGuest;
        this.actionListener = actionListener;
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
        Meal meal = mealList.get(position);

        holder.tvMealName.setText(meal.getStrMeal());

        Glide.with(context)
                .load(meal.getStrMealThumb())
                .placeholder(R.drawable.ic_food_dude_logo)
                .into(holder.ivMeal);

        // Button visibility logic
        if (isGuest)
        {
            holder.btnAddToFavorite.setVisibility(View.VISIBLE);
            holder.btnAddToFavorite.setEnabled(false);
            holder.btnRemoveFromFavorite.setVisibility(View.GONE);
        }
        else
        {
            holder.btnAddToFavorite.setVisibility(View.GONE);
            holder.btnRemoveFromFavorite.setVisibility(View.VISIBLE);
        }

        // Button click listeners
        holder.btnAddToFavorite.setOnClickListener(v ->
        {
            if (actionListener != null)
            {
                actionListener.onAddToFavorites(meal);
            }
        });

        holder.btnRemoveFromFavorite.setOnClickListener(v ->
        {
            if (actionListener != null)
            {
                actionListener.onRemoveFromFavorites(meal);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mealList.size();
    }

    static class MealViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivMeal;
        TextView tvMealName;
        Button btnAddToFavorite, btnRemoveFromFavorite;

        public MealViewHolder(@NonNull View itemView)
        {
            super(itemView);
            ivMeal = itemView.findViewById(R.id.ivMeal);
            tvMealName = itemView.findViewById(R.id.tvMealName);
            btnAddToFavorite = itemView.findViewById(R.id.btnAddToFavorite);
            btnRemoveFromFavorite = itemView.findViewById(R.id.btnRemoveFromFavorite);
        }
    }
}
