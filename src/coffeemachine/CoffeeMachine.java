package coffeemachine;

import java.util.HashMap;
import java.util.Map;

public class CoffeeMachine {
    private Map<Ingredient, Integer> inventory;
    private Order currentOrder;
    
    public CoffeeMachine() {
        this.inventory = new HashMap<>();
        this.currentOrder = null;
        initializeInventory();
    }
    
    private void initializeInventory() {
        // Start with some default quantities
        inventory.put(new Ingredient("Water", "ml"), 1000);
        inventory.put(new Ingredient("Coffee Beans", "g"), 500);
        inventory.put(new Ingredient("Milk", "ml"), 500);
        inventory.put(new Ingredient("Sugar", "g"), 200);
    }
    
    public void refill(Ingredient ingredient, int amount) {
        inventory.put(ingredient, inventory.getOrDefault(ingredient, 0) + amount);
    }
    
    public int getInventoryLevel(Ingredient ingredient) {
        return inventory.getOrDefault(ingredient, 0);
    }
    
    public boolean canMake(Beverage beverage) {
        Map<Ingredient, Integer> required = beverage.getRequiredIngredients();
        
        for (Map.Entry<Ingredient, Integer> entry : required.entrySet()) {
            Ingredient ingredient = entry.getKey();
            int amountNeeded = entry.getValue();
            int amountAvailable = inventory.getOrDefault(ingredient, 0);
            
            if (amountAvailable < amountNeeded) {
                return false;
            }
        }
        return true;
    }
    
    public Order createOrder(Beverage beverage, int quantity) {
        if (!canMake(beverage)) {
            throw new IllegalStateException("Cannot make " + beverage.getName() + " - insufficient ingredients");
        }
        
        this.currentOrder = new Order(beverage, quantity);
        return this.currentOrder;
    }
    
    public void dispenseBeverage(Order order) {
        if (order == null || order != this.currentOrder) {
            throw new IllegalStateException("Invalid order");
        }
        
        Beverage beverage = order.getBeverage();
        int quantity = order.getQuantity();
        
        // Deduct ingredients for the order
        Map<Ingredient, Integer> required = beverage.getRequiredIngredients();
        for (Map.Entry<Ingredient, Integer> entry : required.entrySet()) {
            Ingredient ingredient = entry.getKey();
            int totalNeeded = entry.getValue() * quantity;
            inventory.put(ingredient, inventory.get(ingredient) - totalNeeded);
        }
        
        // Clear current order
        this.currentOrder = null;
        System.out.println("Dispensed " + quantity + "x " + beverage.getName());
    }
    
    public Order getCurrentOrder() {
        return this.currentOrder;
    }
}