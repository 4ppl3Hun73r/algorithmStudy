package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

// https://leetcode.com/problems/design-a-food-rating-system/
public class DesignAFoodRatingSystem {

    public static void main(String[] args) {

        /*FoodRatings f = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"}, new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"}
        , new int[]{9, 12, 8, 15, 14, 7});

        System.out.println(f.highestRated("korean"));
        f.changeRating("sushi", 16);
        System.out.println(f.highestRated("japanese"));*/

        FoodRatings f = new FoodRatings(new String[]{"emgqdbo","jmvfxjohq","qnvseohnoe","yhptazyko","ocqmvmwjq"}, new String[]{"snaxol","snaxol","snaxol","fajbervsj","fajbervsj"}
                , new int[]{2,6,18,6,5});

        f.changeRating("qnvseohnoe", 11);
        System.out.println(f.highestRated("fajbervsj"));

        f.changeRating("emgqdbo", 3);
        f.changeRating("jmvfxjohq", 9);
        f.changeRating("emgqdbo", 14);
        System.out.println(f.highestRated("fajbervsj"));
        System.out.println(f.highestRated("snaxol"));


    }
}


class FoodRatings {

    Map<String, TreeMap<Integer, TreeSet<String>>> cuisineMap = new HashMap<>();
    Map<String, Integer> foodRatingMap = new HashMap<>();
    Map<String, String> foodCuisineMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

        int len = foods.length;


        for (int i = 0; i < len; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            if (!cuisineMap.containsKey(cuisine)) {
                cuisineMap.put(cuisine, new TreeMap<>());
            }

            TreeMap<Integer, TreeSet<String>> ratingFoodsMap = cuisineMap.get(cuisine);
            if (!ratingFoodsMap.containsKey(rating)) {
                ratingFoodsMap.put(rating, new TreeSet<>());
            }

            ratingFoodsMap.get(rating).add(food);
            foodRatingMap.put(food, rating);
            foodCuisineMap.put(food, cuisine);
        }
    }

    public void changeRating(String food, int newRating) {
        int currentRating = foodRatingMap.get(food);
        String cuisine = foodCuisineMap.get(food);


        cuisineMap.get(cuisine).get(currentRating).remove(food);

        if (cuisineMap.get(cuisine).get(currentRating).size() == 0) {
            cuisineMap.get(cuisine).remove(currentRating);
        }


        TreeMap<Integer, TreeSet<String>> ratingFoodsMap = cuisineMap.get(cuisine);
        if (!ratingFoodsMap.containsKey(newRating)) {
            ratingFoodsMap.put(newRating, new TreeSet<>());
        }

        ratingFoodsMap.get(newRating).add(food);

        foodRatingMap.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        TreeMap<Integer, TreeSet<String>> ratingFoodsMap = cuisineMap.get(cuisine);


        return ratingFoodsMap.lastEntry().getValue().first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */