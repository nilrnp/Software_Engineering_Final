
// Observer Pattern
import java.util.ArrayList;
import java.util.List;

class Order {
    Restaurant restaurant;
    Customer customer;
    Driver driver;

    List<MealComponent> items;
    String orderCreationTime;
    String orderPickUpTime;
    String deliveredTime;

    public Order(Restaurant restaurant, Customer customer, String orderCreationTime) {
        this.restaurant = restaurant;
        this.customer = customer;
        this.items = new ArrayList<MealComponent>();
        this.orderCreationTime = orderCreationTime;
    }

    public void addMeal(String dietPlan, int ToppingNum) {
        MealComponent m;
        switch (ToppingNum) {
            case 1:
                m = new ToppingOneDecorator(MealFactory.createMeal(dietPlan), this.restaurant);
                break;
            case 2:
                m = new ToppingTwoDecorator(MealFactory.createMeal(dietPlan), this.restaurant);
                break;
            case 3:
                m = new ToppingThreeDecorator(MealFactory.createMeal(dietPlan), this.restaurant);
                break;
            default:
                m = MealFactory.createMeal(dietPlan);
                break;
        }
        items.add(m);
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setOrderPickUpTime(String orderPickUpTime) {
        this.orderPickUpTime = orderPickUpTime;
    }

    public void setDeliveredTime(String deliveredTime) {
        this.deliveredTime = deliveredTime;
    }

    public List<MealComponent> getItems() {
        return items;
    }

    public String totalCost() {
        String output = "";
        double sum = 0;
        for (MealComponent i : items) {
            output += String.format("\n%s", i.itemDetail());
            sum += i.getCost();
        }
        output += String.format("\n%20s %10.2f", "Total Cost:", sum);

        return output;
    }
}