package com.example.fooddude.meal.data.local;

import android.content.Context;
import androidx.room.Room;
import com.example.fooddude.meal.data.local.db.MealDatabase;
import com.example.fooddude.meal.data.local.db.WeeklyPlanDao;
import com.example.fooddude.meal.data.model.WeeklyPlan;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;

public class PlanLocalDataSource
{
    private final WeeklyPlanDao planDao;

    public PlanLocalDataSource(Context context)
    {
        MealDatabase db = Room.databaseBuilder(
                        context.getApplicationContext(),
                        MealDatabase.class, "meals_db"
                )
                .fallbackToDestructiveMigration()
                .build();

        planDao = db.weeklyPlanDao();
    }

    public void getPlansForWeek(long weekStart, long weekEnd, DataCallback callback)
    {
        Executors.newSingleThreadExecutor().execute(() -> {
            List<WeeklyPlan> plans = planDao.getPlansBetween(weekStart, weekEnd);
            callback.onResult(plans);
        });
    }

    public void addPlan(final WeeklyPlan plan)
    {
        Executors.newSingleThreadExecutor().execute(() -> {
            planDao.insertPlan(plan);
        });
    }

    public interface DataCallback
    {
        void onResult(List<WeeklyPlan> plans);
    }
}