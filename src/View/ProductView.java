package View;

import Model.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
<<<<<<< HEAD
import org.nocrala.tools.texttablefmt.CellStyle;
=======
>>>>>>> a59930f1b6be0347ed4d3a4b266a61a5df598087
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class ProductView {
    public static final String ANSI_BLUE = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    private final Scanner scanner = new Scanner(System.in);

    static final CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);

<<<<<<< HEAD

    public void displayProduct(List<Product> products, int rowPerPage, int currentPage){
        int size = products.size();
        int startIndex = (currentPage - 1) * rowPerPage;
        int endIndex = Math.min(startIndex + rowPerPage, size);
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        table.addCell("     ID   ", cellStyle);
        table.addCell("     NAME    ", cellStyle);
        table.addCell("     QUANTITY     ", cellStyle);
        table.addCell("     UNIT_PRICE    ", cellStyle);
        table.addCell("     IMPORTED_AT     ", cellStyle);
        for (int i = startIndex; i < endIndex; i++) {
            table.addCell(products.get(i).getId(), cellStyle);
            table.addCell(products.get(i).getName(), cellStyle);
            table.addCell(products.get(i).getQuantity().toString(), cellStyle);
            table.addCell(products.get(i).getUnitPrice().toString(), cellStyle);
            table.addCell(products.get(i).getImportedDate().toString(), cellStyle);
        }
        System.out.println(table.render());
        table = new Table(2, BorderStyle.DESIGN_CURTAIN, ShownBorders.HEADER_ONLY);
=======
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
>>>>>>> a59930f1b6be0347ed4d3a4b266a61a5df598087
        int totalPages = (int) Math.ceil((double) size / rowPerPage);
        table.addCell("  Page : %d of %s".formatted(currentPage, totalPages + " ".repeat(65)));
        table.addCell("Total Record : %d".formatted(size));
        System.out.println(table.render());
<<<<<<< HEAD
    }



=======
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

>>>>>>> a59930f1b6be0347ed4d3a4b266a61a5df598087
}
