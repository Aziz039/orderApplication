package product;

public class ProductCatalogue {
	
	private static Product[] catalogue = new Product[10]; 
	
	public ProductCatalogue() {
		int coun = 0;
		while (coun < 10) {
			catalogue[coun] = new Product();
			coun++;
		}
	}
	public Product[] getProducts() {
		return catalogue;
	}
	public void setProducts(String new_Name3, double new_Price3, int new_ProductID3, int counter) {
		catalogue[counter] = new Product(new_Name3, new_Price3, new_ProductID3);
	}
}
