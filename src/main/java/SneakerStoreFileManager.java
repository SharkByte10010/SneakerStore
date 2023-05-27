import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SneakerStoreFileManager {

    private final String fileName;

    public SneakerStoreFileManager(String fileName) {
        this.fileName = fileName;
    }

    public SneakerStore getSneakerStore(){

        // Create a new SneakerStore object with default values
        SneakerStore sneakerStore = new SneakerStore("Imperial Kicks","555-202-8909","444 Meadow Road");

        try{FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.readLine();

            String input;
            // Read each line from the file
            while((input = bufferedReader.readLine()) != null){
                if (!input.isEmpty()){
                    String[] parts = input.split("\\|");
                    int serialNumber = Integer.parseInt(parts[0]);
                    String brand = parts[1];
                    String material = parts[2];
                    String color = parts[3];
                    String name = parts[4];
                    double price = Double.parseDouble(parts[5]);
                    // Create a new Sneaker object with extracted information
                    Sneaker sneaker = new Sneaker(brand,color,material,price,serialNumber,name);

                    sneakerStore.addSneaker(sneaker);
                }
            }
        }catch (IOException e){
            // Handle any IOException that occurs while reading the inventory file
            System.err.println("File not found");
        }
            return sneakerStore;


    }

    public void saveSneakerStore(SneakerStore sneakerStore) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write("SerialNumber|Brand|Material|Color|Name|Price\n");
            for (Sneaker sneaker : sneakerStore.allSneakers()) {
                String sneakerData = String.format("%d|%s|%s|%s|%s|%.2f%n",
                        sneaker.getSerialNumber(),
                        sneaker.getBrand(),
                        sneaker.getMaterial(),
                        sneaker.getColor(),
                        sneaker.getName(),
                        sneaker.getPrice());
                fileWriter.write(sneakerData);
            }
            fileWriter.close();
            System.out.println("Sneaker Store has been saved.");
        } catch (IOException e) {
            System.err.println("Error saving Sneaker Store inventory");
        }
    }


}
