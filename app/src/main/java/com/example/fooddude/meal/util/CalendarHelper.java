package com.example.fooddude.meal.util;

import android.content.ContentValues;
import android.content.Context;
import android.provider.CalendarContract;
import com.example.fooddude.meal.data.model.Meal;

public class CalendarHelper
{
    public static void addMealToCalendar(Context context, Meal meal, long dateMillis)
    {
        ContentValues values = new ContentValues();
        values.put(CalendarContract.Events.DTSTART, dateMillis);
        values.put(CalendarContract.Events.DTEND, dateMillis + 60 * 60 * 1000);
        // 1 hour values.put(CalendarContract.Events.TITLE, "Cook: " + meal.getStrMeal()); values.put(CalendarContract.Events.DESCRIPTION, meal.getStrInstructions()); values.put(CalendarContract.Events.CALENDAR_ID, 1); // Default calendar values.put(CalendarContract.Events.EVENT_TIMEZONE, "UTC");

    context.getContentResolver().insert(CalendarContract.Events.CONTENT_URI, values);
}

}