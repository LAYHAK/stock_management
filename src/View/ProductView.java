package View;

import Model.Product;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class ProductView {
    public static final String ANSI_BLUE = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    private final Scanner scanner = new Scanner(System.in);


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


}
