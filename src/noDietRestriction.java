import java.util.ArrayList;

@SuppressWarnings("unused")
public class noDietRestriction extends Meal implements MealComponent {
    private ArrayList<String> newDiet = new ArrayList<>();
    private Macronutrient macros = new Macronutrient();

    public noDietRestriction(String name) {
        super(name);
        super.setCost(12.0);
        curate();
    }

    public void curate() {
        // get index of new randomly chosen carb
        int index = (int) Math.floor(Math.random() * (3 + 1));
        // get list of carbs and set the newCarb to that selected element
        String newCarb = (String) macros.getListCarbs().get(index);
        // add new carb to list
        newDiet.add(newCarb);

        // for protein
        int i = (int) Math.floor(Math.random() * (3 + 1));
        String newProtein = (String) macros.getListProteins().get(i);
        newDiet.add(newProtein);

        // for fat
        int idx = (int) Math.floor(Math.random() * (3 + 1));
        String newFat = (String) macros.getListFats().get(idx);
        newDiet.add(newFat);

    }

    @Override
    public String itemDetail() {
        String s = String.format("%-20s %10.2f", this.getName(), this.getCost()) + "\n" + newDiet;
        return s;
    }
}