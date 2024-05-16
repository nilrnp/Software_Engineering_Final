import java.util.List;

public class CPPFoodDelivery {

        public static void printOrderInformation(Order order) {
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
                System.out.println(order.totalCost());

                System.out.println("\nOrder Information: ");
                System.out.println("Order Creation Time -> " + order.orderCreationTime);
                System.out.println("Order Pickup Time -> " + order.orderPickUpTime);
                System.out.println("Order Delivered Time -> " + order.deliveredTime);
        }

        public static void main(String[] args) {
                // TO DO, add/show toppings and diet restriction

                // Creating restaurants of 4 different types
                Restaurant italianRestaurant = new Restaurant("Restaurant Name", "Restaurant Address",
                                "Restaurant County", List.of("Marinara Sauce", "Cheese", "Meat Ball"),
                                List.of("8AM - 10PM"), FoodType.ITALIAN);
                Restaurant mexicanRestaurant = new Restaurant("Restaurant Name", "Restaurant Address",
                                "Restaurant County", List.of("Black Bean", "Limes", "Chips"), List.of("12PM - 12AM"),
                                FoodType.MEXICAN);
                Restaurant americanRestaurant = new Restaurant("Restaurant Name", "Restaurant Address",
                                "Restaurant County", List.of("Cheese", "French Fries", "Bacon"), List.of("10AM - 9PM"),
                                FoodType.AMERICAN);
                Restaurant japaneseRestaurant = new Restaurant("Restaurant Name", "Restaurant Address",
                                "Restaurant County", List.of("Mayonnaise", "Corn", "Salmon"), List.of("12PM - 6PM"),
                                FoodType.JAPANESE);

                // Print Menus
                italianRestaurant.printMenu();
                mexicanRestaurant.printMenu();
                americanRestaurant.printMenu();
                japaneseRestaurant.printMenu();

                // Creating a customer
                Customer customer1 = new Customer("Customer Name", "Customer Address", "Customer County");

                // Creating a driver
                Driver driver1 = new Driver("Driver Name", "Driver Address", "Driver County", 0);

                // Creating an order
                Order order1 = new Order(italianRestaurant, customer1, "10:00 AM");
                order1.addMeal(customer1, "vegan", 0);
                order1.addMeal(customer1, "nutAllergy", 3);

                order1.setDriver(driver1);
                order1.setOrderPickUpTime("10:30 AM");
                order1.setDeliveredTime("11:00 AM");

                // Adding the order to the customer's order list
                customer1.getOrders().add(order1);

                // Displaying Order Information
                printOrderInformation(order1);
        }
}