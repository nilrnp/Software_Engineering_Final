import java.util.List;

public class CPPFoodDelivery {

        public static void printOrderInformation(Order order) {
                String separator = "+-------------------------------+--------------------------------+";
                String format = "| %-29s | %-30s |%n";

                System.out.printf("%-30s%-1s\n", order.customer.name + "'s Order", "");
                System.out.println(separator);

                System.out.printf(format, "Customer Information", "");
                System.out.println(separator);
                System.out.printf(format, "Name", order.customer.name);
                System.out.printf(format, "Address", order.customer.address);
                System.out.printf(format, "County", order.customer.county);
                System.out.println(separator);

                System.out.printf(format, "Restaurant Information", "");
                System.out.println(separator);
                System.out.printf(format, "Name", order.restaurant.name);
                System.out.printf(format, "Address", order.restaurant.address);
                System.out.printf(format, "County", order.restaurant.county);
                System.out.println(separator);

                System.out.printf(format, "Driver Information", "");
                System.out.println(separator);
                System.out.printf(format, "Name", order.driver.name);
                System.out.printf(format, "County", order.driver.county);
                System.out.printf(format, "Shift", order.driver.getShift());
                System.out.println(separator);

                System.out.printf(format, "Items", "");
                System.out.println(separator);
                System.out.printf(format, "Total Cost", order.totalCost());
                System.out.println(separator);

                System.out.printf(format, "Order Information", "");
                System.out.println(separator);
                System.out.printf(format, "Creation Time", order.orderCreationTime);
                System.out.printf(format, "Pickup Time", order.orderPickUpTime);
                System.out.printf(format, "Delivered Time", order.deliveredTime);
                System.out.println(separator);
        }



        public static void main(String[] args) {
                // TO DO, add/show toppings and diet restriction

                // Creating restaurants of 4 different types
                Restaurant italianRestaurant = new Restaurant("Bella Italia", "1234 Tuscany Ave",
                                "Los Angeles County", List.of("Marinara Sauce", "Cheese", "Meat Ball"),
                                List.of("8AM - 10PM"), FoodType.ITALIAN);
                Restaurant mexicanRestaurant = new Restaurant("El Camino Real", "5678 Fiesta Blvd",
                                "San Diego County", List.of("Black Beans", "Limes", "Chips"), List.of("12PM - 12AM"),
                                FoodType.MEXICAN);
                Restaurant americanRestaurant = new Restaurant("The Patriot Grill", "3456 Freedom St",
                                "Los Angeles County", List.of("Extra Cheese", "French Fries", "Bacon"), List.of("10AM - 9PM"),
                                FoodType.AMERICAN);
                Restaurant japaneseRestaurant = new Restaurant("Sakura Garden", "9102 Cherry Blossom Ln",
                                "Orange County", List.of("Mayonnaise", "Corn", "Salmon"), List.of("12PM - 6PM"),
                                FoodType.JAPANESE);

                // Print Menus
                italianRestaurant.printMenu();
                mexicanRestaurant.printMenu();
                americanRestaurant.printMenu();
                japaneseRestaurant.printMenu();

                // Creating a customer
                Customer customer1 = new Customer("Alice Johnson", "101 Main St", "Los Angeles County");
                Customer customer2 = new Customer("Bob Smith", "202 Maple Ave", "San Diego County");
                Customer customer3 = new Customer("Charlie Brown", "303 Oak Dr", "Orange County");
                Customer customer4 = new Customer("Diana Clark", "404 Pine Ln", "Los Angeles County");
                Customer customer5 = new Customer("Eva Martinez", "505 Cedar St", "San Diego County");
                Customer customer6 = new Customer("Frank Wilson", "606 Birch Rd", "Orange County");
                Customer customer7 = new Customer("Grace Taylor", "707 Elm St", "Los Angeles County");
                Customer customer8 = new Customer("Henry Davis", "808 Spruce Blvd", "Orange County");
                Customer customer9 = new Customer("Isabel Adams", "909 Oakwood Ave", "San Diego County");
                Customer customer10 = new Customer("Jackie Roberts", "1010 Sunset Blvd", "Los Angeles County");


                // Creating a driver
                Driver driver1 = new Driver("John Smith", "101 Main St", "Los Angeles County", 0);
                Driver driver2 = new Driver("Jane Doe", "202 Maple Ave", "San Diego County", 1);
                Driver driver3 = new Driver("Mike Johnson", "303 Oak Dr", "Orange County", 2);
                Driver driver4 = new Driver("Emily Davis", "404 Pine Ln", "Los Angeles County", 0);
                Driver driver5 = new Driver("Chris Wilson", "505 Cedar St", "San Diego County", 1);
                Driver driver6 = new Driver("Lisa Wilson", "606 Birch Rd", "Orange County", 2);
                Driver driver7 = new Driver("Tom Clark", "707 Elm St", "Los Angeles County", 0);
                Driver driver8 = new Driver("Susan Martinez", "808 Spruce Blvd", "Orange County", 1);


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