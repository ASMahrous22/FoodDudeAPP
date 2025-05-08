package com.example.fooddude.meal.data.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Room entity representing a meal with details such as name, category, ingredients, and measures.
 */
@Entity(tableName = "meals")
public class Meal {
    @PrimaryKey
    @NonNull
    private String idMeal = "";
    private String strMeal;
    private String strMealThumb;
    private String strCategory;
    private String strArea;
    private String strInstructions;
    private String strYoutube;
    private String strIngredient1;
    private String strIngredient2;
    private String strIngredient3;
    private String strIngredient4;
    private String strIngredient5;
    private String strIngredient6;
    private String strIngredient7;
    private String strIngredient8;
    private String strIngredient9;
    private String strIngredient10;
    private String strIngredient11;
    private String strIngredient12;
    private String strIngredient13;
    private String strIngredient14;
    private String strIngredient15;
    private String strIngredient16;
    private String strIngredient17;
    private String strIngredient18;
    private String strIngredient19;
    private String strIngredient20;
    private String strMeasure1;
    private String strMeasure2;
    private String strMeasure3;
    private String strMeasure4;
    private String strMeasure5;
    private String strMeasure6;
    private String strMeasure7;
    private String strMeasure8;
    private String strMeasure9;
    private String strMeasure10;
    private String strMeasure11;
    private String strMeasure12;
    private String strMeasure13;
    private String strMeasure14;
    private String strMeasure15;
    private String strMeasure16;
    private String strMeasure17;
    private String strMeasure18;
    private String strMeasure19;
    private String strMeasure20;

    // Getters

    /**
     * Gets the unique ID of the meal.
     * @return Non-null meal ID.
     */
    @NonNull
    public String getIdMeal() {
        return idMeal;
    }

    /**
     * Gets the name of the meal.
     * @return Non-null meal name, empty string if null.
     */
    @NonNull
    public String getStrMeal() {
        return strMeal != null ? strMeal : "";
    }

    /**
     * Gets the URL of the meal's thumbnail image.
     * @return Thumbnail URL, or null if not available.
     */
    @Nullable
    public String getStrMealThumb() {
        return strMealThumb;
    }

    /**
     * Gets the category of the meal.
     * @return Category, or null if not available.
     */
    @Nullable
    public String getStrCategory() {
        return strCategory;
    }

    /**
     * Gets the geographical area of the meal.
     * @return Area, or null if not available.
     */
    @Nullable
    public String getStrArea() {
        return strArea;
    }

    /**
     * Gets the cooking instructions for the meal.
     * @return Instructions, or null if not available.
     */
    @Nullable
    public String getStrInstructions() {
        return strInstructions;
    }

    /**
     * Gets the YouTube video URL for the meal.
     * @return YouTube URL, or null if not available.
     */
    @Nullable
    public String getStrYoutube() {
        return strYoutube;
    }

    /**
     * Gets the first ingredient of the meal.
     * @return First ingredient, or null if not available.
     */
    @Nullable
    public String getStrIngredient1() {
        return strIngredient1;
    }

    /**
     * Gets the second ingredient of the meal.
     * @return Second ingredient, or null if not available.
     */
    @Nullable
    public String getStrIngredient2() {
        return strIngredient2;
    }

    /**
     * Gets the third ingredient of the meal.
     * @return Third ingredient, or null if not available.
     */
    @Nullable
    public String getStrIngredient3() {
        return strIngredient3;
    }

    /**
     * Gets the fourth ingredient of the meal.
     * @return Fourth ingredient, or null if not available.
     */
    @Nullable
    public String getStrIngredient4() {
        return strIngredient4;
    }

    /**
     * Gets the fifth ingredient of the meal.
     * @return Fifth ingredient, or null if not available.
     */
    @Nullable
    public String getStrIngredient5() {
        return strIngredient5;
    }

    /**
     * Gets the sixth ingredient of the meal.
     * @return Sixth ingredient, or null if not available.
     */
    @Nullable
    public String getStrIngredient6() {
        return strIngredient6;
    }

    /**
     * Gets the seventh ingredient of the meal.
     * @return Seventh ingredient, or null if not available.
     */
    @Nullable
    public String getStrIngredient7() {
        return strIngredient7;
    }

    /**
     * Gets the eighth ingredient of the meal.
     * @return Eighth ingredient, or null if not available.
     */
    @Nullable
    public String getStrIngredient8() {
        return strIngredient8;
    }

    /**
     * Gets the ninth ingredient of the meal.
     * @return Ninth ingredient, or null if not available.
     */
    @Nullable
    public String getStrIngredient9() {
        return strIngredient9;
    }

    /**
     * Gets the tenth ingredient of the meal.
     * @return Tenth ingredient, or null if not available.
     */
    @Nullable
    public String getStrIngredient10() {
        return strIngredient10;
    }

    /**
     * Gets the eleventh ingredient of the meal.
     * @return Eleventh ingredient, or null if not available.
     */
    @Nullable
    public String getStrIngredient11() {
        return strIngredient11;
    }

    /**
     * Gets the twelfth ingredient of the meal.
     * @return Twelfth ingredient, or null if not available.
     */
    @Nullable
    public String getStrIngredient12() {
        return strIngredient12;
    }

    /**
     * Gets the thirteenth ingredient of the meal.
     * @return Thirteenth ingredient, or null if not available.
     */
    @Nullable
    public String getStrIngredient13() {
        return strIngredient13;
    }

    /**
     * Gets the fourteenth ingredient of the meal.
     * @return Fourteenth ingredient, or null if not available.
     */
    @Nullable
    public String getStrIngredient14() {
        return strIngredient14;
    }

    /**
     * Gets the fifteenth ingredient of the meal.
     * @return Fifteenth ingredient, or null if not available.
     */
    @Nullable
    public String getStrIngredient15() {
        return strIngredient15;
    }

    /**
     * Gets the sixteenth ingredient of the meal.
     * @return Sixteenth ingredient, or null if not available.
     */
    @Nullable
    public String getStrIngredient16() {
        return strIngredient16;
    }

    /**
     * Gets the seventeenth ingredient of the meal.
     * @return Seventeenth ingredient, or null if not available.
     */
    @Nullable
    public String getStrIngredient17() {
        return strIngredient17;
    }

    /**
     * Gets the eighteenth ingredient of the meal.
     * @return Eighteenth ingredient, or null if not available.
     */
    @Nullable
    public String getStrIngredient18() {
        return strIngredient18;
    }

    /**
     * Gets the nineteenth ingredient of the meal.
     * @return Nineteenth ingredient, or null if not available.
     */
    @Nullable
    public String getStrIngredient19() {
        return strIngredient19;
    }

    /**
     * Gets the twentieth ingredient of the meal.
     * @return Twentieth ingredient, or null if not available.
     */
    @Nullable
    public String getStrIngredient20() {
        return strIngredient20;
    }

    /**
     * Gets the measure for the first ingredient.
     * @return First measure, or null if not available.
     */
    @Nullable
    public String getStrMeasure1() {
        return strMeasure1;
    }

    /**
     * Gets the measure for the second ingredient.
     * @return Second measure, or null if not available.
     */
    @Nullable
    public String getStrMeasure2() {
        return strMeasure2;
    }

    /**
     * Gets the measure for the third ingredient.
     * @return Third measure, or null if not available.
     */
    @Nullable
    public String getStrMeasure3() {
        return strMeasure3;
    }

    /**
     * Gets the measure for the fourth ingredient.
     * @return Fourth measure, or null if not available.
     */
    @Nullable
    public String getStrMeasure4() {
        return strMeasure4;
    }

    /**
     * Gets the measure for the fifth ingredient.
     * @return Fifth measure, or null if not available.
     */
    @Nullable
    public String getStrMeasure5() {
        return strMeasure5;
    }

    /**
     * Gets the measure for the sixth ingredient.
     * @return Sixth measure, or null if not available.
     */
    @Nullable
    public String getStrMeasure6() {
        return strMeasure6;
    }

    /**
     * Gets the measure for the seventh ingredient.
     * @return Seventh measure, or null if not available.
     */
    @Nullable
    public String getStrMeasure7() {
        return strMeasure7;
    }

    /**
     * Gets the measure for the eighth ingredient.
     * @return Eighth measure, or null if not available.
     */
    @Nullable
    public String getStrMeasure8() {
        return strMeasure8;
    }

    /**
     * Gets the measure for the ninth ingredient.
     * @return Ninth measure, or null if not available.
     */
    @Nullable
    public String getStrMeasure9() {
        return strMeasure9;
    }

    /**
     * Gets the measure for the tenth ingredient.
     * @return Tenth measure, or null if not available.
     */
    @Nullable
    public String getStrMeasure10() {
        return strMeasure10;
    }

    /**
     * Gets the measure for the eleventh ingredient.
     * @return Eleventh measure, or null if not available.
     */
    @Nullable
    public String getStrMeasure11() {
        return strMeasure11;
    }

    /**
     * Gets the measure for the twelfth ingredient.
     * @return Twelfth measure, or null if not available.
     */
    @Nullable
    public String getStrMeasure12() {
        return strMeasure12;
    }

    /**
     * Gets the measure for the thirteenth ingredient.
     * @return Thirteenth measure, or null if not available.
     */
    @Nullable
    public String getStrMeasure13() {
        return strMeasure13;
    }

    /**
     * Gets the measure for the fourteenth ingredient.
     * @return Fourteenth measure, or null if not available.
     */
    @Nullable
    public String getStrMeasure14() {
        return strMeasure14;
    }

    /**
     * Gets the measure for the fifteenth ingredient.
     * @return Fifteenth measure, or null if not available.
     */
    @Nullable
    public String getStrMeasure15() {
        return strMeasure15;
    }

    /**
     * Gets the measure for the sixteenth ingredient.
     * @return Sixteenth measure, or null if not available.
     */
    @Nullable
    public String getStrMeasure16() {
        return strMeasure16;
    }

    /**
     * Gets the measure for the seventeenth ingredient.
     * @return Seventeenth measure, or null if not available.
     */
    @Nullable
    public String getStrMeasure17() {
        return strMeasure17;
    }

    /**
     * Gets the measure for the eighteenth ingredient.
     * @return Eighteenth measure, or null if not available.
     */
    @Nullable
    public String getStrMeasure18() {
        return strMeasure18;
    }

    /**
     * Gets the measure for the nineteenth ingredient.
     * @return Nineteenth measure, or null if not available.
     */
    @Nullable
    public String getStrMeasure19() {
        return strMeasure19;
    }

    /**
     * Gets the measure for the twentieth ingredient.
     * @return Twentieth measure, or null if not available.
     */
    @Nullable
    public String getStrMeasure20() {
        return strMeasure20;
    }

    /**
     * Gets the ingredient at the specified index (1 to 20).
     * @param index Ingredient index (1 to 20).
     * @return Ingredient string, or null if not available or index is invalid.
     */
    @Nullable
    public String getIngredient(int index) {
        switch (index) {
            case 1: return strIngredient1;
            case 2: return strIngredient2;
            case 3: return strIngredient3;
            case 4: return strIngredient4;
            case 5: return strIngredient5;
            case 6: return strIngredient6;
            case 7: return strIngredient7;
            case 8: return strIngredient8;
            case 9: return strIngredient9;
            case 10: return strIngredient10;
            case 11: return strIngredient11;
            case 12: return strIngredient12;
            case 13: return strIngredient13;
            case 14: return strIngredient14;
            case 15: return strIngredient15;
            case 16: return strIngredient16;
            case 17: return strIngredient17;
            case 18: return strIngredient18;
            case 19: return strIngredient19;
            case 20: return strIngredient20;
            default: return null;
        }
    }

    /**
     * Gets the measure at the specified index (1 to 20).
     * @param index Measure index (1 to 20).
     * @return Measure string, or null if not available or index is invalid.
     */
    @Nullable
    public String getMeasure(int index) {
        switch (index) {
            case 1: return strMeasure1;
            case 2: return strMeasure2;
            case 3: return strMeasure3;
            case 4: return strMeasure4;
            case 5: return strMeasure5;
            case 6: return strMeasure6;
            case 7: return strMeasure7;
            case 8: return strMeasure8;
            case 9: return strMeasure9;
            case 10: return strMeasure10;
            case 11: return strMeasure11;
            case 12: return strMeasure12;
            case 13: return strMeasure13;
            case 14: return strMeasure14;
            case 15: return strMeasure15;
            case 16: return strMeasure16;
            case 17: return strMeasure17;
            case 18: return strMeasure18;
            case 19: return strMeasure19;
            case 20: return strMeasure20;
            default: return null;
        }
    }

    // Setters

    /**
     * Sets the unique ID of the meal.
     * @param idMeal Non-null meal ID.
     */
    public void setIdMeal(@NonNull String idMeal) {
        this.idMeal = idMeal;
    }

    /**
     * Sets the name of the meal.
     * @param strMeal Meal name.
     */
    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    /**
     * Sets the URL of the meal's thumbnail image.
     * @param strMealThumb Thumbnail URL.
     */
    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    /**
     * Sets the category of the meal.
     * @param strCategory Category.
     */
    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    /**
     * Sets the geographical area of the meal.
     * @param strArea Area.
     */
    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }

    /**
     * Sets the cooking instructions for the meal.
     * @param strInstructions Instructions.
     */
    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    /**
     * Sets the YouTube video URL for the meal.
     * @param strYoutube YouTube URL.
     */
    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    /**
     * Sets the first ingredient of the meal.
     * @param strIngredient1 First ingredient.
     */
    public void setStrIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    /**
     * Sets the second ingredient of the meal.
     * @param strIngredient2 Second ingredient.
     */
    public void setStrIngredient2(String strIngredient2) {
        this.strIngredient2 = strIngredient2;
    }

    /**
     * Sets the third ingredient of the meal.
     * @param strIngredient3 Third ingredient.
     */
    public void setStrIngredient3(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }

    /**
     * Sets the fourth ingredient of the meal.
     * @param strIngredient4 Fourth ingredient.
     */
    public void setStrIngredient4(String strIngredient4) {
        this.strIngredient4 = strIngredient4;
    }

    /**
     * Sets the fifth ingredient of the meal.
     * @param strIngredient5 Fifth ingredient.
     */
    public void setStrIngredient5(String strIngredient5) {
        this.strIngredient5 = strIngredient5;
    }

    /**
     * Sets the sixth ingredient of the meal.
     * @param strIngredient6 Sixth ingredient.
     */
    public void setStrIngredient6(String strIngredient6) {
        this.strIngredient6 = strIngredient6;
    }

    /**
     * Sets the seventh ingredient of the meal.
     * @param strIngredient7 Seventh ingredient.
     */
    public void setStrIngredient7(String strIngredient7) {
        this.strIngredient7 = strIngredient7;
    }

    /**
     * Sets the eighth ingredient of the meal.
     * @param strIngredient8 Eighth ingredient.
     */
    public void setStrIngredient8(String strIngredient8) {
        this.strIngredient8 = strIngredient8;
    }

    /**
     * Sets the ninth ingredient of the meal.
     * @param strIngredient9 Ninth ingredient.
     */
    public void setStrIngredient9(String strIngredient9) {
        this.strIngredient9 = strIngredient9;
    }

    /**
     * Sets the tenth ingredient of the meal.
     * @param strIngredient10 Tenth ingredient.
     */
    public void setStrIngredient10(String strIngredient10) {
        this.strIngredient10 = strIngredient10;
    }

    /**
     * Sets the eleventh ingredient of the meal.
     * @param strIngredient11 Eleventh ingredient.
     */
    public void setStrIngredient11(String strIngredient11) {
        this.strIngredient11 = strIngredient11;
    }

    /**
     * Sets the twelfth ingredient of the meal.
     * @param strIngredient12 Twelfth ingredient.
     */
    public void setStrIngredient12(String strIngredient12) {
        this.strIngredient12 = strIngredient12;
    }

    /**
     * Sets the thirteenth ingredient of the meal.
     * @param strIngredient13 Thirteenth ingredient.
     */
    public void setStrIngredient13(String strIngredient13) {
        this.strIngredient13 = strIngredient13;
    }

    /**
     * Sets the fourteenth ingredient of the meal.
     * @param strIngredient14 Fourteenth ingredient.
     */
    public void setStrIngredient14(String strIngredient14) {
        this.strIngredient14 = strIngredient14;
    }

    /**
     * Sets the fifteenth ingredient of the meal.
     * @param strIngredient15 Fifteenth ingredient.
     */
    public void setStrIngredient15(String strIngredient15) {
        this.strIngredient15 = strIngredient15;
    }

    /**
     * Sets the sixteenth ingredient of the meal.
     * @param strIngredient16 Sixteenth ingredient.
     */
    public void setStrIngredient16(String strIngredient16) {
        this.strIngredient16 = strIngredient16;
    }

    /**
     * Sets the seventeenth ingredient of the meal.
     * @param strIngredient17 Seventeenth ingredient.
     */
    public void setStrIngredient17(String strIngredient17) {
        this.strIngredient17 = strIngredient17;
    }

    /**
     * Sets the eighteenth ingredient of the meal.
     * @param strIngredient18 Eighteenth ingredient.
     */
    public void setStrIngredient18(String strIngredient18) {
        this.strIngredient18 = strIngredient18;
    }

    /**
     * Sets the nineteenth ingredient of the meal.
     * @param strIngredient19 Nineteenth ingredient.
     */
    public void setStrIngredient19(String strIngredient19) {
        this.strIngredient19 = strIngredient19;
    }

    /**
     * Sets the twentieth ingredient of the meal.
     * @param strIngredient20 Twentieth ingredient.
     */
    public void setStrIngredient20(String strIngredient20) {
        this.strIngredient20 = strIngredient20;
    }

    /**
     * Sets the measure for the first ingredient.
     * @param strMeasure1 First measure.
     */
    public void setStrMeasure1(String strMeasure1) {
        this.strMeasure1 = strMeasure1;
    }

    /**
     * Sets the measure for the second ingredient.
     * @param strMeasure2 Second measure.
     */
    public void setStrMeasure2(String strMeasure2) {
        this.strMeasure2 = strMeasure2;
    }

    /**
     * Sets the measure for the third ingredient.
     * @param strMeasure3 Third measure.
     */
    public void setStrMeasure3(String strMeasure3) {
        this.strMeasure3 = strMeasure3;
    }

    /**
     * Sets the measure for the fourth ingredient.
     * @param strMeasure4 Fourth measure.
     */
    public void setStrMeasure4(String strMeasure4) {
        this.strMeasure4 = strMeasure4;
    }

    /**
     * Sets the measure for the fifth ingredient.
     * @param strMeasure5 Fifth measure.
     */
    public void setStrMeasure5(String strMeasure5) {
        this.strMeasure5 = strMeasure5;
    }

    /**
     * Sets the measure for the sixth ingredient.
     * @param strMeasure6 Sixth measure.
     */
    public void setStrMeasure6(String strMeasure6) {
        this.strMeasure6 = strMeasure6;
    }

    /**
     * Sets the measure for the seventh ingredient.
     * @param strMeasure7 Seventh measure.
     */
    public void setStrMeasure7(String strMeasure7) {
        this.strMeasure7 = strMeasure7;
    }

    /**
     * Sets the measure for the eighth ingredient.
     * @param strMeasure8 Eighth measure.
     */
    public void setStrMeasure8(String strMeasure8) {
        this.strMeasure8 = strMeasure8;
    }

    /**
     * Sets the measure for the ninth ingredient.
     * @param strMeasure9 Ninth measure.
     */
    public void setStrMeasure9(String strMeasure9) {
        this.strMeasure9 = strMeasure9;
    }

    /**
     * Sets the measure for the tenth ingredient.
     * @param strMeasure10 Tenth measure.
     */
    public void setStrMeasure10(String strMeasure10) {
        this.strMeasure10 = strMeasure10;
    }

    /**
     * Sets the measure for the eleventh ingredient.
     * @param strMeasure11 Eleventh measure.
     */
    public void setStrMeasure11(String strMeasure11) {
        this.strMeasure11 = strMeasure11;
    }

    /**
     * Sets the measure for the twelfth ingredient.
     * @param strMeasure12 Twelfth measure.
     */
    public void setStrMeasure12(String strMeasure12) {
        this.strMeasure12 = strMeasure12;
    }

    /**
     * Sets the measure for the thirteenth ingredient.
     * @param strMeasure13 Thirteenth measure.
     */
    public void setStrMeasure13(String strMeasure13) {
        this.strMeasure13 = strMeasure13;
    }

    /**
     * Sets the measure for the fourteenth ingredient.
     * @param strMeasure14 Fourteenth measure.
     */
    public void setStrMeasure14(String strMeasure14) {
        this.strMeasure14 = strMeasure14;
    }

    /**
     * Sets the measure for the fifteenth ingredient.
     * @param strMeasure15 Fifteenth measure.
     */
    public void setStrMeasure15(String strMeasure15) {
        this.strMeasure15 = strMeasure15;
    }

    /**
     * Sets the measure for the sixteenth ingredient.
     * @param strMeasure16 Sixteenth measure.
     */
    public void setStrMeasure16(String strMeasure16) {
        this.strMeasure16 = strMeasure16;
    }

    /**
     * Sets the measure for the seventeenth ingredient.
     * @param strMeasure17 Seventeenth measure.
     */
    public void setStrMeasure17(String strMeasure17) {
        this.strMeasure17 = strMeasure17;
    }

    /**
     * Sets the measure for the eighteenth ingredient.
     * @param strMeasure18 Eighteenth measure.
     */
    public void setStrMeasure18(String strMeasure18) {
        this.strMeasure18 = strMeasure18;
    }

    /**
     * Sets the measure for the nineteenth ingredient.
     * @param strMeasure19 Nineteenth measure.
     */
    public void setStrMeasure19(String strMeasure19) {
        this.strMeasure19 = strMeasure19;
    }

    /**
     * Sets the measure for the twentieth ingredient.
     * @param strMeasure20 Twentieth measure.
     */
    public void setStrMeasure20(String strMeasure20) {
        this.strMeasure20 = strMeasure20;
    }
}