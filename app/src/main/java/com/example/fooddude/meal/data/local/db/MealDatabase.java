package com.example.fooddude.meal.data.local.db;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import android.content.Context;
import com.example.fooddude.meal.data.model.Meal;
import com.example.fooddude.meal.data.model.Category;
import com.example.fooddude.meal.data.model.FavoriteMeal;
import com.example.fooddude.meal.data.model.WeeklyPlan; // ✅ Add this import
import com.example.fooddude.meal.data.local.db.WeeklyPlanDao; // ✅ Add this import

/**
 * Room database for storing Meal, Category, and FavoriteMeal entities.
 */
@Database(entities = {Meal.class, Category.class, FavoriteMeal.class, WeeklyPlan.class}, version = 2, exportSchema = false) // ✅ Add WeeklyPlan.class
public abstract class MealDatabase extends RoomDatabase {
    private static volatile MealDatabase INSTANCE;

    /**
     * Provides access to Meal DAO for meal-related database operations.
     * @return MealDao instance.
     */
    public abstract MealDao mealDao();

    /**
     * Provides access to Category DAO for category-related database operations.
     * @return CategoryDao instance.
     */
    public abstract CategoryDao categoryDao();

    /**
     * Provides access to FavoriteMeal DAO for favorite meal-related database operations.
     * @return FavoriteMealDao instance.
     */
    public abstract FavoriteMealDao favoriteMealDao();

    /**
     * Provides access to WeeklyPlan DAO for weekly plan-related database operations.
     * @return WeeklyPlanDao instance.
     */
    public abstract WeeklyPlanDao weeklyPlanDao(); // ✅ Add this method

    /**
     * Migration from version 1 to 2: Adds the favorite_meals table.
     */
    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `favorite_meals` (" +
                    "`idMeal` TEXT NOT NULL, " +
                    "PRIMARY KEY(`idMeal`))");
        }
    };

    /**
     * Gets the singleton instance of the MealDatabase.
     * @param context Application context.
     * @return MealDatabase instance.
     */
    public static MealDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (MealDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MealDatabase.class, "meal_database")
                            .addMigrations(MIGRATION_1_2)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
