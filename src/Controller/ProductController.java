package Controller;

import Model.Product;
import Model.ProductDAO;
import Model.ProductGenerator;
import View.ProductView;

import java.io.IOException;
import java.util.List;

public class ProductController {
    private ProductDAO productDao = new ProductDAO();
    private ProductGenerator productGenerator = new ProductGenerator();
    private ProductView productView = new ProductView();

    public void addProduct() {
        try {
            Product product = productView.getProductDetails();
            productDao.addProduct(product);
            productView.showSuccessMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public void gerneateReport(int numberOfProducts) {
        productGenerator.generateProducts(numberOfProducts);
    }

    public void displayProducts(int pageSize) {
        try {
            List<Product> products = productDao.readAllProducts(); // Assumes this method exists
            int pageNumber = productView.getPageNumber(); // Get page number from the user
            productView.displayProductsPage(products, pageNumber, pageSize);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

}
