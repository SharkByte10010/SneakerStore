import java.util.ArrayList;
import java.util.List;

public class FittedHats {
    String brandName;
    String teamName;

    double hatSize;

    String color;

    double price;


    public FittedHats(String brandName, String teamName, double hatSize, String color, double price) {
        this.brandName = brandName;
        this.teamName = teamName;
        this.hatSize = hatSize;
        this.color = color;
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public double getHatSize() {
        return hatSize;
    }

    public void setHatSize(double hatSize) {
        this.hatSize = hatSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }





}
