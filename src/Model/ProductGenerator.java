package Model;


import java.io.*;
import java.util.Random;

public class ProductGenerator {

    public void generateProducts(int numberOfProducts) {
        String filePath = "products.CSV";
        int lastId = 0; // Variable to hold the last used ID

        // Read the last product ID from the file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String lastLine = null, line;
            while ((line = br.readLine()) != null) {
                lastLine = line; // Keep updating lastLine until the end of file
            }
            if (lastLine != null && !lastLine.isEmpty()) {
                String[] lastProduct = lastLine.split(",");
                String lastProductId = lastProduct[0];
                lastId = Integer.parseInt(lastProductId.replaceAll("\\D+", "")); // Extract numerical part of the ID
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading product records: " + e.getMessage());
        }

        // Generate new products starting from the next ID
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            Random random = new Random();
            for (int i = 1; i <= numberOfProducts; ++i) {
                int newId = lastId + i; // Calculate new ID based on the last ID
                String id = String.format("CSTAD-%05d", newId); // Corrected format specifier
                String name = "Product::%d".formatted(newId); // Use newId to ensure uniqueness
                int quantity = random.nextInt(100) + 1;
                double unitPrice = random.nextDouble() * 100;

                String productRecord = String.join(",", id, name, String.valueOf(quantity), String.format("%.2f", unitPrice));
                bw.write(productRecord);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while generating product records: " + e.getMessage());
        }
    }


}

