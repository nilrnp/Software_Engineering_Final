import java.util.ArrayList;
import java.util.List;
public class CPPFoodDelivery {
    public static void main(String[] args) {
        // Create sample meals
        Meal meal1 = new Meal("Pizza", 15, 30, 20, List.of("Pepperoni", "Mushrooms"));
        Meal meal2 = new Meal("Salad", 5, 10, 5, List.of("Tomatoes", "Cucumbers"));

        // Create sample menu for a restaurant
        List<Meal> restaurantMenu = List.of(meal1, meal2);

        // Create a sample restaurant
        Restaurant restaurant = new Restaurant("Restaurant Name", "Restaurant Address", "Restaurant County",
                restaurantMenu, List.of("8AM - 10PM"), CuisineType.ITALIAN);

        // Create a sample customer
        Customer customer = new Customer("Customer Name", "Customer Address", "Customer County");

        // Create a sample driver
        Driver driver = new Driver("Driver Name", "Driver Address", "Driver County", List.of("8AM - 4PM"));

        // Create a sample order
        Order order = new Order(restaurant, customer, List.of(meal1, meal2), "10:00 AM");
        order.setDriver(driver);
        order.setOrderPickUpTime("10:30 AM");
        order.setDeliveredTime("11:00 AM");

        // Adding the order to the customer's orders list
        customer.getOrders().add(order);

        // Accessing customer's orders
        for (Order o : customer.getOrders()) {
            System.out.println("Customer: " + customer.name);
            System.out.println("Order Details:");
            System.out.println("Restaurant: " + o.restaurant.name);
            System.out.println("Items:");
            for (Meal meal : o.items) {
                System.out.println("- " + meal.getName());
            }
            System.out.println("Order Creation Time: " + o.orderCreationTime);
            System.out.println("Order Pickup Time: " + o.orderPickUpTime);
            System.out.println("Delivered Time: " + o.deliveredTime);
            System.out.println("Driver: " + o.driver.name);
            System.out.println("------------------------------------");
        }
    }
}