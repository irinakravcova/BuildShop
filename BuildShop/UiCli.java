package BuildShop;

import java.util.Scanner;

public class UiCli {

    public int getUserAction() {
        int choice;
        do {
            System.out.println("Available commands");
            System.out.println("0 - Exit");
            System.out.println("1 - Add Customer");
            System.out.println("2 - Add Store Item");
            System.out.println("3 - Add Sale to Customer");
            System.out.println("4 - Sales Report");
            System.out.println("Your action:");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
        } while (choice < 0 || choice > 4);

        return choice;
    }

    public void addCustomer(Shop shop) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer name:");
        String name = scanner.next();
        System.out.println("Enter customer balance:");
        double balance = scanner.nextDouble();
        Customer customer = new Customer(name, balance);
        shop.addCustomer(customer);
    }

    public void reportCustomers(Shop shop) {
        System.out.println("Customer report. Total customers: " + shop.getCustomers().size());
        for (Customer customer : shop.getCustomers()) {
            System.out.println("Customer name: " + customer.getName() + ", balance: " + customer.getBalance());
        }
    }

    public void reportProducts(Shop shop) {
        System.out.println("Product report. Total product entries: " + shop.getProducts().size());
        for (Product product : shop.getProducts()) {
            System.out.println("Product name: " + product.getName()
                    + ", unit: " + product.getMeasurement() + ", quantity: " + product.getQuantity() + ", price: " + product.getPrice());
        }
    }

    public void reportSales(Shop shop) {
        System.out.println("Sales report. Total sales entries: " + shop.getSales().size());
        for (Sale sale : shop.getSales()) {
            System.out.println("Sold to: " + sale.getCustomer() + ", name: " + sale.getProductName() + ", measurements: " +
                    sale.getMeasurements() + ", price: " + sale.getPrice() + ", quantity: " + sale.getQuantity() );
        }
    }

    public void addStoreItem(Shop shop) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Product name:");
        String name = scanner.next();
        System.out.println("Units:");
        String units = scanner.next();
        System.out.println("Quantity:");
        double quantity = scanner.nextDouble();
        System.out.println("Price:");
        double price = scanner.nextDouble();
        Product product = new Product(name, price, quantity, units);
        shop.addProduct(product);
    }

    public Customer queryCustomer(Shop shop) {
        System.out.println("Enter customer name:");
        Scanner scanner = new Scanner(System.in);
        String customerName = scanner.nextLine();
        Customer customer = shop.getCustomerByName(customerName);
        return customer;
    }

    public Product queryProductName(Shop shop) {
        System.out.println("Enter product name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Product product = shop.getProductByName(name);
        return product;
    }

    public double queryProductQuantity(Shop shop) {
        System.out.println("Enter product quantity:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    double queryProductPricePerUnit(Shop shop) {
        System.out.println("Enter product price per unit:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    public void addSale(Shop shop) {
        Customer customer = queryCustomer(shop);

        if (null == customer) {
            System.err.println("Customer not found, operation cancelled.");
            return;
        }

        Product product = queryProductName(shop);
        if (null == product) {
            System.err.println("Product not found in store.");
            return;
        }

        double quantity = queryProductQuantity(shop);
        if (quantity <= 0.0) {
            System.err.println("Negative quantity is not allowed, operation cancelled.");
            return;
        }

        double pricePerUnit = queryProductPricePerUnit(shop);
        if (pricePerUnit <= 0.0) {
            System.err.println("Negative price is not allowed, operation cancelled.");
            return;
        }

        if (!shop.addSale(customer, product, quantity, pricePerUnit)) {
            System.err.println("Unable to sell '" + product.getName() + "'");
            return;
        }
        System.out.println("Successfully sold to " + customer.getName() + " item '" + product.getName() + "', quantity: " + quantity);
    }

    public void report(Shop shop) {
        reportCustomers(shop);
        reportProducts(shop);
        reportSales(shop);
    }
}
