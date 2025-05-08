package com.example.fooddude.meal.util;

import com.example.fooddude.meal.data.model.FavoriteMeal;
import com.example.fooddude.meal.data.model.WeeklyPlan;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap; import java.util.Map;

public class FirebaseSyncHelper
{ private static final String USERS_COLLECTION = "users";
    private static final String FAVORITES_COLLECTION = "favorites";
    private static final String PLANS_COLLECTION = "weekly_plans";
    private final FirebaseFirestore db;
    private final FirebaseAuth auth;

    public FirebaseSyncHelper()
    {
        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
    }

    public void syncFavoriteMeal(FavoriteMeal meal)
    {
        if (auth.getCurrentUser() == null || auth.getCurrentUser().isAnonymous()) return;
        Map<String, Object> data = new HashMap<>();
        data.put("idMeal", meal.getIdMeal());
        data.put("strMeal", meal.getStrMeal());
        data.put("strMealThumb", meal.getStrMealThumb());
        data.put("strArea", meal.getStrArea());
        data.put("strCategory", meal.getStrCategory());
        data.put("strInstructions", meal.getStrInstructions());
        data.put("strYoutube", meal.getStrYoutube());
        data.put("strIngredient1", meal.getStrIngredient1());
        data.put("strMeasure1", meal.getStrMeasure1());

        db.collection(USERS_COLLECTION)
                .document(auth.getCurrentUser().getUid())
                .collection(FAVORITES_COLLECTION)
                .document(meal.getIdMeal())
                .set(data);
    }

    public void deleteFavoriteMeal(String mealId) {
        if (auth.getCurrentUser() == null || auth.getCurrentUser().isAnonymous()) return;
        db.collection(USERS_COLLECTION)
                .document(auth.getCurrentUser().getUid())
                .collection(FAVORITES_COLLECTION)
                .document(mealId)
                .delete();
    }

    public void syncWeeklyPlan(WeeklyPlan plan)
    {
        if (auth.getCurrentUser() == null || auth.getCurrentUser().isAnonymous()) return;
        Map<String, Object> data = new HashMap<>();
        data.put("dateMillis", plan.getDateMillis());
        data.put("mealId", plan.getMealId());

        db.collection(USERS_COLLECTION)
                .document(auth.getCurrentUser().getUid())
                .collection(PLANS_COLLECTION)
                .document(String.valueOf(plan.getDateMillis()))
                .set(data);
    }

}