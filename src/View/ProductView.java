package View;

import Model.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
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
        int totalPages = (int) Math.ceil((double) size / rowPerPage);
        table.addCell("  Page : %d of %s".formatted(currentPage, totalPages + " ".repeat(65)));
        table.addCell("Total Record : %d".formatted(size));
        System.out.println(table.render());
    }



}
