import java.util.List;

class Restaurant extends User {
    private Menu menu;
    private List<String> operatingHours;
    private FoodType foodType;

    public Restaurant(String name, String address, String county, List<String> toppings,
            List<String> operatingHours, FoodType foodType) {
        super(name, address, county);
        this.menu = new Menu(toppings);
        this.operatingHours = operatingHours;
        this.foodType = foodType;
    }

    public List<String> getToppings() {
        return menu.getToppingList();
    }

    public void printMenu() {
        System.out.printf("----- %s Menu -----\n", name);
        System.out.println("Meals Options : ");
        System.out.println(menu.getMealList());
        System.out.println("Topping Options : ");
        System.out.println(menu.getToppingList());
    }

    public List<String> getOperatingHours() {
        return operatingHours;
    }

    public FoodType getCuisineType() {
        return foodType;
    }

}
