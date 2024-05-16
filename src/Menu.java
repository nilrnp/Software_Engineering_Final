import java.util.List;

public class Menu {
    private List<String> toppingList;
    private List<MealComponent> mealList;

    public Menu(List<String> toppingList, List<MealComponent> mealList) {
        this.toppingList = toppingList;
        this.mealList = mealList;
    }

    public List<String> getToppingList() {
        return toppingList;
    }

    public List<MealComponent> getMealList() {
        return mealList;
    }

}
