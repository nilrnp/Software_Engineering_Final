public class ToppingOneDecorator implements MealComponent {
    private String toppingName;
    private Meal decorated;
    private double cost = 1;

    public ToppingOneDecorator(Meal plainMeal, Restaurant r) {
        this.decorated = plainMeal;
        this.toppingName = r.getToppings().get(0);
    }

    public String itemDetail() {
        return decorated.itemDetail()
                + String.format("\n  %-18s %10.2f", String.format("+ %s", toppingName), this.cost);
    }

    public double getCost() {
        return decorated.getCost() + this.cost;
    }
}
