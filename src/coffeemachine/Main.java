package coffeemachine;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== Coffee Machine Simulator ===\n");
        
        // Create the coffee machine
        CoffeeMachine machine = new CoffeeMachine();
        
        // Create some beverages
        Beverage espresso = new Espresso();
        Beverage latte = new Latte();
        
        // Display initial inventory
        System.out.println("Initial Inventory:");
        displayInventory(machine);
        System.out.println();
        
        // Test 1: Make an espresso
        System.out.println("--- Test 1: Ordering an Espresso ---");
        if (machine.canMake(espresso)) {
            Order order1 = machine.createOrder(espresso, 1);
            System.out.println("Order created: " + order1);
            order1.addPayment(5.00);
            System.out.println("Payment added: $5.00");
            System.out.println("Change: $" + String.format("%.2f", order1.getChange()));
            machine.dispenseBeverage(order1);
        } else {
            System.out.println("Cannot make espresso - insufficient ingredients");
        }
        System.out.println();
        
        // Display inventory after first order
        System.out.println("Inventory after espresso:");
        displayInventory(machine);
        System.out.println();
        
        // Test 2: Make a latte
        System.out.println("--- Test 2: Ordering a Latte ---");
        if (machine.canMake(latte)) {
            Order order2 = machine.createOrder(latte, 2);
            System.out.println("Order created: " + order2);
            order2.addPayment(10.00);
            System.out.println("Payment added: $10.00");
            if (order2.isPaidInFull()) {
                System.out.println("Change: $" + String.format("%.2f", order2.getChange()));
                machine.dispenseBeverage(order2);
            } else {
                System.out.println("Insufficient payment!");
            }
        } else {
            System.out.println("Cannot make latte - insufficient ingredients");
        }
        System.out.println();
        
        // Display final inventory
        System.out.println("Final Inventory:");
        displayInventory(machine);
        System.out.println();
        
        // Test 3: Try to make another latte when ingredients might be low
        System.out.println("--- Test 3: Another Latte Order ---");
        if (machine.canMake(latte)) {
            System.out.println("Can make another latte!");
        } else {
            System.out.println("Cannot make latte - insufficient ingredients");
            System.out.println("Time to refill!");
        }
        
        // Refill test
        System.out.println("\n--- Refilling Machine ---");
        machine.refill(new Ingredient("Water", "ml"), 500);
        machine.refill(new Ingredient("Milk", "ml"), 500);
        machine.refill(new Ingredient("Coffee Beans", "g"), 200);
        System.out.println("Machine refilled!");
        
        System.out.println("\nInventory after refill:");
        displayInventory(machine);
    }
    
    private static void displayInventory(CoffeeMachine machine) {
        System.out.println("  Water: " + machine.getInventoryLevel(new Ingredient("Water", "ml")) + " ml");
        System.out.println("  Coffee Beans: " + machine.getInventoryLevel(new Ingredient("Coffee Beans", "g")) + " g");
        System.out.println("  Milk: " + machine.getInventoryLevel(new Ingredient("Milk", "ml")) + " ml");
        System.out.println("  Sugar: " + machine.getInventoryLevel(new Ingredient("Sugar", "g")) + " g");
    }
}