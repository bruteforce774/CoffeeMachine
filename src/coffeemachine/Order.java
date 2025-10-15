public class Order {
    private Beverage beverage;
    private int quantity;
    private double amountPaid;
    
    public Order(Beverage beverage, int quantity) {
        this.beverage = beverage;
        this.quantity = quantity;
        this.amountPaid = 0.0;
    }
    
    public Beverage getBeverage() {
        return beverage;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public double getTotalPrice() {
        return beverage.getPrice() * quantity;
    }
    
    public double getAmountPaid() {
        return amountPaid;
    }
    
    public void addPayment(double amount) {
        this.amountPaid += amount;
    }
    
    public double getChange() {
        return amountPaid - getTotalPrice();
    }
    
    public boolean isPaidInFull() {
        return amountPaid >= getTotalPrice();
    }
    
    @Override
    public String toString() {
        return quantity + "x " + beverage.getName() + " - $" + String.format("%.2f", getTotalPrice());
    }
}