import java.util.ArrayList;
import java.util.List;

public class SneakerStore {
    private String name;
    private String phoneNumber;
    private String address;
    private ArrayList<Sneaker> inventory = new ArrayList<>();

    public SneakerStore(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public List<Sneaker> getSneakerByBrand(String brand) {
        List<Sneaker> result = new ArrayList<>();
        for (Sneaker sneaker : inventory) {
            if (sneaker.getBrand().equalsIgnoreCase(brand)) {
                result.add(sneaker);
            }
        }
        return result;
    }

    public List<Sneaker> getSneakerByColor(String color) {
        List<Sneaker> result = new ArrayList<>();
        for (Sneaker sneaker : inventory) {
            String[] sneakerColors = sneaker.getColor().split(",");
            for (String sneakerColor : sneakerColors) {
                if (sneakerColor.equalsIgnoreCase(color)) {
                    result.add(sneaker);
                    break;
                }
            }
        }
        return result;
    }

    public List<Sneaker> getSneakerByMaterial(String material) {
        List<Sneaker> result = new ArrayList<>();
        for (Sneaker sneaker : inventory) {
            if (sneaker.getMaterial().equalsIgnoreCase(material)) {
                result.add(sneaker);
            }
        }
        return result;
    }

    public ArrayList<Sneaker> getSneakerByName(String name) {
        ArrayList<Sneaker> result = new ArrayList<>();
        for (Sneaker sneaker : inventory) {
            if (sneaker.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(sneaker);
            }
        }
        return result;
    }


    public List<Sneaker> getSneakerByPriceRange(double minPrice, double maxPrice) {
        List<Sneaker> result = new ArrayList<>();
        for (Sneaker sneaker : inventory) {
            double price = sneaker.getPrice();
            if (price >= minPrice && price <= maxPrice) {
                result.add(sneaker);
            }
        }
        return result;
    }




    public List<Sneaker> getAllSneakers(){
        return new ArrayList<>(inventory);
    }



    public void addSneaker(Sneaker sneaker) {
        inventory.add(sneaker);
    }

    public void removeSneaker(Sneaker sneaker) {
        inventory.remove(sneaker);
    }

    // Getters and setters for name, phoneNumber, and address
    // ...

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}



