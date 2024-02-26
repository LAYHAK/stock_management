package View;

import Model.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class ProductView {
    public static final String ANSI_BLUE = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    private final Scanner scanner = new Scanner(System.in);


    public void displayProducts(List<Product> products, int rowPerPage, int currentPage) {
        int size = products.size();
        int startIndex = (currentPage - 1) * rowPerPage;
        int endIndex = Math.min(startIndex + rowPerPage, size);
        Table productTable = new Table(4);
        productTable.addCell("ID");
        productTable.addCell("Name");
        productTable.addCell("Quantity");
        productTable.addCell("Unit Price");
        ListIterator<Product> productIterator = products.listIterator();
        for (int i = startIndex; i < endIndex; ++i) {
            Product product = productIterator.next();
            productTable.addCell(product.getId());
            productTable.addCell(product.getName());
            productTable.addCell(String.valueOf(product.getQuantity()));
            productTable.addCell(String.format("%.2f", product.getUnitPrice()));
        }
        System.out.println(ANSI_BLUE + productTable.render() + ANSI_RESET);
        Table table = new Table(2, BorderStyle.DESIGN_CURTAIN, ShownBorders.HEADER_ONLY);
        int totalPages = (int) Math.ceil((double) size / rowPerPage);
        table.addCell("  Page : %d of %s".formatted(currentPage, totalPages + " ".repeat(65)));
        table.addCell("Total Record : %d".formatted(size));
        System.out.println(table.render());
    }
    public void paginationOption(){
        Table tableMenu = new Table(6, BorderStyle.DESIGN_CURTAIN);
        tableMenu.addCell("Page Navigation:"+" ".repeat(11));
        tableMenu.addCell("     (F)irst");
        tableMenu.addCell("     (P)revious");
        tableMenu.addCell("     (G)oto ");
        tableMenu.addCell("     (N)ext");
        tableMenu.addCell("     (L)ast   ");
        System.out.println(tableMenu.render());
    }

}
