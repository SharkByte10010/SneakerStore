import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private SneakerStoreFileManager fileManager;
    private SneakerStore sneakerStore;

    private void init() {
        fileManager = new SneakerStoreFileManager("sneakerinventory.csv");
        sneakerStore = fileManager.getSneakerStore();
    }

    public static Scanner userInput = new Scanner(System.in);

    public void display() {
        init();
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                     Main Menu
                     [1] View Sneakers By Brands
                     [2] View Sneakers By Colors
                     [3] View Sneakers By Material Type
                     [4] Search Sneakers By Name
                     [5] Search Sneakers Within Price Range
                     [6] Add A New Sneaker
                     [7] Remove A Sneaker
                     [99] Exit 
                    """);
            int choice = userInput.nextInt();
            userInput.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    getByBrandRequest();
                    break;
                case 2:
                    getByColorRequest();
                    break;
                case 3:
                    getByMaterialRequest();
                    break;
                case 4:
                    getByNameRequest();
                    break;
                case 5:
                    getByPriceRequest();
                    break;
                case 6:
                    addSneaker();
                    break;
                case 7:
                    removeSneaker();
                    break;
                case 99:
                    exit = true;
                    System.out.println("Exiting Dealership Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public void displaySneakers(ArrayList<Sneaker> inventory) {
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-15s %-15s %-15s %-20s %-15s%n",
                "Brand", "Color", "Material", "Price", "Serial Number", "Name");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        for (Sneaker sneaker : inventory) {
            System.out.printf("%-15s %-15s %-15s $%-15.2f %-20d %-15s%n",
                    sneaker.getBrand(),
                    sneaker.getColor(),
                    sneaker.getMaterial(),
                    sneaker.getPrice(),
                    sneaker.getSerialNumber(),
                    sneaker.getName());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }


    public void getByBrandRequest() {
        System.out.print("Please enter the Brand of the Sneaker: ");
        String brand = userInput.next();
        System.out.println("            Sneakers By Brand: ");
        ArrayList<Sneaker> sneakersByBrand = (ArrayList<Sneaker>) sneakerStore.getSneakerByBrand(brand);
        displaySneakers(sneakersByBrand);
    }

    public void getByMaterialRequest() {
        System.out.print("Please enter the type of Material: ");
        String material = userInput.next();
        System.out.println("            Sneakers By Material:       ");
        ArrayList<Sneaker> sneakersByMaterial = (ArrayList<Sneaker>) sneakerStore.getSneakerByMaterial(material);
        displaySneakers(sneakersByMaterial);
    }

    public void getByColorRequest() {
        System.out.print("Please enter the color of the Sneaker:    ");
        String color = userInput.next();
        System.out.println("        Sneakers By Color ");
        ArrayList<Sneaker> sneakersByColor = (ArrayList<Sneaker>) sneakerStore.getSneakerByColor(color);
        displaySneakers(sneakersByColor);
    }


    public void getByNameRequest() {
        System.out.print("Please enter the name of the Sneakers: ");
        String name = userInput.nextLine();
        System.out.println("          Sneakers By Name    ");
        ArrayList<Sneaker> sneakersByName = (ArrayList<Sneaker>) sneakerStore.getSneakerByName(name);
        displaySneakers(sneakersByName);
    }


    public void getByPriceRequest() {
        System.out.print("Please enter the minimum price of Sneakers: ");
        double minPrice = userInput.nextDouble();
        System.out.print("Please enter the maximum price of Sneakers: ");
        double maxPrice = userInput.nextDouble();
        System.out.println("Sneakers in the price range of $" + minPrice + " to $" + maxPrice + ":");
        ArrayList<Sneaker> sneakersByPrice = (ArrayList<Sneaker>) sneakerStore.getSneakerByPriceRange(minPrice, maxPrice);
        displaySneakers(sneakersByPrice);
    }

    public void addSneaker() {
        System.out.print("Please enter the Serial Number of the new Sneaker:  ");
        int serialNumber = Integer.parseInt(userInput.nextLine());
        System.out.print("Please enter the Brand of the new Sneaker:    ");
        String brand = userInput.nextLine();
        System.out.print("Please enter the Material of the new Sneaker:     ");
        String material = userInput.nextLine();
        System.out.print("Please enter the Color of the new Sneaker:  ");
        String color = userInput.nextLine();
        System.out.print("Please enter the Name of the new Sneaker:     ");
        String name = userInput.nextLine();
        System.out.println("Please set the Price of the new Sneaker:    ");
        double price = userInput.nextDouble();
        System.out.println("Sneaker has been added.\n");

        Sneaker sneaker = new Sneaker(brand, color, material, price, serialNumber, name);
        sneakerStore.addSneaker(sneaker);
        fileManager.saveSneakerStore(sneakerStore);
    }

    public void removeSneaker() {
        Sneaker sneakerToBeRemoved = null;
        System.out.print("Please enter the Serial Number:   ");
        int serialNumber = userInput.nextInt();
        for (Sneaker sneaker : sneakerStore.allSneakers()) {
            if (sneaker.getSerialNumber() == serialNumber) {
                System.out.println("Sneaker has been removed.");
                sneakerToBeRemoved = sneaker;
                break;
            }
        }
        sneakerStore.removeSneaker(sneakerToBeRemoved);
        fileManager.saveSneakerStore(sneakerStore);
    }


}




