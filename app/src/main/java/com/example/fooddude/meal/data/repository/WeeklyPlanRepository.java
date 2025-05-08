package com.example.fooddude.meal.data.repository;

import com.example.fooddude.meal.data.local.PlanLocalDataSource;
import com.example.fooddude.meal.data.model.WeeklyPlan;
import com.example.fooddude.meal.util.FirebaseSyncHelper;
import java.util.List;

public class WeeklyPlanRepository
{
    private final PlanLocalDataSource local;
    private final FirebaseSyncHelper firebaseSyncHelper;

    public WeeklyPlanRepository(PlanLocalDataSource local)
    {
        this.local = local;
        this.firebaseSyncHelper = new FirebaseSyncHelper();
    }

    public void getCurrentWeekPlans(long weekStart, long weekEnd, Callback cb)
    {
        local.getPlansForWeek(weekStart, weekEnd, plans -> cb.onSuccess(plans));
    }

    public void addMealToDate(long dateMillis, String mealId)
    {
        WeeklyPlan plan = new WeeklyPlan(dateMillis, mealId);
        local.addPlan(plan);
        firebaseSyncHelper.syncWeeklyPlan(plan);
    }

    public interface Callback
    {
        void onSuccess(List<WeeklyPlan> plans);
    }

}