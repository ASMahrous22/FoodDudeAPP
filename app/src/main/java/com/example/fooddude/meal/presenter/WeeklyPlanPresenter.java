package com.example.fooddude.meal.presenter;

import com.example.fooddude.meal.data.model.WeeklyPlan;
import com.example.fooddude.meal.data.repository.WeeklyPlanRepository;
import com.example.fooddude.meal.view.contract.WeeklyPlanContract;

import java.util.Calendar;
import java.util.List;

public class WeeklyPlanPresenter implements WeeklyPlanContract.Presenter
{
    private final WeeklyPlanContract.View view;
    private final WeeklyPlanRepository repo;
    private final long weekStart, weekEnd;

    public WeeklyPlanPresenter(WeeklyPlanContract.View view, WeeklyPlanRepository repo)
    {
        this.view = view;
        this.repo = repo;

        Calendar cal = Calendar.getInstance();
        // set to start of current week (Sunday)
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        weekStart = cal.getTimeInMillis();
        cal.add(Calendar.DAY_OF_MONTH, 6);
        weekEnd = cal.getTimeInMillis();
    }

    @Override
    public void loadWeek()
    {
        view.showLoading();
        repo.getCurrentWeekPlans(weekStart, weekEnd, plans -> {
            view.hideLoading();
            view.showWeek(plans);
        });
    }

    @Override
    public void addMealToDate(long dateMillis, String mealId)
    {
        repo.addMealToDate(dateMillis, mealId);
        loadWeek();  // refresh
    }

    @Override
    public void onDestroy() {

    }
}