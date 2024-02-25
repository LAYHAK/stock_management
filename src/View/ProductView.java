package View;

import Model.Product;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class ProductView {
    private Scanner scanner = new Scanner(System.in);
    public static final String ANSI_BLUE = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Product getProductDetails() {
        System.out.println("Enter Product ID:");
        String id = scanner.nextLine();
        System.out.println("Enter Product Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Quantity:");
        int quantity = scanner.nextInt();
        System.out.println("Enter Unit Price:");
        double unitPrice = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        return new Product(id, name, quantity, unitPrice);
    }

    public void showSuccessMessage() {
        System.out.println("Product added successfully!");
    }

    public void displayProducts(List<Product> products) {
        Table productTable = new Table(4);
        productTable.addCell("ID");
        productTable.addCell("Name");
        productTable.addCell("Quantity");
        productTable.addCell("Unit Price");
        ListIterator<Product> productIterator = products.listIterator();
        while (productIterator.hasNext()) {
            Product product = productIterator.next();
            productTable.addCell(product.getId());
            productTable.addCell(product.getName());
            productTable.addCell(String.valueOf(product.getQuantity()));
            productTable.addCell(String.format("%.2f", product.getUnitPrice()));
        }
        System.out.println(ANSI_BLUE + productTable.render() + ANSI_RESET);
    }

    public int getPageNumber() {
        System.out.println("Enter page number: ");
        int pageNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left by nextInt()
        return pageNumber;
    }

    // Method to display products on the specified page
    public void displayProductsPage(List<Product> products, int pageNumber, int pageSize) {
        int startIndex = (pageNumber - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, products.size());

        for (int i = startIndex; i < endIndex; i++) {
            Product product = products.get(i);
            System.out.println(product); // Assuming Product class has a meaningful toString() implementation
        }
    }

}
