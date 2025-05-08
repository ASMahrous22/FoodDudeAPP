package com.example.fooddude.meal.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.fooddude.R;
import com.example.fooddude.meal.data.model.Meal;
import com.example.fooddude.meal.view.activity.MealDetailsActivity;
import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder>
{
    private final Context context;
    private List<Meal> mealList;

    private OnItemClickListener clickListener;

    public interface OnItemClickListener
    {
        void onItemClick(Meal meal);
    }

    public SearchAdapter(Context context, List<Meal> mealList, OnItemClickListener listener)
    {
        this.context = context;
        this.mealList = mealList == null ? new ArrayList<>() : mealList;
        this.clickListener = listener;
    }

    public void setMeals(List<Meal> meals)
    {
        this.mealList = meals != null ? meals : new ArrayList<>();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.item_meal, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position)
    {
        Meal meal = mealList.get(position);
        holder.bind(meal);
        holder.itemView.setOnClickListener(v ->
        {
            Intent intent = new Intent(context, MealDetailsActivity.class);
            intent.putExtra("MEAL_ID", meal.getIdMeal());
            context.startActivity(intent);
            if (clickListener != null)
            {
                clickListener.onItemClick(meal);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mealList.size();
    }

    class SearchViewHolder extends RecyclerView.ViewHolder
    {
        private final ImageView mealImage;
        private final TextView mealName;

        SearchViewHolder(@NonNull View itemView)
        {
            super(itemView);
            mealImage = itemView.findViewById(R.id.ivMeal);
            mealName = itemView.findViewById(R.id.tvMealName);
        }

        void bind(Meal meal)
        {
            mealName.setText(meal.getStrMeal());
            Glide.with(context).load(meal.getStrMealThumb()).into(mealImage);
        }
    }

}