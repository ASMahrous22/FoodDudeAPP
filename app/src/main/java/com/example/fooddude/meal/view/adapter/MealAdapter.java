package com.example.fooddude.meal.view.adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fooddude.R;
import com.example.fooddude.meal.data.model.FavoriteMeal;
import com.example.fooddude.meal.view.activity.MealDetailsActivity;
import com.example.fooddude.meal.view.contract.FavoriteMealContract;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealViewHolder>
{
    private final List<FavoriteMeal> mealList;
    private final FavoriteMealContract.Presenter presenter;
    private final LifecycleOwner lifecycleOwner;

    public MealAdapter(List<FavoriteMeal> mealList, FavoriteMealContract.Presenter presenter, LifecycleOwner lifecycleOwner)
    {
        this.mealList = mealList;
        this.presenter = presenter;
        this.lifecycleOwner = lifecycleOwner;
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fav_meal, parent, false);
        return new MealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position)
    {
        FavoriteMeal meal = mealList.get(position);
        holder.bind(meal);
        holder.itemView.setOnClickListener(v ->
        {
            Intent intent = new Intent(holder.itemView.getContext(), MealDetailsActivity.class);
            intent.putExtra("MEAL_ID", meal.getIdMeal());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    public void setMeals(List<FavoriteMeal> meals)
    {
        mealList.clear();
        mealList.addAll(meals);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount()
    {
        return mealList.size();
    }

    class MealViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView mealName;
        private final ImageView mealImage;
        private final ImageView favoriteIcon;

        public MealViewHolder(@NonNull View itemView)
        {
            super(itemView);
            mealName = itemView.findViewById(R.id.tvMealName);
            mealImage = itemView.findViewById(R.id.ivMealImage);
            favoriteIcon = itemView.findViewById(R.id.ivFavorite);
        }

        public void bind(FavoriteMeal meal)
        {
            mealName.setText(meal.getStrMeal());
            Glide.with(itemView.getContext())
                    .load(meal.getStrMealThumb())
                    .into(mealImage);

            presenter.isFavorite(meal.getIdMeal()).observe(lifecycleOwner, isFav -> {
                if (isFav != null && isFav)
                {
                    favoriteIcon.setImageResource(R.drawable.ic_favorite_filled);
                } else {
                    favoriteIcon.setImageResource(R.drawable.ic_favorite_border);
                }
            });

            favoriteIcon.setOnClickListener(v ->
            {
                presenter.isFavorite(meal.getIdMeal()).observe(lifecycleOwner, isFav ->
                {
                    if (isFav != null && isFav)
                    {
                        presenter.delete(meal);
                    } else {
                        presenter.insert(meal);
                    }
                });
            });
        }
    }
}