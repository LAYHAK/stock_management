package Model;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private final String fileName = "dataSource.CSV";

    public void addProduct(Product product) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
        bw.write(product.getId() + "," + product.getName() + "," + product.getQuantity() + "," + product.getUnitPrice());
        bw.newLine();
        bw.close();
    }

    public List<Product> readAllTransaction() throws IOException {
        List<Product> products = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] productDetails = line.split(",");
            Product product = new Product(productDetails[0], productDetails[1], Integer.parseInt(productDetails[2]), Double.parseDouble(productDetails[3]), LocalDate.now());
            products.add(product);
        }
        br.close();
        return products;
    }

    public Product readProductById(String id) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] productDetails = line.split(",");
            if (productDetails[0].equals(id)) {
                br.close();
                return productDetails.length == 5 ? new Product(productDetails[0], productDetails[1], Integer.parseInt(productDetails[2]), Double.parseDouble(productDetails[3]) ,LocalDate.now()) :null;
            }
        }
        br.close();
        return null; // Product not found
    }
}

