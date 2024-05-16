import java.util.List;
public class CPPFoodDelivery {

    public static void printOrderInformation(Order order)
    {
        System.out.println(order.customer.name + "'s Order");
        System.out.println("-------------------------------------------------------");

        System.out.println("\nCustomer Information: ");
        System.out.println("Name -> " + order.customer.name);
        System.out.println("Address -> " + order.customer.address);
        System.out.println("Dietary Restrictions -> " + order.customer.getDietaryRestrictions());

        System.out.println("\nPick Up Details: ");
        System.out.println("Restaurant -> " + order.restaurant.name);
        System.out.println("Restaurant Address -> " + order.restaurant.address);

        System.out.println("\nDriver Information: ");
        System.out.println("Name -> " + order.driver.name);
        System.out.println("Shift -> " + order.driver.getShift());

        System.out.println("\nItems: ");
        System.out.println(order.items);

        System.out.println("\nOrder Information: ");
        System.out.println("Order Creation Time -> " + order.orderCreationTime);
        System.out.println("Order Pickup Time -> " + order.orderPickUpTime);
        System.out.println("Order Delivered Time -> " + order.deliveredTime);
    }
    public static void main(String[] args) {
        // TO DO, add/show toppings and diet restriction

        // Creating meals for each restaurant type
        Meal italianMeal1 = MealFactory.createMeal("Pizza", 15, 30, 20);
        Meal italianMeal2 = MealFactory.createMeal("Salad", 5, 10, 5);

        Meal mexicanMeal1 = MealFactory.createMeal("Taco", 15, 30, 20);
        Meal mexianMeal2 = MealFactory.createMeal("Burrito", 5, 10, 5);

        Meal americanMeal1 = MealFactory.createMeal("Cheeseburger", 15, 30, 20);
        Meal americanMeal2 = MealFactory.createMeal("Hot Dog", 5, 10, 5);

        Meal japaneseMeal1 = MealFactory.createMeal("Ramen", 15, 30, 20);
        Meal japaneseMeal2 = MealFactory.createMeal("Sushi", 5, 10, 5);

        // Create menus for each restaurant type
        List<Meal> italianMenu = List.of(italianMeal1, italianMeal2);
        List<Meal> mexicanMenu = List.of(mexicanMeal1, mexianMeal2);
        List<Meal> americanMenu = List.of(americanMeal1, americanMeal2);
        List<Meal> japaneseMenu = List.of(japaneseMeal1, japaneseMeal2);

        // Creating restaurants of 4 different types
        Restaurant italianRestaurant = new Restaurant("Restaurant Name", "Restaurant Address", "Restaurant County",
                List.of("Toppings Go Here"), italianMenu, List.of("8AM - 10PM"), FoodType.ITALIAN);
        Restaurant mexicanRestaurant = new Restaurant("Restaurant Name", "Restaurant Address", "Restaurant County",
                List.of("Toppings Go Here"), mexicanMenu, List.of("12PM - 12AM"), FoodType.MEXICAN);
        Restaurant americanRestaurant = new Restaurant("Restaurant Name", "Restaurant Address", "Restaurant County",
                List.of("Toppings Go Here"), americanMenu, List.of("10AM - 9PM"), FoodType.AMERICAN);
        Restaurant japaneseRestaurant = new Restaurant("Restaurant Name", "Restaurant Address", "Restaurant County",
                List.of("Toppings Go Here"), japaneseMenu, List.of("12PM - 6PM"), FoodType.JAPANESE);

        // Creating a customer
        Customer customer1 = new Customer("Customer Name", "Customer Address", "Customer County");

        // Creating a driver
        Driver driver1 = new Driver("Driver Name", "Driver Address", "Driver County", 0);

        // Creating an order
        Order order1 = new Order(italianRestaurant, customer1, List.of(italianMeal1, italianMeal2), "10:00 AM");
        order1.setDriver(driver1);
        order1.setOrderPickUpTime("10:30 AM");
        order1.setDeliveredTime("11:00 AM");

        // Adding the order to the customer's order list
        customer1.getOrders().add(order1);

        // Displaying Order Information
        printOrderInformation(order1);
    }
}