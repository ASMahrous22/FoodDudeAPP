package com.example.fooddude.meal.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddude.R;
import com.example.fooddude.meal.data.model.WeeklyPlan;
import com.example.fooddude.meal.data.model.Meal;
import com.example.fooddude.meal.data.remote.RemoteDataSource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DailyPlanAdapter extends RecyclerView.Adapter<DailyPlanAdapter.DayViewHolder> {

    public interface OnAddClick {
        void onAdd(long dateMillis);
    }

    private final List<WeeklyPlan> plans;
    private final OnAddClick addClick;
    private final RemoteDataSource remote;

    public DailyPlanAdapter(List<WeeklyPlan> plans, OnAddClick addClick) {
        this.plans = plans;
        this.addClick = addClick;
        this.remote = new RemoteDataSource();
    }

    @NonNull
    @Override
    public DayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_day_plan, parent, false);
        return new DayViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DayViewHolder holder, int pos) {
        WeeklyPlan plan = plans.get(pos);

        Date date = new Date(plan.getDateMillis());
        holder.tvDate.setText(new SimpleDateFormat("EEE, d MMM", Locale.getDefault())
                .format(date));

        // Load meal details
        remote.getMealDetailsById(plan.getMealId(), new RemoteDataSource.MealDetailCallback() {
            @Override
            public void onSuccess(Meal meal) {
                if (meal != null && holder.tvMealName != null) {
                    holder.tvMealName.setText(meal.getStrMeal());
                }
            }

            @Override
            public void onError(String e) {
                if (holder.tvMealName != null) {
                    holder.tvMealName.setText("Error loading");
                }
            }
        });

        holder.btnAddMeal.setOnClickListener(v -> addClick.onAdd(plan.getDateMillis()));
    }

    @Override
    public int getItemCount() {
        return plans.size();
    }

    static class DayViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate;
        TextView tvMealName;
        Button btnAddMeal;

        DayViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvMealName = itemView.findViewById(R.id.tvMealName);
            btnAddMeal = itemView.findViewById(R.id.btnAddMeal);
        }
    }
}