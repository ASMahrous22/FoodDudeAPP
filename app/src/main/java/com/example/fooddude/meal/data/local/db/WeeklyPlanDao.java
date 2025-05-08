package com.example.fooddude.meal.data.local.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.OnConflictStrategy;

import com.example.fooddude.meal.data.model.WeeklyPlan;

import java.util.List;

@Dao
public interface WeeklyPlanDao
{
    @Query("SELECT * FROM weekly_plan WHERE dateMillis BETWEEN :start AND :end")
    List<WeeklyPlan> getPlansBetween(long start, long end);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPlan(WeeklyPlan plan);

    @Query("DELETE FROM weekly_plan WHERE dateMillis = :date")
    void deletePlansForDate(long date);
}
