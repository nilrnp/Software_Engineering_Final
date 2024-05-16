import java.util.ArrayList;

@SuppressWarnings("unused")
public class veganDiet extends Meal implements MealComponent {
    private ArrayList<String> newDiet = new ArrayList<>();
    private Macronutrient macros = new Macronutrient();

    public veganDiet(String name) {
        super(name);
        super.setCost(11.0);
        curate();
    }

    // No Meat (Fish, Chicken, Tuna) and No Dairy (Cheese and Sour cream)
    public void curate() {
        // add new carb to list
        int index = (int) Math.floor(Math.random() * (2 + 1));
        // no cheese
        macros.removeCarb("Cheese");
        String newCarb = (String) macros.getListCarbs().get(index);
        newDiet.add(newCarb);

        // for protein
        int i = (int) Math.floor(Math.random() * (1 + 1));
        // no fish or chicken
        macros.removeProtein("Fish");
        macros.removeProtein("Chicken");
        String newProtein = (String) macros.getListProteins().get(i);
        newDiet.add(newProtein);

        // for fat
        int idx = (int) Math.floor(Math.random() * (1 + 1));
        // no sour cream or tuna
        macros.removeFat("Sour Cream");
        macros.removeFat("Tuna");
        String newFat = (String) macros.getListFats().get(idx);
        newDiet.add(newFat);
    }

    @Override
    public String itemDetail() {
        String s = String.format("%-20s %10.2f", this.getName(), this.getCost()) + "\n" + newDiet;
        return s;
    }
}