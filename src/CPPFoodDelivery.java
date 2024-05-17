import java.util.List;

public class CPPFoodDelivery {
        public static void notifyDriversNewOrder(List<Driver> drivers, Order order) {
                for (Driver observer : drivers) {
                        if (observer.getCounty().equals(order.customer.getCounty()) &&
                                        isWithinWorkingHours(observer.getShift(), order.orderCreationTime) &&
                                        isWithinWorkingHours(order.restaurant.getOperatingHours().get(0),
                                                        order.orderCreationTime)) {
                                observer.update(order);
                        }
                }
        }

        public static void notifyDriversOrderPickedUp(List<Driver> drivers, Order order) {
                for (Driver observer : drivers) {
                        observer.updatePickedUp(order);
                }
        }

        public static Driver assignDriver(Order order, List<Driver> drivers) {
                for (Driver driver : drivers) {
                        if (driver.getCounty().equals(order.customer.getCounty()) &&
                                        isWithinWorkingHours(driver.getShift(), order.orderCreationTime) &&
                                        isWithinWorkingHours(order.restaurant.getOperatingHours().get(0),
                                                        order.orderCreationTime)) {
                                notifyDriversOrderPickedUp(drivers, order);
                                return driver;

                        }
                }
                return null;
        }

        public static boolean isWithinWorkingHours(String workingHours, String orderTime) {
                String[] hours = workingHours.split(" - ");
                String startTime = convertTo24HourFormat(hours[0]);
                String endTime = convertTo24HourFormat(hours[1]);
                String order24HourTime = convertTo24HourFormat(orderTime);
                return order24HourTime.compareTo(startTime) >= 0 && order24HourTime.compareTo(endTime) <= 0;
        }

        public static String convertTo24HourFormat(String time) {
                try {
                        java.text.SimpleDateFormat displayFormat = new java.text.SimpleDateFormat("HH:mm");
                        java.text.SimpleDateFormat parseFormat = new java.text.SimpleDateFormat("hh:mma");
                        java.util.Date date = parseFormat.parse(time.replace(" ", "").toUpperCase());
                        return displayFormat.format(date);
                } catch (java.text.ParseException e) {
                        e.printStackTrace();
                        return null;
                }
        }

        public static void confirmOrder(Order order, Driver assignedDriver, String pickUpTime, String deliveredTime) {
                if (assignedDriver != null) {
                        order.setDriver(assignedDriver);
                        order.setOrderPickUpTime(pickUpTime);
                        order.setDeliveredTime(deliveredTime);
                        order.customer.getOrders().add(order);
                        System.out.println();
                        printOrderInformation(order);
                } else {
                        System.out.println("\nNo available driver for the order.");
                        order.setDriver(null);
                        order.setOrderPickUpTime(null);
                        order.setDeliveredTime(null);
                        order.customer.getOrders().add(order);
                        System.out.println();
                        printOrderInformation(order);
                }
        }

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
                System.out.printf(format, "Hours", order.restaurant.getOperatingHours());
                System.out.printf(format, "Address", order.restaurant.address);
                System.out.printf(format, "County", order.restaurant.county);
                System.out.println(separator);

                System.out.printf(format, "Driver Information", "");
                System.out.println(separator);
                if (order.driver == null) {
                        System.out.printf(format, "Name", "");
                        System.out.printf(format, "County", "");
                        System.out.printf(format, "Shift", "");
                } else {
                        System.out.printf(format, "Name", order.driver.name);
                        System.out.printf(format, "County", order.driver.county);
                        System.out.printf(format, "Shift", order.driver.getShift());
                }
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

                // Creating restaurants of 4 different types
                Restaurant italianRestaurant = new Restaurant("Bella Italia", "1234 Tuscany Ave",
                                "Los Angeles County", List.of("Marinara Sauce", "Cheese", "Meat Ball"),
                                List.of("8:00AM - 10:00PM"), FoodType.ITALIAN);
                Restaurant mexicanRestaurant = new Restaurant("El Camino Real", "5678 Fiesta Blvd",
                                "San Diego County", List.of("Black Beans", "Limes", "Chips"),
                                List.of("12:00PM - 11:00PM"),
                                FoodType.MEXICAN);
                Restaurant americanRestaurant = new Restaurant("The Patriot Grill", "3456 Freedom St",
                                "Los Angeles County", List.of("Extra Cheese", "French Fries", "Bacon"),
                                List.of("10:00AM - 9:00PM"),
                                FoodType.AMERICAN);
                Restaurant japaneseRestaurant = new Restaurant("Sakura Garden", "9102 Cherry Blossom Ln",
                                "Orange County", List.of("Mayonnaise", "Corn", "Salmon"), List.of("12:00PM - 6:00PM"),
                                FoodType.JAPANESE);

                // Print Menus
                italianRestaurant.printMenu();
                mexicanRestaurant.printMenu();
                americanRestaurant.printMenu();
                japaneseRestaurant.printMenu();

                System.out.println();

                // Creating Customers
                List<Customer> customers = List.of(
                                new Customer("Alice Johnson", "101 Main St", "Los Angeles County"),
                                new Customer("Bob Smith", "202 Maple Ave", "San Diego County"),
                                new Customer("Charlie Brown", "303 Oak Dr", "Orange County"),
                                new Customer("Diana Clark", "404 Pine Ln", "Los Angeles County"),
                                new Customer("Eva Martinez", "505 Cedar St", "San Diego County"),
                                new Customer("Frank Wilson", "606 Birch Rd", "Orange County"),
                                new Customer("Grace Taylor", "707 Elm St", "Los Angeles County"),
                                new Customer("Henry Davis", "808 Spruce Blvd", "Orange County"),
                                new Customer("Isabel Adams", "909 Oakwood Ave", "San Diego County"),
                                new Customer("Jackie Roberts", "1010 Sunset Blvd", "Los Angeles County"));

                // Creating Drivers
                List<Driver> drivers = List.of(
                                new Driver("John Smith", "101 Main St", "Los Angeles County", 1),
                                new Driver("Jane Doe", "202 Maple Ave", "San Diego County", 2),
                                new Driver("Mike Johnson", "303 Oak Dr", "Orange County", 1),
                                new Driver("Emily Davis", "404 Pine Ln", "Los Angeles County", 0),
                                new Driver("Chris Wilson", "505 Cedar St", "San Diego County", 1),
                                new Driver("Lisa Wilson", "606 Birch Rd", "Orange County", 2),
                                new Driver("Tom Clark", "707 Elm St", "Los Angeles County", 2),
                                new Driver("Susan Martinez", "808 Spruce Blvd", "Orange County", 0));

                // Creating orders
                Order order1 = new Order(italianRestaurant, customers.get(0), "10:00 AM");
                order1.addMeal("vegan", 1);
                order1.addMeal("nutAllergy", 2);
                notifyDriversNewOrder(drivers, order1);

                // Attempt to assign a driver to the order
                Driver assignedDriver1 = assignDriver(order1, drivers);
                confirmOrder(order1, assignedDriver1, "10:30 AM", "11:00 AM");

                Order order2 = new Order(mexicanRestaurant, customers.get(1), "12:30 PM");
                order2.addMeal("paleo", 1);
                order2.addMeal("noRestriction", 2);
                notifyDriversNewOrder(drivers, order2);

                Driver assignedDriver2 = assignDriver(order2, drivers);
                confirmOrder(order2, assignedDriver2, "01:00 PM", "01:30 PM");

                Order order3 = new Order(americanRestaurant, customers.get(9), "10:00 AM");
                order3.addMeal("vegan", 0);
                notifyDriversNewOrder(drivers, order3);

                Driver assignedDriver3 = assignDriver(order3, drivers);
                confirmOrder(order3, assignedDriver3, "10:30 AM", "11:00 AM");

                Order order4 = new Order(japaneseRestaurant, customers.get(5), "05:00 PM");
                order4.addMeal("vegan", 1);
                order4.addMeal("nutAllergy", 2);
                order4.addMeal("paleo", 0);
                notifyDriversNewOrder(drivers, order4);

                Driver assignedDriver4 = assignDriver(order4, drivers);
                confirmOrder(order4, assignedDriver4, "05:30 PM", "06:00 PM");

                // No available driver for the order case
                Order order5 = new Order(italianRestaurant, customers.get(4), "05:00 PM");
                order5.addMeal("noRestriction", 1);
                order5.addMeal("nutAllergy", 2);
                notifyDriversNewOrder(drivers, order5);

                Driver assignedDriver5 = assignDriver(order5, drivers);
                confirmOrder(order5, assignedDriver5, "05:30 PM", "06:00 PM");

        }

}