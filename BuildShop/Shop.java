package BuildShop;

import javax.swing.*;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Customer> customers = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private List<Sale> sales = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public Customer getCustomerByName(String customerName) {
        Customer lookup = new Customer(customerName, 0);
        int idx = customers.indexOf(lookup);
        if (idx < 0) {
            return null;
        }
        return customers.get(idx);
    }

    /**
     * Register sale of specific {@link Product} to specific {@link Customer}.<br />
     * Steps to be performed:
     * <ol>
     * <li>Check if product has required quantity at all
     * <li>Reduce product quantity in store
     * <li>Adjust customer balance (subtract quantity*pricePerUnit)
     * </ol>
     *
     * @param customer     customer to be handled
     * @param product      product to be sold
     * @param quantity     quantity to be sold
     * @param pricePerUnit price per unit for quantity
     * @return status of sale
     */
    public boolean addSale(Customer customer, Product product, double quantity, double pricePerUnit) {
        // Check product quantity
        double currQuantity = 0.0;
        String unit = null;
        for (Product p : products) {
            if (product.equals(p)) {
                unit = p.getMeasurement(); // store for future last found unit
                currQuantity += p.getQuantity();
            }
        }
        if (currQuantity < quantity) {
            System.err.println("Unable to perform sale - out of stock (has: " + currQuantity + ", required: " + quantity + ")");
            return false;
        }
        // Reduce
        Product sold = new Product(product.getName(), pricePerUnit, -quantity, unit);
        products.add(sold);
        Sale sale = new Sale(customer, product.getName(), pricePerUnit, unit, quantity);
        sales.add(sale);
        // Adjust balance
        customer.addBalance(-1.0 * (pricePerUnit * quantity));
        return true;
    }

    public Product getProductByName(String name) {
        Product lookup = new Product(name, 0, 0, "");
        int idx = products.indexOf(lookup);
        if (idx < 0) {
            return null;
        }
        return lookup;
    }
}

