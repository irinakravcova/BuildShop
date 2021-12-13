package BuildShop;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UiGui extends UiCli {

    public int getUserAction() {
        int choice;
        do {
            String[] options = {
                    "0 - Exit",
                    "1 - Add Customer",
                    "2 - Add Store Item",
                    "3 - Add Sale to Customer",
                    "4 - Sales Report"
            };
            String operation = (String) JOptionPane.showInputDialog(null,
                    "Select Operation",
                    "Operations",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            List<String> list = Arrays.asList(options);
            choice = list.indexOf(operation);
        } while (choice < 0 || choice > 4);

        return choice;
    }

    public void addStoreItem(Shop shop) {
        String name = JOptionPane.showInputDialog("Enter product name: ");
        double price = Double.parseDouble(JOptionPane.showInputDialog("Enter product price: "));
        String[] availableMeasurements = {"KG", "Item", "MB", "Liters"};
        String measurement = (String) JOptionPane.showInputDialog(null,
                "Select product measurement",
                "Product Measurement",
                JOptionPane.QUESTION_MESSAGE,
                null,
                availableMeasurements,
                availableMeasurements[0]
        );

        double quantity = Double.parseDouble(JOptionPane.showInputDialog("Enter product quantity: "));
        Product product = new Product(name, price, quantity, measurement);
        shop.addProduct(product);
    }

    public void addCustomer(Shop shop) {
        String name = JOptionPane.showInputDialog("Enter customer name:");
        double balance = Double.parseDouble(JOptionPane.showInputDialog("Enter customer balance:"));
        Customer customer = new Customer(name, balance);
        shop.addCustomer(customer);
    }

    @Override
    public Customer queryCustomer(Shop shop) {
        String customerName = JOptionPane.showInputDialog("Enter customer name:");
        return shop.getCustomerByName(customerName);
    }

    @Override
    public Product queryProductName(Shop shop) {
        String name = JOptionPane.showInputDialog("Enter product name:");
        return shop.getProductByName(name);
    }

    @Override
    public double queryProductQuantity(Shop shop) {
        return Double.parseDouble(JOptionPane.showInputDialog("Enter product quantity:"));
    }

    @Override
    double queryProductPricePerUnit(Shop shop) {
        return Double.parseDouble(JOptionPane.showInputDialog("Enter product price per unit:"));
    }
}

