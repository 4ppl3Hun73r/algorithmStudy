package contest;

import java.util.*;

public class Contest18 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        List<String> result = new ArrayList<>();
        Map<String, Set<String>> recipeIngredientsMap = new HashMap<>();
        Map<String, Set<String>> ingredientRecipesMap = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            recipeIngredientsMap.put(recipes[i], new HashSet<>(ingredients.get(i)));
            for (String ingredient : ingredients.get(i)) {
                if (!ingredientRecipesMap.containsKey(ingredient)) {
                    ingredientRecipesMap.put(ingredient, new HashSet<>());
                }
                ingredientRecipesMap.get(ingredient).add(recipes[i]);
            }
        }

        Queue<String> suppliesQueue =  new LinkedList<>();
        for (String supply : supplies) {
            suppliesQueue.add(supply);
        }

        while(!suppliesQueue.isEmpty()) {
            String supply = suppliesQueue.poll();
            Set<String> recipeSet = ingredientRecipesMap.get(supply);
            if (recipeSet != null) {
                for (String recipe : recipeSet) {
                    recipeIngredientsMap.get(recipe).remove(supply);
                    if (recipeIngredientsMap.get(recipe).isEmpty()) {
                        suppliesQueue.add(recipe);
                    }
                }
            }
        }

        for (String recipe : recipes) {
            if (recipeIngredientsMap.get(recipe).isEmpty()) {
                result.add(recipe);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Contest18 c = new Contest18();
    }
}
