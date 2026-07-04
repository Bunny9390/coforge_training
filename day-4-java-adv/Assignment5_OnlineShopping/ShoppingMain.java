// Main class for Assignment 5
public class ShoppingMain {
    public static void main(String[] args) {
        Cart cart = new Cart();
        Customer customer = new Customer(1, "Nisha", cart);

        Product product1 = new Product(101, "Laptop", 45000);
        Product product2 = new Product(102, "Mouse", 800);
        Product product3 = new Product(103, "Keyboard", 1200);
        Product product4 = new Product(104, "Monitor", 9000);
        Product product5 = new Product(105, "Headphones", 2500);

        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        cart.addProduct(product4);
        cart.addProduct(product5);

        cart.removeProduct(102);

        System.out.println("Remaining products in cart:");
        cart.displayProducts();

        System.out.println("Total Bill: " + cart.calculateTotal());
        customer.displayCustomerDetails();
    }
}
