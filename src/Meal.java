
// Factory Pattern
import java.util.List;
import java.util.ArrayList;

class Meal implements MealComponent {
    private String name;

    private List<String> toppings;
    private double cost;

    public Meal(String name) {
        this.name = name;
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

    public String itemDetail() {
        return String.format("%-20s %10.2f", name, this.getCost());
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double c) {
        this.cost = c;
    }

    public String mealDetail() {
        return null;
    }

}
