package com.example.fooddude.auth.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager
{
    private static final String PREF_NAME = "FoodDudePrefs";
    private static final String KEY_USER_ID = "user_id";
    private final SharedPreferences prefs;

    public SessionManager(Context context)
    {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveUserId(String userId)
    {
        prefs.edit().putString(KEY_USER_ID, userId).apply();
    }

    public String getUserId()
    {
        return prefs.getString(KEY_USER_ID, null);
    }

    public void clearSession()
    {
        prefs.edit().remove(KEY_USER_ID).apply();
    }

}