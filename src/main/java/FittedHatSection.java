import java.util.ArrayList;
import java.util.List;

public class FittedHatSection {

    private ArrayList<FittedHats> inventory = new ArrayList<>();
    public List<FittedHats> getHatByBrand(String brand) {
        List<FittedHats> result = new ArrayList<>();
        for (FittedHats fittedHats : inventory) {
            if (fittedHats.getBrandName().equalsIgnoreCase(brand)) {
                result.add(fittedHats);
            }
        }
        return result;
    }

    public List<FittedHats> getHatByColor(String color) {
        List<FittedHats> result = new ArrayList<>();
        for (FittedHats fittedHats : inventory) {
            String[] HatColors = fittedHats.getColor().split(",");
            for (String fittedHat : HatColors) { // Iterate over HatColors array
                if (fittedHat.equalsIgnoreCase(color.trim())) {
                    result.add(fittedHats);
                    break;
                }
            }
        }
        return result;
    }

    public List<FittedHats> getHatByPriceRange(double minPrice, double maxPrice) {
        List<FittedHats> result = new ArrayList<>();
        for (FittedHats fittedHats : inventory) {
            double price = fittedHats.getPrice();
            if (price >= minPrice && price <= maxPrice) {
                result.add(fittedHats);
            }
        }
        return result;
    }

    public ArrayList<FittedHats> getHatByTeamName(String name) {
        ArrayList<FittedHats> result = new ArrayList<>();
        for (FittedHats fittedHats : inventory) {
            if (fittedHats.getTeamName().toLowerCase().contains(name.toLowerCase())) {
                result.add(fittedHats);
            }
        }
        return result;
    }

    public ArrayList<FittedHats> getHatBySize(double size){
        ArrayList<FittedHats> result = new ArrayList<>();
        for (FittedHats fittedHats : inventory){
            double hatSize = fittedHats.getHatSize();
            if (hatSize == size ){
                result.add(fittedHats);
            }
        }
        return result;
    }


    public void addFittedHat(FittedHats fittedHats) {
        inventory.add(fittedHats);
    }

    public void removeFittedHat(FittedHats fittedHats) {
        inventory.remove(fittedHats);
    }

    public List<FittedHats> getAllFittedHats(){
        return new ArrayList<>(inventory);
    }
}
