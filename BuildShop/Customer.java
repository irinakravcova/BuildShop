package BuildShop;

public class Customer {
    private final String name;
    private double balance;

    public Customer(String name, double balance) {
        if (name == null) {
            throw new IllegalArgumentException("Customer name cannot be null");
        }
        if (balance < 0.0) {
            throw new IllegalArgumentException("Customer cannot have negative balance");
        }
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double adjustment) {
        balance += adjustment;
    }

    public double decreaseBalance(double amount) {
        balance = balance - amount;
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return name.equals(customer.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
