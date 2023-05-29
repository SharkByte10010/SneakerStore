import java.util.ArrayList;
import java.util.List;

public class Sneaker {
    String brand;
    String color;

    String material;

    double price;

    int serialNumber;

    String name;

    String hotkey;

    public Sneaker(String brand, String color, String material, double price, int serialNumber, String name) {
        this.brand = brand;
        this.color = color;
        this.material = material;
        this.price = price;
        this.serialNumber = serialNumber;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
}
