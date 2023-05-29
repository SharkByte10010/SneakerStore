import java.util.ArrayList;
import java.util.Scanner;

public class HatSectionUI {

    public HatSectionUI(FittedHatSection fittedHats) {
        this.fittedHats = fittedHats;
    }

    private boolean exitFlag = false;

    private FittedHatSection fittedHats;

    public static Scanner userInput = new Scanner(System.in);

    public HatSectionUI(boolean exitFlag) {
        this.exitFlag = exitFlag;
    }

    public void display() {
        while (!exitFlag) {
            System.out.println("""
                Fitted Hats
                [1] View Hats By Brand
                [2] View Hats By Color
                [3] View Hats By Team Name
                [4] View Hats By Size
                [5] View Hats By Price Range
                [0] Return To Sneakers Menu 
                """);
            int choice = userInput.nextInt();
            switch (choice) {
                case 1:
                    getHatByBrandRequest();
                    break;
                case 2:
                    getHatByColorRequest();
                    break;
                case 3:
                    getHatByTeamNameRequest();
                    break;
                case 4:
                    getHatBySizeRequest();
                    break;
                case 5:
                    getHatByPriceRangeRequest();
                    break;
                case 6:
                    getAllFittedHats();
                    break;
                case 0:
                    exitFlag = true;
                    System.out.println("Returning To Previous Sneaker Menu....");
                    returnToSneakersMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }


    private void returnToSneakersMenu() {
        UserInterface userInterface = new UserInterface(); // Create an instance of UserInterface
        userInterface.display(); // Display the sneakers menu
    }

    public void displayInventory(ArrayList<FittedHats> inventory) {
        displayFittedHats(inventory);
    }



    public void displayFittedHats(ArrayList<FittedHats> inventory) {
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-15s %-15s %-15s %-20s%n",
                "Brand", "Team", "Hat Size ", "Color", "Price");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        for (FittedHats fittedHat : inventory) {
            System.out.printf("%-15s %-15s %-15s %-15s $%.2f%n",
                    fittedHat.getBrandName(),
                    fittedHat.getTeamName(),
                    fittedHat.getHatSize(),
                    fittedHat.getColor(),
                    fittedHat.getPrice());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }



    public void getHatByBrandRequest() {
        System.out.print("Please enter the Brand of the Fitted Hat: ");
        String brand = userInput.next();
        System.out.println("            Hats By Brand: ");
        ArrayList<FittedHats> fittedHatsByBrand = (ArrayList<FittedHats>) fittedHats.getHatByBrand(brand);
        displayInventory(fittedHatsByBrand);
    }

    public void getHatByColorRequest(){
        System.out.print("{Please enter the color of the Fitted Hat: ");
        String color = userInput.next();
        System.out.println("Hats By Color :              ");
        ArrayList<FittedHats> fittedHatsByColor = (ArrayList<FittedHats>)fittedHats.getHatByColor(color);
        displayInventory(fittedHatsByColor);
    }

    public void getHatByTeamNameRequest(){
    System.out.print("Please Enter The Team Of The Fitted Hat: ");
    String teamName = userInput.next();
    System.out.println("Hats By Team Name :              ");
    ArrayList<FittedHats> fittedHatsHatByTeamName = (ArrayList<FittedHats>) fittedHats.getHatByTeamName(teamName);
        displayInventory(fittedHatsHatByTeamName);
    }

    public void getHatBySizeRequest(){
        System.out.print("Please Enter The Size Of Hat: ");
        double hatSize = userInput.nextDouble();
        System.out.println("Hats By Sizes:      ");
        ArrayList<FittedHats> fittedHatsSize = (ArrayList<FittedHats>) fittedHats.getHatBySize(hatSize);
        displayInventory(fittedHatsSize);
    }

    public void getHatByPriceRangeRequest() {
        System.out.print("Please enter the Minimum Amount of your Price Range: ");
        double minPrice = userInput.nextDouble();
        System.out.print("Please enter the Maximum Amount of your Price Range: ");
        double maxPrice = userInput.nextDouble();
        System.out.println("Fitted Hats in the price range of $" + minPrice + " to $" + maxPrice + ":");
        ArrayList<FittedHats> fittedHatsByPrice = (ArrayList<FittedHats>) fittedHats.getHatByPriceRange(minPrice, maxPrice);
        displayInventory(fittedHatsByPrice);
    }

    public void getAllFittedHats(){
        System.out.println(" Our Collection Of Fitted Hats");
        ArrayList aList = (ArrayList) fittedHats.getAllFittedHats();
        displayInventory(aList);
    }

}