public class ToppingTwoDecorator implements MealComponent {
    private String toppingName;
    private Meal decorated;
    private double cost = 1;

    public ToppingTwoDecorator(Meal plainMeal, Restaurant r) {
        this.decorated = plainMeal;
        this.toppingName = r.getToppings().get(1);
    }

    public String itemDetail() {
        return decorated.itemDetail()
                + String.format("\n  %-18s %10.2f", String.format("+ %s", toppingName), this.cost);
    }

    public double getCost() {
        return decorated.getCost() + this.cost;
    }
}
