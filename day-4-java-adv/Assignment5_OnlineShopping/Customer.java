// Customer class for Assignment 5
class Customer {
    int customerId;
    String customerName;
    Cart cart;

    Customer(int customerId, String customerName, Cart cart) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.cart = cart;
    }

    void displayCustomerDetails() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Cart Items: " + cart.count);
    }
}
