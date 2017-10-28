package product;

public class Product {

	private String name3;
	private double price3;
	private int productID3;
	
	Product() {
		name3 = null;
		price3 = 0.0;
		productID3 = 0;
	}
	public Product(String new_Name3, double new_Price3, int new_ProductID3) {
		name3 = new_Name3;
		price3 = new_Price3;
		productID3 = new_ProductID3;
	}
	
	// setters
	public void set_Name3(String new_Name3) {
		name3 = new_Name3;
	}
	public void set_Price3(double new_Price3) {
		price3 = new_Price3;
	}
	public void set_ProductID3(int new_ProductID3) {
		productID3 = new_ProductID3;
	}
	
	// getters
	public String getName3() {
		return name3;
	}
	public double getPrice3() {
		return price3;
	}
	public int getProductID3() {
		return productID3;
	}
	
}
