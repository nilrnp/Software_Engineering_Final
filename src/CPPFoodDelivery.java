import java.util.List;
public class CPPFoodDelivery {
    public static void main(String[] args) {
        // Creating meals for each restaurant type
        Meal italianMeal1 = new Meal("Pizza", 15, 30, 20, List.of("Pepperoni", "Mushrooms","Green Peppers"));
        Meal italianMeal2 = new Meal("Salad", 5, 10, 5, List.of("Tomatoes", "Cucumbers", "Feta Cheese"));

        Meal mexicanMeal1 = new Meal("Taco", 15, 30, 20, List.of("Onions", "Beef", "Cheese"));
        Meal mexianMeal2 = new Meal("Burrito", 5, 10, 5, List.of("Onions", "Beef", "Cheese"));

        Meal americanMeal1 = new Meal("Cheeseburger", 15, 30, 20, List.of("Onions", "Beef Patty", "Lettuce"));
        Meal americanMeal2 = new Meal("Hot Dog", 5, 10, 5, List.of("Relish", "Ranch", "Ketchup"));

        Meal japaneseMeal1 = new Meal("Ramen", 15, 30, 20, List.of("Boiled Egg", "Onions", "Tofu"));
        Meal japaneseMeal2 = new Meal("Sushi", 5, 10, 5, List.of("Cucumber", "Avocado", "Spring Onions"));

        // Create menus for each restaurant type
        List<Meal> italianMenu = List.of(italianMeal1, italianMeal2);
        List<Meal> mexicanMenu = List.of(mexicanMeal1, mexianMeal2);
        List<Meal> americanMenu = List.of(americanMeal1, americanMeal2);
        List<Meal> japaneseMenu = List.of(japaneseMeal1, japaneseMeal2);

        // Creating restaurants of 4 different types
        Restaurant italianRestaurant = new Restaurant("Restaurant Name", "Restaurant Address", "Restaurant County",
                italianMenu, List.of("8AM - 10PM"), FoodType.ITALIAN);
        Restaurant mexicanRestaurant = new Restaurant("Restaurant Name", "Restaurant Address", "Restaurant County",
                mexicanMenu, List.of("8AM - 10PM"), FoodType.MEXICAN);
        Restaurant americanRestaurant = new Restaurant("Restaurant Name", "Restaurant Address", "Restaurant County",
                americanMenu, List.of("8AM - 10PM"), FoodType.AMERICAN);
        Restaurant japaneseRestaurant = new Restaurant("Restaurant Name", "Restaurant Address", "Restaurant County",
                japaneseMenu, List.of("8AM - 10PM"), FoodType.JAPANESE);

        // Creating a customer
        Customer customer1 = new Customer("Customer Name", "Customer Address", "Customer County");

        // Creating a driver
        Driver driver1 = new Driver("Driver Name", "Driver Address", "Driver County", List.of("8AM - 4PM"));

        // Creating an order
        Order order = new Order(italianRestaurant, customer1, List.of(italianMeal1, italianMeal2), "10:00 AM");
        order.setDriver(driver1);
        order.setOrderPickUpTime("10:30 AM");
        order.setDeliveredTime("11:00 AM");

        // Adding the order to the customer's order list
        customer1.getOrders().add(order);

        // Displaying Customer's Order
        for (Order o : customer1.getOrders()) {
            System.out.println("Customer: " + customer1.name);
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
        }
    }
}