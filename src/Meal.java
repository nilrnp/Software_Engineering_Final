
// Design Pattern
import java.util.List;
import java.util.ArrayList;

class Meal extends MealFactory {
    private String name;
    private int fats;
    private int carbs;
    private int protein;
    private List<String> toppings;
    private double cost;

    public Meal(String name, int fats, int carbs, int protein) {
        this.name = name;
        this.fats = fats;
        this.carbs = carbs;
        this.protein = protein;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(String topping) {
        toppings.add(topping);
    }

    public List<String> getToppings() {
        return toppings;
    }

    public String getName() {
        return name;
    }

    public int getFats() {
        return fats;
    }

    public int getCarbs() {
        return carbs;
    }

    public int getProtein() {
        return protein;
    }

    public String itemDetail() {
        return String.format("%-20s %10.2f", name, this.getCost());
    }

    public double getCost() {
        return cost;
    }
}
