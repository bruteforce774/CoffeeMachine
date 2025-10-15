package coffeemachine;

import java.util.Objects;

public class Ingredient {
    private String name;
    private String unit;
    
    public Ingredient(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }
    
    public String getName() {
        return name;
    }
    
    public String getUnit() {
        return unit;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return name.equals(that.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    
    @Override
    public String toString() {
        return name + " (" + unit + ")";
    }
}