import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Leetcode2353 {
    // 存储食物名称到其烹饪方式和评分的映射
    private Map<String, String> foodToCuisine;
    private Map<String, Integer> foodToRating;

    // 存储每种烹饪方式对应的食物及其评分
    private Map<String, TreeMap<Integer, TreeSet<String>>> cuisineToFoods;

    public Leetcode2353(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            // 如果该烹饪方式还没有对应的 TreeMap，则创建一个
            cuisineToFoods.computeIfAbsent(cuisine, k -> new TreeMap<>(Collections.reverseOrder()))
                          .computeIfAbsent(rating, k -> new TreeSet<>())
                          .add(food);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        int oldRating = foodToRating.get(food);

        // 从旧的评分中移除该食物
        TreeMap<Integer, TreeSet<String>> ratingMap = cuisineToFoods.get(cuisine);
        if (ratingMap != null) {
            TreeSet<String> foodsWithOldRating = ratingMap.get(oldRating);
            if (foodsWithOldRating != null) {
                foodsWithOldRating.remove(food);
                if (foodsWithOldRating.isEmpty()) {
                    ratingMap.remove(oldRating);
                }
            }
        }

        // 更新评分
        foodToRating.put(food, newRating);

        // 将食物添加到新的评分中
        cuisineToFoods.computeIfAbsent(cuisine, k -> new TreeMap<>(Collections.reverseOrder()))
                      .computeIfAbsent(newRating, k -> new TreeSet<>())
                      .add(food);
    }
    
    public String highestRated(String cuisine) {
        TreeMap<Integer, TreeSet<String>> ratingMap = cuisineToFoods.get(cuisine);
        if (ratingMap == null || ratingMap.isEmpty()) {
            return null;
        }
        // 获取评分最高的食物集合
        TreeSet<String> highestRatedFoods = ratingMap.firstEntry().getValue();
        // 返回字典序最小的食物
        return highestRatedFoods.first();
    }
}
