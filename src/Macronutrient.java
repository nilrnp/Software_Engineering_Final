import java.util.ArrayList;
import java.util.List;


public class Macronutrient {
    private ArrayList<String> listCarbs;
    private ArrayList<String> listProteins;
    private ArrayList<String> listFats;

    public Macronutrient() {
        listCarbs = new ArrayList<> (List.of("Cheese", "Bread", "Lentils", "Pistachio"));
        listProteins = new ArrayList<> (List.of("Fish", "Chicken", "Beef", "Tofu"));
        listFats = new ArrayList<>(List.of("Avocado", "Sour Cream", "Tuna", "Peanuts"));
    }
    public List getListCarbs() {
        return listCarbs;
    }

    public List getListProteins() {
        return listProteins;
    }

    public List getListFats() {
        return listFats;
    }

    public void removeCarb(String carb) {
        listCarbs.remove(carb);
    }

    public void removeProtein(String protein) {
        listProteins.remove(protein);
    }

    public void removeFat(String fat) {
        listFats.remove(fat);
    }
}