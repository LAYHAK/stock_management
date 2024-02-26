package Model;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private String id;
    private String name;
    private Integer quantity;
    private Double unitPrice;
    private LocalDate importedDate;

    public Product(){}

    // Constructor


    public Product(String id, String name, Integer quantity, Double unitPrice, LocalDate importedDate) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.importedDate = importedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public LocalDate getImportedDate() {
        return importedDate;
    }

    public void setImportedDate(LocalDate importedDate) {
        this.importedDate = importedDate;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(quantity, product.quantity) && Objects.equals(unitPrice, product.unitPrice) && Objects.equals(importedDate, product.importedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity, unitPrice, importedDate);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", importedDate=" + importedDate +
                '}';

    }
}
