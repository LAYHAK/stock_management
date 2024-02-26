package Controller;

import Model.Product;
import Model.ProductDAO;
import Model.ProductGenerator;
import View.ProductView;
import service.Service;
import service.ServiceImp;

import java.io.IOException;
import java.util.List;

public class ProductController {
    private final ProductDAO productDao = new ProductDAO();
    private final ProductGenerator productGenerator = new ProductGenerator();
    private final ProductView productView = new ProductView();
    private final Service service = new ServiceImp();

    public void addProduct() {
        service.addProduct();
    }

    public void commitToDataSource() {
        service.commitToDataSource();
    }

    public void displayTransaction() {


        try {
            productView.displayProducts(productDao.readAllTransaction());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayData() {
        try {
            productView.displayProducts(productDao.readAllTransaction());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void generateReport(int numberOfProducts) {
        service.generateReport(numberOfProducts);
    }

    public void searchProduct(String productName) {
        service.searchProduct(productName);
    }

}
