// Cart class for Assignment 5
class Cart {
    Product[] products = new Product[20];
    int count = 0;

    void addProduct(Product product) {
        if (count < products.length) {
            products[count] = product;
            count++;
            System.out.println("Added to cart: " + product.name);
        } else {
            System.out.println("Cart is full.");
        }
    }

    void removeProduct(int id) {
        for (int i = 0; i < count; i++) {
            if (products[i].id == id) {
                for (int j = i; j < count - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[count - 1] = null;
                count--;
                System.out.println("Removed product with ID: " + id);
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }

    void displayProducts() {
        System.out.println("Products in cart:");
        for (int i = 0; i < count; i++) {
            products[i].displayProduct();
            System.out.println();
        }
    }

    double calculateTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total = total + products[i].price;
        }
        return total;
    }
}
