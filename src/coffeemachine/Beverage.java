import java.util.Map;

public interface Beverage {
    String getName();
    double getPrice();
    Map<Ingredient, Integer> getRequiredIngredients();
}