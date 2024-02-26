package View;

import Controller.ProductController;
import Model.Product;
import Pagination.StockHelp;
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


    public static class Menu {
        static ProductController productController = new ProductController();
        public static void welcomeMsg() {
            System.out.println("");
            System.out.println("✨  WELCOME TO STOCK MANAGEMENT SYSTEM  ✨");
            System.out.println(
                            "\n" +
                   " ██████╗███████╗████████╗ █████╗ ██████╗     ███████╗███╗   ███╗███████╗  \n" +
                  "██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔══██╗    ██╔════╝████╗ ████║██╔════╝   \n" +
                  "██║     ███████╗   ██║   ███████║██║  ██║    ███████╗██╔████╔██║███████╗   \n" +
                  "██║     ╚════██║   ██║   ██╔══██║██║  ██║    ╚════██║██║╚██╔╝██║╚════██║   \n" +
                  "╚██████╗███████║   ██║   ██║  ██║██████╔╝    ███████║██║ ╚═╝ ██║███████║   \n" +
                  "╚═════╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═════╝     ╚══════╝╚═╝     ╚═╝╚══════╝    \n"
                    );
        }
        public static void createTable() {
            Scanner sc = new Scanner(System.in);
            System.out.println("#  Application Menu");
            Table table = new Table(9, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.SURROUND);
            table.addCell("".repeat(4) + " | Disp(l)ay" + "".repeat(4));
            table.addCell("".repeat(4) + " | Rando(m)" + "".repeat(4));
            table.addCell("".repeat(4) + " | (W)rite" + "".repeat(4));
            table.addCell("".repeat(4) + " | (E)dit" + "".repeat(4));
            table.addCell("".repeat(4) + " | (D)elete" + "".repeat(4));
            table.addCell("".repeat(4) + " | (S)earch" + "".repeat(4));
            table.addCell("".repeat(4) + " | Set r(o)w" + "".repeat(4));
            table.addCell("".repeat(4) + " | (C)ommit" + "".repeat(4));
            table.addCell("".repeat(4) + " | Bac(k) up" + "".repeat(4));
            table.addCell("".repeat(4) + " | Res(t)ore" + "".repeat(4));
            table.addCell("".repeat(4) + " | (H)elp" + "".repeat(4));
            table.addCell("".repeat(4) + " | E(x)it" + "".repeat(4));

            System.out.println(table.render());
            System.out.print("Command -> ");
            String options = sc.nextLine();
            switch (options) {
                case "l" , "L" -> productController.displayTransaction();
                case "H" , "h" -> StockHelp.displayHelp();
                case "e", "E" -> {
                    System.out.println("Have a Nice Day!! \uD83D\uDC7B\uD83D\uDC7B\uD83D\uDC7B");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Option");
            }
        }
    }
}
