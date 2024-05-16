import java.util.ArrayList;

@SuppressWarnings("unused")
public class nutAllergyDiet extends Meal implements MealComponent {
    private ArrayList<String> newDiet = new ArrayList<>();
    private Macronutrient macros = new Macronutrient();

    public nutAllergyDiet(String name) {
        super(name);
        super.setCost(14.0);
        curate();
    }
    // No Nuts (Pistachio and Peanuts)

    public void curate() {
        // add new carb to list
        int index = (int) Math.floor(Math.random() * (2 + 1));
        // no pistachio
        macros.removeCarb("Pistachio");
        String newCarb = (String) macros.getListCarbs().get(index);
        newDiet.add(newCarb);

        // for protein
        int i = (int) Math.floor(Math.random() * (3 + 1));
        String newProtein = (String) macros.getListProteins().get(i);
        newDiet.add(newProtein);

        // for fat
        int idx = (int) Math.floor(Math.random() * (2 + 1));
        // no peanuts
        macros.removeFat("Peanuts");
        String newFat = (String) macros.getListFats().get(idx);
        newDiet.add(newFat);
    }

    @Override
    public String itemDetail() {
        String s = String.format("%-20s %10.2f", this.getName(), this.getCost()) + "\n" + newDiet;
        return s;
    }
}