package Contest0724.T3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author IronSid
 * @since 2022-07-24 10:26
 */
public class FoodRatings {

    HashMap<String, Food> strToFood = new HashMap<>();
    HashMap<Food, String> foodToCuisine = new HashMap<>();
    HashMap<String, TreeSet<Food>> c = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for (int i = 0; i < n; i++) {
            Food food = new Food(ratings[i], foods[i]);
            strToFood.put(foods[i], food);
            foodToCuisine.put(food, cuisines[i]);
            if (!c.containsKey(cuisines[i])) c.put(cuisines[i], new TreeSet<>(Comparator.comparingInt((Food o) -> o.r).reversed().thenComparing((Food o) -> o.name)));
            c.get(cuisines[i]).add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        Food change = strToFood.get(food);
        if (change.r == newRating) return;
        TreeSet<Food> foods = c.get(foodToCuisine.get(change));
        foods.remove(change);
        change.r = newRating;
        foods.add(change);
    }

    public String highestRated(String cuisine) {
        return c.get(cuisine).first().name;
    }

    class Food{
        int r;
        String name;

        public Food(int r, String name) {
            this.r = r;
            this.name = name;
        }
    }
}