import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HatFileManager {

    private final String fileName;

    public HatFileManager(String fileName) {
        this.fileName = fileName;
    }

    public FittedHatSection getFittedHatSection() {

        FittedHatSection fittedHatSection = new FittedHatSection();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReader.readLine();

            String input;

            while ((input = bufferedReader.readLine()) != null) {
                if (!input.isEmpty()) {
                    String[] parts = input.split("\\|");
                    String brand = parts[0];
                    String team = parts[1];
                    double hatSize = Double.parseDouble(parts[2]);
                    String color = parts[3];
                    double price = Double.parseDouble(parts[4]);

                    FittedHats fittedHats = new FittedHats(brand, team, hatSize, color, price);

                    fittedHatSection.addFittedHat(fittedHats);
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("File Not Found");
        }
        return fittedHatSection;
    }

    public void saveFittedHatSection(FittedHatSection fittedHatSection) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write("Brand|TeamName|HatSize|Color|Price\n");
            for (FittedHats fittedHat : fittedHatSection.getAllFittedHats()) {
                String fittedHatData = String.format("%s|%s|%.2f|%s|%.2f%n",
                        fittedHat.getBrandName(),
                        fittedHat.getTeamName(),
                        fittedHat.getHatSize(),
                        fittedHat.getColor(),
                        fittedHat.getPrice());
                fileWriter.write(fittedHatData);
            }
            fileWriter.close();
            System.out.println("Fitted Hat Section has been saved.");
        } catch (IOException e) {
            System.err.println("Error saving Fitted Hat Section inventory");
        }
    }




}
