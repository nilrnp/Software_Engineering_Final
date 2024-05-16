import java.util.ArrayList;

@SuppressWarnings("unused")
public class paleoDiet extends Meal implements MealComponent {
    private ArrayList<String> newDiet = new ArrayList<>();
    private Macronutrient macros = new Macronutrient();

    public paleoDiet(String name) {
        super(name);
        super.setCost(13.0);
        curate();
    }
    // No Carbs except pistachio, No Tofu, No Dairy (Cheese and Sour cream)

    public void curate() {
        // add new carb to list
        newDiet.add("Pistachio");

        // for protein
        int i = (int) Math.floor(Math.random() * (2 + 1));
        macros.removeProtein("Tofu");
        String newProtein = (String) macros.getListProteins().get(i);
        newDiet.add(newProtein);

        // for fat
        int idx = (int) Math.floor(Math.random() * (2 + 1));
        macros.removeFat("Sour Cream");
        String newFat = (String) macros.getListFats().get(idx);
        newDiet.add(newFat);
    }

    @Override
    public String itemDetail() {
        String s = String.format("%-20s %10.2f", this.getName(), this.getCost()) + "\n" + newDiet;
        return s;
    }
}