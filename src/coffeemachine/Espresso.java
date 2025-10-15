package coffeemachine;

import java.util.HashMap;
import java.util.Map;

public class Espresso implements Beverage {
    
    @Override
    public String getName() {
        return "Espresso";
    }
    
    @Override
    public double getPrice() {
        return 2.50;
    }
    
    @Override
    public Map<Ingredient, Integer> getRequiredIngredients() {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(new Ingredient("Water", "ml"), 50);
        ingredients.put(new Ingredient("Coffee Beans", "g"), 18);
        return ingredients;
    }
}