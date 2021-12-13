package BuildShop;

import java.util.Objects;

public class Product {
    public final String name;
    private double price;
    private double quantity;
    private final String measurement;


    public Product(String name, double price, double quantity, String measurement) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.measurement = measurement;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public double getQuantity(){
        return quantity;
    }
    public String getMeasurement(){
        return measurement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "name='" + name +
                ", price=" + price +
                ", quantity=" + quantity +
                ", measurement='" + measurement;
    }
}
