public class ProductClass {

	int productId;
	String productName;
	double price;
	int quantity;

	ProductClass(int productId, String productName, double price, int quantity) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	double calculateTotal() {
		return price * quantity;
	}

	void displayBill() {
		System.out.println("Product ID : " + productId);
		System.out.println("Product    : " + productName);
		System.out.println("Price      : " + price);
		System.out.println("Quantity   : " + quantity);
		System.out.println("Total      : " + calculateTotal());
	}

	public static void main(String[] args) {

		ProductClass p = new ProductClass(101, "Laptop", 50000, 2);

		p.displayBill();
	}
}