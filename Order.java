package product;

import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Order{

	private Date dateReceived;
	private double price;
	private int orderID;
	
	private Product[] wantedItems;
	private OrderLine[] wantedQuantity;
	public Order() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		dateReceived = new Date();
		dateFormat.format(dateReceived);
		price = 0;
		orderID = 0;
		wantedItems = new Product[10];
		wantedQuantity = new OrderLine[10];
		int counter = 0;
		while (counter < 10) {
			wantedItems[counter] = new Product();
			counter++;
		}
		counter = 0;
		while (counter < 10) {
			wantedQuantity[counter] = new OrderLine();
			counter++;
		}
	}
	
	// setters
	public void set_dateReceived(Date new_dateReceived) {
		dateReceived = new_dateReceived;
	}
	
	public void set_price(double new_price) {
		price = new_price;
	}
	
	public void set_orderID(int new_orderID) {
		orderID = new_orderID;
	}
	
	// getters
	public Date get_dateReceived() {
		return dateReceived;
	}
	
	public double get_price() {
		return price;
	}
	
	public int get_orderID() {
		return orderID;
	}
	public Product[] items() {
		return wantedItems;
	}
	public OrderLine[] quantity() {
		return wantedQuantity;
	}
	
	// methods required
	public Date getDateReceived() { //////////// ?????????????
		return dateReceived;
	}
	
	public double calculatePrice(ProductCatalogue catalg) {
		System.out.println("Order recipt:");
		System.out.println("Date order recieved: " + dateReceived);
		
		int counterLoop = 0;
		int counterItems = 0;
		while (counterLoop < 10) {
			price = price + (wantedQuantity[counterLoop].getQuantiy() * catalg.getProducts()[counterLoop].getPrice3());
			if (wantedQuantity[counterLoop].getQuantiy() > 0) {
				System.out.println("*****************" );
				System.out.println("item " + ++counterItems + ":" );
				System.out.println("Name: " + catalg.getProducts()[counterLoop].getName3());
				System.out.println("Price: " + catalg.getProducts()[counterLoop].getPrice3());
				System.out.println("product ID: " + catalg.getProducts()[counterLoop].getProductID3());
				System.out.println("Quentity: " + wantedQuantity[counterLoop].getQuantiy());
				System.out.println("*****************" );
				
			}
			counterLoop++;
		}
		return price;
	}
	
}
