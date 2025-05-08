package com.example.fooddude.meal.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fooddude.R;
import com.example.fooddude.meal.data.local.PlanLocalDataSource;
import com.example.fooddude.meal.data.model.WeeklyPlan;
import com.example.fooddude.meal.data.model.Meal;
import com.example.fooddude.meal.data.model.MealResponse;
import com.example.fooddude.meal.data.remote.RemoteDataSource;
import com.example.fooddude.meal.data.repository.MealRepository;
import com.example.fooddude.meal.data.repository.WeeklyPlanRepository;
import com.example.fooddude.meal.presenter.WeeklyPlanPresenter;
import com.example.fooddude.meal.util.CalendarHelper;
import com.example.fooddude.meal.view.adapter.DailyPlanAdapter;
import com.example.fooddude.meal.view.contract.WeeklyPlanContract;
import java.util.List;
import androidx.annotation.Nullable;

public class WeeklyPlanActivity extends AppCompatActivity implements WeeklyPlanContract.View {
    private RecyclerView rvWeek;
    private TextView emptyTextView;
    private WeeklyPlanPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weekly_plan_screen);

        rvWeek = findViewById(R.id.rvWeek);
        emptyTextView = findViewById(R.id.tvEmptyPlan);
        rvWeek.setLayoutManager(new LinearLayoutManager(this));

        WeeklyPlanRepository repo = new WeeklyPlanRepository(new PlanLocalDataSource(this));
        presenter = new WeeklyPlanPresenter(this, repo);
        presenter.loadWeek();
    }

    @Override
    public void showLoading() {}

    @Override
    public void hideLoading() {}

    @Override
    public void showWeek(List<WeeklyPlan> plans) {
        runOnUiThread(() -> {
            if (plans.isEmpty()) {
                emptyTextView.setText("No meals planned for this week.");
                emptyTextView.setVisibility(View.VISIBLE);
                rvWeek.setVisibility(View.GONE);
            } else {
                DailyPlanAdapter adapter = new DailyPlanAdapter(plans, dateMillis -> {
                    Intent intent = new Intent(this, SearchActivity.class);
                    intent.putExtra("DATE_MILLIS", dateMillis);
                    startActivityForResult(intent, 100);
                });
                rvWeek.setAdapter(adapter);
                emptyTextView.setVisibility(View.GONE);
                rvWeek.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            String mealId = data.getStringExtra("SELECTED_MEAL_ID");
            long dateMillis = data.getLongExtra("DATE_MILLIS", 0);
            if (mealId != null && dateMillis != 0) {
                presenter.addMealToDate(dateMillis, mealId);
                new MealRepository(new RemoteDataSource()).getMealDetailsById(mealId, new RemoteDataSource.MealCallback() {
                    @Override
                    public void onSuccess(MealResponse mealResponse) {
                        if (mealResponse != null && mealResponse.getMeals() != null && !mealResponse.getMeals().isEmpty()) {
                            CalendarHelper.addMealToCalendar(WeeklyPlanActivity.this, mealResponse.getMeals().get(0), dateMillis);
                        }
                    }

                    @Override
                    public void onError(String message) {
                        Toast.makeText(WeeklyPlanActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }
}