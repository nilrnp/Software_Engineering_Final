import java.util.List;

public class Menu {
    private List<String> toppingList;
    private List<Meal> mealList;

    public Menu(List<String> toppingList, List<Meal> mealList) {
        this.toppingList = toppingList;
        this.mealList = mealList;
    }

    public List<String> getToppingList() {
        return toppingList;
    }

    public List<Meal> getMealList() {
        return mealList;
    }

}
