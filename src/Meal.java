// Factory & Design Pattern
import java.util.List;
class Meal {
    private List<String> toppings;
    private String name;
    private int fats;
    private int carbs;
    private int protein;

    public Meal(String name, int fats, int carbs, int protein, List<String> toppings) {
        this.name = name;
        this.fats = fats;
        this.carbs = carbs;
        this.protein = protein;
        this.toppings = toppings;
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
}