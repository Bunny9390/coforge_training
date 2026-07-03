public class MobileClass {

	private String brand;
	private String model;
	private int ram;
	private double price;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {

		return "Brand = " + brand + "\nModel = " + model + "\nRAM = " + ram + "\nPrice = " + price;
	}

	public static void main(String[] args) {

		MobileClass m = new MobileClass();

		m.setBrand("Samsung");
		m.setModel("S24");
		m.setRam(12);
		m.setPrice(70000);

		System.out.println(m);
	}
}