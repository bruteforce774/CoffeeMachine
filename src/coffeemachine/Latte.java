package coffeemachine;

import java.util.HashMap;
import java.util.Map;

public class Latte implements Beverage {
    
    @Override
    public String getName() {
        return "Latte";
    }
    
    @Override
    public double getPrice() {
        return 3.50;
    }
    
    @Override
    public Map<Ingredient, Integer> getRequiredIngredients() {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(new Ingredient("Water", "ml"), 200);
        ingredients.put(new Ingredient("Coffee Beans", "g"), 24);
        ingredients.put(new Ingredient("Milk", "ml"), 150);
        return ingredients;
    }
}