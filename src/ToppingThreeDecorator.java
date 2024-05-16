public class ToppingThreeDecorator implements MealComponent {
    private String toppingName;
    private MealComponent decorated;
    private double cost = 5.0;

    public ToppingThreeDecorator(MealComponent plainMeal, Restaurant r) {
        this.decorated = plainMeal;
        this.toppingName = r.getToppings().get(2);
    }

    public String itemDetail() {
        return decorated.itemDetail()
                + String.format("\n  %-18s %10.2f", String.format("+ %s", toppingName), this.cost);
    }

    public double getCost() {
        return decorated.getCost() + this.cost;
    }
}
