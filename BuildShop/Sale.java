package BuildShop;

public class Sale {
    private final Customer customer;
    private final String productName;
    private final double price;
    private final String measurements;
    private final double quantity;


    public Sale(Customer customer, String productName, double price, String measurements, double quantity) {
        this.customer = customer;
        this.productName = productName;
        this.price = price;
        this.measurements = measurements;
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getMeasurements() {
        return measurements;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "customer=" + customer +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", measurements='" + measurements + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
